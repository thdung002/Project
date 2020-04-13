import axios from '../http'

export async function
GetSchedulerForSale(id){
    return await axios.get('/sale/scheduler' ,{
        params:{
            id: id,
        }
    }).then(respone => {
        console.log(respone);
        return respone;
    }).catch(e=> {
        console.log(e);
    });

}
export async function
Delete(id){
    return await axios.post('/sale/scheduler/delete',null,{
        params:{
            id: id
        }
    }).then(respone=>{
        return respone;
    }).catch(e=> {
        console.log(e);
    });
}

export function
AddScheduler(id,date,start,end,idplane){
    return axios.post('/sale/scheduler',null,{
        params:{
            id: id,
            date: date,
            start: start,
            end: end,
            idplane: idplane
        }
    }).then(respone=>
    {
        return respone;
    }).catch(e=> {
        console.log(e);
    });
}