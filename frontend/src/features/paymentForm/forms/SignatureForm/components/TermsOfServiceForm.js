import React from "react";
import style from "../../../../../css/FormModule.module.css";
import Checkbox from "@material-ui/core/Checkbox";
import Button from "@material-ui/core/Button";
import Grid from "@material-ui/core/Grid";
import {useDispatch, useSelector} from "react-redux";
import {
    selectPayment,
    selectTermsOfService,
    termsOfService
} from "../../../../components/payments/reducers/paymentSlice";
import {SubmitPayment} from "../../../../components/payments/restApi/RestApi";

export function TermsOfServiceForm() {


    const termsOfServiceStatement = 'I have read and accept the terms of service'

    const dispatch = useDispatch();
    const termsOfServiceValue = useSelector(selectTermsOfService);
    const payment = useSelector(selectPayment);


    const openModel = () => {

    }


    const handleCheckbox = (event) => {
        dispatch(termsOfService(event.target.checked));
    };

    function handleSubmit() {
        //Add modals
        SubmitPayment(payment).then(r => {

        }).catch(

        );
    }

    return (

        <div className={style.flexcontainer}>

            <Grid aria-label={'Terms of service'}>
                <label htmlFor={'termsOfService'}>{termsOfServiceStatement}</label>
                <Checkbox id={'termsOfService'} value={termsOfServiceValue} onChange={handleCheckbox}/>
                <Grid>
                    <Button disabled={!termsOfServiceValue} color={'primary'}
                            onClick={()=>handleSubmit()}>Submit</Button>
                </Grid>
            </Grid>
        </div>
    );
}
