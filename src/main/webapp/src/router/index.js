import Vue from 'vue'
import Router from 'vue-router'
import VueRouter from 'vue-router'
import Main from '../components/Main.vue'
import study from '../components/study.vue'
import exercise from '../components/exercise.vue'
import Code_f from '../components/Code_f.vue'

Vue.use(Router)
Vue.use(VueRouter)

export default new VueRouter({
    mode: 'history',
    routes: [{
            path: '/',
            redirect: '/src/components/Main.vue'
        },
        {
            path: '/src/components/Main.vue',
            name: 'Main',
            component: Main
        },
        {
            path: '/',
            redirect: '../components/study.vue'
        },
        {
            path: '/src/components/study.vue',
            name: 'study',
            component: study
        },
        {
            path: '/',
            redirect: '../components/exercise.vue'
        },
        {
            path: '/src/components/exercise.vue',
            name: 'exercise',
            component: exercise
        },
        {
            path: '/',
            redirect: '../components/Code_f.vue'
        },
        {
            path: '/src/components/Code_f.vue',
            name: 'Code_f',
            component: Code_f
        },
    ]
})