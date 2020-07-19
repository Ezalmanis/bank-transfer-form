import React from "react";
import style from "../../../../css/FormModule.module.css";
import bankLogo from "../../../../gentlemanparrot.gif";
import {DocumentInfo} from "./components/DocumentInfo";
import {DocumentInfoInputs} from "./components/DocumentInfoInputs";
import {useDispatch} from "react-redux";

export function PaymentHeader() {

    return (
        <div>
            <h1>Payment Order</h1>
            <h2>Bank information</h2>
            <img src={bankLogo} className="BankLogo" alt="Bank logo"/>
            <div className={style.flexleftcollumn}>
                <div className={style.bankInformation}>Gentleman Parrot Bank, Reg. nr 123456</div>
                <div className={style.bankInformation}>Demo street 50A, Paradise, PI-000, Parrot Island</div>
            </div>
            <h2>Document information</h2>
            <hr/>

            <div className={style.flexcontainer}>
                <DocumentInfo/>
                <DocumentInfoInputs/>
            </div>
            <hr className={style.formseparator}/>
        </div>
    );
}