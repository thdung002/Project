import axios from '../http'

export function PlaneForUser(){
    return axios.get('admin/plane?id='+ this.$cookie.get('CurrentAccountID')).then(respone => {
        return respone;
    }).catch(e=> {
        console.log(e);
    });

}