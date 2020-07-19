package com.erikszalmanis.hw.domain.entities;

import com.erikszalmanis.hw.domain.enums.PaymentStatus;
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

@Entity(name = "PAYMENT_ORDER")
public class PaymentOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long documentId;
    private String clientId;
    private LocalDate documentDate;
    private PaymentStatus status;
    private boolean termsOfService;

    @OneToOne(cascade = CascadeType.ALL)
    private RemitterEntry remitterEntity;

    @OneToOne(cascade = CascadeType.ALL)
    private BeneficiaryEntry beneficiaryEntity;

    @OneToOne(cascade = CascadeType.ALL)
    private PaymentInformationEntity paymentInformationEntity;

    public PaymentOrderEntity() {
    }

    public PaymentOrderEntity(final Long documentId, final String clientId, final LocalDate documentDate, final PaymentStatus status, final boolean termsOfService, final RemitterEntry remitterEntity, final BeneficiaryEntry beneficiaryEntity, final PaymentInformationEntity paymentInformationEntity) {
        this.documentId = documentId;
        this.clientId = clientId;
        this.documentDate = documentDate;
        this.status = status;
        this.termsOfService = termsOfService;
        this.remitterEntity = remitterEntity;
        this.beneficiaryEntity = beneficiaryEntity;
        this.paymentInformationEntity = paymentInformationEntity;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(final Long documentId) {
        this.documentId = documentId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(final String clientId) {
        this.clientId = clientId;
    }

    public LocalDate getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(final LocalDate documentDate) {
        this.documentDate = documentDate;
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

    public RemitterEntry getRemitterEntity() {
        return remitterEntity;
    }

    public void setRemitterEntity(final RemitterEntry remitterEntity) {
        this.remitterEntity = remitterEntity;
    }

    public BeneficiaryEntry getBeneficiaryEntity() {
        return beneficiaryEntity;
    }

    public void setBeneficiaryEntity(final BeneficiaryEntry beneficiaryEntity) {
        this.beneficiaryEntity = beneficiaryEntity;
    }

    public PaymentInformationEntity getPaymentInformationEntity() {
        return paymentInformationEntity;
    }

    public void setPaymentInformationEntity(final PaymentInformationEntity paymentInformationEntity) {
        this.paymentInformationEntity = paymentInformationEntity;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        final PaymentOrderEntity that = (PaymentOrderEntity) o;

        return new EqualsBuilder()
                .append(isTermsOfService(), that.isTermsOfService())
                .append(getDocumentId(), that.getDocumentId())
                .append(getClientId(), that.getClientId())
                .append(getDocumentDate(), that.getDocumentDate())
                .append(getStatus(), that.getStatus())
                .append(getRemitterEntity(), that.getRemitterEntity())
                .append(getBeneficiaryEntity(), that.getBeneficiaryEntity())
                .append(getPaymentInformationEntity(), that.getPaymentInformationEntity())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getDocumentId())
                .append(getClientId())
                .append(getDocumentDate())
                .append(getStatus())
                .append(isTermsOfService())
                .append(getRemitterEntity())
                .append(getBeneficiaryEntity())
                .append(getPaymentInformationEntity())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("documentId", documentId)
                .append("clientId", clientId)
                .append("documentDate", documentDate)
                .append("status", status)
                .append("termsOfService", termsOfService)
                .append("remitterEntity", remitterEntity)
                .append("beneficiaryEntity", beneficiaryEntity)
                .append("paymentInformationEntity", paymentInformationEntity)
                .toString();
    }
}
