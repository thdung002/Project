import Vue from 'vue'
import App from './App.vue'
import router from './router'
import Vuex from 'vuex'
import {store} from './store.js'
import TableComponent from 'vue-table-component';

Vue.config.productionTip = false;
Vue.use(Vuex);
Vue.use(TableComponent);
new Vue({
  el:'#app',
  router, store,
  render: h => h(App),
}).$mount('#app');
