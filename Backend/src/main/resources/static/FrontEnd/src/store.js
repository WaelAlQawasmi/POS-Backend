import { createStore } from 'vuex'

// Create a new store instance.
export const store = createStore({
    state() {
        return {
            user: null,
            token: null
        }
    },
    mutations: {
        setUser(state, user) {
            state.user = user;
        },
        setToken(state, token) {
            state.token = token;
        },
    },
    actions: {

    },
    getters: {
        getUser: state => {
            return state.user;
        },
        getToken: state => {
            return state.token;
        },
        isAuthenticatedUser: state => {
            console.log(state.user, state.token)
            return state.user != null && state.token != null;
        }
    },
});