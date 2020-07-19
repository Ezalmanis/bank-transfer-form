import React from "react";
import style from "../../../../../css/FormModule.module.css";
import TextField from "@material-ui/core/TextField";
import {useDispatch, useSelector} from "react-redux";
import {
    beneficiaryBank,
    beneficiaryBankAccountNo, beneficiaryBankCode, beneficiaryBankUserId,
    beneficiaryBankUserName, beneficiaryResidenceCountry,
} from "../../../../components/payments/reducers/paymentSlice";

export function BeneficiaryInputs() {

    const beneficiaryNameLabel = 'Beneficiary name and surname or company name here';
    const beneficiaryIdLabel = 'Beneficiary Personal id or registration number here';
    const beneficiaryBankCodeLabel = 'Bank Code';
    const beneficiaryBankLabel = 'Beneficiary bank';
    const beneficiaryAccountNumberLabel = 'Account number';
    const beneficiaryResidenceCountryLabel = 'Residence country';

    const dispatch = useDispatch();

    return (
        <div>
            <div className={style.flexallignend}>
                <label className={style.accessibility} htmlFor={'beneficiaryNameInput'}>{beneficiaryNameLabel}</label>
                <TextField id={'beneficiaryNameInput'}
                           name={beneficiaryNameLabel}
                           value={useSelector((state=>state.payment.beneficiary.bankUserName))}
                           onChange={(event) => dispatch(beneficiaryBankUserName(event.target.value))}
                />
            </div>
            <div className={style.flexallignend}>
                <label className={style.accessibility} htmlFor={'beneficiaryIdInput'}>{beneficiaryIdLabel}</label>
                <TextField id={'beneficiaryIdInput'}
                           name={beneficiaryIdLabel}
                           value={useSelector((state=>state.payment.beneficiary.bankUserId))}
                           onChange={(event) => dispatch(beneficiaryBankUserId(event.target.value))}
                />
            </div>
            <div className={style.flexallignend}>
                <label className={style.accessibility}
                       htmlFor={'beneficiaryAccountNumberLabel'}> {beneficiaryAccountNumberLabel}</label>
                <TextField id={'beneficiaryAccountNumberLabel'}
                           name={beneficiaryAccountNumberLabel}
                           value={useSelector((state=>state.payment.beneficiary.bankAccountNo))}
                           onChange={(event) => dispatch(beneficiaryBankAccountNo(event.target.value))}
                />
            </div>
            <div className={style.flexallignend}>
                <label className={style.accessibility}
                       htmlFor={'beneficiaryResidenceCountry'}>{beneficiaryResidenceCountryLabel}</label>
                <TextField id={'beneficiaryResidenceCountry'}
                           name={beneficiaryResidenceCountryLabel}
                           value={useSelector((state=>state.payment.beneficiary.beneficiaryResidenceCountry))}
                           onChange={(event) => dispatch(beneficiaryResidenceCountry(event.target.value))}
                />
            </div>
            <div className={style.flexallignend}>
                <label className={style.accessibility}
                       htmlFor={'beneficiaryBankCode'}> {beneficiaryBankCodeLabel}</label>
                <TextField id={'beneficiaryBankCode'}
                           name={beneficiaryBankCodeLabel}
                           value={useSelector((state=>state.payment.beneficiary.beneficiaryBank))}
                           onChange={(event) => dispatch(beneficiaryBank(event.target.value))}
                />
            </div>
            <div className={style.flexallignend}>
                <label className={style.accessibility} htmlFor={'beneficiaryBank'}>{beneficiaryBankLabel}</label>
                <TextField id={'beneficiaryBank'}
                           name={beneficiaryBankLabel}
                           value={useSelector((state=>state.payment.beneficiary.beneficiaryBankCode))}
                           onChange={(event) => dispatch(beneficiaryBankCode(event.target.value))}
                />
            </div>
        </div>

    );
}
