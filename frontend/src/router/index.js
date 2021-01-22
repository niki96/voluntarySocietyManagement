import Vue from 'vue'
import Router from 'vue-router'
import material from '@/components/material'
import vehicle from '@/components/vehicle'
import loading from '@/components/loading'
import loadingForm from '@/components/loadingForm'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'material',
      component: material
    },
    {
        path: '/vehicle',
        name: 'vehicle',
        component: vehicle
      },
      {
        path: '/loading',
        name: 'loading',
        component: loading
      },
      {
        path: '/loading/create',
        name: 'loadingForm',
        component: loadingForm
      }
  ]
})
