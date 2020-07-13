package com.erikszalmanis.hw.domain.objects;

import com.erikszalmanis.hw.domain.enums.PaymentStatus;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


public class PaymentOrder {

    private Long documentId;
    @NotNull(message = "clientId cannot be null")
    private Long clientId;

    @NotNull(message = "Date cannot be null")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate documentDate;
    @Valid
    private Remitter remitter;
    @Valid
    private Beneficiary beneficiary;
    @Valid
    private PaymentInformation paymentInformation;
    @NotNull
    private PaymentStatus status;
    @AssertTrue(message = "Please accept Terms of service")
    private boolean termsOfService;

    public PaymentOrder() {
        this.status = PaymentStatus.PENDING;
    }

    public PaymentOrder(final Long clientId, final LocalDate documentDate, final Remitter remitter, final Beneficiary beneficiary, final PaymentInformation paymentInformation, final PaymentStatus status, final boolean termsOfService) {
        this.clientId = clientId;
        this.documentDate = documentDate;
        this.remitter = remitter;
        this.beneficiary = beneficiary;
        this.paymentInformation = paymentInformation;
        this.status = status;
        this.termsOfService = termsOfService;
    }

    public PaymentOrder(final Long clientId, final LocalDate documentDate, final Remitter remitter, final Beneficiary beneficiary, final PaymentInformation paymentInformation, final boolean termsOfService) {
        this.clientId = clientId;
        this.documentDate = documentDate;
        this.remitter = remitter;
        this.beneficiary = beneficiary;
        this.paymentInformation = paymentInformation;
        this.status = PaymentStatus.PENDING;
        this.termsOfService = termsOfService;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(final Long documentId) {
        this.documentId = documentId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(final Long clientId) {
        this.clientId = clientId;
    }

    public LocalDate getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(final LocalDate documentDate) {
        this.documentDate = documentDate;
    }

    public Remitter getRemitter() {
        return remitter;
    }

    public void setRemitter(final Remitter remitter) {
        this.remitter = remitter;
    }

    public Beneficiary getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(final Beneficiary beneficiary) {
        this.beneficiary = beneficiary;
    }

    public PaymentInformation getPaymentInformation() {
        return paymentInformation;
    }

    public void setPaymentInformation(final PaymentInformation paymentInformation) {
        this.paymentInformation = paymentInformation;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(final PaymentStatus status) {
        this.status = status;
    }

    public boolean isTermsOfService() {
        return termsOfService;
    }

    public void setTermsOfService(final boolean termsOfService) {
        this.termsOfService = termsOfService;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("documentId", documentId)
                .append("clientId", clientId)
                .append("date", documentDate)
                .append("remitter", remitter)
                .append("beneficiary", beneficiary)
                .append("paymentInformation", paymentInformation)
                .append("status", status)
                .append("termsOfService", termsOfService)
                .toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        final PaymentOrder that = (PaymentOrder) o;

        return new EqualsBuilder()
                .append(getDocumentId(), that.getDocumentId())
                .append(getClientId(), that.getClientId())
                .append(getDocumentDate(), that.getDocumentDate())
                .append(getRemitter(), that.getRemitter())
                .append(getBeneficiary(), that.getBeneficiary())
                .append(getPaymentInformation(), that.getPaymentInformation())
                .append(getStatus(), that.getStatus())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getDocumentId())
                .append(getClientId())
                .append(getDocumentDate())
                .append(getRemitter())
                .append(getBeneficiary())
                .append(getPaymentInformation())
                .append(getStatus())
                .toHashCode();
    }
}
