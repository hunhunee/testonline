// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
//iview
import iView from 'iview';
import 'iview/dist/styles/iview.css';
//vue-router
import router from './router'
//axios
import VueAxios from 'vue-axios';
import axios from 'axios'
import api from './api/global.js'
// 将API方法绑定到全局
Vue.prototype.$api = api
//vuex
import store from './vuex/store'

Vue.config.productionTip = false
//echarts
import echarts from 'echarts'
Vue.prototype.$echarts = echarts


Vue.use(iView);
Vue.use(VueAxios,axios);
/* eslint-disable no-new */

router.beforeEach((to, from, next) => {
  if (to.matched.some(m => m.meta.auth)) {
    if (window.localStorage.isLogin === '1') {
      next()
    } else if (to.path !== '/') {
      next({path: '/'})
      Vue.prototype.$message.warning('检测到您还未登录,请登录后操作！')
    }
  } else {
    next()
  }
})



new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
