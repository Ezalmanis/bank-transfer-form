package com.erikszalmanis.hw.mapper;

import com.erikszalmanis.hw.domain.entities.PaymentOrderEntity;
import com.erikszalmanis.hw.domain.objects.Beneficiary;
import com.erikszalmanis.hw.domain.objects.PaymentInformation;
import com.erikszalmanis.hw.domain.objects.PaymentOrder;
import com.erikszalmanis.hw.domain.objects.Remitter;


public interface SimplePaymentMapper {

    PaymentOrderEntity paymentOrderToEntity(final PaymentOrder source);

    PaymentOrder entityToPaymentOrder(final PaymentOrderEntity source);

    Beneficiary entityToPaymentBeneficiary(final PaymentOrderEntity source);

    Remitter entityToPaymentRemitter(final PaymentOrderEntity source);

    PaymentInformation entityToPaymentPaymentInformation(final PaymentOrderEntity source);

    void updatePaymentOrderEntity(final PaymentOrder source, final PaymentOrderEntity entity);
//    PaymentOrderEntityTemp entityToPayme~SAntOrder(final PaymentOrder source);
//
//    BeneficiaryEntity entityToPaymentBeneficiary(fin~al PaymentOrder source);
//
//    RemitterEntity entityToPaymentRemitter(final PaymentOrder source);
//
//    PaymentInformationEntity entityToPaymentPaymentInformation(final PaymentOrder source);

}

