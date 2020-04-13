import axios from '../http'

export async function GetAllBooking(){
    return await axios.get('/admin/booking').then(respone => {
        return respone;
    }).catch(e=> {
        console.log(e);
    });

}
export async function
Delete(id){
    return await axios.post('/admin/booking',null,{
        params:{
            id: id
        }
    }).then(respone=>{
        return respone;
    }).catch(e=> {
        console.log(e);
    });
}

