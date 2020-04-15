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
                            <div class="content">Hi {{checkinglist.Fullname}},</div>

                            <div class="account-wrap">
                                <div class="account-item clearfix js-item-menu">
                                    <div class="content" @click="logout">
                                        <i class="zmdi zmdi-power"></i>Logout
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <!--        End of Header-->
        <div class="main-content">
            <div class="section__content section__content--p30">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-9">
                            <div class="card">
                                <div class="card-header"><strong class="card-title">Schedule</strong></div>
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-lg-11"></div>
                                        <div class="col-lg-1">
                                            <button class="btn btn-danger btn-sm" @click="DeleteSchedule">
                                                <i class="fa fa-minus"></i> Delete
                                            </button>
                                        </div>
                                    </div>
                                    <vue-bootstrap-table
                                            :columns="colScheduler"
                                            :values="SchedulerMerge"
                                            :show-filter="true"
                                            :sortable="true"
                                            :paginated="true"
                                            :multi-column-sortable=true
                                            :filter-case-sensitive=false
                                            :selectable=true
                                            :pageSize="5"
                                            class="table table-borderless table-data3"

                                    ></vue-bootstrap-table>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3">
                            <div class="card">
                                <div class="card-header">Add schedule</div>
                                <div class="card-body card-block">
                                    <form action="" method="post"  @submit.prevent="addSchedule">
                                        <div class="form-group">
                                            <div v-if="errors.length" class="form-label">
                                                <b>Please correct the following error(s):</b>
                                                <b>
                                                    <ul style="padding-left: 1em;">
                                                        <li  v-for="(error,index) in errors" :key="index">{{ error }}</li>
                                                    </ul>

                                                </b>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="form-control-label"> Choose sale</label>
                                            <select class="form-control" v-model="dataform.idsale">
                                                <option v-for="(sale,index) in userdata" :key="index" :value="sale.Id_sale">
                                                    {{sale.Fullname}}
                                                </option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label  class="form-control-label">Choose plane</label>
                                            <select class="form-control " v-model="dataform.plane">
                                                <option v-for="(plane,index) in planedata"
                                                        :key="index"
                                                        v-show="dataform.idsale === plane.Id_sale"
                                                        :value="{id: plane.Id_plane, text: plane.planename}">{{plane.planename}}</option>
                                            </select>
                                        </div>

                                        <div class="form-group has-success">
                                            <label class="form-control-label">Choose date</label>
                                            <input v-model="dataform.date" class="form-control" type="date">
                                        </div>
                                        <br>
                                        <div class="form-group">
                                            <label class="form-control-label">Choose your worktime</label>
                                            <vue-range-slider ref="slider" v-model="value" :min="min" :max="max"  :enable-cross="enableCross"
                                                              :step="step" :min-range="minrange"></vue-range-slider>
                                        </div>

                                        <div class="card-footer">
                                            <button type="submit" class="btn btn-primary btn-sm">
                                                <i class="fa fa-dot-circle-o"></i> Add
                                            </button>
                                            <button type="reset" class="btn btn-danger btn-sm">
                                                <i class="fa fa-ban"></i> Reset
                                            </button>
                                            <label class="label label-success">{{message}} - Code: {{success}}</label>
                                        </div>

                                    </form>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div clas="row">
                        <div class="col-lg-9">
                            <div class="card">
                                <div class="card-header"><strong class="card-title">All booking</strong></div>
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-lg-11"></div>
                                        <div class="col-lg-1">
                                            <button class="btn btn-danger btn-sm" @click="DeleteBooking">
                                                <i class="fa fa-minus"></i> Delete
                                            </button>
                                        </div>
                                    </div>
                                    <vue-bootstrap-table
                                            :columns="colBooking"
                                            :values="BookingList"
                                            :show-filter="true"
                                            :sortable="true"
                                            :paginated="true"
                                            :multi-column-sortable=true
                                            :filter-case-sensitive=false
                                            :selectable=true
                                            :pageSize="5"
                                            :showSelectfilter="true"

                                            class="table table-borderless table-data3"
                                    ></vue-bootstrap-table>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3">
                            <div class="card">
                                <div class="card-header">Add Booking</div>
                                <div class="card-body card-block">
                                    <form action="" method="post"  @submit.prevent="addBooking">
                                        <div class="form-group">
                                            <div v-if="errors2.length" class="form-label">
                                                <b>Please correct the following error(s):</b>
                                                <b>
                                                    <ul style="padding-left: 1em;">
                                                        <li  v-for="(error,index) in errors2" :key="index">{{ error }}</li>
                                                    </ul>

                                                </b>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <span class="form-label">Name</span>
                                            <input class="form-control" v-model="dataformbooking.name" type="text" placeholder="Enter your name">
                                        </div>
                                        <div class="form-group">
                                            <span class="form-label">Email</span>
                                            <input class="form-control" v-model="dataformbooking.email" type="email" placeholder="Enter your email">
                                        </div>
                                        <div class="form-group">
                                            <span class="form-label">Phone</span>
                                            <input class="form-control" v-model="dataformbooking.phone" type="tel" placeholder="Enter your phone number">
                                        </div>
                                        <div class="form-group">
                                            <label class="form-control-label"> Choose sale</label>
                                            <select class="form-control" v-model="dataformbooking.idsale">
                                                <option v-for="(sale,index) in userdata" :key="index" :value="sale.Id_sale">
                                                    {{sale.Fullname}}
                                                </option>
                                            </select>
                                        </div>

                                        <div class="form-group">
                                            <label  class="form-control-label">Choose plane</label>
                                            <select class="form-control " v-model="dataformbooking.plane">
                                                <option v-for="(plane,index) in planedata" :key="index"  :value="plane.Id_plane"
                                                v-show="dataformbooking.idsale === plane.Id_sale">{{plane.planename}}</option>
                                            </select>
                                        </div>

                                        <div class="row">
                                            <div class="col-sm-6">
                                                <div class="form-group">
                                                    <span class="form-label">Choose date</span>
                                                    <select v-model="dataformbooking.dateUserChoose" class="form-control" >
                                                        <option
                                                                v-for="(dates, index) in schedulerdata"
                                                                :value="dates.DateCreated"
                                                                v-show="dataformbooking.plane=== dates.Id_plane"
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
                                        <div class="card-footer">
                                            <button type="submit" class="btn btn-primary btn-sm">
                                                <i class="fa fa-dot-circle-o"></i> Add
                                            </button>
                                            <button type="reset" class="btn btn-danger btn-sm">
                                                <i class="fa fa-ban"></i> Reset
                                            </button>
                                            <label class="label label-success">{{message2}}</label>
                                        </div>

                                    </form>
                                </div>

                            </div>
                        </div>
                    </div>
                        <div class="row">
                            <div class="col-lg-9">
                                <div class="card">
                                    <div class="card-header"><strong class="card-title">Plane</strong></div>
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="col-lg-11"></div>
                                            <div class="col-lg-1">
                                                <button class="btn btn-danger btn-sm" @click="DeletePlane">
                                                    <i class="fa fa-minus"></i> Delete
                                                </button>
                                            </div>
                                        </div>
                                        <vue-bootstrap-table
                                                :columns="colPlane"
                                                :values="PlaneList"
                                                :show-filter="true"
                                                :sortable="true"
                                                :paginated="true"
                                                :multi-column-sortable=true
                                                :filter-case-sensitive=false
                                                :selectable=true
                                                :pageSize="5"
                                                class="table table-borderless table-data3"

                                        ></vue-bootstrap-table>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-3">
                                <div class="card">
                                    <div class="card-header">Add plane</div>
                                    <div class="card-body card-block">
                                        <form action="" method="post"  @submit.prevent="addPlane">
                                            <div class="form-group">
                                                <div v-if="errors3.length" class="form-label">
                                                    <b>Please correct the following error(s):</b>
                                                    <b>
                                                        <ul style="padding-left: 1em;">
                                                            <li  v-for="(error,index) in errors3" :key="index">{{ error }}</li>
                                                        </ul>

                                                    </b>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="form-control-label"> Choose sale</label>
                                                <select class="form-control" v-model="dataformplane.idsale">
                                                    <option v-for="(sale,index) in userdata" :key="index" :value="sale.Id_sale">
                                                        {{sale.Fullname}}
                                                    </option>
                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <span class="form-label">Plane name</span>
                                                <input class="form-control" v-model="dataformplane.name" type="text" placeholder="Enter your name">
                                            </div>

                                            <div class="card-footer">
                                                <button type="submit" class="btn btn-primary btn-sm">
                                                    <i class="fa fa-dot-circle-o"></i> Add
                                                </button>
                                                <button type="reset" class="btn btn-danger btn-sm">
                                                    <i class="fa fa-ban"></i> Reset
                                                </button>
                                                <label class="label label-success">{{message3}}</label>
                                            </div>

                                        </form>
                                    </div>

                                </div>
                            </div>
                        </div>

                    <div class="row">
                        <div class="col-lg-9">
                            <div class="card">
                                <div class="card-header"><strong class="card-title">All user</strong></div>
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-lg-11"></div>
                                        <div class="col-lg-1">
                                            <button class="btn btn-danger btn-sm" @click="DeleteUser">
                                                <i class="fa fa-minus"></i> Delete
                                            </button>
                                        </div>
                                    </div>
                                    <vue-bootstrap-table
                                            :columns="colUsers"
                                            :values="userdata"
                                            :show-filter="true"
                                            :sortable="true"
                                            :paginated="true"
                                            :multi-column-sortable=true
                                            :filter-case-sensitive=false
                                            :selectable=true
                                            :pageSize="5"
                                            class="table table-borderless table-data3"

                                    ></vue-bootstrap-table>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3">
                            <div class="card">
                                <div class="card-header">Add users</div>
                                <div class="card-body card-block">
                                    <form action="" method="post"  @submit.prevent="addUser">
                                        <div class="form-group">
                                            <div v-if="errors4.length" class="form-label">
                                                <b>Please correct the following error(s):</b>
                                                <b>
                                                    <ul style="padding-left: 1em;">
                                                        <li  v-for="(error,index) in errors4" :key="index">{{ error }}</li>
                                                    </ul>

                                                </b>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="form-control-label"> Username</label>
                                            <input class="form-control" v-model="dataformuser.username" type="text" placeholder="Enter your username">
                                        </div>
                                        <div class="form-group">
                                            <span class="form-label">Plane name</span>
                                            <input class="form-control" v-model="dataformuser.password" type="password" placeholder="Enter your password">
                                        </div>
                                        <div class="form-group">
                                            <label class="form-control-label"> Full name</label>
                                            <input class="form-control" v-model="dataformuser.fullname" type="text" placeholder="Enter your full name">
                                        </div>
                                        <label class="form-control-label"> Choose account type</label>
                                        <select class="form-control" v-model="dataformuser.accounttype">
                                            <option value="1">
                                                Admin
                                            </option>
                                            <option value="2">
                                                Sale
                                            </option>
                                        </select>


                                        <div class="card-footer">
                                            <button type="submit" class="btn btn-primary btn-sm">
                                                <i class="fa fa-dot-circle-o"></i> Add
                                            </button>
                                            <button type="reset" class="btn btn-danger btn-sm">
                                                <i class="fa fa-ban"></i> Reset
                                            </button>
                                            <label class="label label-success">{{message4}}</label>
                                        </div>
                                    </form>
                                </div>
                            </div>

                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import {Logout} from "../service/SaleServices/Logout";
    import * as Account from "../service/AdminServices/UsersForAdmin";
    import * as Booking from "../service/AdminServices/BookingForAdmin";
    import * as Plane from "../service/AdminServices/PlaneForAdmin";
    import * as Scheduler from "../service/UserServices/SchedulerForUser";
    import * as ScheduleSale from "../service/SaleServices/SchedulerForSale"
    import moment from 'moment';
    import VueBootstrapTable from "vue2-bootstrap-table2";
    import * as Cookies from"../service/Cookies/Cookies";
    import {Delete} from "../service/SaleServices/SchedulerForSale"
    import 'vue-range-component/dist/vue-range-slider.css'
    import VueRangeSlider from 'vue-range-component'
    import {AddBooking} from "../service/UserServices/BookingForUser";
    import VueTimepicker from 'vue2-timepicker/src/vue-timepicker.vue'

    export default {
        name: "Admin",
        data(){
            return{
                bookingdata:[],
                userdata:[],
                planedata:[],
                schedulerdata:[],
                checkinglist:{},
                dataform:[],
                errors:[],
                message:"",
                value: [0, 24],
                success: "",
                errors2:[],
                timeval: "",
                message2:"",
                dataformbooking:[],
                dataformplane:[],
                dataformuser:[],
                message3:"",
                errors3:[],
                message4:"",
                errors4:[],

                colScheduler:[
                    {
                        name: 'Id_scheduler',
                        title: "ID",
                        visible:true,
                        sortable: true,
                        filterable:true,
                    },

                    {
                        name: 'Fullname',
                        title: "Full name",
                        visible:true,
                        sortable: true,
                        filterable:true,
                    },

                    {
                        name: 'planename',
                        title: "Location",
                        visible:true,
                        sortable: true,
                        filterable:true,
                    },
                    {
                        name: 'DateCreated',
                        title: "Date Created",
                        visible:true,
                        sortable: true,
                        filterable:true,

                    },
                    {
                        name: 'Starts',
                        title: "Start Time",
                        visible:true,
                        sortable: true,
                        filterable:true,

                    },
                    {
                        name: 'Ends',
                        title: "End Time",
                        visible:true,
                        sortable: true,
                        filterable:true,

                    }
                ],
                colBooking:[
                    {
                        name: 'Id_booking',
                        title: "ID",
                        visible:true,
                        sortable: true,
                        filterable:true,
                    },
                    {
                        name: 'Full_name',
                        title: "Full Name",
                        visible:true,
                        sortable: true,
                        filterable:true,
                    },
                    {
                        name: 'Phone',
                        title: "Phone",
                        visible:true,
                        sortable: true,
                        filterable:true,

                    },
                    {
                        name: 'Email',
                        title: "Email",
                        visible:true,
                        sortable: true,
                        filterable:true,

                    },
                    {
                        name: 'Datebooking',
                        title: "Date Booking",
                        visible:true,
                        sortable: true,
                        filterable:true,

                    },
                    {
                        name: 'Timebooking',
                        title: "Time Booking",
                        visible:true,
                        sortable: true,
                        filterable:true,

                    },
                    {
                        name: 'planename',
                        title: "Location",
                        visible:true,
                        sortable: true,
                        filterable:true,
                    }
                ],
                colPlane:[
                    {
                        name: 'Id_plane',
                        title: "ID",
                        visible:true,
                        sortable: true,
                        filterable:true,

                    },
                    {
                        name: 'planename',
                        title: "Location",
                        visible:true,
                        sortable: true,
                        filterable:true,

                    },
                    {
                        name: "Fullname",
                        title: "Sale",
                        visible:true,
                        sortable: true,
                        filterable:true,
                    }
                ],
                colUsers:[
                    {
                        name: 'Id_sale',
                        title: "ID",
                        visible:true,
                        sortable: true,
                        filterable:true,
                    },
                    {
                        name: 'Fullname',
                        title: "Full Name",
                        visible:true,
                        sortable: true,
                        filterable:true,
                    },
                    {
                        name: 'username',
                        title: "Username",
                        visible:true,
                        sortable: true,
                        filterable:true,
                    },
                    {
                        name: 'AccountType',
                        title: "Type(1 is admin, others is sale)",
                        visible:true,
                        sortable: true,
                        filterable:true,

                    }
                ],

            }
        },
        methods:{
            logout() {
                Logout().then(()=>{
                    this.$router.push('/login');
                });
            },
            home(){
                this.$router.push('/');
            },
            validEmail:function(email) {
                var re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3})|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
                return re.test(email);
            },
            datestamp(date){
                return moment(date).format("DD/MM/YYYY");
            },
            datestamp2(date) {
                return moment(date).format("YYYY-MM-DD");
            },

            checkingTime(){
                let checking=0;
                for(let i=0;i<this.schedulerdata.length;i++)
                {
                    if(this.schedulerdata[i].DateCreated === this.dataformbooking.dateUserChoose )
                        if(this.timeval <= this.timestamp(this.schedulerdata[i].Ends) && this.timeval >= this.timestamp(this.schedulerdata[i].Starts))
                        {checking=1;
                            break;}
                }
                return checking;
            },

            timestamp(hours){
                if(hours===24)
                    return '24:00';
                else
                    return moment.utc(hours * 3600 * 1000).format('HH:mm')
            },
            addSchedule() {
                this.message="";
                this.errors = [];
                this.success="";
                if(!this.dataform.idsale) this.errors.push("Please choose sale.");
                if(!this.dataform.plane) this.errors.push("Please choose plane.");
                if(this.dataform.date < this.datestamp2(this.showDate))
                    this.errors.push("Can't add with older date with today");
                if(!this.errors.length) {
                    new ScheduleSale.AddScheduler(this.dataform.idsale, this.dataform.date, this.value[0], this.value[1], this.dataform.plane.id).then(response => {
                        console.log(response);
                        if (response.data.result !== 0) {
                            this.message = "You added success!";
                            this.success = response.data.result;
                            new Scheduler.GetScheduler().then(response =>{
                                // console.log(response.data);
                                this.schedulerdata=response.data;
                            });
                        } else {
                            this.message = "Added failed";
                            this.success = response.data.result;
                        }
                    })
                }
            },
            addPlane(){
                this.message3="";
                this.errors3 = [];
                if(!this.dataformplane.name) this.errors3.push("Name required.");
                if(!this.dataformplane.idsale) this.errors3.push("Please choose sale.");
                if(!this.errors3.length) {
                    new Plane.AddPlane(this.dataformplane.idsale,this.dataformplane.name).then((response)=>{
                        if(response.data.result>0){
                            this.message3="You added success!";
                            new Plane.GetAllPlane().then(response =>{
                                // console.log(response.data);
                                this.planedata=response.data;
                            });

                        }
                        else{
                            this.message3="Added failed";
                        }

                    })
                }
            },
            addUser(){
                this.message4="";
                this.errors4 = [];
                if(!this.dataformuser.username) this.errors4.push("Username required.");
                if(!this.dataformuser.password) this.errors4.push("Password required.");
                if(!this.dataformuser.fullname) this.errors4.push("Name required.");
                if(!this.dataformuser.accounttype) this.errors4.push("Account type required.");

                if(!this.errors3.length) {
                    new Account.AddUser(this.dataformuser.fullname,this.dataformuser.username,this.dataformuser.password,this.dataformuser.accounttype).then((response)=>{
                        if(response.data.result>0){
                            this.message4="You added success!";
                            new Account.GetAllAccounts().then(response =>{
                                // console.log(response.data);
                                this.userdata=response.data;
                            });
                        }
                        else{
                            this.message4="Added failed";
                        }

                    })
                }
            },

            addBooking(){
                this.message2="";
                this.errors2 = [];
                if(!this.dataformbooking.name) this.errors2.push("Name required.");
                if(!this.dataformbooking.email) {
                    this.errors2.push("Email required.");
                } else if(!this.validEmail(this.dataformbooking.email)) {
                    this.errors2.push("Valid email required.");
                }
                if(!this.dataformbooking.phone) this.errors2.push("Phone required");
                if(!this.dataformbooking.dateUserChoose) this.errors2.push("Date required");
                if(!this.timeval) this.errors2.push("Time required");
                // console.log(this.checkingTime());
                if(this.checkingTime()===0)
                {
                    this.errors2.push("Time is not in range!")
                }
                if(!this.errors2.length) {
                    new AddBooking(this.dataformbooking.name,this.dataformbooking.email,this.dataformbooking.phone,this.dataformbooking.dateUserChoose,this.dataformbooking.plane,this.timeval,this.dataformbooking.idsale).then((respone)=>{
                        // console.log(respone.data);
                        if(respone.data.result>0){
                            this.message2="You added success!";
                            new Booking.GetAllBooking().then(response =>{
                                console.log(response.data);
                                this.bookingdata=response.data;
                            });

                        }
                        else{
                            this.message2="Added failed";
                        }
                    })}
            },

            DeleteSchedule(){
                let counter=0;
                for(let i=0; i< this.SchedulerMerge.length; i++)
                {
                    if(this.SchedulerMerge[i].selected === true)
                    {
                        this.counter+=1;
                        new Delete(this.SchedulerMerge[i].Id_scheduler).then(response =>{
                            if(response.data.result === 1)
                            {
                                window.location.reload();
                                alert("Delete success");
                            }
                            else{
                                alert("Delete failed");
                            }
                        })
                    }
                }
                if(counter===0){alert("Please choose at least 1 rows to delete");}
            },
            DeleteBooking(){
                let counter=0;
                for(let i=0; i< this.BookingList.length; i++)
                {
                    if(this.BookingList[i].selected === true)
                    {
                        this.counter+=1;
                        new Booking.Delete(this.BookingList[i].Id_booking).then(response =>{
                            if(response.data.result === 1)
                            {
                                window.location.reload();
                                alert("Delete success");
                            }
                            else{
                                alert("Delete failed");
                            }
                        })
                    }
                }
                if(counter===0){alert("Please choose at least 1 rows to delete");}
            },
            DeletePlane(){
                let counter=0;
                for(let i=0; i< this.PlaneList.length; i++)
                {
                    if(this.PlaneList[i].selected === true)
                    {
                        this.counter+=1;
                        new Plane.Delete(this.PlaneList[i].Id_plane).then(response =>{
                            if(response.data.result === 1)
                            {
                                window.location.reload();
                                alert("Delete success");
                            }
                            else{
                                alert("Delete failed");
                            }
                        })
                    }
                }
                if(counter===0){alert("Please choose at least 1 rows to delete");}
            },

            DeleteUser(){
                let counter=0;
                for(let i=0; i< this.userdata.length; i++)
                {
                    if(this.userdata[i].selected === true)
                    {
                        this.counter+=1;
                        new Account.Delete(this.userdata[i].Id_sale).then(response =>{
                            if(response.data.result === 1)
                            {
                                window.location.reload();
                                alert("Delete success");
                            }
                            else{
                                alert("Delete failed");
                            }
                        })
                    }
                }
                if(counter===0){alert("Please choose at least 1 rows to delete");}
            },

        },

        created(){
            this.min = 0;
            this.max = 24;
            this.step = 0.5;
            this.minrange = 2;
            this.enableCross = false;

            if(this.$cookie.get('JSESSIONID')===""){
                this.$router.push('/login');
            }
            else {
                new Cookies.GetCheckingCookies(this.$cookie.get('JSESSIONID')).then(response =>{
                    this.checkinglist = response.data;
                    if(this.checkinglist.AccountType<1 || this.checkinglist === "")
                    {
                        alert("Invalid session - please login again");
                        this.$router.push('/login');
                    }
                    else if(this.checkinglist.AccountType > 1)
                    {
                        this.$router.push('/scheduler');
                    }
                    else{
                            new Account.GetAllAccounts().then(response =>{
                            // console.log(response.data);
                            this.userdata=response.data;
                        });
                        new Booking.GetAllBooking().then(response =>{
                            console.log(response.data);
                            this.bookingdata=response.data;
                        });
                        new Plane.GetAllPlane().then(response =>{
                            // console.log(response.data);
                            this.planedata=response.data;
                        });
                        new Scheduler.GetScheduler().then(response =>{
                            // console.log(response.data);
                            this.schedulerdata=response.data;
                        });
                    }
                });

            }
        },
        computed:{

            SchedulerMerge(){
                return this.schedulerdata.map(item => {
                    const obj = this.planedata.find(o =>o.Id_plane === item.Id_plane);
                    const obj2 = this.userdata.find(o=> o.Id_sale === item.Id_sale);
                    return {...item,...obj,...obj2};
                })
            },
            BookingList(){
                return this.bookingdata.map(item => {
                    const obj = this.planedata.find(o =>o.Id_plane === item.Id_plane);
                    return {...item,...obj};
                })
            },
            PlaneList(){
                return this.planedata.map(item => {
                    const obj = this.userdata.find(o =>o.Id_sale === item.Id_sale);
                    return {...item,...obj};
                })

            }

        },
        components:{
            VueBootstrapTable: VueBootstrapTable,
            VueRangeSlider,VueTimepicker

        }

    }
</script>

<style scoped>
    @import '../assets/css/bootstrap.min.css';

</style>