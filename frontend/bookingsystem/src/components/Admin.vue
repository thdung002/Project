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
                    <div clas="row">
                        <div class="card">
                            <div class="card-header"><strong class="card-title">All booking</strong></div>
                            <div class="card-body">
                                <vue-bootstrap-table
                                        :columns="colBooking"
                                        :values="BookingList"
                                        :show-filter="true"
                                        :sortable="true"
                                        :paginated="true"
                                        :multi-column-sortable=true
                                        :filter-case-sensitive=false
                                        :selectable=false
                                        :pageSize="5"
                                        class="table table-borderless table-data3"
                                ></vue-bootstrap-table>
                            </div>
                            </div>
                        <div class="card">
                            <div class="card-header"><strong class="card-title">Schedule</strong></div>
                            <div class="card-body">
                                <vue-bootstrap-table
                                        :columns="colScheduler"
                                        :values="SchedulerMerge"
                                        :show-filter="true"
                                        :sortable="true"
                                        :paginated="true"
                                        :multi-column-sortable=true
                                        :filter-case-sensitive=false
                                        :selectable=false
                                        :pageSize="5"
                                        class="table table-borderless table-data3"

                                ></vue-bootstrap-table>
                            </div>
                            </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="card">
                                    <div class="card-header"><strong class="card-title">Plane</strong></div>
                                    <div class="card-body">
                                        <vue-bootstrap-table
                                                :columns="colPlane"
                                                :values="PlaneList"
                                                :show-filter="true"
                                                :sortable="true"
                                                :paginated="true"
                                                :multi-column-sortable=true
                                                :filter-case-sensitive=false
                                                :selectable=false
                                                :pageSize="5"
                                                class="table table-borderless table-data3"

                                        ></vue-bootstrap-table>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="card">
                                    <div class="card-header"><strong class="card-title">All user</strong></div>
                                    <div class="card-body">
                                        <vue-bootstrap-table
                                                :columns="colUsers"
                                                :values="userdata"
                                                :show-filter="true"
                                                :sortable="true"
                                                :paginated="true"
                                                :multi-column-sortable=true
                                                :filter-case-sensitive=false
                                                :selectable=false
                                                :pageSize="5"
                                                class="table table-borderless table-data3"

                                        ></vue-bootstrap-table>
                                    </div>
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
    import {GetAllAccounts} from "../service/AdminServices/UsersForAdmin";
    import {GetAllBooking} from "../service/AdminServices/BookingForAdmin";
    import {GetAllPlane} from "../service/AdminServices/PlaneForAdmin";
    import {GetScheduler} from "../service/UserServices/SchedulerForUser";
    import moment from 'moment';
    import VueBootstrapTable from "vue2-bootstrap-table2";

    export default {
        name: "Admin",
        data(){
            return{
                bookingdata:[],
                userdata:[],
                planedata:[],
                schedulerdata:[],
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

            timestamp(hours){
                if(hours===24)
                    return '24:00';
                else
                    return moment.utc(hours * 3600 * 1000).format('HH:mm')
            },

        },
        mounted(){
            if(this.$cookie.get('CurrentAccountType')=== null || this.$cookie.get('CurrentAccountType') === '0'){
                this.$router.push('/login');
            }
            else if(this.$cookie.get('CurrentAccountType') > '1')
            {
                this.$router.push('/scheduler');
            }
        },

        created(){
            new GetAllAccounts().then(response =>{
                // console.log(response.data);
                this.userdata=response.data;
            });
            new GetAllBooking().then(response =>{
                console.log(response.data);
                this.bookingdata=response.data;
            });
            new GetAllPlane().then(response =>{
                // console.log(response.data);
                this.planedata=response.data;
            });
            new GetScheduler().then(response =>{
                // console.log(response.data);
                this.schedulerdata=response.data;
            });
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
            VueBootstrapTable: VueBootstrapTable
        }

    }
</script>

<style scoped>
    @import '../assets/css/bootstrap.min.css';

</style>