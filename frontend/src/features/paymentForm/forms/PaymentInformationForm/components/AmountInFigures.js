import style from "../../../../../css/FormModule.module.css";
import React from "react";
import TextField from "@material-ui/core/TextField";
import {useDispatch, useSelector} from "react-redux";
import {
    amountToTransferFromRemitter,
    amountToTransferToBeneficiary
} from "../../../../components/payments/reducers/paymentSlice";

export function AmountInFigures() {
    const amountLabel = 'Amount in figures';

    const dispatch = useDispatch();

    const exchangeRate = useSelector((state => state.payment.paymentInformation.exchangeRate))

    //TODO, add logic here
    function handleAmountChange(event) {
        dispatch(amountToTransferFromRemitter(event.target.value));
        dispatch(amountToTransferToBeneficiary(event.target.value * exchangeRate));
    }

    return (
        <div className={style.flexallignend}>
            <label className={style.accessibility} htmlFor={'amount'}> {amountLabel}</label>
            <TextField type={'number'}
                       id={'amount'}
                       name={'Amount'}
                       value={useSelector((state => state.payment.paymentInformation.amountToTransferFromRemitter))}
                       onChange={(event) => handleAmountChange(event)}
            />
        </div>
    );
}
