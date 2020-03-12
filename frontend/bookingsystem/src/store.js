import Vuex from 'vuex'

export const store = new Vuex.Store({
    state: {
        planes : '',
        sale_id:0,
    },
    getters: {
        myPlane: (state) => state.planes,
    },
    mutations:{
      updatePlane(state,plane){
          state.planes=plane;
      },
        updateID(state,id){
          state.sale_id= id;
},

    },
    strict: true
});
