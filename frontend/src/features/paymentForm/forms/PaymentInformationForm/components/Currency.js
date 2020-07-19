import style from "../../../../../css/FormModule.module.css";
import React from "react";
import TextField from "@material-ui/core/TextField";

export function Currency() {
    const currencyLabel = 'Currency';


    return (
        <div className={style.flexallignend}>
            <label className={style.accessibility} htmlFor={'currency'}> {currencyLabel}</label>
            <TextField id={'currency'} name={'currencyType'} value={'EUR'} disabled={true}/>
        </div>
    );
}
