import React from "react";
import style from "../../../../../css/FormModule.module.css";

export function RemitterEntryNames() {

    return (
        <div className={style.flexleftcollumn}>
            <div>
                Name, Surname
            </div>
            <div>
                Personal ID number
            </div>
            <div>
                Account Number
            </div>
        </div>
    );
}
