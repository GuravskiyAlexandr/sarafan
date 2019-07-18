import Vue from 'vue'
import VueRouter from 'vue-router'
import MessagesList from '../components/messages/messageList.vue'
import Auth from '../pages/Auth.vue'
import Profile from '../pages/Profile.vue'
import Subscription from '../pages/Subscriptions.vue'


Vue.use(VueRouter)

const routes = [
    { path: '/', component: MessagesList },
    { path: '/auth', component: Auth },
    { path: '/user/:id?', component: Profile },
    {path: '/subscription/:id', component: Subscription},
    { path: '*', component: MessagesList },

]

export default new VueRouter({
    mode: 'history',
    routes
})