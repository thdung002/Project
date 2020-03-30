<template>
    <transition name="modal" >
        <div class="modal-mask">
            <div class="modal-wrapper">
                <div class="modal-container">
                    <button type="button" class="close" @click="$emit('close')" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <div class="modal-header">
                        <slot name="header">
                            <h1>Please fill your information</h1>
                        </slot>

                    </div>

                    <div class="modal-body">
                        <slot name="body">
                                <form action="" method="post" @submit.prevent="addUser" novalidate="true">
                                <div class="form-group">
                                    <div v-if="errors.length" class="form-label">
                                        <b>Please correct the following error(s):</b>
                                        <ul>
                                            <li v-for="(error,index) in errors" :key="index">{{ error }}</li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <span class="form-label">Name</span>
                                    <input class="form-control" v-model="dataform.name" type="text" placeholder="Enter your name">
                                </div>
                                <div class="form-group">
                                    <span class="form-label">Email</span>
                                    <input class="form-control" v-model="dataform.email" type="email" placeholder="Enter your email">
                                </div>
                                <div class="form-group">
                                    <span class="form-label">Phone</span>
                                    <input class="form-control" v-model="dataform.phone" type="tel" placeholder="Enter your phone number">
                                </div>
                                <div class="row">
                                    <div class="col-sm-8">
                                        <div class="form-group">
                                            <span class="form-label">Choose date</span>

                                            <select v-model="dataform.dateUserChoose" class="form-control" >
                                                <option
                                                        v-for="(dates, index) in saledata"
                                                        v-show="planelast === dates.Id_plane"
                                                        :value="dates.DateCreated"

                                                        :key="index">{{datestamp(dates.DateCreated)}}- Start from {{timestamp(dates.Starts)}} to  {{timestamp(dates.Ends)}}</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-sm-3">
                                        <div class="form-group">
                                            <span class="form-label">Time</span>
                                            <vue-timepicker format="HH:mm" v-model="timeval"></vue-timepicker>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-btn">
                                    <button class="btn btn-warning btn-lg btn-block" type="submit">Book Now</button>
                                    <label class="label label-success">{{message}}</label>

                                </div>
                            </form>
                        </slot>
                    </div>
                </div>
            </div>
        </div>
    </transition>
</template>

<script>
    import moment from 'moment';
    import VueTimepicker from 'vue2-timepicker/src/vue-timepicker.vue'
    import {GetScheduler} from "../service/UserServices/SchedulerForUser";
    import {AddBooking} from "../service/UserServices/BookingForUser";

    export default {
        name: "User",
        data:function() {
            return {
                saledata: {},
                dataform: {},//dataform.name, email, phone, dateUserChoose, planeUserChoose, timeUserChoose
                message:"",
                success:0,
                errors:[],
                planelast : this.$store.state.id_plane,
                timeval: "",
                datesl: this.$store.state.dateselect,
            }
        },
        methods:{
            getNumbers:function(start,stop){
                return new Array((stop -start)*2).fill(start).map((n,i)=>i*0.5+n);
            },
            validEmail:function(email) {
                var re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3})|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
                return re.test(email);
            },
            timestamp(hours){
                if(hours===24)
                    return '24:00';
                else
                    return moment.utc(hours * 3600 * 1000).format('HH:mm')
            },
            datestamp(date){
                return moment(date).format("DD/MM/YYYY");
            },
            checkingTime(){
                let checking=0;
                for(let i=0;i<this.saledata.length;i++)
                {
                    if(this.saledata[i].DateCreated === this.dataform.dateUserChoose )
                        if(this.timeval <= this.timestamp(this.saledata[i].Ends) && this.timeval >= this.timestamp(this.saledata[i].Starts))
                            {checking=1;
                                break;}
                }
                return checking;
            },
            addUser(){
                this.message="";
                this.errors = [];
                if(!this.dataform.name) this.errors.push("Name required.");
                if(!this.dataform.email) {
                    this.errors.push("Email required.");
                } else if(!this.validEmail(this.dataform.email)) {
                    this.errors.push("Valid email required.");
                }
                if(!this.dataform.phone) this.errors.push("Phone required");
                if(!this.dataform.dateUserChoose) this.errors.push("Date required");
                if(!this.timeval) this.errors.push("Time required");
                // console.log(this.checkingTime());
                if(this.checkingTime()===0)
                {
                    this.errors.push("Time is not in range!")
                }
                if(!this.errors.length) {
                    new AddBooking(this.dataform.name,this.dataform.email,this.dataform.phone,this.dataform.dateUserChoose,this.$store.state.id_plane,this.timeval,this.$store.state.sale_id).then((respone)=>{
                        // console.log(respone.data);
                        if(respone.data.result>0){
                            this.message="You added success!";
                            alert("Added successful");
                            this.success=respone.data.result;
                            this.$emit('close');

                        }
                        else{
                            this.message="Added failed";
                            this.success=respone.data.result;
                        }
                    })}
            }
        },
        created() {
            new GetScheduler().then(respone =>{
                // console.log(respone.data);
                this.saledata=respone.data;
            });
            this.dataform.dateUserChoose= this.$store.state.dateselect;
        },
        components:{VueTimepicker }
    }
</script>

<style scoped>
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

    @import '../assets/login/vendor/bootstrap/css/bootstrap.min.css';
    .modal-mask {
        position: fixed;
        z-index: 9998;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background-color: rgba(0, 0, 0, 0.5);
        display: table;
        transition: opacity 0.3s ease;
    }

    .modal-wrapper {
        display: table-cell;
        vertical-align: middle;
    }

    .modal-container {
        width: 700px;
        margin: 0px auto;
        padding: 20px 30px;
        background-color: #fff;
        border-radius: 2px;
        box-shadow: 0 2px 8px rgba(0, 0, 0, 0.33);
        transition: all 0.3s ease;
        font-family: Helvetica, Arial, sans-serif;
    }

    .modal-header h3 {
        margin-top: 0;
        color: #42b983;
    }

    .modal-body {
        margin: 20px 0;
    }

    .modal-default-button {
        float: right;
    }

    /*
     * The following styles are auto-applied to elements with
     * transition="modal" when their visibility is toggled
     * by Vue.js.
     *
     * You can easily play with the modal transition by editing
     * these styles.
     */

    .modal-enter {
        opacity: 0;
    }

    .modal-leave-active {
        opacity: 0;
    }

    .modal-enter .modal-container,
    .modal-leave-active .modal-container {
        -webkit-transform: scale(1.1);
        transform: scale(1.1);
    }

</style>
