import Vue from 'vue'
import App from './App.vue'
import router from './router'
import Vuex from 'vuex'
import {store} from './store.js'
import TableComponent from 'vue-table-component';
import VueCookies from 'vue-cookies';

Vue.use(VueCookies);
var VueCookie = require('vue-cookie');
Vue.config.productionTip = false;
Vue.use(Vuex);
Vue.use(TableComponent);
Vue.use(VueCookie);

new Vue({
  el:'#app',
  router, store,
  render: h => h(App),
}).$mount('#app');
