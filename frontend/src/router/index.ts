import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue';
import AboutView from '../views/AboutView.vue';
import RepositoryList from '../views/RepositoriesView.vue';
import FollowingList from '../views/FollowingView.vue';
import RepositoryView from '../views/RepositoryView.vue';
// Define the routes
const routes = [
  {
    path: '/',
    name: 'Home',
    component: HomeView, // Lazy-loaded by default
  },
  {
    path: '/about',
    name: 'About',
    component: AboutView,
  },
  {
    path: '/repositories',
    name: 'Repositories',
    component: RepositoryList,
  },
  {
    path: '/following',
    name: 'Following',
    component: FollowingList,
  },
  {
    path: '/repositories/:nodeId',
    name: 'Repository',
    component: RepositoryView,
  },
];


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
})

export default router
