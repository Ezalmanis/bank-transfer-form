import React from "react";
import style from "../../../../../css/FormModule.module.css";
import TextField from "@material-ui/core/TextField";
import {UseFetchExchangeRate} from "../../../../components/payments/restApi/RestApi";

export function ExchangeRate() {

    const exchangeRateLabel = 'Exchange rate';

    const fetchedExchangeRate = UseFetchExchangeRate();

    return (
        <div className={style.flexallignend} >
            <label className={style.accessibility}  htmlFor={'exchangeRate'}> {exchangeRateLabel}</label>
            <TextField id={'exchangeRate'} name={'Exchange rate'} value={'1.00'} disabled={true}/>
        </div>
    )

}