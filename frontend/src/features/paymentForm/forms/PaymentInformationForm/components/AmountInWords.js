import style from "../../../../../css/FormModule.module.css";
import React from "react";
import TextField from "@material-ui/core/TextField";

export function AmountInWords() {
    const amountLabel = 'Amount in words';


    return (
        <div className={style.flexallignend}>
            <label className={style.accessibility} htmlFor={'amountInWords'}> {amountLabel}</label>
            <TextField id={'amountInWords'} name={'Amount in words'}/>
        </div>
    );
}
