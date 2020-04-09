import axios from '../http'

export async function GetAllBooking(){
    return await axios.get('/admin/booking').then(respone => {
        return respone;
    }).catch(e=> {
        console.log(e);
    });

}
export function
Delete(id){
    return axios.post('/admin/booking/delete',null,{
        params:{
            id: id
        }
    }).then(respone=>{
        return respone;
    }).catch(e=> {
        console.log(e);
    });
}

