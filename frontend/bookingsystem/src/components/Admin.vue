<template>
    <div>
        <nav class="navbar navbar-toggleable-sm navbar-inverse bg-dark">
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbar"     aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <button class="btn btn-default" @click="logout">
                Logout
            </button>
            <div class="collapse navbar-collapse justify-content-between" id="navbar">
            </div>
        </nav>
        <div class="section-center">
            <div class="container">
                <div class="row" id="form-register">
                    <div class="col-md-2"></div>
                    <div class="col-md-8">
                        <h2>Booking List</h2>

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
                        ></vue-bootstrap-table>

                        <br>
                        <h2>Scheduler</h2>
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
                        ></vue-bootstrap-table>

                        <br>
                        <h2>Plane</h2>
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
                        ></vue-bootstrap-table>

                        <br>
                        <h2>Users</h2>
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
                        ></vue-bootstrap-table>


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
                        name: 'Id_sale',
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
            logout(){
                Logout();
                this.$router.push('/login');
            },
            timestamp(hours){
                return moment.utc(hours*3600*1000).format('HH:mm')
            },

        },
        beforeCreate(){
            if(this.$cookie.get('CurrentAccountID')=== null || this.$cookie.get('CurrentAccountType') > '1'|| this.$cookie.get('CurrentAccountType') === '0'){
                this.$router.push('/login');
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