import React from 'react';
import style from "../../../../css/FormModule.module.css";
import {PaymentInformationEntryNames} from "./components/PaymentInformationEntryNames";
import {PaymentInputs} from "./components/PaymentInputs";

export function PaymentInformationForm() {
    // const count = useSelector(selectCount);
    // const dispatch = useDispatch();
    // const [incrementAmount, setIncrementAmount] = useState('2');

    return (
        <div>
            <h2>Payment Information</h2>
            <div className={style.flexcontainer}>
                <PaymentInformationEntryNames/>
                <PaymentInputs/>
            </div>
            <hr className={style.formseparator}/>
        </div>
    );
}
