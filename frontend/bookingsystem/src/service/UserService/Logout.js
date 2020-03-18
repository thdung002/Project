import axios from '../http'

export function Logout(){
    return axios.get('/logout').then(respone => {
        return respone;
    }).catch(e=> {
        console.log(e);
    });

}