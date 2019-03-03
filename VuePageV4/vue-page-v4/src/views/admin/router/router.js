import Vue from 'vue/dist/vue.js'
import Router from 'vue-router'//使用 路由
import iView from 'iview';
import store from '../../../store/store'// 使用 状态管理

Vue.use(iView);
Vue.use(Router);

const routes = [
    {
        path: "/admin/home",
        name: 'Home',
        meta: {
            title: 'Online Judge'
        },
        component: resolve => require(['../pages/Home'], resolve),
    },
    {
        path: "/admin/user",
        name: 'User',
        meta: {
            title: 'Online Judge'
        },
        component: resolve => require(['../pages/general/User'], resolve),
    },
    {
        path: "/admin/login",
        name: 'Login',
        meta: {
            title: 'Online Judge'
        },
        component: resolve => require(['../pages/general/Login'], resolve),
    },
    {
        path: "/admin/problems",
        name: 'ProblemList',
        meta: {
            title: 'Online Judge'
        },
        component: resolve => require(['../pages/problem/ProblemList'], resolve),
    },
    {
        path: "/admin/",
        redirect: '/admin/home'
    },

];

const router = new Router({
    mode: "history",
    routes,
});

router.beforeEach((to, from, next) => {
    // iView.LoadingBar.start();
    if (to.path !== "/admin/login" && (store.state.admin === "false" || store.state.admin == null || store.state.user == null)) {
        // this.$Message.error("无权访问,请先登录");
        console.log("无权访问,请先登录");
        next("/admin/login");
    }

    if (to.meta.title) {
        document.title = to.meta.title;
    }
    next();
});
router.afterEach(route => {
    // iView.LoadingBar.finish();
});

export default router;