import style from "../../../../../css/FormModule.module.css";
import React from "react";
import TextField from "@material-ui/core/TextField";
import {useDispatch, useSelector} from "react-redux";
import {amountInWords} from "../../../../components/payments/reducers/paymentSlice";

export function AmountInWords() {
    const amountLabel = 'Amount in words';

    const dispatch = useDispatch();

    return (
        <div className={style.flexallignend}>
            <label className={style.accessibility} htmlFor={'amountInWords'}> {amountLabel}</label>
            <TextField id={'amountInWords'}
                       name={'Amount in words'}
                       value={useSelector((state=>state.payment.paymentInformation.amountInWords))}
                       onChange={(event) => dispatch(amountInWords(event.target.value))}
            />
        </div>
    );
}
