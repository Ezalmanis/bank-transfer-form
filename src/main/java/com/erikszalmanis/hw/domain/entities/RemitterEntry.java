package com.erikszalmanis.hw.domain.entities;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class RemitterEntry extends BankUserEntry {

    @OneToOne
    private PaymentOrderEntity paymentOrderEntity;

    public RemitterEntry() {
        super();
    }

    public RemitterEntry(final Long bankUserEntry, final String bankUserId, final String bankUserName, final String bankAccountNo, final PaymentOrderEntity paymentOrderEntity) {
        super(bankUserEntry, bankUserId, bankUserName, bankAccountNo);
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
