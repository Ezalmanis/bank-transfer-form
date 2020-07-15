package com.erikszalmanis.hw.service;

import com.erikszalmanis.hw.domain.enums.PaymentStatus;
import com.erikszalmanis.hw.domain.objects.ExchangeRate;
import com.erikszalmanis.hw.domain.objects.PaymentOrder;
import com.erikszalmanis.hw.exceptions.NoDefaultExchangeRateException;
import com.erikszalmanis.hw.exceptions.OutdatedRatesException;
import com.erikszalmanis.hw.exceptions.TransferAmountDiscrepancyException;

import javax.persistence.EntityNotFoundException;
import java.util.List;


public interface PaymentOrderService {

    void saveAndSubmitOrderToClerk(final PaymentOrder paymentOrder) throws OutdatedRatesException, TransferAmountDiscrepancyException, NoDefaultExchangeRateException;

    PaymentOrder savePaymentOrder(final PaymentOrder paymentOrder) throws OutdatedRatesException, TransferAmountDiscrepancyException, NoDefaultExchangeRateException;

    void updatePaymentOrder(final PaymentOrder paymentOrder) throws EntityNotFoundException;

    void updatePaymentStatus(final Long id, final PaymentStatus status) throws EntityNotFoundException;

    ExchangeRate getExchangeRate() throws NoDefaultExchangeRateException;

    List<PaymentOrder> getPaymentOrders();

}
