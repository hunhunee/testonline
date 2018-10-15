import Vue from 'vue';
import Vuex from 'vuex';
//引进模块
import user from './modules/user/index';
import person from './modules/person/index';
import test from './modules/test/index';
import exam from './modules/exam/index';
import info from './modules/info/index'
import lesson from './modules/Lesson/index';
import score from './modules/score/index';
import Class from './modules/Class/index';

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    //Vuex 允许我们将 store 分割成模块（module）。每个模块拥有自己的 state、mutation、action
    user:user,
    person:person,
    test:test,
    exam:exam,
    info:info,
    lesson:lesson,
    score:score,
    Class:Class
  }

});
