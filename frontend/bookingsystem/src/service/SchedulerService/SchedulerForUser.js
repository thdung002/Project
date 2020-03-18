import axios from '../http'
export function GetScheduler(){
    return axios.get('/sale').then(respone=> {
         return respone;
    }).catch(e=> {
        console.log(e);
    });
}