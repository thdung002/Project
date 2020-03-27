import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login'
import Scheduler from '@/components/Scheduler'
import Home from '@/components/Home'
import Admin from '@/components/Admin'

Vue.use(Router);

export default new Router({
    base: process.env.BASEL_URL,
    routes: [
        {   path: '/',
            name: 'Homepage',
            component: Home,}
        ,
        {
            path: '/login',
            name: 'Login',
            component: Login
        },
        {
            path: '/scheduler',
            name: 'Scheduler',
            component: Scheduler
        },
        {
            path: '/admin',
            name: 'Admin',
            component: Admin
        },

    ],
    mode:'history'
})
