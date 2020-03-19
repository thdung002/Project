<template>
    <div class="row" id="form-login">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <form action="" method="post" @submit.prevent="login">
                <div class="panel panel-primary col-md-7">
                    <div class="panel-heading">Login</div>
                    <div class="panel-body">
                        <div class="form-group">
                            <label> Username </label>
                            <input type="text" v-model="formdata.username"/>
                        </div>
                        <div class="form-group">
                            <label> Password </label>
                            <input type="password" v-model="formdata.password"/>
                        </div>
                        <button class="form-group btn btn-success">Login
                        </button>
                        <button class="btn btn-danger" @click="Goback"> Back</button>
                    </div>
                </div>
            </form>
        </div>
    </div>


</template>

<script>
    import {Login} from "../service/SaleServices/Login";

    export default {
        name: "Login",
        data(){
            return {
                formdata:{
                    username:'',
                    password:'',
                },
            }
        },
        // beforeCreate(){
        //     if(this.$cookie.get('CurrentAccountID')!==null|| this.$cookie.get('CurrentAccountID')==='0')
        //     {
        //         this.$router.push('/scheduler');
        //     }
        // },
        methods:{
            login(){
                new Login(this.formdata.username,this.formdata.password).then(respone =>{
                    if(respone.data.Id_sale>0){
                        if(this.$cookie.get('CurrentAccountType')>0){
                            alert("Log in successful");
                            this.$router.push('/scheduler');
                        }
                        else{
                            alert("Log in successful");
                            this.$router.push('/admin');
                        }
                    }
                    else{
                        alert("Login faile");
                        this.$router.push('/login');
                    }
                })
            },
            Goback(){
                this.$router.push('/');
            },

        }
    }
</script>

