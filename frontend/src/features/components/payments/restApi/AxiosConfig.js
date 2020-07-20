import axios from "axios";

axios.defaults.baseURL = '';
axios.defaults.headers.post['Content-Type'] = 'application/json';

//todo, actully make this with dev-mode in mind

export default axios({
    baseURL: "http://localhost:8075",
    headers: {
        'Content-Type': 'application/json',
        // 'Access-Control-Allow-Origin': '*'
    }
});
