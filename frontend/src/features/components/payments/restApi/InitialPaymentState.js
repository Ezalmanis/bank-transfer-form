export const InitialPaymentState = {

    documentId: null,
    clientId: null,
    documentDate: null,
    status: null,
    termsOfService: null,
    remitter: {
        bankUserName: null,
        bankUserId: null,
        bankAccountNo: null
    },
    beneficiary: {
        bankUserName: null,
        bankUserId: null,
        bankAccountNo: null,
        beneficiaryResidenceCountry: null,
        beneficiaryBank: null,
        beneficiaryBankCode: null
    },
    paymentInformation: {
        amountInWords: null,
        amountToTransferFromRemitter: null,
        amountToTransferToBeneficiary: null,
        currencyType: null,
        paymentType: null,
        valuedAtDate: null,
        paymentDetails: null,
        bankFee: null,
        exchangeRate: null,
        externalPaymentCode: null
    }
};

