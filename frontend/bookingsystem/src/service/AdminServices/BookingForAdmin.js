import axios from '../http'

export async function GetAllBooking(){
    return await axios.get('/admin/booking').then(respone => {
        return respone;
    }).catch(e=> {
        console.log(e);
    });

}