import axios from "axios";

axios.defaults.baseURL = 'http://localhost:8075';
axios.defaults.headers.post['Content-Type'] = 'application/json'
//TODO, make devmode setting for cors, for now this will do
axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';

export const GetExchangeRate = () => {
    return axios.get('/payment/rates');
};

export const UpdatePaymentStatus = (id, status) => {
    return axios.post('/payment/' + id + '/' + status);
};

export const CreatePayment = data => {
    return axios.post("/payment", data);
};

export const GetPayments = () => {
    return axios.get('/payments');
};