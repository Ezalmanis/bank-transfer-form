import React from "react";
import style from "../../../../../css/FormModule.module.css";
import TextField from "@material-ui/core/TextField";

export function PaymentDetails() {
    // const count = useSelector(selectCount);
    // const dispatch = useDispatch();
    // const [incrementAmount, setIncrementAmount] = useState('2');
    const paymentDetailsLabel = 'Payment Details';

    return (
        <div  className={style.flexallignend}>
            <label className={style.accessibility} htmlFor={'paymentDetails'}>{paymentDetailsLabel}</label>
            <TextField id={'paymentDetails'} name={paymentDetailsLabel}/>
        </div>
    );
}
