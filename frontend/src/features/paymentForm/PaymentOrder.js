import React from 'react';
import {PaymentHeader} from "./forms/PaymentHeader/PaymentHeader";
import {RemitterForm} from "./forms/Remitter/RemitterForm";
import {BeneficiaryForm} from "./forms/Beneficiary/BeneficiaryForm";
import {PaymentInformationForm} from "./forms/PaymentInformationForm/PaymentInformationForm";
import {SignatureForm} from "./forms/SignatureForm/SignatureForm";


export function PaymentOrder() {
    // const count = useSelector(selectCount);
    // const dispatch = useDispatch();
    // const [incrementAmount, setIncrementAmount] = useState('2');

    return (
        <div>
            <PaymentHeader/>
            <RemitterForm/>
            <BeneficiaryForm/>
            <PaymentInformationForm/>
            <SignatureForm/>
        </div>
    );
}
