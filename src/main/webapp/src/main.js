import Vue from 'vue'
import App from './App'
import router from './router'
import VueRouter from 'vue-router'
import ace from 'ace-builds'
import axios from 'axios'
// import axios from '@/api/http' //vue项目对axios的全局配置
import qs from 'qs'
import VueAxios from 'vue-axios'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';


Vue.use(ElementUI);
Vue.use(ace);
Vue.use(VueRouter)
Vue.use(VueAxios, axios)
Vue.use(qs)

Vue.config.productionTip = false

// 创建 Vue 实例对象
new Vue({
    render: h => h(App),
    router // 路由 4
}).$mount('#app')