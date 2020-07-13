package com.erikszalmanis.hw.domain.objects;

import com.erikszalmanis.hw.domain.enums.PaymentType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class PaymentInformation {

    @NotEmpty
    private String amountInWords;
    @NotNull
    private Double amountToTransferFromRemitter;
    @NotNull
    private Double amountToTransferToBeneficiary;
    @NotEmpty
    private String currencyType;
    @NotNull
    private PaymentType paymentType;
    @NotNull
    private LocalDate valuedAtDate;
    @NotEmpty
    private String paymentDetails;
    @NotNull
    private Double bankFee;
    @NotNull
    private Double exchangeRate;
    @NotEmpty
    private String externalPaymentCode;

    public PaymentInformation() {
    }

    public PaymentInformation(@NotEmpty final String amountInWords, @NotNull final Double amountToTransferFromRemitter, @NotNull final Double amountToTransferToBeneficiary, @NotEmpty final String currencyType, @NotNull final PaymentType paymentType, @NotNull final LocalDate valuedAtDate, @NotEmpty final String paymentDetails, @NotNull final Double bankFee, @NotNull final Double exchangeRate, @NotEmpty final String externalPaymentCode) {
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

        final PaymentInformation that = (PaymentInformation) o;

        return new EqualsBuilder()
                .append(getAmountInWords(), that.getAmountInWords())
                .append(getAmountToTransferFromRemitter(), that.getAmountToTransferFromRemitter())
                .append(getAmountToTransferToBeneficiary(), that.getAmountToTransferToBeneficiary())
                .append(getCurrencyType(), that.getCurrencyType())
                .append(getPaymentType(), that.getPaymentType())
                .append(getValuedAtDate(), that.getValuedAtDate())
                .append(getPaymentDetails(), that.getPaymentDetails())
                .append(getBankFee(), that.getBankFee())
                .append(getExchangeRate(), that.getExchangeRate())
                .append(getExternalPaymentCode(), that.getExternalPaymentCode())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getAmountInWords())
                .append(getAmountToTransferFromRemitter())
                .append(getAmountToTransferToBeneficiary())
                .append(getCurrencyType())
                .append(getPaymentType())
                .append(getValuedAtDate())
                .append(getPaymentDetails())
                .append(getBankFee())
                .append(getExchangeRate())
                .append(getExternalPaymentCode())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
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
