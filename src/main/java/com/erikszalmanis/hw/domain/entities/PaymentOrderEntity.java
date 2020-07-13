package com.erikszalmanis.hw.domain.entities;

import com.erikszalmanis.hw.domain.enums.PaymentStatus;
import com.erikszalmanis.hw.domain.enums.PaymentType;
import com.erikszalmanis.hw.domain.objects.Beneficiary;
import com.erikszalmanis.hw.domain.objects.PaymentInformation;
import com.erikszalmanis.hw.domain.objects.PaymentOrder;
import com.erikszalmanis.hw.domain.objects.Remitter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity(name = "PAYMENT_ORDER")
public class PaymentOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long documentId;
    private Long clientId;
    private LocalDate documentDate;
    private PaymentStatus status;
    private boolean termsOfService;

    private String remitterName;
    private Long remitterId;
    private Long remitterBankAccountNo;

    private String beneficiaryName;
    private Long beneficiaryId;
    private Long beneficiaryAccountNo;
    private String beneficiaryResidenceCountry;
    private String beneficiaryBank;
    private String beneficiaryBankCode;

    private String amountInWords;
    private Double amountToTransferFromRemitter;
    private Double amountToTransferToBeneficiary;
    //todo enum;
    private String currencyType;
    private PaymentType paymentType;
    private LocalDate valuedAtDate;
    private String paymentDetails;
    private Double bankFee;
    private Double exchangeRate;
    private String externalPaymentCode;

    public PaymentOrderEntity() {
    }

    public PaymentOrderEntity(final Long documentId, final Long clientId, final LocalDate documentDate,
                              final PaymentStatus status, final boolean termsOfService, final String remitterName,
                              final Long remitterId, final Long remitterBankAccountNo, final String beneficiaryName,
                              final Long beneficiaryId, final Long beneficiaryAccountNo,
                              final String beneficiaryResidenceCountry, final String beneficiaryBank,
                              final String beneficiaryBankCode, final String amountInWords, final Double amountToTransferFromRemitter,
                              final Double amountToTransferToBeneficiary, final String currencyType,
                              final PaymentType paymentType, final LocalDate valuedAtDate, final String paymentDetails,
                              final Double bankFee, final Double exchangeRate, final String externalPaymentCode) {
        this.documentId = documentId;
        this.clientId = clientId;
        this.documentDate = documentDate;
        this.status = status;
        this.termsOfService = termsOfService;
        this.remitterName = remitterName;
        this.remitterId = remitterId;
        this.remitterBankAccountNo = remitterBankAccountNo;
        this.beneficiaryName = beneficiaryName;
        this.beneficiaryId = beneficiaryId;
        this.beneficiaryAccountNo = beneficiaryAccountNo;
        this.beneficiaryResidenceCountry = beneficiaryResidenceCountry;
        this.beneficiaryBank = beneficiaryBank;
        this.beneficiaryBankCode = beneficiaryBankCode;
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

    public String getRemitterName() {
        return remitterName;
    }

    public void setRemitterName(final String remitterName) {
        this.remitterName = remitterName;
    }

    public Long getRemitterId() {
        return remitterId;
    }

    public void setRemitterId(final Long remitterId) {
        this.remitterId = remitterId;
    }

    public Long getRemitterBankAccountNo() {
        return remitterBankAccountNo;
    }

    public void setRemitterBankAccountNo(final Long remitterBankAccountNo) {
        this.remitterBankAccountNo = remitterBankAccountNo;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public void setBeneficiaryName(final String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    public Long getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(final Long beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public Long getBeneficiaryAccountNo() {
        return beneficiaryAccountNo;
    }

    public void setBeneficiaryAccountNo(final Long beneficiaryAccountNo) {
        this.beneficiaryAccountNo = beneficiaryAccountNo;
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

    public String getAmountInWords() {
        return amountInWords;
    }

    public void setAmountInWords(final String amountInWords) {
        this.amountInWords = amountInWords;
    }

    public Double getAmountToTransferFromRemitter() {
        return amountToTransferFromRemitter;
    }

    public void setAmountToTransferFromRemitter(final Double amountToTransfer) {
        this.amountToTransferFromRemitter = amountToTransfer;
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

    public void setValuedAtDate(final LocalDate valueDate) {
        this.valuedAtDate = valueDate;
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

    public Double getAmountToTransferToBeneficiary() {
        return amountToTransferToBeneficiary;
    }

    public void setAmountToTransferToBeneficiary(final Double amountToTransferToBeneficiary) {
        this.amountToTransferToBeneficiary = amountToTransferToBeneficiary;
    }

    public void updatePaymentOrder(final PaymentOrder order) {
        final Beneficiary beneficiary = order.getBeneficiary();
        final Remitter remitter = order.getRemitter();
        final PaymentInformation paymentInformation = order.getPaymentInformation();

        this.clientId = order.getClientId();
        this.documentDate = order.getDocumentDate();
        this.status = order.getStatus();
        this.termsOfService = order.isTermsOfService();
        this.remitterName = remitter.getBankUserName();
        this.remitterId = remitter.getBankUserId();
        this.remitterBankAccountNo = remitter.getBankAccountNo();
        this.beneficiaryName = beneficiary.getBankUserName();
        this.beneficiaryId = beneficiary.getBankUserId();
        this.beneficiaryAccountNo = beneficiary.getBankAccountNo();
        this.beneficiaryResidenceCountry = beneficiary.getBeneficiaryResidenceCountry();
        this.beneficiaryBank = beneficiary.getBeneficiaryBank();
        this.beneficiaryBankCode = beneficiary.getBeneficiaryBankCode();
        this.amountInWords = paymentInformation.getAmountInWords();
        this.amountToTransferFromRemitter = paymentInformation.getAmountToTransferFromRemitter();
        this.currencyType = paymentInformation.getCurrencyType();
        this.paymentType = paymentInformation.getPaymentType();
        this.valuedAtDate = paymentInformation.getValuedAtDate();
        this.paymentDetails = paymentInformation.getPaymentDetails();
        this.bankFee = paymentInformation.getBankFee();
        this.exchangeRate = paymentInformation.getExchangeRate();
        this.externalPaymentCode = paymentInformation.getExternalPaymentCode();
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
                .append(getRemitterName(), that.getRemitterName())
                .append(getRemitterId(), that.getRemitterId())
                .append(getRemitterBankAccountNo(), that.getRemitterBankAccountNo())
                .append(getBeneficiaryName(), that.getBeneficiaryName())
                .append(getBeneficiaryId(), that.getBeneficiaryId())
                .append(getBeneficiaryAccountNo(), that.getBeneficiaryAccountNo())
                .append(getBeneficiaryResidenceCountry(), that.getBeneficiaryResidenceCountry())
                .append(getBeneficiaryBank(), that.getBeneficiaryBank())
                .append(getBeneficiaryBankCode(), that.getBeneficiaryBankCode())
                .append(getAmountInWords(), that.getAmountInWords())
                .append(getAmountToTransferFromRemitter(), that.getAmountToTransferFromRemitter())
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
                .append(getDocumentId())
                .append(getClientId())
                .append(getDocumentDate())
                .append(getStatus())
                .append(isTermsOfService())
                .append(getRemitterName())
                .append(getRemitterId())
                .append(getRemitterBankAccountNo())
                .append(getBeneficiaryName())
                .append(getBeneficiaryId())
                .append(getBeneficiaryAccountNo())
                .append(getBeneficiaryResidenceCountry())
                .append(getBeneficiaryBank())
                .append(getBeneficiaryBankCode())
                .append(getAmountInWords())
                .append(getAmountToTransferFromRemitter())
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
                .append("documentId", documentId)
                .append("clientId", clientId)
                .append("documentDate", documentDate)
                .append("status", status)
                .append("termsOfService", termsOfService)
                .append("remitterName", remitterName)
                .append("remitterId", remitterId)
                .append("remitterBankAccountNo", remitterBankAccountNo)
                .append("beneficiaryName", beneficiaryName)
                .append("beneficiaryId", beneficiaryId)
                .append("beneficiaryAccountNo", beneficiaryAccountNo)
                .append("beneficiaryResidenceCountry", beneficiaryResidenceCountry)
                .append("beneficiaryBank", beneficiaryBank)
                .append("beneficiaryBankCode", beneficiaryBankCode)
                .append("amountInWords", amountInWords)
                .append("amountToTransfer", amountToTransferFromRemitter)
                .append("currencyType", currencyType)
                .append("paymentType", paymentType)
                .append("valueDate", valuedAtDate)
                .append("paymentDetails", paymentDetails)
                .append("bankFee", bankFee)
                .append("exchangeRate", exchangeRate)
                .append("externalPaymentCode", externalPaymentCode)
                .toString();
    }

}
