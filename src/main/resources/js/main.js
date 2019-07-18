import Vue from 'vue'
import 'api/resource'
import '@babel/polyfill'
import router from 'router/router'
import App from 'pages/App.vue'
import store from 'store/store'
import {connect} from "./util/ws"
import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.min.css'



if (profile) {
    connect()
}

Vue.use(Vuetify)

new Vue({
    el: '#app',
    router: router,
    store: store,
    render: a => a(App)
});