import React from "react";
import style from "../../../../../css/FormModule.module.css";

export function RemitterInputs() {

    const remitterNameLabel = 'Enter Remitter name/surname or company name here'
    const remitterIdLabel = 'Enter Remitter Personal id or registration number here'
    const remitterAccountNumberLabel = 'Enter Remitter Account number here'

    return (
        <div className={style.flexcontainer}>
            <div className={style.flexcontainer}>
                <div className={style.flexleftcollumn}>
                    <div className={style.flexallignend}>
                        <label className={style.accessibility} htmlFor={'remitterNameInput'}>{remitterNameLabel}</label>
                        <input id={'remitterNameInput'} name={'Remitter Name/Surname/Company name'}/>
                    </div>
                    <div className={style.flexallignend}>
                        <label className={style.accessibility} htmlFor={'remitterIdInput'}>{remitterIdLabel}</label>
                        <input id={'remitterIdInput'} name={'Enter Remitter Personal Id or Registration number here'}/>
                    </div>
                    <div className={style.flexallignend}>
                        <label className={style.accessibility} htmlFor={'remitterAccountNumberInput'}>{remitterAccountNumberLabel}</label>
                        <input id={'remitterAccountNumberInput'} name={'Enter Remitter Account number herte'}/>
                    </div>
                </div>
            </div>
        </div>
    );
}
