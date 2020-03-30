import Vuex from 'vuex'

export const store = new Vuex.Store({
    state: {
        sale_id:0,
        id_plane:0,
        sale_name:'',
        dateselect:''
    },
    getters: {
        myPlane: (state) => state.planes,
    },
    mutations:{
        updateIDSale(state,id){
          state.sale_id= id;
},
        updateIDPlane(state,id){
            state.id_plane= id;
        },
        updateName(state,name){
            state.sale_name=name;
        },
        updateDate(state,d){
            state.dateselect=d;
        }

    },
    strict: true
});
