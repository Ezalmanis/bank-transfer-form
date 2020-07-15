package com.erikszalmanis.hw.mapper.impl;

import com.erikszalmanis.hw.domain.entities.BeneficiaryEntity;
import com.erikszalmanis.hw.domain.entities.PaymentInformationEntity;
import com.erikszalmanis.hw.domain.entities.PaymentOrderEntity;
import com.erikszalmanis.hw.domain.entities.RemitterEntity;
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
    public void updatePaymentOrderEntity(final PaymentOrder source, final PaymentOrderEntity entity) {
        getPaymentOrderEntity(source, entity);
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
    public Beneficiary entityToPaymentBeneficiary(final PaymentOrderEntity entity) {
        if (entity == null) {
            return null;
        }
        final Beneficiary beneficiary = new Beneficiary();
        final BeneficiaryEntity source = entity.getBeneficiaryEntity();

        beneficiary.setBankAccountNo(source.getBankAccountNo());
        beneficiary.setBankUserId(source.getBankUserId());
        beneficiary.setBankUserName(source.getBankUserName());

        beneficiary.setBeneficiaryResidenceCountry(source.getResidenceCountry());
        beneficiary.setBeneficiaryBank(source.getBeneficiaryBank());
        beneficiary.setBeneficiaryBankCode(source.getBankCode());

        return beneficiary;
    }

    @Override
    public Remitter entityToPaymentRemitter(final PaymentOrderEntity entity) {
        if (entity == null) {
            return null;
        }

        final Remitter remitter = new Remitter();
        final RemitterEntity source = entity.getRemitterEntity();
        remitter.setBankAccountNo(source.getBankAccountNo());
        remitter.setBankUserId(source.getBankUserId());
        remitter.setBankUserName(source.getBankUserName());

        return remitter;
    }


    @Override
    public PaymentInformation entityToPaymentPaymentInformation(final PaymentOrderEntity entity) {
        if (entity == null) {
            return null;
        }
        final PaymentInformation paymentInformation = new PaymentInformation();
        final PaymentInformationEntity source = entity.getPaymentInformationEntity();

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
            final RemitterEntity remitterEntity = new RemitterEntity();
            remitterEntity.setBankUserId(source.getBankUserId());
            remitterEntity.setBankUserName(source.getBankUserName());
            remitterEntity.setBankAccountNo(source.getBankAccountNo());
            orderEntity.setRemitterEntity(remitterEntity);
        }
    }

    private void paymentInformationToEntity(final PaymentOrderEntity orderEntity, final PaymentInformation paymentInformation) {
        if (paymentInformation != null && orderEntity != null) {
            final PaymentInformationEntity paymentInformationEntity = new PaymentInformationEntity();
            paymentInformationEntity.setAmountInWords(paymentInformation.getAmountInWords());
            paymentInformationEntity.setAmountToTransferFromRemitter(paymentInformation.getAmountToTransferFromRemitter());
            paymentInformationEntity.setAmountToTransferToBeneficiary(paymentInformation.getAmountToTransferToBeneficiary());
            paymentInformationEntity.setCurrencyType(paymentInformation.getCurrencyType());
            paymentInformationEntity.setPaymentType(paymentInformation.getPaymentType());
            paymentInformationEntity.setValuedAtDate(paymentInformation.getValuedAtDate());
            paymentInformationEntity.setPaymentDetails(paymentInformation.getPaymentDetails());
            paymentInformationEntity.setBankFee(paymentInformation.getBankFee());
            paymentInformationEntity.setExchangeRate(paymentInformation.getExchangeRate());
            paymentInformationEntity.setExternalPaymentCode(paymentInformation.getExternalPaymentCode());

            orderEntity.setPaymentInformationEntity(paymentInformationEntity);
        }
    }

    private void beneficiaryToEntity(final PaymentOrderEntity orderEntity, final Beneficiary source) {
        if (source != null && orderEntity != null) {
            final BeneficiaryEntity beneficiaryEntity = new BeneficiaryEntity();
            beneficiaryEntity.setBankCode(source.getBeneficiaryBankCode());
            beneficiaryEntity.setBeneficiaryBank(source.getBeneficiaryBank());
            beneficiaryEntity.setResidenceCountry(source.getBeneficiaryResidenceCountry());
            beneficiaryEntity.setBankUserId(source.getBankUserId());
            beneficiaryEntity.setBankUserName(source.getBankUserName());
            beneficiaryEntity.setBankAccountNo(source.getBankAccountNo());

            orderEntity.setBeneficiaryEntity(beneficiaryEntity);
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
