import {createSlice} from '@reduxjs/toolkit';

export const paymentSlice = createSlice({
    name: 'payment',
    initialState: {
        documentId: 1,
        clientId: 4001,
        documentDate: null,
        status: 'PENDING',
        termsOfService: false,
        remitter: {
            bankUserName: "TestPayment",
            bankUserId: 101,
            bankAccountNo: 201
        },
        beneficiary: {
            bankUserName: "TestPayment",
            bankUserId: 301,
            bankAccountNo: 401,
            beneficiaryResidenceCountry: "TestPayment",
            beneficiaryBank: "TestPayment",
            beneficiaryBankCode: "TestPayment"
        },
        paymentInformation: {
            amountInWords: "TestPayment",
            amountToTransferFromRemitter: 22.02,
            amountToTransferToBeneficiary: 22.02,
            currencyType: null,
            paymentType: "CASH",
            valuedAtDate: null,
            paymentDetails: "TestPayment",
            bankFee: 1.02,
            exchangeRate: 2.02,
            externalPaymentCode: "TestPayment"
        }

    },

    reducers: {
        clientId: (state, action) => {
            state.clientId = action.payload;
        },
        documentDate: (state, action) => {
            state.documentDate = action.payload;
        },
        status: (state, action) => {
            state.status = action.payload;
        },
        termsOfService: (state, action) => {
            state.termsOfService = action.payload;
        },
        remitterBankUserName: (state, action) => {
            state.remitter.bankUserName = action.payload;
        },
        remitterBankUserId: (state, action) => {
            state.remitter.bankUserId = action.payload;
        },
        remitterBankAccountNo: (state, action) => {
            state.remitter.bankAccountNo = action.payload;
        },
        beneficiaryBankUserName: (state, action) => {
            state.beneficiary.bankUserName = action.payload;
        },
        beneficiaryBankUserId: (state, action) => {
            state.beneficiary.bankUserId = action.payload;
        },
        beneficiaryBankAccountNo: (state, action) => {
            state.beneficiary.bankAccountNo = action.payload;
        },
        beneficiaryResidenceCountry: (state, action) => {
            state.beneficiary.beneficiaryResidenceCountry = action.payload;
        },
        beneficiaryBank: (state, action) => {
            state.beneficiary.beneficiaryBank = action.payload;
        },
        beneficiaryBankCode: (state, action) => {
            state.beneficiary.beneficiaryBankCode = action.payload;
        },
        amountInWords: (state, action) => {
            state.paymentInformation.amountInWords = action.payload;
        },
        amountToTransferFromRemitter: (state, action) => {
            state.paymentInformation.amountToTransferFromRemitter = action.payload;
        },
        amountToTransferToBeneficiary: (state, action) => {
            state.paymentInformation.amountToTransferToBeneficiary = action.payload;
        },
        currencyType: (state, action) => {
            state.paymentInformation.currencyType = action.payload;
        },
        paymentType: (state, action) => {
            state.paymentInformation.paymentType = action.payload;
        },
        valuedAtDate: (state, action) => {
            console.log(JSON.stringify(state));
            console.log(action.payload);
            state.paymentInformation.valuedAtDate = action.payload;
            console.log(state.paymentInformation.valuedAtDate)
        },
        paymentDetails: (state, action) => {
            state.paymentInformation.paymentDetails = action.payload;
        },
        bankFeeAmount: (state, action) => {
            state.paymentInformation.bankFee = action.payload;
        },
        exchangeRate: (state, action) => {
            state.paymentInformation.exchangeRate = action.payload;
        },
        externalPaymentCode: (state, action) => {
            state.paymentInformation.externalPaymentCode = action.payload;
        },
    },
});

export const {
    clientId,
    documentDate,
    status,
    termsOfService,
    remitterBankUserName,
    remitterBankUserId,
    remitterBankAccountNo,
    beneficiaryBankUserName,
    beneficiaryBankUserId,
    beneficiaryBankAccountNo,
    beneficiaryResidenceCountry,
    beneficiaryBank,
    beneficiaryBankCode,
    amountInWords,
    amountToTransferFromRemitter,
    amountToTransferToBeneficiary,
    currencyType,
    paymentType,
    valuedAtDate,
    paymentDetails,
    bankFeeAmount,
    exchangeRate,
    externalPaymentCode
} = paymentSlice.actions;

// The function below is called a selector and allows us to select a value from
// the state. Selectors can also be defined inline where they're used instead of
// in the slice file. For example: `useSelector((state) => state.counter.value)`
export const selectPayment = state => state.payment;
export const selectCurrencyType = state => state.payment.paymentInformation.currencyType;
export const selectValuedAtDate = state => state.payment.paymentInformation.valuedAtDate;
export const selectTermsOfService = state => state.payment.termsOfService;



export default paymentSlice.reducer;
