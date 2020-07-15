package com.erikszalmanis.hw.domain.objects;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class BankUser {

    @NotEmpty(message = "Bank users name must be present")
    private String bankUserName;

    @NotNull(message = "Bank users identification number must be present")
    private Long bankUserId;

    @NotNull(message = "Bank account number must be present")
    private Long bankAccountNo;


    public BankUser() {
    }

    public BankUser(final String bankUserName, final Long bankUserId, final Long bankAccountNo) {
        this.bankUserName = bankUserName;
        this.bankUserId = bankUserId;
        this.bankAccountNo = bankAccountNo;
    }

    public String getBankUserName() {
        return bankUserName;
    }

    public void setBankUserName(final String bankUserName) {
        this.bankUserName = bankUserName;
    }

    public Long getBankUserId() {
        return bankUserId;
    }

    public void setBankUserId(final Long bankUserId) {
        this.bankUserId = bankUserId;
    }

    public Long getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(final Long bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        final BankUser bankUser = (BankUser) o;

        return new EqualsBuilder()
                .append(getBankUserName(), bankUser.getBankUserName())
                .append(getBankUserId(), bankUser.getBankUserId())
                .append(getBankAccountNo(), bankUser.getBankAccountNo())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getBankUserName())
                .append(getBankUserId())
                .append(getBankAccountNo())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("bankUserName", bankUserName)
                .append("bankUserId", bankUserId)
                .append("bankAccountNo", bankAccountNo)
                .toString();
    }
}
