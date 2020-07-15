package com.erikszalmanis.hw.domain;

import com.erikszalmanis.hw.domain.enums.PaymentStatus;
import com.erikszalmanis.hw.domain.enums.PaymentType;
import com.erikszalmanis.hw.domain.objects.Beneficiary;
import com.erikszalmanis.hw.domain.objects.PaymentInformation;
import com.erikszalmanis.hw.domain.objects.PaymentOrder;
import com.erikszalmanis.hw.domain.objects.Remitter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class PaymentOrderDomainTest {

    private static final Long REMITTER_ID = 123L;
    private static final Long BENEFICIARY_ID = 321L;
    private static final Long BENEFICIARY_ACCOUNT_NO = 100L;
    private static final Long REMITTER_ACCOUNT_NO = 200L;
    private static final Double AMOUNT_TO_TRANSFER_FROM_REMITTER = 200.2d;
    private static final Double AMOUNT_TO_TRANSFER_FROM_BENEFICIARY = 200.2d;
    private static final Double BANK_FEE = 0.2d;
    private static final Double EXCHANGE_RATE = 1.1212d;
    private static final Long DOCUMENT_ID = 300L;

    private static final Long CLIENT_ID = 213L;
    private static final LocalDate TODAY = LocalDate.now();
    private static final PaymentStatus PENDING_STATUS = PaymentStatus.PENDING;
    private static final boolean TERMS_OF_SERVICE = true;

    private static Beneficiary getCorrectBeneficiary() {
        return new Beneficiary("expectedBeneficiary", PaymentOrderDomainTest.REMITTER_ID, PaymentOrderDomainTest.REMITTER_ACCOUNT_NO, "expectedCountry",
                "expectedBank", "expectedBankCode");
    }

    ///
    ///Auxiliary methods
    ///

    private static PaymentInformation getCorrectPaymentInformation() {

        return new PaymentInformation("expectedAmount", PaymentOrderDomainTest.AMOUNT_TO_TRANSFER_FROM_REMITTER, PaymentOrderDomainTest.AMOUNT_TO_TRANSFER_FROM_BENEFICIARY, "EUR",
                PaymentType.CASH, LocalDate.now(), "expectedDetails", PaymentOrderDomainTest.BANK_FEE, PaymentOrderDomainTest.EXCHANGE_RATE,
                "expectedPaymentCode");
    }

    private static Remitter getCorrectRemitter() {
        return new Remitter("expectedRemitter", PaymentOrderDomainTest.BENEFICIARY_ID, PaymentOrderDomainTest.BENEFICIARY_ACCOUNT_NO);
    }

    @Test
    public void paymentOrderPopulatedCorrectly() {
        final PaymentInformation expectedPaymentInformation = getCorrectPaymentInformation();
        final Beneficiary expectedBeneficiary = getCorrectBeneficiary();
        final Remitter expectedRemitter = getCorrectRemitter();

        final PaymentOrder expectedPaymentOrder = new PaymentOrder(CLIENT_ID, TODAY, expectedRemitter, expectedBeneficiary, expectedPaymentInformation, PENDING_STATUS, TERMS_OF_SERVICE);
        expectedPaymentOrder.setDocumentId(DOCUMENT_ID);
        assertPaymentOrderPopulated(expectedPaymentOrder);
        Assertions.assertEquals(expectedBeneficiary, expectedPaymentOrder.getBeneficiary());
        Assertions.assertEquals(expectedRemitter, expectedPaymentOrder.getRemitter());
        Assertions.assertEquals(expectedPaymentInformation, expectedPaymentOrder.getPaymentInformation());

    }

    private void assertPaymentOrderPopulated(final PaymentOrder paymentOrder) {
        Assertions.assertNotNull(paymentOrder);
        Assertions.assertEquals(CLIENT_ID, paymentOrder.getClientId());
        Assertions.assertEquals(TODAY, paymentOrder.getDocumentDate());
        Assertions.assertEquals(DOCUMENT_ID, paymentOrder.getDocumentId());
        Assertions.assertEquals(PENDING_STATUS, paymentOrder.getStatus());

    }

}
