import React from "react";
import style from "../../../../../css/FormModule.module.css";
import TextField from "@material-ui/core/TextField";
import {useDispatch, useSelector} from "react-redux";
import {paymentDetails} from "../../../../components/payments/reducers/paymentSlice";

export function PaymentDetails() {
    const dispatch = useDispatch();
    const paymentDetailsLabel = 'Payment Details';

    return (
        <div className={style.flexallignend}>
            <label className={style.accessibility} htmlFor={'paymentDetails'}>{paymentDetailsLabel}</label>
            <TextField id={'paymentDetails'}
                       name={paymentDetailsLabel}
                       value={useSelector((state => state.payment.paymentInformation.paymentDetails))}
                       onChange={(event) => dispatch(paymentDetails(event.target.value))}
            />
        </div>
    );
}
