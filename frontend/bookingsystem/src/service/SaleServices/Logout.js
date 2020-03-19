import axios from '../http'

export async function Logout(){
    return await axios.get('/logout').then(respone => {
        return respone;
    }).catch(e=> {
        console.log(e);
    });

}