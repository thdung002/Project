import axios from '../http'

export function PlaneForSale(){
    return axios.get("http://localhost:8000/plane").then(respone => {
        return respone.data;
    }).catch(e=> {
        console.log(e);
    });

}