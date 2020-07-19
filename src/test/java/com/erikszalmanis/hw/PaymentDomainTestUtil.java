package com.erikszalmanis.hw;

import com.erikszalmanis.hw.domain.entities.BeneficiaryEntry;
import com.erikszalmanis.hw.domain.entities.PaymentInformationEntity;
import com.erikszalmanis.hw.domain.entities.PaymentOrderEntity;
import com.erikszalmanis.hw.domain.entities.RemitterEntry;
import com.erikszalmanis.hw.domain.enums.PaymentStatus;
import com.erikszalmanis.hw.domain.enums.PaymentType;
import com.erikszalmanis.hw.domain.objects.Beneficiary;
import com.erikszalmanis.hw.domain.objects.PaymentInformation;
import com.erikszalmanis.hw.domain.objects.PaymentOrder;
import com.erikszalmanis.hw.domain.objects.Remitter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PaymentDomainTestUtil {

    private static final Long DOCUMENT_ID = 1L;
    private static final String CLIENT_ID = "4000C";
    private static final LocalDate DOCUMENT_DATE = LocalDate.now();
    private static final boolean TERMS_OF_SERVICE = true;
    private static final List<PaymentStatus> PAYMENT_STATUSES = Collections.unmodifiableList(Arrays.asList(PaymentStatus.values()));

    private static final String REMITTER_ID = "100R";
    private static final String REMITTER_BANK_ACCOUNT_NO = "200B";
    private static final String REMITTER_NAME = "remitterName%s";

    private static final String BENEFICIARY_ID = "300B";
    private static final String BENEFICIARY_ACCOUNT_NO = "400B";
    private static final String BENEFICIARY_NAME = "beneficiaryName%s";
    private static final String BENEFICIARY_COUNTRY = "beneficiaryCountry%s";
    private static final String BENEFICIARY_BANK = "beneficiaryBank%s";
    private static final String BENEFICIARY_BANK_CODE = "beneficiaryBankCode%s";

    private static final String AMOUNT_IN_WORDS = "amountInWords%s";
    private static final Double AMOUNT_TO_TRANSFER_FROM_REMITTER = 20.02;
    private static final Double AMOUNT_TO_TRANSFER_TO_BENEFICIARY = 21.02;

    private static final String CURRENCY_TYPE = "EUR";
    private static final PaymentType PAYMENT_TYPE = PaymentType.CASH;
    private static final LocalDate VALUED_AT_DATE = LocalDate.now();
    private static final String PAYMENT_DETAILS = "paymentDetails%s";
    private static final Double BANK_FEE = 0.02;
    private static final Double EXCHANGE_RATE = 1.02;
    private static final String PAYMENT_CODE = "paymentCode%s";

    public static PaymentOrder getCorrectPaymentOrder(final int counter) {
        final Long documentId = DOCUMENT_ID + counter;
        final String clientId = CLIENT_ID + counter;
        final LocalDate documentDate = DOCUMENT_DATE.plusDays(counter);

        final PaymentStatus paymentStatus = PAYMENT_STATUSES.get(counter % PAYMENT_STATUSES.size());
        final Beneficiary beneficiary = getCorrectBeneficiary(counter);
        final PaymentInformation paymentInformation = getCorrectPaymentInformation(counter);
        final Remitter remitter = getCorrectRemitter(counter);

        final PaymentOrder paymentOrder = new PaymentOrder();
        paymentOrder.setDocumentId(documentId);
        paymentOrder.setClientId(clientId);
        paymentOrder.setDocumentDate(documentDate);
        paymentOrder.setStatus(paymentStatus);
        paymentOrder.setPaymentInformation(paymentInformation);
        paymentOrder.setRemitter(remitter);
        paymentOrder.setBeneficiary(beneficiary);
        paymentOrder.setTermsOfService(TERMS_OF_SERVICE);

        return paymentOrder;
    }

    static Beneficiary getCorrectBeneficiary(final int counter) {
        final String beneficiaryId = BENEFICIARY_ID + counter;
        final String beneficiaryAccountNo = BENEFICIARY_ACCOUNT_NO + counter;
        final String beneficiaryName = String.format(BENEFICIARY_NAME, counter);
        final String beneficiaryCountry = String.format(BENEFICIARY_COUNTRY, counter);
        final String beneficiaryBank = String.format(BENEFICIARY_BANK, counter);
        final String beneficiaryBankCode = String.format(BENEFICIARY_BANK_CODE, counter);

        return new Beneficiary(beneficiaryName, beneficiaryId, beneficiaryAccountNo, beneficiaryCountry,
                beneficiaryBank, beneficiaryBankCode);
    }

    static PaymentInformation getCorrectPaymentInformation(final int counter) {
        final Double amountToTransferFromRemitter = AMOUNT_TO_TRANSFER_FROM_REMITTER + counter;
        final Double amountToTransferToBeneficiary = AMOUNT_TO_TRANSFER_TO_BENEFICIARY + counter;
        final Double bankFee = BANK_FEE + counter;
        final Double exchangeRate = EXCHANGE_RATE + counter;
        final String amountInWords = String.format(AMOUNT_IN_WORDS, counter);
        final String paymentDetails = String.format(PAYMENT_DETAILS, counter);
        final String paymentCode = String.format(PAYMENT_CODE, counter);

        final LocalDate valuedAtDate = VALUED_AT_DATE.plusWeeks(counter);

        return new PaymentInformation(amountInWords, amountToTransferFromRemitter, amountToTransferToBeneficiary, CURRENCY_TYPE,
                PAYMENT_TYPE, valuedAtDate, paymentDetails, bankFee, exchangeRate,
                paymentCode);
    }

    static Remitter getCorrectRemitter(final int counter) {
        final String remitterId = REMITTER_ID + counter;
        final String remitterBankAccountNo = REMITTER_BANK_ACCOUNT_NO + counter;
        final String remitterName = String.format(REMITTER_NAME, counter);
        return new Remitter(remitterName, remitterId, remitterBankAccountNo);
    }


    public static PaymentOrderEntity getEntityCorrectPaymentOrder(final int counter) {

        final PaymentOrderEntity entity = new PaymentOrderEntity();

        setPaymentEntity(counter, entity);

        setRemitter(counter, entity);

        setBeneficiary(counter, entity);

        setPaymentInformation(counter, entity);

        return entity;
    }

    private static void setPaymentEntity(final int counter, final PaymentOrderEntity entity) {
        final Long documentId = DOCUMENT_ID + counter;
        final String clientId = CLIENT_ID + counter;
        final LocalDate documentDate = DOCUMENT_DATE.plusDays(counter);
        final PaymentStatus status = PAYMENT_STATUSES.get(counter % PAYMENT_STATUSES.size());

        entity.setDocumentId(documentId);
        entity.setClientId(clientId);
        entity.setDocumentDate(documentDate);
        entity.setStatus(status);
        entity.setTermsOfService(TERMS_OF_SERVICE);
    }

    private static void setRemitter(final int counter, final PaymentOrderEntity entity) {
        final RemitterEntry remitterEntity = new RemitterEntry();

        final String remitterId = REMITTER_ID + counter;
        final String remitterBankAccountNo = REMITTER_BANK_ACCOUNT_NO + counter;
        final String remitterName = String.format(REMITTER_NAME, counter);
        remitterEntity.setBankUserName(remitterName);
        remitterEntity.setBankUserId(remitterId);
        remitterEntity.setBankAccountNo(remitterBankAccountNo);
        entity.setRemitterEntity(remitterEntity);
    }

    private static void setBeneficiary(final int counter, final PaymentOrderEntity entity) {
        final BeneficiaryEntry beneficiaryEntity = new BeneficiaryEntry();

        final String beneficiaryId = BENEFICIARY_ID + counter;
        final String beneficiaryAccountNo = BENEFICIARY_ACCOUNT_NO + counter;
        final String beneficiaryName = String.format(BENEFICIARY_NAME, counter);
        final String beneficiaryCountry = String.format(BENEFICIARY_COUNTRY, counter);
        final String beneficiaryBank = String.format(BENEFICIARY_BANK, counter);
        final String beneficiaryBankCode = String.format(BENEFICIARY_BANK_CODE, counter);
        beneficiaryEntity.setBankUserName(beneficiaryName);
        beneficiaryEntity.setBankUserId(beneficiaryId);
        beneficiaryEntity.setBankAccountNo(beneficiaryAccountNo);
        beneficiaryEntity.setResidenceCountry(beneficiaryCountry);
        beneficiaryEntity.setBeneficiaryBank(beneficiaryBank);
        beneficiaryEntity.setBankCode(beneficiaryBankCode);

        entity.setBeneficiaryEntity(beneficiaryEntity);

    }

    private static void setPaymentInformation(final int counter, final PaymentOrderEntity entity) {
        final PaymentInformationEntity paymentInformationEntity = new PaymentInformationEntity();

        final String amountInWords = String.format(AMOUNT_IN_WORDS, counter);
        final Double amountToTransferFromRemitter = AMOUNT_TO_TRANSFER_FROM_REMITTER + counter;
        final Double amountToTransferToBeneficiary = AMOUNT_TO_TRANSFER_TO_BENEFICIARY + counter;
        final LocalDate valuedAtDate = VALUED_AT_DATE.plusWeeks(counter);
        final String paymentDetails = String.format(PAYMENT_DETAILS, counter);
        final Double bankFee = BANK_FEE + counter;
        final Double exchangeRate = EXCHANGE_RATE + counter;
        final String paymentCode = String.format(PAYMENT_CODE, counter);


        paymentInformationEntity.setAmountInWords(amountInWords);
        paymentInformationEntity.setAmountToTransferFromRemitter(amountToTransferFromRemitter);
        paymentInformationEntity.setAmountToTransferToBeneficiary(amountToTransferToBeneficiary);
        paymentInformationEntity.setCurrencyType(CURRENCY_TYPE);
        paymentInformationEntity.setPaymentType(PAYMENT_TYPE);
        paymentInformationEntity.setValuedAtDate(valuedAtDate);
        paymentInformationEntity.setPaymentDetails(paymentDetails);
        paymentInformationEntity.setBankFee(bankFee);
        paymentInformationEntity.setExchangeRate(exchangeRate);
        paymentInformationEntity.setExternalPaymentCode(paymentCode);

        entity.setPaymentInformationEntity(paymentInformationEntity);
    }


}
