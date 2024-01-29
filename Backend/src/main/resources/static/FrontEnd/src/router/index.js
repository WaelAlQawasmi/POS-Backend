import { createRouter, createWebHistory } from 'vue-router';
import { store } from '../store.js'
import TheWelcome from '@/components/TheWelcome.vue'
import Login from '@/views/Login.vue'
const router = createRouter({
    history: createWebHistory(
        import.meta.env.BASE_URL),
    routes: [{
            path: '/home',
            name: 'home',
            component: TheWelcome,
            meta: {
                authRequired: true
            }
        },
        {
            path: "/login",
            name: "login",
            component: Login,
        },



    ]
})
export default router;

router.beforeEach(async(to) => {
    const authRequired = to.meta.authRequired;
    if (!store.getters.isAuthenticatedUser && authRequired == true) {
        alert(store.getters.getUser)
        return '/login';
    }
});