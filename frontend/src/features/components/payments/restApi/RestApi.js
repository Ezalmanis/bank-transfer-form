import React, {useEffect, useState} from "react";
import {CreatePayment, GetExchangeRate, GetPayments, UpdatePaymentStatus} from "./RestConfig";
import {useDispatch, useSelector} from 'react-redux';
import {currencyType, exchangeRate, selectPayment, valuedAtDate,} from '../reducers/paymentSlice';


export const UseFetchPayments = () => {
    const [hasError, setErrors] = useState(false);
    const [payments, setPayments] = useState({});

    function fetchPayments() {
        GetPayments()
            .then(response => {
                console.log(JSON.stringify(response.data))
                setPayments({
                    payments: response.data,
                });
            })
            .catch(e => {
                console.log(e);
            });
    }

    useEffect(() => {
        fetchPayments()
    }, []);

    return ({payments});
};


export const UseFetchExchangeRate = () => {
    const [exchangeRateResponse, setExchangeRate] = useState({});
    const dispatch = useDispatch();

    async function fetchRates() {
        await GetExchangeRate()
            .then(response => {
                setExchangeRate(response.data);
                dispatch(currencyType(response.data.base));
                dispatch(valuedAtDate(response.data.date));
                dispatch(exchangeRate(1.00));
            })
            .catch(e => {
                console.log(e);
            });
    }

    useEffect(() => {
        fetchRates()
    }, []);
    console.log(JSON.stringify(useSelector(selectPayment)))
    return ({exchangeRateResponse});
};


export const UseUpdateStatus = (id, status) => {
    useEffect(() => {
        updatePayment(id, status)
    }, []);

    const [updateResponse, setUpdateResponse] = useState({});

    function updatePayment(id, status) {
        console.log(JSON.stringify(id), JSON.stringify(status));
        UpdatePaymentStatus(id, status)
            .then(response => {
                console.log(JSON.stringify(response.data))
                setUpdateResponse({
                    documentId: response.data.documentId,
                });
            })
            .catch(e => {
                console.log(e);
            });
    }

    return ({updateResponse})
}

export async function SubmitPayment(payment) {
    console.log(JSON.stringify(payment));
    await CreatePayment(JSON.stringify(payment))
        .then(response => {
            return response.data
        })
        .catch(e => {
            return null;
        });
}