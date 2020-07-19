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
import {ExternalPaymentDetails} from "./ExternalPaymentDetails";

export function PaymentInputs() {

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
                    <ExternalPaymentDetails/>
                    <PaymentDetails/>
                </div>
            </div>
        </div>
    );
}
