import React from "react";
import style from "../../../../../css/FormModule.module.css";
import {ExchangeRate} from "./ExchangeRate";
import {AmountInFigures} from "./AmountInFigures";
import {BankFee} from "./BankFee";
import {Currency} from "./Currency";
import {PaymentType} from "./PaymentType";
import {ValueDate} from "./ValueDate";
import {AmountInWords} from "./AmountInWords";
import {PaymentDetails} from "./PaymentDetails";
import TextField from "@material-ui/core/TextField";

export function PaymentInputs() {

    const externalPaymentLabel = 'Code of external payment';

    return (
        <div className={style.flexcontainer}>
            <div className={style.flexcontainer}>
                <div className={style.flexleftcollumn}>
                    <AmountInFigures/>
                    <BankFee/>
                    <AmountInWords/>
                    <Currency/>
                    <PaymentType/>
                    <ExchangeRate/>
                    <ValueDate/>
                    <div className={style.flexallignend} >
                        <label className={style.accessibility} htmlFor={'externalPayment'}> {externalPaymentLabel}</label>
                        <TextField id={'externalPayment'} name={externalPaymentLabel}/>
                    </div>
                    <PaymentDetails/>
                </div>
            </div>
        </div>
    );
}
