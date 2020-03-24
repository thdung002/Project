<template>
    <div>
<!--        <nav class="navbar navbar-toggleable-sm navbar-inverse bg-dark">-->
<!--            <div style='float: right' class = "form-header">-->

<!--                <button class="btn btn-warning" @click="login" v-show="this.$cookie.get('CurrentAccountID')=== null || this.$cookie.get('CurrentAccountID')==='0'">-->
<!--                    Login-->
<!--                </button>-->
<!--                <button class="btn btn-warning" @click="login" v-show="this.$cookie.get('CurrentAccountID') >= '1'">-->
<!--                    Account Page-->
<!--                </button>-->

<!--            </div>-->
<!--        </nav>-->
        <nav class="navbar navbar-toggleable-sm navbar-inverse bg-dark">
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbar"     aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
                            <button class="btn btn-warning" @click="login" v-show="this.$cookie.get('CurrentAccountID')=== null || this.$cookie.get('CurrentAccountID')==='0'">
                                Login
                            </button>
                            <button class="btn btn-warning" @click="login" v-show="this.$cookie.get('CurrentAccountID') >= '1'">
                                Account Page
                            </button>

            <div class="collapse navbar-collapse justify-content-between" id="navbar">
            </div>
        </nav>
        <div   class="section">
            <!-- CONTAINER -->
            <div class="container">
                <!-- ROW -->
                <div class="row">

                    <!-- Main Column -->
                    <div class="col-md-12">

                        <!-- section title -->
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
<!--                                            Img here-->
<!--                                            <div class="article-img">-->
<!--                                                <a href="#">-->
<!--                                                    <img src="../assets/img/img-widget-1.jpg" alt="">-->
<!--                                                </a>-->
<!--                                            </div>-->
                                            <div class="article-body" >
                                                <h4 class="article-title" @click="planeclick(planes.Id_plane,planes.Id_sale)"><a href="#">{{planes.planename}}</a></h4>
                                                <ul class="article-meta">
                                                    <b> {{planes.Fullname}}</b>
                                                    <li>
                                                        <i>Ngày làm việc: {{datestamp(planes.DateCreated)}}</i> </li>
                                                </ul>
                                            </div>
                                        </article>
                                        <!-- /ARTICLE -->
                                    </div>
                                    <!-- /Column 1 -->
                                </div>
                                <!-- /row -->
                            </div>
                            <!-- /tab1 -->
                        </div>
                        <!-- /tab content -->
                    </div>
                    <!-- /Main Column -->
                </div>
                <!-- /ROW -->
            </div>
            <!-- /CONTAINER -->
        </div>
    </div>

</template>

<script>
    import moment from 'moment';
    import {GetScheduler} from "../service/UserServices/SchedulerForUser";
    import {PlaneForUser} from "../service/UserServices/PlaneForUser";
    import {GetListLogin} from "../service/SaleServices/Login";

    export default {
        name: "Home",
        data:function(){
            return{
                planedata:[],
                planename:[],
                listsale:[],
            }
        },
        methods:{
            login(){
                this.$router.push('/login');
            },
            planeclick(idplane, idsale ){
                this.$store.commit('updateIDPlane',idplane);
                this.$store.commit('updateIDSale',idsale);
                this.$router.push('/user');

            },
            datestamp(date){
                return moment(date).format("DD/MM/YYYY");
            },

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

</style>