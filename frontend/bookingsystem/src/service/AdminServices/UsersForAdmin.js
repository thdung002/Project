import axios from '../http'

export async function GetAllAccounts(){
    return await axios.get('/admin/users').then(respone => {
        return respone;
    }).catch(e=> {
        console.log(e);
    });

}
export async function
Delete(id){
    return await axios.post('/admin/users/delete',null,{
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
AddUser(fn,usrname,pwd,at){
    return axios.post('/admin/users',null,{
        params:{
            fullname: fn,
            username: usrname,
            password: pwd,
            accounttype: at,
        }
    }).then(response =>{
        return response;
    }).catch(e=>{
        console.log(e);
    })
}
