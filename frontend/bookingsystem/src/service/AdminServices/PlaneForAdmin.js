import axios from '../http'

export async function GetAllPlane(){
    return await axios.get('/admin/plane').then(respone => {
        return respone;
    }).catch(e=> {
        console.log(e);
    });

}