import style from "../../../../../css/FormModule.module.css";
import React from "react";
import Typography from "@material-ui/core/Typography";
import Grid from "@material-ui/core/Grid";
import PurpleSwitch from "@material-ui/core/Switch";

export function PaymentType() {

    const transferTypeCash = 'Cash';
    const transferTypeTransfer = 'Transfer';

    return (
        <div className={style.flexallignend}>
            <div aria-label={'Select transfer type'}>
                <Typography component="div">
                    <Grid component="label" container alignItems="center" spacing={1}>
                        <label className={style.accessibility} htmlFor={'cash'}>{transferTypeCash}</label>
                        <Grid item htmlFor={'cash'}>{transferTypeCash}</Grid>
                        <Grid item>
                            <PurpleSwitch name="checkedC"/>
                        </Grid>
                        <label className={style.accessibility} htmlFor={'transfer'}>{transferTypeTransfer}</label>
                        <Grid item id={'transfer'}>{transferTypeTransfer}</Grid>
                    </Grid>
                </Typography>
            </div>
        </div>
    );
}
