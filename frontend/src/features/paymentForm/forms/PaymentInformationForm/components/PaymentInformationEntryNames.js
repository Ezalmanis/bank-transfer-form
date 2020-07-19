import React from "react";
import style from "../../../../../css/FormModule.module.css";

export function PaymentInformationEntryNames() {

    return (
        <div className={style.flexleftcollumn}>
            <div>
                Amount in figures
            </div>
            <div>
                Bank Fee
            </div>
            <div>
                Amount in words
            </div>
            <div>
                Currency
            </div>
            <div>
                Payment type
            </div>
            <div>
                Exchange rate
            </div>
            <div>
                Value date
            </div>
            <div>
                Code of external payment
            </div>
            <div>
                Payment Details
            </div>
        </div>
    );
}
