import React from "react";
import style from "../../../../../css/FormModule.module.css";
import TextField from "@material-ui/core/TextField";
import {useDispatch, useSelector} from "react-redux";
import {
    remitterBankAccountNo,
    remitterBankUserId,
    remitterBankUserName
} from "../../../../components/payments/reducers/paymentSlice";

export function RemitterInputs() {

    const remitterNameLabel = 'Remitter name and surname or company name here'
    const remitterIdLabel = 'Remitter Personal id or registration number here'
    const remitterAccountNumberLabel = 'Remitter Account number here'

    const dispatch = useDispatch();

    return (
        <div className={style.flexcontainer}>
            <div className={style.flexcontainer}>
                <div className={style.flexleftcollumn}>
                    <div className={style.flexallignend}>
                        <label className={style.accessibility} htmlFor={'remitterNameInput'}>{remitterNameLabel}</label>
                        <TextField id={'remitterNameInput'}
                                   name={'Remitter Name/Surname/Company name'}
                                   value={useSelector((state=>state.payment.remitter.bankUserName))}
                                   onChange={(event) => dispatch(remitterBankUserName(event.target.value))}
                        />
                    </div>
                    <div className={style.flexallignend}>
                        <label className={style.accessibility} htmlFor={'remitterIdInput'}>{remitterIdLabel}</label>
                        <TextField id={'remitterIdInput'}
                                   name={'Enter Remitter Personal Id or Registration number here'}
                                   value={useSelector((state=>state.payment.remitter.bankUserId))}
                                   onChange={(event) => dispatch(remitterBankUserId(event.target.value))}
                        />
                    </div>
                    <div className={style.flexallignend}>
                        <label className={style.accessibility} htmlFor={'remitterAccountNumberInput'}>{remitterAccountNumberLabel}</label>
                        <TextField id={'remitterAccountNumberInput'}
                                   name={'Enter Remitter Account number herte'}
                                   value={useSelector((state=>state.payment.remitter.bankAccountNo))}
                                   onChange={(event) => dispatch(remitterBankAccountNo(event.target.value))}
                        />
                    </div>
                </div>
            </div>
        </div>
    );
}
