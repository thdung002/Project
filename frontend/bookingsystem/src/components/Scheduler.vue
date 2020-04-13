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
                                <div class="card-header">
                                    <strong class="card-title">Your work time</strong>
                                </div>
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
                                        :columns="columnScheduler"
                                        :values="MergeSale"
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
                                <div class="card-header">Work time</div>
                                <div class="card-body card-block">
                                    <form action="" method="post"  @submit.prevent="add">
                                        <div v-if="errors.length" class="form-label">
                                            <b>Please correct the following error(s):</b>
                                            <b>
                                                <ul style="padding-left: 1em;">
                                                    <li  v-for="(error,index) in errors" :key="index">{{ error }}</li>
                                                </ul>

                                            </b>
                                        </div>

                                        <div class="form-group">
                                            <label  class="form-control-label">Choose plane</label>
                                            <select class="form-control " v-model="dataform.plane">
                                                <option v-for="(plane,index) in planedata" :key="index"  :value="{id: plane.Id_plane, text: plane.planename}">{{plane.planename}}</option>
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
                        <div class="card">
                                    <div class="card-header">
                                        <div class="row">
                                            <div class="col-lg-1">
                                                <strong class="card-title">Schedule By</strong>
                                                <div class="select">
                                                    <select class="form-control" v-model="displayPeriodUom">
                                                        <option>month</option>
                                                        <option>week</option>
                                                        <option>year</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="col-lg-1">
                                                <strong class="card-title">Period</strong>
                                                <div class="select">
                                                    <select class="form-control" v-model="displayPeriodCount">
                                                        <option :value="1">1</option>
                                                        <option :value="2">2</option>
                                                        <option :value="3">3</option>
                                                        <option :value="4">4</option>

                                                    </select>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                            <div class="card-body">
                                <calendar-view
                                        :events="BookingList"
                                        :show-date="showDate"
                                        :show-event-times="true"
                                        :display-period-uom="displayPeriodUom"
                                        :display-period-count="displayPeriodCount"
                                        :time-format-options="{ hour: 'numeric', minute: '2-digit' }"
                                        @click-event="onClickItem"
                                        class=" theme-default holiday-us-traditional holiday-us-official"
                                >
                                    <calendar-view-header
                                            slot="header"
                                            slot-scope="{ headerProps }"
                                            :header-props="headerProps"
                                            @input="setShowDate"
                                    />
                                </calendar-view>
                                <Details v-if="showModal" @close="showModal = false">
                                    <h2 slot="header">{{time}}</h2>
                                    <h3 slot="body">{{title}}</h3>
                                </Details>

                            </div>


                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import  * as Booking from '../service/SaleServices/BookingForSale';
    import * as Plane from "../service/SaleServices/PlaneForSale";
    import * as Scheduler from "../service/SaleServices/SchedulerForSale";
    import * as Cookies from"../service/Cookies/Cookies";

    import {Logout} from "../service/SaleServices/Logout";
    import 'vue-range-component/dist/vue-range-slider.css'
    import VueRangeSlider from 'vue-range-component'
    import moment from 'moment';
    import VueBootstrapTable from "vue2-bootstrap-table2";
    import { CalendarView, CalendarViewHeader } from "vue-simple-calendar"
    import Details from './Details'
    require("vue-simple-calendar/static/css/default.css");
    require("vue-simple-calendar/static/css/holidays-us.css");
    require('moment/locale/vi.js');

    export default {
        name: "Scheduler",
        data() {
            return {
                title: 'Add new worktime',
                dataform: {}, //Store to add new worktime of sale plane,date
                schedulerdata: [],//Data get from sale database id, date, plane, starts, ends
                userdata: [],//Data get from booking in database_Note of user
                planedata: [],//data from master database plane
                checkinglist: {}, // checking account when refesh with jsessionid cookie  - the user information will store here
                message: "",
                value: [0, 24],
                success: "",
                showDate: new Date(),
                displayPeriodUom: "month",
                displayPeriodCount: 1,
                showModal: false,
                time:"",
                errors:[],
                columnScheduler: [
                    {
                        name: 'Id_scheduler',
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

            }
        },

        methods: {
            logout() {
                Logout().then(()=>{
                    this.$router.push('/login');
                });
            },
            home(){
                this.$router.push('/');
            },

            setShowDate(d) {
                this.showDate = d;
            },

            timestamp(hours) {
                if(hours===24)
                    return '24:00';
                else
                    return moment.utc(hours * 3600 * 1000).format('HH:mm')
            },
            datestamp(date) {
                return moment(date).format("YYYY-MM-DD");
            },
            onClickItem(e) {
                this.showModal=true;
                this.title= `${e.title}`;
                for(let i=0; i<this.userdata.length;i++)
                {
                    if(e.id === this.userdata[i].Id_booking)
                    {
                        this.time = this.userdata[i].Timebooking + " " + moment(this.userdata[i].Datebooking).locale('vi').format("dddd DD, MMMM  YYYY");
                    }
                }
            },
            DeleteSchedule(){
                let counter=0;
                for(let i=0; i< this.MergeSale.length; i++)
                {
                    if(this.MergeSale[i].selected === true)
                    {
                        this.counter+=1;
                        new Scheduler.Delete(this.MergeSale[i].Id_scheduler).then(response =>{
                            if(response.data.result === 1)
                            {
                                window.location.reload();
                                this.message="Delete success";
                                this.counter+=1;
                            }
                            else{
                                this.message="Delete failed";
                            }

                        })
                    }
                }
                if(counter===0){this.message="Please choose at least 1 rows to delete";}
            },
            add() {
                this.message="";
                this.errors=[];
                if(!this.dataform.date) this.errors.push("Date required.");
                if(!this.dataform.plane) this.errors.push("Plane required.");
                if(this.dataform.date < this.datestamp(this.showDate))
                    this.errors.push("Can't add with older date with today");
                else {
                    new Scheduler.AddScheduler(this.checkinglist.Id_sale, this.dataform.date, this.value[0], this.value[1], this.dataform.plane.id).then(response => {
                        console.log(response);
                        if (response.data.result !== 0) {
                            this.message = "You added success!";
                            this.success = response.data.result;
                            new Scheduler.GetSchedulerForSale(this.checkinglist.Id_sale).then(response => {
                                // console.log(response.data);
                                this.schedulerdata = response.data;
                            });
                        } else {
                            this.message = "Added failed";
                            this.success = response.data.result;
                        }
                    })
                }
            },
        },
        components: {
            VueRangeSlider,
            VueBootstrapTable: VueBootstrapTable,
            CalendarView,
            CalendarViewHeader,Details

        },
        computed: {
            MergeSale() {
                // return this.saledata.map((item,i)=> Object.assign({},item, this.planedata[i]));
                return this.schedulerdata.map(item => {
                    const obj = this.planedata.find(o => o.Id_plane === item.Id_plane);
                    return {...item, ...obj};
                })
            },
            BookingList() {
                // return this.userdata.map((item,i)=> Object.assign({},item,this.planedata[i]));
                return this.userdata.map(item => {
                    const obj = this.planedata.find(o => o.Id_plane === item.Id_plane);
                    const arr=
                        {
                            id: item.Id_booking,
                            startDate: this.datestamp(item.Datebooking) +" "+ item.Timebooking,
                            title: "Gặp: " + item.Full_name + " tại "+obj.planename + ", điện thoại: "+item.Phone + ", email: "+ item.Email
                        }
                    ;
                    return arr;

                })

            },
        },

            created() {
                this.min = 0;
                this.max = 24;
                this.step = 0.5;
                this.minrange = 2;
                this.enableCross = false;
                if(this.$cookie.get('JSESSIONID')===null){
                    this.$router.push('/login');
                }
                else{
                    new Cookies.GetCheckingCookies(this.$cookie.get('JSESSIONID')).then(response =>{
                        this.checkinglist = response.data;
                        if(this.checkinglist.AccountType<1 || this.checkinglist === "")
                        {
                            alert("Invalid session - please login again");
                            this.$router.push('/login');
                        }
                        else if(this.checkinglist.AccountType === 1)
                        {
                            this.$router.push('/admin');
                        }
                        else{
                            new Scheduler.GetSchedulerForSale(this.checkinglist.Id_sale).then(response => {
                                // console.log(response.data);
                                this.schedulerdata = response.data;
                            });
                            new Booking.GetListBookingByID(this.checkinglist.Id_sale).then(respone => {
                                // console.log(respone.data);
                                this.userdata = respone.data;
                            });
                            new Plane.PlaneForSale(this.checkinglist.Id_sale).then(respone => {
                                // console.log(respone.data);
                                this.planedata = respone.data;
                            });
                        }
                    });
                }


            }


    }
</script>

<style scoped>
        /*@import '../assets/css/schedule.css';*/
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



