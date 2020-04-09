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

                                    <div class="content" @click="login">
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
                                        <div class="col-md-4 col-sm-6" v-for="(names,index1) in filteredData" :key="index1" >
                                            <!-- ARTICLE -->
                                            <article class="article widget-article"  >
                                                <div class="article-body" >
                                                    <h4 class="article-title" @click="planeclick(names.Id_plane,names.Id_sale)"
                                                        @keydown.esc="showModal = false"><a href="#">{{names.planename}}</a></h4>
                                                    <b> {{names.Fullname}}</b>
                                                    <ul class="article-meta">
                                                        <li v-for="(planes,index) in MergeData" :key="index" v-show="planes.Id_plane === names.Id_plane" @keydown.esc="showModal = false">
                                                            <a href="#"  @click="dateclick(planes.Id_plane,planes.Id_sale,planes.DateCreated)" >
                                                                <i>{{datestamp(planes.DateCreated)}}  {{timestamp(planes.Starts)}} - {{timestamp(planes.Ends)}}</i></a>
                                                        </li>
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
    import _ from "lodash";
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
                this.$store.commit('updateDate','');
                this.showModal=true;
            },
            dateclick(idplane, idsale ,date){
                this.$store.commit('updateIDPlane',idplane);
                this.$store.commit('updateIDSale',idsale);
                this.$store.commit('updateDate',date);
                this.showModal=true;
            },

            datestamp(date){
                return moment(date).format("DD/MM/YYYY");
            },
            timestamp(hours) {
                if(hours===24)
                    return '24:00';
                else
                    return moment.utc(hours * 3600 * 1000).format('HH:mm')
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
            filteredData(){
                return _.uniqBy(this.MergeData,'Id_plane');
            }

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