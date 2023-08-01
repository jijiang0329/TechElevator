import Vue from 'vue'
import VueRouter from 'vue-router'
import Products from '../views/Products'
import Example from '../views/Example'
import ProductDetails from '../views/ProductDetails'
import AddReview from '../views/AddReview.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: "/",
    component: Products,
    name: "products"
  },
  {
    path: "/products/:productId",
    component: ProductDetails,
    name: "details"
  },
  {
    path: "/example/whateverIWant",
    component: Example,
    name: "example"
  },
  {
    path: "/products/:productId/add-review",
    component: AddReview,
    name: "add-review"
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
