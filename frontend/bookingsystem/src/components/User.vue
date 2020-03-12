<template>
        <div id="booking" class="section">
            <nav class="navbar navbar-toggleable-sm navbar-inverse bg-dark">
                <div style='float: right' class = "form-header">
                    <button class="btn btn-warning" @click="login">
                        Login
                    </button>
                </div>
                <div style='float: left' class = "form-header">
                    <button class="btn btn-default" @click="home">
                        Home
                    </button>
                </div>

            </nav>

            <div class="section-center">
            <div class="container">
                <div class="row">
                    <div class="booking-form">
                        <div class="form-header">
                            <h1>Please fill your information</h1>
                        </div>
                        <form action="" method="post" @submit.prevent="addUser" novalidate="true">
                            <div class="row">
                            <div v-if="errors.length" class="form-label">
                                <b>Please correct the following error(s):</b>
                            <ul>
                                <li v-for="(error,index) in errors" :key="index">{{ error }}</li>
                            </ul>
                            </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <span class="form-label">Name</span>
                                        <input class="form-control" v-model="dataform.name" type="text" placeholder="Enter your name">
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <span class="form-label">Email</span>
                                        <input class="form-control" v-model="dataform.email" type="email" placeholder="Enter your email">
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <span class="form-label">Phone</span>
                                <input class="form-control" v-model="dataform.phone" type="tel" placeholder="Enter your phone number">
                            </div>
                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="form-group">
                                        <span class="form-label">Choose date</span>
                                        <select v-model="dataform.dateUserChoose" class="form-control" >
                                            <option
                                                    v-for="(dates, index) in unionAll"
                                                    v-show="planelast === dates.id_plane"
                                                    :item="dates"
                                                    :key="index">{{datestamp(dates.date)}}</option>
                                        </select>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <span class="form-label">Time</span>
                                <select v-model="dataform.timeUserChoose" class="form-control"
                                        v-for="(time, index) in saledata"
                                        v-show="dataform.dateUserChoose === datestamp(time.date)"
                                        :key="index"
                                        >
                                    <option

                                            v-for="(n,ind) in getNumbers(parseInt(time.starts),parseInt(time.ends))"
                                            :value="timestamp(n)"
                                            :key="ind">{{timestamp(n)}}</option>
                                </select>
                                <span class="select-arrow"></span>
                            </div>

                            <div class="form-btn">
                                <button class="submit-btn" type="submit">Book Now</button>
                                <label class="label label-success">{{message}}</label>

                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import axios from 'axios';
    import _ from 'lodash';
    import moment from 'moment';

    export default {
        name: "User",
        data:function() {
            return {
                saledata: {},
                dataform: {},//dataform.name, email, phone, dateUserChoose, planeUserChoose, timeUserChoose
                message:"",
                success:0,
                errors:[],
                planelast : this.$store.state.planes
            }
        },
        methods:{
            login(){
                this.$router.push('/login');

            },
            home(){
                this.$router.push('/');
            },
            getNumbers:function(start,stop){
                return new Array((stop -start)*2).fill(start).map((n,i)=>i*0.5+n);
            },

            validEmail:function(email) {
                var re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3})|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
                return re.test(email);
            },
            timestamp(hours){
                return moment.utc(hours*3600*1000).format('HH:mm')
            },
            datestamp(date){
                return moment(date).format("DD/MM/YYYY");
            },

            addUser(){
                this.errors = [];
                if(!this.dataform.name) this.errors.push("Name required.");
                if(!this.dataform.email) {
                    this.errors.push("Email required.");
                } else if(!this.validEmail(this.dataform.email)) {
                    this.errors.push("Valid email required.");
                }
                if(!this.errors.length) {
                axios.post("http://localhost:8000/booking/add?fn="+this.dataform.name+"&email="+this.dataform.email+"&phone="+this.dataform.phone+"&date="+this.dataform.dateUserChoose+"&idplane="+this.$store.state.planes+"&time="+this.dataform.timeUserChoose).then((respone)=>{
                    console.log(respone);
                    if(respone.data.result>0){
                        this.message="You added success!";
                        this.success=respone.data.result;
                    }
                    else{
                        this.message="Added failed";
                        this.success=respone.data.result;
                    }
                })}
            }
        },
        computed:{
            uniqPlane:function(){
                return _.uniqBy(this.saledata,'plane')
            },
            uniqDate:function(){
                return _.uniqBy(this.saledata,'date')
            },
            unionAll:function(){
                return _.unionWith(this.uniqPlane,this.uniqDate,_.isEqual);
            }

        },
        mounted() {
            axios.get("http://localhost:8000/sale").then((respone)=>{
                console.log(respone);
                this.saledata = respone.data;

            })

        },
    }
</script>

<style scoped>
    @import '../assets/css/style.css';
    @import '../assets/css/bootstrap.min.css';
</style>
