import axios from '../http'
export function AddBooking(fn,email,phone,date,idplane,time,idsale){
    return axios.post('/booking/add',null,{
        params:{
            fn: fn,
            email: email,
            phone: phone,
            date: date,
            idplane: idplane,
            time: time,
            idsale: idsale
        }
    }).then(respone=> {
            return respone;
    })
}