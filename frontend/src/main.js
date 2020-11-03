import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import vueAxios from 'vue-axios'
import { library } from '@fortawesome/fontawesome-svg-core'
import { faEdit,faSync,faPlusSquare} from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import { BootstrapVue } from 'bootstrap-vue'
library.add(faEdit, faSync, faPlusSquare)
Vue.component('font-awesome-icon', FontAwesomeIcon)
Vue.use(BootstrapVue)
// Optionally install the BootstrapVue icon components plugin
Vue.use(vueAxios, axios)

Vue.config.productionTip = false

new Vue({
  el:'#app',
  router, 
  render: h => h(App),
  componets:{App}, 
  template: '<App/>'
})
