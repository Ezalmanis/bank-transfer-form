import React from "react";
import style from "../../../../css/FormModule.module.css";
import {RemitterInputs} from "./components/RemitterInputs";
import {RemitterEntryNames} from "./components/RemitterEntryNames";

export function RemitterForm() {
    // const count = useSelector(selectCount);
    // const dispatch = useDispatch();
    // const [incrementAmount, setIncrementAmount] = useState('2');

    return (
        <div>
            <h2>Remitter</h2>
            <div className={style.flexcontainer}>
                <RemitterEntryNames/>
                <RemitterInputs/>
            </div>
            <hr className={style.formseparator}/>
        </div>
    );
}