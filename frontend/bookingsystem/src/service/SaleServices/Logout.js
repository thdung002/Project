import axios from '../http'

export  function Logout(){
    return  axios.post('/logout').catch(e=> {
        console.log(e);
    });

}