import axios from '../http'

export function GetListBookingByID(id){
    return axios.get('/admin/booking',{
        params:{
            id: id,
        }
    }).then(respone => {
        return respone;
    }).catch(e=> {
        console.log(e);
    });
}