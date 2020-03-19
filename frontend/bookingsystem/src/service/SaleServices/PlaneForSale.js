import axios from '../http'

export async function  PlaneForSale(id){
    return await  axios.get('/sale/plane',{
        params:{
            id: id,
        }
    } ).then(respone => {
        return respone;
    }).catch(e=> {
        console.log(e);
    });

}