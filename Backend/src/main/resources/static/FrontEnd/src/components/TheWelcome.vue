<template>
  <h1 class="row p-5 ">Welcome to home page</h1>
</template>
<script>
import axios from 'axios';
import { mapMutations } from "vuex";

export default {
  data() {
    return {
      email: '',
      password: '',
      errorMessage: false
    };
  },
  methods: {
    
    ...mapMutations(["setUser", "setToken"]),
    async  getUserData() {
     

      try {
     //   console.log( this.$store.getters.getToken);
     console.log("**********headersheadersheaders****************************");

var headers=  {
            "Content-type": "application/json",

            'Authorization': "Bearer " + this.$store.getters.getToken,
           };
           console.log("**********headersheadersheaders****************************");
           console.log(headers);

        const response = await axios.get('http://127.0.0.1:8089/api/main-page/userProfile', {
          withCredentials: true,
          headers:headers
        });
        // Handle the response
        console.log(response.data);
      } catch (error) {
        // Handle errors
        console.error('Error fetching data:', error.message);
      }

    }
  },
  created() {
    // This is the created lifecycle hook
    console.log("Component is created!");

    // You can perform initializations or fetch data here
    // For example, make an API call to get some data
    // and update the component's state
    this.getUserData();
  },

};
</script>