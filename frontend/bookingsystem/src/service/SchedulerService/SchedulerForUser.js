import axios from '../http'
export function GetScheduler(){
    return axios.get("http://localhost:8000/sale").then(respone=> {
         return respone.data;
    }).catch(e=> {
        console.log(e);
    });
}