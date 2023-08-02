import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '../views/Home';
import MyBooks from '../views/MyBooks';
import NewBook from '../views/NewBook';
import BookDetails from '../views/BookDetails';

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    component: Home,
    name: "home"
  },
  {
    path: "/myBooks",
    component: MyBooks,
    name: "myBooks"
  },
  {
    path: "/addBook",
    component: NewBook,
    name: "newBook"
  },
  {
    path: "/book/:isbn",
    component: BookDetails,
    name: "bookDetails"
  }
];

const router = new VueRouter({
  mode: 'history',
  routes
});

export default router;
