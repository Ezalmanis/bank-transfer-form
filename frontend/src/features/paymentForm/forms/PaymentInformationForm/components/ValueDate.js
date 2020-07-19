import style from "../../../../../css/FormModule.module.css";
import React from "react";
import TextField from "@material-ui/core/TextField";
import {selectValuedAtDate} from "../../../../components/payments/reducers/paymentSlice";
import {useSelector} from "react-redux";

export function ValueDate() {

    const valuedAtDate = useSelector(selectValuedAtDate);
    const valueDateLabel = 'Value Date'

    return (
        <div className={style.flexallignend}>
            <label className={style.accessibility} htmlFor={'valueDate'}>{valueDateLabel}</label>
            <TextField value={valuedAtDate} id={'valueDate'} name={'valueDate'} type={'date'} disabled={true} />
        </div>
    );
}
