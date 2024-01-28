import './assets/main.css'
import router from "./router";
import { createApp } from 'vue'
import { store } from './store.js'
import App from './App.vue'
createApp(App).use(router).use(store)
    .mount('#app')