package com.erikszalmanis.hw.domain.entities;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;

@Entity
public class BeneficiaryEntry extends RemitterEntry {

    private String residenceCountry;
    private String beneficiaryBank;
    private String bankCode;

    public BeneficiaryEntry() {
        super();
    }

    public BeneficiaryEntry(final Long bankUserEntry, final String bankUserId, final String bankUserName, final String bankAccountNo, final PaymentOrderEntity paymentOrderEntity, final String residenceCountry, final String beneficiaryBank, final String bankCode) {
        super(bankUserEntry, bankUserId, bankUserName, bankAccountNo, paymentOrderEntity);
        this.residenceCountry = residenceCountry;
        this.beneficiaryBank = beneficiaryBank;
        this.bankCode = bankCode;
    }

    public String getResidenceCountry() {
        return residenceCountry;
    }

    public void setResidenceCountry(final String residenceCountry) {
        this.residenceCountry = residenceCountry;
    }

    public String getBeneficiaryBank() {
        return beneficiaryBank;
    }

    public void setBeneficiaryBank(final String beneficiaryBank) {
        this.beneficiaryBank = beneficiaryBank;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(final String bankCode) {
        this.bankCode = bankCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString())
                .append("residenceCountry", residenceCountry)
                .append("beneficiaryBank", beneficiaryBank)
                .append("bankCode", bankCode)
                .toString();
    }
}