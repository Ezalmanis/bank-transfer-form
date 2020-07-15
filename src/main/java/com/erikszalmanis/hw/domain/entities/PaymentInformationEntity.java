package com.erikszalmanis.hw.domain.entities;

import com.erikszalmanis.hw.domain.enums.PaymentType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Entity
public class PaymentInformationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paymentInfoId;
    @OneToOne(cascade = CascadeType.ALL)
    private PaymentOrderEntity paymentOrderEntity;
    private String amountInWords;
    private Double amountToTransferFromRemitter;
    private Double amountToTransferToBeneficiary;
    private String currencyType;
    private PaymentType paymentType;
    private LocalDate valuedAtDate;
    private String paymentDetails;
    private Double bankFee;
    private Double exchangeRate;
    private String externalPaymentCode;

    public PaymentInformationEntity() {
    }

    public PaymentInformationEntity(final Long paymentInfoId, final PaymentOrderEntity paymentOrderEntity, final String amountInWords, final Double amountToTransferFromRemitter, final Double amountToTransferToBeneficiary, final String currencyType, final PaymentType paymentType, final LocalDate valuedAtDate, final String paymentDetails, final Double bankFee, final Double exchangeRate, final String externalPaymentCode) {
        this.paymentInfoId = paymentInfoId;
        this.paymentOrderEntity = paymentOrderEntity;
        this.amountInWords = amountInWords;
        this.amountToTransferFromRemitter = amountToTransferFromRemitter;
        this.amountToTransferToBeneficiary = amountToTransferToBeneficiary;
        this.currencyType = currencyType;
        this.paymentType = paymentType;
        this.valuedAtDate = valuedAtDate;
        this.paymentDetails = paymentDetails;
        this.bankFee = bankFee;
        this.exchangeRate = exchangeRate;
        this.externalPaymentCode = externalPaymentCode;
    }

    public Long getPaymentInfoId() {
        return paymentInfoId;
    }

    public void setPaymentInfoId(final Long paymentInfoId) {
        this.paymentInfoId = paymentInfoId;
    }

    public PaymentOrderEntity getPaymentOrderEntity() {
        return paymentOrderEntity;
    }

    public void setPaymentOrderEntity(final PaymentOrderEntity paymentOrderEntity) {
        this.paymentOrderEntity = paymentOrderEntity;
    }

    public String getAmountInWords() {
        return amountInWords;
    }

    public void setAmountInWords(final String amountInWords) {
        this.amountInWords = amountInWords;
    }

    public Double getAmountToTransferFromRemitter() {
        return amountToTransferFromRemitter;
    }

    public void setAmountToTransferFromRemitter(final Double amountToTransferFromRemitter) {
        this.amountToTransferFromRemitter = amountToTransferFromRemitter;
    }

    public Double getAmountToTransferToBeneficiary() {
        return amountToTransferToBeneficiary;
    }

    public void setAmountToTransferToBeneficiary(final Double amountToTransferToBeneficiary) {
        this.amountToTransferToBeneficiary = amountToTransferToBeneficiary;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(final String currencyType) {
        this.currencyType = currencyType;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(final PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public LocalDate getValuedAtDate() {
        return valuedAtDate;
    }

    public void setValuedAtDate(final LocalDate valuedAtDate) {
        this.valuedAtDate = valuedAtDate;
    }

    public String getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(final String paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public Double getBankFee() {
        return bankFee;
    }

    public void setBankFee(final Double bankFee) {
        this.bankFee = bankFee;
    }

    public Double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(final Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getExternalPaymentCode() {
        return externalPaymentCode;
    }

    public void setExternalPaymentCode(final String externalPaymentCode) {
        this.externalPaymentCode = externalPaymentCode;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        final PaymentInformationEntity that = (PaymentInformationEntity) o;

        return new EqualsBuilder()
                .append(paymentInfoId, that.paymentInfoId)
                .append(paymentOrderEntity, that.paymentOrderEntity)
                .append(amountInWords, that.amountInWords)
                .append(amountToTransferFromRemitter, that.amountToTransferFromRemitter)
                .append(amountToTransferToBeneficiary, that.amountToTransferToBeneficiary)
                .append(currencyType, that.currencyType)
                .append(paymentType, that.paymentType)
                .append(valuedAtDate, that.valuedAtDate)
                .append(paymentDetails, that.paymentDetails)
                .append(bankFee, that.bankFee)
                .append(exchangeRate, that.exchangeRate)
                .append(externalPaymentCode, that.externalPaymentCode)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(paymentInfoId)
                .append(paymentOrderEntity)
                .append(amountInWords)
                .append(amountToTransferFromRemitter)
                .append(amountToTransferToBeneficiary)
                .append(currencyType)
                .append(paymentType)
                .append(valuedAtDate)
                .append(paymentDetails)
                .append(bankFee)
                .append(exchangeRate)
                .append(externalPaymentCode)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("paymentInfoId", paymentInfoId)
                .append("paymentOrderEntity", paymentOrderEntity)
                .append("amountInWords", amountInWords)
                .append("amountToTransferFromRemitter", amountToTransferFromRemitter)
                .append("amountToTransferToBeneficiary", amountToTransferToBeneficiary)
                .append("currencyType", currencyType)
                .append("paymentType", paymentType)
                .append("valuedAtDate", valuedAtDate)
                .append("paymentDetails", paymentDetails)
                .append("bankFee", bankFee)
                .append("exchangeRate", exchangeRate)
                .append("externalPaymentCode", externalPaymentCode)
                .toString();
    }
}
