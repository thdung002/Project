<template>
    <div class="page-container3">
        <header class="header-desktop">
            <div class="section__content section__content--p30">
                <div class="container-fluid">
                    <div class="header-wrap">
                        <form class="form-header">
                            <div class="account-wrap">
                                <div class="account-item clearfix js-item-menu">
                                    <div class="content" @click="home">
                                        <i class="zmdi zmdi-home"></i>
                                        HOME
                                    </div>

                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </header>
        <div class="page-content--bge5">
            <div class="container">
                <div class="login-wrap">
                    <div class="login-content">
                        <div class="login-form">
                            <form action="" method="post" @submit.prevent="login">
                                <div class="form-group">
                                    <label>Username</label>
                                    <input class="au-input au-input--full" name="email" placeholder="Email" v-model="formdata.username">
                                </div>
                                <div class="form-group">
                                    <label>Password</label>
                                    <input class="au-input au-input--full" type="password" name="password" placeholder="Password" v-model="formdata.password">
                                </div>
                                <div class="login-checkbox">
                                    <label>
                                        <a href="#">Forgotten Password?</a>
                                    </label>
                                </div>
                                <button class="au-btn au-btn--block au-btn--green m-b-20" type="submit">Log in</button>
                                <div class="social-login-content">
                                </div>
                            </form>
                            <div class="register-link">
                                <p>
                                    Go back?
                                    <a href="#" @click="Goback">Click here</a>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
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
        mounted(){
            if(this.$cookie.get('CurrentAccountType')> '1')
            {
                this.$router.push('/scheduler');
            }
            else if(this.$cookie.get('CurrentAccountType')==='1')
            this.$router.push('/admin');
        },
        methods:{
            login(){
                new Login(this.formdata.username,this.formdata.password).then(respone =>{
                    if(respone.data.Id_sale>0){
                        if(this.$cookie.get('CurrentAccountType')>'1'){
                            alert("Log in successful");
                            this.$store.commit('updateName',respone.data.Fullname);
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
            home(){
                this.$router.push('/');
            },

            Goback(){
                this.$router.push('/');
            },

        }
    }
</script>

<style>
@import "../assets/Lib/css/font-face.css";
@import "../assets/Lib/vendor/font-awesome-4.7/css/font-awesome.min.css";
@import "../assets/Lib/vendor/font-awesome-5/css/fontawesome-all.min.css";
@import "../assets/Lib/vendor/mdi-font/css/material-design-iconic-font.min.css";
@import "../assets/Lib/vendor/bootstrap-4.1/bootstrap.min.css";
@import "../assets/Lib/vendor/animsition/animsition.min.css";
@import "../assets/Lib/vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css";
@import "../assets/Lib/vendor/wow/animate.css";
@import "../assets/Lib/vendor/css-hamburgers/hamburgers.min.css";
@import "../assets/Lib/vendor/slick/slick.css";
@import "../assets/Lib/vendor/select2/select2.min.css";
@import "../assets/Lib/vendor/perfect-scrollbar/perfect-scrollbar.css";
@import "../assets/Lib/css/theme.css";
</style>

