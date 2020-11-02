import Vue from 'vue'
import Router from 'vue-router'
import material from '@/components/material'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'material',
      component: material
    }
  ]
})
