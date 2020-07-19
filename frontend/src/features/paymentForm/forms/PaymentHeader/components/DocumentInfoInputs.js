import React from "react";
import style from "../../../../../css/FormModule.module.css";
import {dateNow} from "../../../formatters/GetCurrentDate";
import TextField from "@material-ui/core/TextField";
import {useDispatch, useSelector} from "react-redux";
import {clientId, documentDate} from "../../../../components/payments/reducers/paymentSlice";

export function DocumentInfoInputs() {

    const customerNumberLabel = 'Customer Number';
    const currentDateLabel = 'Current Date';
    const dateToday = dateNow();
    const dispatch = useDispatch();
    dispatch(documentDate(dateToday));

    return (
        <div className={style.flexleftcollumn}>
            <div className={style.flexallignend}>
                <label className={style.accessibility} htmlFor={'customerNumber'}> {customerNumberLabel}</label>
                <TextField  id={'customerNumber'}
                            name={'Customer number'}
                            value={useSelector((state=>state.payment.clientId))}
                            onChange={(event) => dispatch(clientId(event.target.value))
                }/>
            </div>
            <div className={style.flexallignend}>
                <label className={style.accessibility} htmlFor={'date'}>{currentDateLabel}</label>
                <TextField id={'date'}
                           name={'Current Date'}
                           type={'date'}
                           value={useSelector((state=>state.payment.documentDate))} disabled={true}/>
            </div>
        </div>

    );
}


