package com.erikszalmanis.hw.domain.entities;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class RemitterEntity extends BankUserEntity {

    @OneToOne
    private PaymentOrderEntity paymentOrderEntity;

    public RemitterEntity() {
        super();
    }

    public RemitterEntity(final Long bankUserId, final String bankUserName, final Long bankAccountNo, final PaymentOrderEntity paymentOrderEntity) {
        super(bankUserId, bankUserName, bankAccountNo);
        this.paymentOrderEntity = paymentOrderEntity;
    }

    public PaymentOrderEntity getPaymentOrderEntity() {
        return paymentOrderEntity;
    }

    public void setPaymentOrderEntity(final PaymentOrderEntity paymentOrderEntity) {
        this.paymentOrderEntity = paymentOrderEntity;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString())
                .append("paymentOrderEntity", paymentOrderEntity)
                .toString();
    }
}
