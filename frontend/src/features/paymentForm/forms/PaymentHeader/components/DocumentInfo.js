import style from "../../../../../css/FormModule.module.css";
import React from "react";


export function DocumentInfo() {

    return (
        <div className={style.flexleftcollumn}>
            <div>
                Customer Number
            </div>
            <div>
                Current Date
            </div>
        </div>
    );
}