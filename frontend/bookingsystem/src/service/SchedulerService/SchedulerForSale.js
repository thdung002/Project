import axios from '../http'

export function
GetSchedulerForSale(id){
    return axios.get("http://localhost:8000/admin/sale?id=" + id).then(respone => {
        console.log(respone);
        return respone.data;
    }).catch(e=> {
        console.log(e);
    });

}

export function
AddScheduler(id,date,start,end,idplane){
    return axios.post("http://localhost:8000/admin/sale?id="+id+"&date="+date+"&start="+start+"&end="+end+"&idplane="+idplane).then(respone=>
    {
        return respone.data;
    }).catch(e=> {
        console.log(e);
    });
}