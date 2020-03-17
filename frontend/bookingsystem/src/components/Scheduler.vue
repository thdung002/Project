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
                <form action="" method="post" @submit.prevent="add">
                    <div class="panel panel-primary">
                        <div class="panel-heading" >{{title}}</div>
                        <div class="panel-body">
                            <div class="form-group">
                                <label>Choose date</label>
                                <input v-model="dataform.date" class="form-control" type="date">
                            </div>
                            <div class="form-group">
                                <label>Choose plane</label>
                                <select class="form-control" v-model="dataform.plane">
                                    <option v-for="(plane,index) in planedata" :key="index"  :value="{id: plane.Id_plane, text: plane.planename}">{{plane.planename}}</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Your worktime</label>
                                <div class="form-group">
                                    <vue-range-slider ref="slider" v-model="value" :min="min" :max="max"  :enable-cross="enableCross"
                                                      :step="step" :min-range="minrange"></vue-range-slider>
                                </div>
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-danger">Add</button>
                                <button type="reset" class="btn btn-success">Reset</button>
                                <label class="label label-success">{{message}} ----- {{success}}</label>
                            </div>

                        </div>

                    </div>

                </form>
                <h2>NOTE user</h2>
                <table-component :data="userdata"
                                 sort-by="date"
                                 sort-order="asc">
                    <table-column show="full_name" label="Full Name" :filterable="true"></table-column>
                    <table-column show="email" label="Email"></table-column>
                    <table-column show="phone" label="Phone number"></table-column>
                    <table-column show="date" label="Date" :filterable="true" :sortable="true" data-type="date:YYYY-MM-DD"></table-column>
                    <table-column show="id_plane" label="ID Plane"></table-column>
                    <table-column show="time" label="Time"></table-column>

                </table-component>
                <br>
                <h2>All your work time</h2>
                    <table-component :data="saledata"
                    sort-by="date"
                    sort-order="asc">
                        <table-column show="Id_sale" label="Sale ID"></table-column>
                        <table-column show="Id_plane" label="Plane"></table-column>
                        <table-column show="DateCreated" label="DateCreated" :filterable="true" :sortable="true" data-type="date:YYYY-MM-DD"></table-column>
                        <table-column show="Starts" label="Start Time"></table-column>
                        <table-column show="Ends" label="End Time"></table-column>
                    </table-component>

            </div>

        </div>

            </div>

        </div>

    </div>

</template>

<script>
    import axios from 'axios';
    import 'vue-range-component/dist/vue-range-slider.css'
    import VueRangeSlider from 'vue-range-component'

    import moment from 'moment';
    export default {
        name: "Scheduler",
        data(){
            return{
                title:'Add new worktime',
                dataform:{}, //Store to add new worktime of sale plane,date
                saledata:{},//Data get from sale database id, date, plane, starts, ends
                userdata:{},//Data get from booking in database_Note of user
                planedata:{},//data from master database plane
                message:"",
                value:[0,24],
                success:"",
            }
        },
        beforeCreate(){
            if(this.$cookie.get('CurrentAccountID')===null || this.$cookie.get('CurrentAccountID')==='0'){
                this.$router.push('/login');
            }
        },
        methods:{
            logout(){
                axios.get("http://localhost:8000/logout").then((respone) => {
                    console.log(respone);

                });
                this.$store.commit('updateID',0);
                this.$router.push('/login');
            },
            timestamp(hours){
                return moment.utc(hours*3600*1000).format('HH:mm')
            },
            datestamp(date){
                return moment(date).format("DD/MM/YYYY");
            },
            add(){
                if(this.dataform.plane.text===undefined)
                return this.message="Added failed";

                else{
                    axios.post("http://localhost:8000/admin/sale?id="+this.$cookie.get('CurrentAccountID')+"&date="+this.dataform.date+"&start="+this.value[0]+"&end="+this.value[1]+"&idplane="+this.dataform.plane.id).then((respone)=>{
                        console.log(respone);
                        if(respone.data.result>0){
                            this.message="You added success!";
                            this.success=respone.data.result;
                            this.$forceUpdate();
                        }
                        else{
                            this.message="Added failed";
                            this.success=respone.data.result;
                        }
                    })
                }
            },
        },
        components: {
            VueRangeSlider
        },
        created() {
            this.min = 0;
            this.max = 24;
            this.step=0.5;
            this.minrange=2;
            this.enableCross = false;

            axios.get("http://localhost:8000/admin/sale?id=" + this.$cookie.get('CurrentAccountID')).then((respone) => {
                console.log(respone);
                this.saledata = respone.data;
            });
            axios.get("http://localhost:8000/admin/booking?id="+ this.$cookie.get('CurrentAccountID')).then((respone) => {
                console.log(respone);
                this.userdata = respone.data;
            });
            axios.get("http://localhost:8000/admin/plane?id="+ this.$cookie.get('CurrentAccountID')).then((respone) => {
                console.log(respone);
                this.planedata = respone.data;
            });

        }

    }
</script>
<style scoped>
    @import '../assets/css/table-component.css';
</style>



