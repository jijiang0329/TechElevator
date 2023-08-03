import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    hotels: []
  },
  getters: {
  },
  mutations: {
    SET_HOTELS(state, payload){
      state.hotels = payload;
    }
  },
  actions: {
  },
  modules: {
  }
})
