import axios from '../http'

export async function Logout(){
    return await axios.post('/logout').catch(e=> {
        console.log(e);
    });

}