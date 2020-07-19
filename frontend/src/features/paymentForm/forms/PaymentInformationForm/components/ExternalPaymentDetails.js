import React from "react";
import style from "../../../../../css/FormModule.module.css";
import TextField from "@material-ui/core/TextField";
import {useDispatch, useSelector} from "react-redux";
import {externalPaymentCode} from "../../../../components/payments/reducers/paymentSlice";

export function ExternalPaymentDetails() {
    const dispatch = useDispatch();
    const externalPaymentLabel = 'Code of external payment';

    return (
        <div className={style.flexallignend}>
            <label className={style.accessibility} htmlFor={'externalPayment'}> {externalPaymentLabel}</label>
            <TextField id={'externalPayment'}
                       name={externalPaymentLabel}
                       value={useSelector((state=>state.payment.paymentInformation.externalPaymentCode))}
                       onChange={(event) => dispatch(externalPaymentCode(event.target.value))}
            />
        </div>
    );
}
