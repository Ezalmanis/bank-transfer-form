import React from "react";
import style from "../../../../../css/FormModule.module.css";

export function BeneficiaryEntryNames() {

    return (
        <div className={style.flexleftcollumn}>
            <div>
                Name, Surname
            </div>
            <div>
                Personal ID number
            </div>
            <div>
                Bank Code
            </div>
            <div>
                Beneficiary bank
            </div>
            <div>
                Account number
            </div>
            <div>
                Residence country
            </div>
        </div>
    );
}
