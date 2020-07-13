package com.erikszalmanis.hw.service.impl;

import com.erikszalmanis.hw.domain.enums.PaymentStatus;
import com.erikszalmanis.hw.domain.objects.ExchangeRate;
import com.erikszalmanis.hw.domain.objects.PaymentInformation;
import com.erikszalmanis.hw.domain.objects.PaymentOrder;
import com.erikszalmanis.hw.exceptions.NoDefaultExchangeRateException;
import com.erikszalmanis.hw.exceptions.OutdatedRatesException;
import com.erikszalmanis.hw.exceptions.TransferAmountDiscrepancyException;
import com.erikszalmanis.hw.repository.impl.RepositoryWrapperImpl;
import com.erikszalmanis.hw.service.EmailService;
import com.erikszalmanis.hw.service.PaymentOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//TODO, test dis;
@Service
public class PaymentOrderServiceImpl implements PaymentOrderService {

    private static final Logger logger = LoggerFactory.getLogger(PaymentOrderServiceImpl.class);

    //TODO, add make email service for clerk, also make testEmail for it and the sender.
    //TODO, prolly add a different exchange rate api, this one doesnt fetch data daily.
    private final RepositoryWrapperImpl orderRepository;
    private final EmailService emailService;
    private final ExchangeRateServiceWrapperImpl exchangeRateService;

    @Autowired
    public PaymentOrderServiceImpl(final RepositoryWrapperImpl orderRepository, final EmailService emailService, final ExchangeRateServiceWrapperImpl exchangeRateService) {
        this.orderRepository = orderRepository;
        this.emailService = emailService;
        this.exchangeRateService = exchangeRateService;
    }

    @Override
    public void saveAndSubmitOrderToClerk(final PaymentOrder paymentOrder) throws OutdatedRatesException, TransferAmountDiscrepancyException, NoDefaultExchangeRateException {
        areExchangeRatesUpToDate(paymentOrder);
        isTransferAmountCorrect(paymentOrder);
        final PaymentOrder savedPaymentOrder = orderRepository.savePaymentOrder(paymentOrder);
        emailService.sendEmailToClerk(savedPaymentOrder);
    }


    @Override
    public PaymentOrder savePaymentOrder(final PaymentOrder paymentOrder) throws OutdatedRatesException, TransferAmountDiscrepancyException, NoDefaultExchangeRateException {
        areExchangeRatesUpToDate(paymentOrder);
        isTransferAmountCorrect(paymentOrder);
        return orderRepository.savePaymentOrder(paymentOrder);
    }

    @Override
    public void updatePaymentOrder(final PaymentOrder paymentOrder) {
        final Long documentId = paymentOrder.getDocumentId();
        orderRepository.updatePaymentOrder(paymentOrder, documentId);
    }

    @Override
    public void updatePaymentStatus(final Long id, final PaymentStatus status) {
        orderRepository.updatePaymentStatus(id, status);
    }

    @Override
    public ExchangeRate getExchangeRate() throws NoDefaultExchangeRateException {
        return exchangeRateService.getExchangeRate();
    }

    @Override
    public List<PaymentOrder> getPaymentOrders() {
        return orderRepository.getAllPayments();
    }

    private void areExchangeRatesUpToDate(final PaymentOrder paymentOrder) throws OutdatedRatesException, NoDefaultExchangeRateException {
        final ExchangeRate rate = exchangeRateService.getExchangeRate();
        final String currencyTypeBase = rate.getBase();
        final String currencyType = paymentOrder.getPaymentInformation().getCurrencyType();
        final Double providedExchangeRate = paymentOrder.getPaymentInformation().getExchangeRate();
        final Double fetchedExchangeRate = rate.getRates().get(currencyType);
        if (!currencyType.equals(currencyTypeBase) && !providedExchangeRate.equals(fetchedExchangeRate)) {
            logger.error("Outdated exchange rates; base {}, providedRate: {}, fetcedExchangeRate {}", currencyTypeBase, providedExchangeRate, fetchedExchangeRate);
            throw new OutdatedRatesException(providedExchangeRate, fetchedExchangeRate);
        }
    }

    private void isTransferAmountCorrect(final PaymentOrder paymentOrder) throws TransferAmountDiscrepancyException, NoDefaultExchangeRateException {
        final PaymentInformation paymentInformation = paymentOrder.getPaymentInformation();
        final Double amountToTransferFromRemitter = paymentInformation.getAmountToTransferFromRemitter();
        final Double amountToTransferToBeneficiary = paymentInformation.getAmountToTransferToBeneficiary();

        final ExchangeRate rate = exchangeRateService.getExchangeRate();
        final String base = rate.getBase();
        final String currencyType = paymentOrder.getPaymentInformation().getCurrencyType();

        if (base.equals(currencyType) && !amountToTransferToBeneficiary.equals(amountToTransferFromRemitter)) {
            logger.error("Incorrect transfer amount; expected {}, actual: {}", amountToTransferToBeneficiary, amountToTransferFromRemitter);
            throw new TransferAmountDiscrepancyException(amountToTransferToBeneficiary, amountToTransferFromRemitter);
        }
        //Todo, clean this
        if (!base.equals(currencyType)){
            final Double fetchedExchangeRate = rate.getRates().get(currencyType);
            logger.info("exchange rate" + rate.toString());
            final Double expectedAmountToTransferToBeneficiary = amountToTransferToBeneficiary * fetchedExchangeRate;
            if (!expectedAmountToTransferToBeneficiary.equals(amountToTransferToBeneficiary)) {
                logger.error("Incorrect transfer amount; expected {}, actual: {}", expectedAmountToTransferToBeneficiary, amountToTransferToBeneficiary);
                throw new TransferAmountDiscrepancyException(expectedAmountToTransferToBeneficiary, amountToTransferToBeneficiary);
            }
        }
    }

}
