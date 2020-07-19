import React from "react";
import style from "../../../../../css/FormModule.module.css";
import Checkbox from "@material-ui/core/Checkbox";
import Grid from "@material-ui/core/Grid";
import {useDispatch, useSelector} from "react-redux";
import {
    selectTermsOfService,
    termsOfService
} from "../../../../components/payments/reducers/paymentSlice";
import SubmitButton from "./SubmitButton";

export function TermsOfServiceForm() {

    const termsOfServiceStatement = 'I have read and accept the terms of service'
    const dispatch = useDispatch();
    const termsOfServiceValue = useSelector(selectTermsOfService);

    const handleCheckbox = (event) => {
        dispatch(termsOfService(event.target.checked));
    };

    return (
        <div className={style.flexcontainer}>
            <Grid aria-label={'Terms of service'}>
                <label htmlFor={'termsOfService'}>{termsOfServiceStatement}</label>
                <Checkbox id={'termsOfService'} value={termsOfServiceValue} onChange={handleCheckbox}/>
                <SubmitButton/>
            </Grid>
        </div>
    );
}
