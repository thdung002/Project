import axios from '../http'

export async function GetAllPlane(){
    return await axios.get('/admin/plane').then(respone => {
        return respone;
    }).catch(e=> {
        console.log(e);
    });

}
export async function
Delete(id){
    return await axios.post('/admin/plane/delete',null,{
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
AddPlane(id_sale, planename){
    return axios.post('/admin/plane',null,{
        params:{
            id_sale: id_sale,
            planename: planename
        }
    }).then(response =>{
        return response;
    }).catch(e=>{
        console.log(e);
    })
}

