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
                        <table-component :data="BookingList"
                                         sort-by="date"
                                         sort-order="asc"
                                         ref="table">
                            <table-column show="Full_name" label="Full Name" :filterable="true"></table-column>
                            <table-column show="Email" label="Email"></table-column>
                            <table-column show="Phone" label="Phone number"></table-column>
                            <table-column show="Datebooking" label="Date meeting" :filterable="true" :sortable="true" data-type="date:YYYY-MM-DD"></table-column>
                            <table-column show="planename" label="Location" :filterable="true"></table-column>
                            <table-column show="Timebooking" label="Time meeting"></table-column>

                        </table-component>
                        <br>
                        <h2>Scheduler</h2>
                        <table-component :data="SchedulerMerge"
                                         sort-by="date"
                                         sort-order="asc"
                                         ref="table">
                            <table-column show="Fullname" label="Sale name"></table-column>
                            <table-column show="planename" label="Location"></table-column>
                            <table-column show="DateCreated" label="DateCreated" :filterable="true" :sortable="true" data-type="date:YYYY-MM-DD"></table-column>
                            <table-column show="Starts" label="Start Time"></table-column>
                            <table-column show="Ends" label="End Time"></table-column>
                        </table-component>

                        <br>
                        <h2>Plane</h2>
                        <table-component :data="PlaneList"
                                         sort-by="date"
                                         sort-order="asc"
                                         ref="table">
                            <table-column show="Id_plane" label="Plane ID"></table-column>
                            <table-column show="planename" label="Location"></table-column>
                            <table-column show="Fullname" label="ID SALE" :filterable="true" :sortable="true" ></table-column>
                        </table-component>

                        <br>
                        <h2>Users</h2>
                        <table-component :data="userdata"
                                         sort-by="date"
                                         sort-order="asc"
                                         ref="table">
                            <table-column show="Id_sale" label="Sale ID"></table-column>
                            <table-column show="Fullname" label="Full name" :filterable="true" :sortable="true"></table-column>
                            <table-column show="username" label="Username"></table-column>
                            <table-column show="password" label="Password"></table-column>
                            <table-column show="AccountType" label="Account Type"></table-column>
                        </table-component>


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

    export default {
        name: "Admin",
        data(){
            return{
                bookingdata:[],
                userdata:[],
                planedata:[],
                schedulerdata:[],
            }
        },
        methods:{
            logout(){
                Logout();
                this.$router.push('/login');
            }
        },
        beforeCreate(){
            if(this.$cookie.get('CurrentAccountID')===null || this.$cookie.get('CurrentAccountID')==='0'){
                this.$router.push('/login');
            }
        },

        created(){
            new GetAllAccounts().then(response =>{
                console.log(response.data);
                this.userdata=response.data;
            });
            new GetAllBooking().then(response =>{
                console.log(response.data);
                this.bookingdata=response.data;
            });
            new GetAllPlane().then(response =>{
                console.log(response.data);
                this.planedata=response.data;
            });
            new GetScheduler().then(response =>{
                console.log(response.data);
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

    }
</script>

<style scoped>

</style>