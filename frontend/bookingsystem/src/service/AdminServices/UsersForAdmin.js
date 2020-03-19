import axios from '../http'

export async function GetAllAccounts(){
    return await axios.get('/admin/users').then(respone => {
        return respone;
    }).catch(e=> {
        console.log(e);
    });

}