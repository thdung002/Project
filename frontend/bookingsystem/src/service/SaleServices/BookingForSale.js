import axios from '../http'

export async function GetListBookingByID(id){
    return await axios.get('/sale/booking',{
        params:{
            id: id,
        }
    }).then(respone => {

        return respone;
    }).catch(e=> {
        console.log(e);
    });
}