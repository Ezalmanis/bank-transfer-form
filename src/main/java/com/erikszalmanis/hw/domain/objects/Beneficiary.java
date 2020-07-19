package com.erikszalmanis.hw.domain.objects;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotEmpty;

public class Beneficiary extends BankUser {

    @NotEmpty(message = "Beneficiaries residence country must be stated")
    private String beneficiaryResidenceCountry;

    @NotEmpty(message = "Beneficiaries bank must be stated")
    private String beneficiaryBank;

    @NotEmpty(message = "Beneficiaries bank code must be stated")
    private String beneficiaryBankCode;

    public Beneficiary() {
        super();
    }

    public Beneficiary(final String bankUserName, final String bankUserId, final String bankAccountNo,
                       final String beneficiaryResidenceCountry, final String beneficiaryBank, final String beneficiaryBankCode) {
        super(bankUserName, bankUserId, bankAccountNo);
        this.beneficiaryResidenceCountry = beneficiaryResidenceCountry;
        this.beneficiaryBank = beneficiaryBank;
        this.beneficiaryBankCode = beneficiaryBankCode;
    }

    public String getBeneficiaryResidenceCountry() {
        return beneficiaryResidenceCountry;
    }

    public void setBeneficiaryResidenceCountry(final String beneficiaryResidenceCountry) {
        this.beneficiaryResidenceCountry = beneficiaryResidenceCountry;
    }

    public String getBeneficiaryBank() {
        return beneficiaryBank;
    }

    public void setBeneficiaryBank(final String beneficiaryBank) {
        this.beneficiaryBank = beneficiaryBank;
    }

    public String getBeneficiaryBankCode() {
        return beneficiaryBankCode;
    }

    public void setBeneficiaryBankCode(final String beneficiaryBankCode) {
        this.beneficiaryBankCode = beneficiaryBankCode;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        final Beneficiary that = (Beneficiary) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(getBeneficiaryResidenceCountry(), that.getBeneficiaryResidenceCountry())
                .append(getBeneficiaryBank(), that.getBeneficiaryBank())
                .append(getBeneficiaryBankCode(), that.getBeneficiaryBankCode())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(getBeneficiaryResidenceCountry())
                .append(getBeneficiaryBank())
                .append(getBeneficiaryBankCode())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .appendSuper(super.toString())
                .append("residenceCountry", beneficiaryResidenceCountry)
                .append("bank", beneficiaryBank)
                .append("bankCode", beneficiaryBankCode)
                .toString();
    }
}
