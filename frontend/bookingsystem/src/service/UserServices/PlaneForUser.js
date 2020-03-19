import axios from '../http'

export async function PlaneForUser(){
    return await axios.get('/user/plane').then(respone => {
        return respone;
    }).catch(e=> {
        console.log(e);
    });

}