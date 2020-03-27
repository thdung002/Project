<template>
    <div class="page-container" id="booking">
        <!-- HEADER DESKTOP-->
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
                        <div class="header-button">
                            <div class="account-wrap">
                                <div class="account-item clearfix js-item-menu">
                                    <div class="content" @click="login" v-if="this.$cookie.get('CurrentAccountType') > '0'">
                                        <i class="zmdi zmdi-settings"></i>Go to manage
                                    </div>
                                    <div class="content" @click="login" v-if="this.$cookie.get('CurrentAccountType') === '0'|| this.$cookie.get('CurrentAccountType') === null">
                                        <i class="zmdi zmdi-power"></i>Login
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <div class="main-content ">
            <div class="section__content section__content--p30">
                <div class="container-fluid">
                    <div class="row">
                        <div class="top-campaign">
                            <div class="section-title">
                                <h2 class="title">Địa chỉ nhà</h2>
                            </div>
                            <br>

                            <div class="tab-content">
                                <!-- tab1 -->
                                <div id="tab1" class="tab-pane fade in active">
                                    <!-- row -->
                                    <div class="row">
                                        <!-- Column 1 -->
                                        <div class="col-md-4 col-sm-6" v-for="(planes,index) in MergeData "
                                             :key="index" >
                                            <!-- ARTICLE -->
                                            <article class="article widget-article" >
                                                <div class="article-body" >
                                                    <h4 class="article-title" @click="planeclick(planes.Id_plane,planes.Id_sale)"
                                                        @keydown.esc="showModal = false"><a href="#">{{planes.planename}}</a></h4>
                                                    <ul class="article-meta">
                                                        <b> {{planes.Fullname}}</b>
                                                        <li>
                                                            <i>Ngày làm việc: {{datestamp(planes.DateCreated)}}</i> </li>
                                                    </ul>
                                                </div>
                                            </article>
                                            <User v-if="showModal" @close="showModal = false" >

                                            </User>
                                            <!-- /ARTICLE -->
                                        </div>
                                        <!-- /Column 1 -->
                                    </div>
                                    <!-- /row -->
                                </div>
                                <!-- /tab1 -->
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import moment from 'moment';
    import {GetScheduler} from "../service/UserServices/SchedulerForUser";
    import {PlaneForUser} from "../service/UserServices/PlaneForUser";
    import {GetListLogin} from "../service/SaleServices/Login";
    import User from "./User";
    export default {
        name: "Home",
        data:function(){
            return{
                planedata:[],
                planename:[],
                listsale:[],
                contact: false,
                showModal: false,
            }
        },
        methods:{
            login(){
                this.$router.push('/login');
            },
            home(){
                this.$router.push('/');
            },

            planeclick(idplane, idsale ){
                this.$store.commit('updateIDPlane',idplane);
                this.$store.commit('updateIDSale',idsale);
                this.showModal=true;
            },
            datestamp(date){
                return moment(date).format("DD/MM/YYYY");
            },

        },
        components:{
            User,
        },
        computed:{
            MergeData(){
                return this.planedata.map(item => {
                    const obj = this.planename.find(o =>o.Id_plane === item.Id_plane);
                    const obj2 = this.listsale.find(o=> o.Id_sale === item.Id_sale);
                    return {...item,...obj,...obj2};
                })
            },
        },

        created(){

             new GetScheduler().then(response=>{
                // console.log(response.data);
                this.planedata = response.data;
            });
            new GetListLogin().then(respone=>{
                // console.log(respone.data);
                this.listsale = respone.data;
            });
            new PlaneForUser(this.$cookie.get('CurrentAccountID')).then(respone=>{
                // console.log(respone.data);
                this.planename = respone.data;
            });
        },

    }
</script>

<style scoped>
    @import '../assets/css/style.css';
    @import '../assets/login/vendor/bootstrap/css/bootstrap.min.css';

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