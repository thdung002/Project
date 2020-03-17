import Vuex from 'vuex'

export const store = new Vuex.Store({
    state: {
        sale_id:0,
        id_plane:0,
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

    },
    strict: true
});
