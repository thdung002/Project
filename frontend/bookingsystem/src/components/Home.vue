<template>
    <div>
        <nav class="navbar navbar-toggleable-sm navbar-inverse bg-dark">
            <div style='float: right' class = "form-header">
                <button class="btn btn-warning" @click="login">
                    Login
                </button>
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
                        <div class="tab-content">
                            <!-- tab1 -->
                            <div id="tab1" class="tab-pane fade in active">

                                <!-- row -->
                                <div class="row">
                                    <!-- Column 1 -->
                                    <div class="col-md-4 col-sm-6" v-for="(planes,index) in planedata "
                                         :key="index" >
                                        <!-- ARTICLE -->
                                        <article class="article widget-article" >

                                            <div class="article-body" >
                                                <h4 class="article-title" @click="planeclick(planes.Id_plane,planes.Id_sale)" v-for="(name,ind) in planename"
                                                    :key="ind"
                                                    v-show="planes.Id_plane === name.Id_plane"><a href="#">{{name.planename}}</a></h4>
                                                <ul class="article-meta">
                                                    <li v-for="(sale,i) in listsale" :key="i"
                                                        v-show="sale.Id_sale === planes.Id_sale"><b>{{sale.Fullname}}</b></li>
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
    import _ from 'lodash';
    import moment from 'moment';
    import {GetScheduler} from "../service/SchedulerService/SchedulerForUser";
    import {PlaneForUser} from "../service/PlaneService/PlaneForUser";
    import {GetListLogin} from "../service/UserService/Login";

    export default {
        name: "Home",
        data:function(){
            return{
                planedata:{},
                planename:{},
                listsale:{},
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
            uniqPlane:function(){
                return _.uniqBy(this.planedata,'plane')
            },
            uniqDate:function(){
                return _.uniqBy(this.planedata,'date')
            },
            unionAll:function(){
                return _.unionWith(this.planedata,this.uniqDate,_.isEqual);
            }

        },

        created(){

             new GetScheduler().then(response=>{
                console.log(response.data);
                this.planedata = response.data;
            });
            new GetListLogin().then(respone=>{
                console.log(respone.data);
                this.listsale = respone.data;
            });


            new PlaneForUser(this.$cookie.get('CurrentAccountID')).then(respone=>{
                console.log(respone.data);
                this.planename = respone.data;
            });
        },

    }
</script>

<style scoped>
    @import '../assets/css/style.css';
    @import '../assets/css/bootstrap.min.css';

</style>