import axios from '../http'

export function
GetSchedulerForSale(id){
    return axios.get('/admin/sale' ,{
        params:{
            id: id,
        }
    }).then(respone => {
        console.log(respone);
        return respone.data;
    }).catch(e=> {
        console.log(e);
    });

}

export function
AddScheduler(id,date,start,end,idplane){
    return axios.post('admin/sale',null,{
        params:{
            id: id,
            date: date,
            start: start,
            end: end,
            idplane: idplane
        }
    }).then(respone=>
    {
        return respone.data;
    }).catch(e=> {
        console.log(e);
    });
}