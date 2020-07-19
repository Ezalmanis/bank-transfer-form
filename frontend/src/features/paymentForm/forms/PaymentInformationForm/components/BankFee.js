import style from "../../../../../css/FormModule.module.css";
import React from "react";
import TextField from "@material-ui/core/TextField";
import {useDispatch, useSelector} from "react-redux";
import { bankFeeAmount} from "../../../../components/payments/reducers/paymentSlice";

export function BankFee() {

    const dispatch = useDispatch();
    const defaultFee = 1.02
    dispatch(bankFeeAmount(defaultFee));
    const bankFeeLabel = 'Bank Fee'

    return (
        <div className={style.flexallignend}>
            <label className={style.accessibility} htmlFor={'bankFee'}>{bankFeeLabel}</label>
            <TextField
                id={'bankFee'}
                name={'bankFee'}
                value={useSelector((state => state.payment.paymentInformation.bankFee))}
                disabled={true}/>
        </div>
    );
}
