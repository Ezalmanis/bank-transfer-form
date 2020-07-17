import React from "react";
import style from "../../../../css/FormModule.module.css";

export function PaymentHeader() {
    // const count = useSelector(selectCount);
    // const dispatch = useDispatch();
    // const [incrementAmount, setIncrementAmount] = useState('2');

    const customerNumberLabel= 'Customer Number';
    const currentDateLabel= 'Current Date';

    return (
        <div>
            <h1>Payment Order</h1>
            <h2>Bank information</h2>
            <div className={style.flexcontainer}>
                <div className={style.flexleftcollumn}>
                    <div>Demo bank name here</div>
                    <div>Demo bank Address here</div>
                </div>

                <div className={style.flexcontainer}>
                    <div className={style.flexleftcollumn}>
                        <div className={style.flexallignend}>
                            <label for={'customerNumber'}> {customerNumberLabel}</label>
                            <input id={'customerNumber'} name={'customer number'}/>
                        </div>
                        <div className={style.flexallignend}>
                            <label for={'date'}>{currentDateLabel}</label>
                            <input id={'date'} name={ 'Current Date' }/>
                        </div>
                    </div>
                </div>
            </div>
            <hr className={style.formseparator}/>
        </div>
    );
}