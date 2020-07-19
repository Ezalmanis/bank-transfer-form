import React from "react";
import style from "../../../../css/FormModule.module.css";
import {BeneficiaryEntryNames} from "./components/BeneficiaryEntryNames";
import {BeneficiaryInputs} from "./components/BeneficiaryInputs";


//TODO, work on this
export function BeneficiaryForm() {
    // const count = useSelector(selectCount);
    // const dispatch = useDispatch();
    // const [incrementAmount, setIncrementAmount] = useState('2');


    return (
        <div>
            <h2>Beneficiary</h2>
            <div className={style.flexcontainer}>
                <BeneficiaryEntryNames/>
                <BeneficiaryInputs/>
            </div>
            <hr className={style.formseparator}/>
        </div>
    );
}