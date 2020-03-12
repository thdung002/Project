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
                                    <div class="col-md-4 col-sm-6" v-for="(planes,index) in uniqPlane "
                                         :key="index" >
                                        <!-- ARTICLE -->
                                        <article class="article widget-article" >

                                            <div class="article-body">
                                                <h4 class="article-title" @click="planeclick(planes.id_plane)"><a>{{planes.plane}}</a></h4>
                                                <ul class="article-meta">
                                                    <li v-for="(item,ind) in unionAll"
                                                    :key="ind"
                                                    v-show="item.plane == planes.plane">
                                                        <i class="fa fa-clock-o"></i> Ngày có sale rảnh: {{datestamp(item.date)}}</li>
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
    import axios from 'axios';
    import _ from 'lodash';
    import moment from 'moment';
    export default {
        name: "Home",
        data:function(){
            return{
                planedata:{},
            }
        },
        methods:{
            login(){
                this.$router.push('/login');
            },
            planeclick(planes){
                this.$store.commit('updatePlane',planes);
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
                return _.unionWith(this.uniqPlane,this.uniqDate,_.isEqual);
            }

        },

        mounted(){
            axios.get("http://localhost:8000/sale").then((respone)=>{
                console.log(respone);
                this.planedata = respone.data;
            });
        },

    }
</script>

<style scoped>
    @import '../assets/css/style.css';
    @import '../assets/css/bootstrap.min.css';

</style>