package com.erikszalmanis.hw.domain.entities;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BankUserEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bankUserEntry;

    private String bankUserId;

    private String bankUserName;

    private String bankAccountNo;

    public BankUserEntry() {
    }

    public BankUserEntry(final Long bankUserEntry, final String bankUserId, final String bankUserName, final String bankAccountNo) {
        this.bankUserEntry = bankUserEntry;
        this.bankUserId = bankUserId;
        this.bankUserName = bankUserName;
        this.bankAccountNo = bankAccountNo;
    }

    public String getBankUserId() {
        return bankUserId;
    }

    public void setBankUserId(final String bankUserId) {
        this.bankUserId = bankUserId;
    }

    public String getBankUserName() {
        return bankUserName;
    }

    public void setBankUserName(final String bankUserName) {
        this.bankUserName = bankUserName;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(final String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        final BankUserEntry that = (BankUserEntry) o;

        return new EqualsBuilder()
                .append(bankUserId, that.bankUserId)
                .append(bankUserName, that.bankUserName)
                .append(bankAccountNo, that.bankAccountNo)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(bankUserId)
                .append(bankUserName)
                .append(bankAccountNo)
                .toHashCode();
    }
}
