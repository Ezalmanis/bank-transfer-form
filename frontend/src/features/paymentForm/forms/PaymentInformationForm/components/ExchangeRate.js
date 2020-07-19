import React from "react";
import style from "../../../../../css/FormModule.module.css";
import TextField from "@material-ui/core/TextField";
import {UseFetchExchangeRate} from "../../../../components/payments/restApi/RestApi";
import {useSelector} from "react-redux";

export function ExchangeRate() {

    const exchangeRateLabel = 'Exchange rate';
    const fetchedExchangeRate = UseFetchExchangeRate();
    const exchangeRateValue = Number(useSelector(state=>state.payment.paymentInformation.exchangeRate)).toPrecision(3);

    return (
        <div className={style.flexallignend} >
            <label className={style.accessibility}  htmlFor={'exchangeRate'}> {exchangeRateLabel}</label>
            <TextField id={'exchangeRate'} name={'Exchange rate'} value={exchangeRateValue} disabled={true}/>
        </div>
    )

}