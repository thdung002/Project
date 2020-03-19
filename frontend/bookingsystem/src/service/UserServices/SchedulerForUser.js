import axios from '../http'
export async function GetScheduler(){
    return await axios.get('/user/scheduler').then(respone=> {
         return respone;
    }).catch(e=> {
        console.log(e);
    });
}