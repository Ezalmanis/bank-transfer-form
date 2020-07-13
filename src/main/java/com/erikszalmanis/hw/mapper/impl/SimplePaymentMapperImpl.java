package com.erikszalmanis.hw.mapper.impl;

import com.erikszalmanis.hw.domain.entities.PaymentOrderEntity;
import com.erikszalmanis.hw.domain.objects.Beneficiary;
import com.erikszalmanis.hw.domain.objects.PaymentInformation;
import com.erikszalmanis.hw.domain.objects.PaymentOrder;
import com.erikszalmanis.hw.domain.objects.Remitter;
import com.erikszalmanis.hw.mapper.SimplePaymentMapper;
import org.springframework.stereotype.Component;

@Component
public class SimplePaymentMapperImpl implements SimplePaymentMapper {

    @Override
    public PaymentOrderEntity paymentOrderToEntity(final PaymentOrder source) {
        if (source == null) {
            return null;
        }
        final PaymentOrderEntity paymentOrderEntity = new PaymentOrderEntity();
        return getPaymentOrderEntity(source, paymentOrderEntity);
    }

    @Override
    public PaymentOrder entityToPaymentOrder(final PaymentOrderEntity source) {
        if (source == null) {
            return null;
        }

        final PaymentOrder paymentOrder = new PaymentOrder();

        paymentOrder.setDocumentId(source.getDocumentId());
        paymentOrder.setClientId(source.getClientId());
        paymentOrder.setDocumentDate(source.getDocumentDate());
        paymentOrder.setStatus(source.getStatus());
        paymentOrder.setTermsOfService(source.isTermsOfService());
        paymentOrder.setBeneficiary(entityToPaymentBeneficiary(source));
        paymentOrder.setRemitter(entityToPaymentRemitter(source));
        paymentOrder.setPaymentInformation(entityToPaymentPaymentInformation(source));

        return paymentOrder;
    }

    @Override
    public Beneficiary entityToPaymentBeneficiary(final PaymentOrderEntity source) {
        if (source == null) {
            return null;
        }

        final Beneficiary beneficiary = new Beneficiary();

        beneficiary.setBankAccountNo(source.getBeneficiaryAccountNo());
        beneficiary.setBankUserId(source.getBeneficiaryId());
        beneficiary.setBankUserName(source.getBeneficiaryName());

        beneficiary.setBeneficiaryResidenceCountry(source.getBeneficiaryResidenceCountry());
        beneficiary.setBeneficiaryBank(source.getBeneficiaryBank());
        beneficiary.setBeneficiaryBankCode(source.getBeneficiaryBankCode());

        return beneficiary;
    }

    @Override
    public Remitter entityToPaymentRemitter(final PaymentOrderEntity source) {
        if (source == null) {
            return null;
        }

        final Remitter remitter = new Remitter();

        remitter.setBankAccountNo(source.getRemitterBankAccountNo());
        remitter.setBankUserId(source.getRemitterId());
        remitter.setBankUserName(source.getRemitterName());

        return remitter;
    }

    @Override
    public PaymentInformation entityToPaymentPaymentInformation(final PaymentOrderEntity source) {
        if (source == null) {
            return null;
        }
        final PaymentInformation paymentInformation = new PaymentInformation();

        paymentInformation.setAmountInWords(source.getAmountInWords());
        paymentInformation.setAmountToTransferFromRemitter(source.getAmountToTransferFromRemitter());
        paymentInformation.setAmountToTransferToBeneficiary(source.getAmountToTransferToBeneficiary());
        paymentInformation.setCurrencyType(source.getCurrencyType());
        paymentInformation.setPaymentType(source.getPaymentType());
        paymentInformation.setValuedAtDate(source.getValuedAtDate());
        paymentInformation.setPaymentDetails(source.getPaymentDetails());
        paymentInformation.setBankFee(source.getBankFee());
        paymentInformation.setExchangeRate(source.getExchangeRate());
        paymentInformation.setExternalPaymentCode(source.getExternalPaymentCode());

        return paymentInformation;
    }

    private void remitterToEntity(final PaymentOrderEntity orderEntity, final Remitter source) {
        if (source != null && orderEntity != null) {
            orderEntity.setRemitterBankAccountNo(source.getBankAccountNo());
            orderEntity.setRemitterId(source.getBankUserId());
            orderEntity.setRemitterName(source.getBankUserName());
        }
    }

    private void paymentInformationToEntity(final PaymentOrderEntity orderEntity, final PaymentInformation paymentInformation) {
        if (paymentInformation != null && orderEntity != null) {

            orderEntity.setAmountInWords(paymentInformation.getAmountInWords());
            orderEntity.setAmountToTransferFromRemitter(paymentInformation.getAmountToTransferFromRemitter());
            orderEntity.setAmountToTransferToBeneficiary(paymentInformation.getAmountToTransferToBeneficiary());
            orderEntity.setCurrencyType(paymentInformation.getCurrencyType());
            orderEntity.setPaymentType(paymentInformation.getPaymentType());
            orderEntity.setValuedAtDate(paymentInformation.getValuedAtDate());
            orderEntity.setPaymentDetails(paymentInformation.getPaymentDetails());
            orderEntity.setBankFee(paymentInformation.getBankFee());
            orderEntity.setExchangeRate(paymentInformation.getExchangeRate());
            orderEntity.setExternalPaymentCode(paymentInformation.getExternalPaymentCode());
        }
    }

    private void beneficiaryToEntity(final PaymentOrderEntity orderEntity, final Beneficiary source) {
        if (source != null && orderEntity != null) {
            orderEntity.setBeneficiaryAccountNo(source.getBankAccountNo());
            orderEntity.setBeneficiaryId(source.getBankUserId());
            orderEntity.setBeneficiaryName(source.getBankUserName());

            orderEntity.setBeneficiaryResidenceCountry(source.getBeneficiaryResidenceCountry());
            orderEntity.setBeneficiaryBank(source.getBeneficiaryBank());
            orderEntity.setBeneficiaryBankCode(source.getBeneficiaryBankCode());
        }
    }

    private PaymentOrderEntity getPaymentOrderEntity(final PaymentOrder source, final PaymentOrderEntity paymentOrderEntity) {
        final Beneficiary beneficiary = source.getBeneficiary();
        final Remitter remitter = source.getRemitter();
        final PaymentInformation paymentInformation = source.getPaymentInformation();

        beneficiaryToEntity(paymentOrderEntity, beneficiary);
        remitterToEntity(paymentOrderEntity, remitter);
        paymentInformationToEntity(paymentOrderEntity, paymentInformation);

        paymentOrderEntity.setClientId(source.getClientId());
        paymentOrderEntity.setDocumentDate(source.getDocumentDate());
        paymentOrderEntity.setStatus(source.getStatus());
        paymentOrderEntity.setTermsOfService(source.isTermsOfService());

        return paymentOrderEntity;
    }
}
