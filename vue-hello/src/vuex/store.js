import Vue from 'vue';
import Vuex from 'vuex';
import user from './modules/user/index';//引进模块
import person from './modules/person/index';
import test from './modules/test/index'
Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    //Vuex 允许我们将 store 分割成模块（module）。每个模块拥有自己的 state、mutation、action
    user:user,
    person:person,
    test:test
  }

});
