import React from "react";
import style from "../../../../css/FormModule.module.css";
import {TermsOfServiceForm} from "./components/TermsOfServiceForm";

export function SignatureForm() {
    // const count = useSelector(selectCount);
    // const dispatch = useDispatch();
    // const [incrementAmount, setIncrementAmount] = useState('2');

    return (
        <div>
            <h2>Terms Of Service</h2>
            <TermsOfServiceForm/>
            <hr className={style.formseparator}/>
        </div>
    );
}