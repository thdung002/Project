<template>
    <div class="limiter" id="form-login">
        <div class="container-login100">
            <div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-50">
                <form class="login100-form validate-form" method="post" @submit.prevent="login">
					<span class="login100-form-title p-b-33">
						Account Login
					</span>

                    <div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
                        <input class="input100" type="text" name="email" placeholder="Username" v-model="formdata.username">
                        <span class="focus-input100-1"></span>
                        <span class="focus-input100-2"></span>
                    </div>

                    <div class="wrap-input100 rs1 validate-input" data-validate="Password is required">
                        <input class="input100" type="password" name="pass" placeholder="Password"  v-model="formdata.password">
                        <span class="focus-input100-1"></span>
                        <span class="focus-input100-2"></span>
                    </div>

                    <div class="container-login100-form-btn m-t-20">
                        <button class="login100-form-btn">
                            Sign in
                        </button>
                    </div>

                    <div class="text-center p-t-45 p-b-4">
						<span class="txt1">
							Forgot
						</span>

                        <a href="#" class="txt2 hov1">
                            Username / Password?
                        </a>
                    </div>

                    <div class="text-center">
						<span class="txt1">
							Go back?
						</span>

                        <a href="#" class="txt2 hov1" @click="Goback">
                            Click here
                        </a>
                    </div>
                </form>
            </div>
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
        // mounted(){
        //     if(this.$cookie.get('CurrentAccountID') !== null)
        //     {
        //         this.$router.push('/scheduler');
        //     }
        // },
        methods:{
            login(){
                new Login(this.formdata.username,this.formdata.password).then(respone =>{
                    if(respone.data.Id_sale>0){
                        if(this.$cookie.get('CurrentAccountType')>'1'){

                            alert("Log in successful");
                            this.$store.commit('updateName',respone.data.Fullname)
                            this.$router.push('/scheduler');
                        }
                        else if( this.$cookie.get('CurrentAccountType')==='1'){
                            alert("Log in successful");
                            this.$router.push('/admin');
                        }
                    }
                    else{
                        alert("Login failed");
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

<style>
    @import '../assets/login/vendor/bootstrap/css/bootstrap.min.css';
    @import '../assets/login/fonts/font-awesome-4.7.0/css/font-awesome.min.css';
    @import '../assets/login/fonts/Linearicons-Free-v1.0.0/icon-font.min.css';
    @import '../assets/login/vendor/animate/animate.css';
    @import '../assets/login/vendor/css-hamburgers/hamburgers.min.css';
    @import '../assets/login/vendor/animsition/css/animsition.min.css';
    @import '../assets/login/vendor/select2/select2.min.css';
    @import '../assets/login/vendor/daterangepicker/daterangepicker.css';
    @import '../assets/login/css/util.css';
    @import '../assets/login/css/main.css';

</style>

