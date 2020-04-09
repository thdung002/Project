import axios from '../http'
export async function GetCheckingCookies(id){
    return await axios.get('/checkingcookie',{
        params:{
            id:id,
        }
    }).then(respone=> {
        return respone;
    }).catch(e => {
        console.log(e);
    });
}

