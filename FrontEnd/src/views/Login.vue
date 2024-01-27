<template>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        Login Form
                    </div>
                    <div class="card-body">
                        <form  @submit.prevent="login">
                            <div class="form-group">
                                <label for="username">Email:</label>
                                <input  v-model="email" type="email" class="form-control" id="username" name="email" required>
                            </div>
                            <div class="form-group">
                                <label for="password">Password:</label>
                                <input   v-model="password" type="password" class="form-control" id="password" name="password" required>
                            </div>
                            <button type="submit" class="btn btn-primary mt-3">Login</button>
                        </form>
                        <div v-if="errorMessage" class="error">{{ errorMessage }}</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>


<script>
import axios from 'axios';
export default {
  data() {
    return {
      email: '',
      password: '',
      errorMessage: false
    };
  },
  methods: {
    async  login() {
        try {
        const response = await axios.post('http://127.0.0.1:8089/api/auth/login', {
          email: this.email,
          password: this.password,
        },
        {
        withCredentials: true,
        });

        const token = response.data.token;
        localStorage.setItem('token', token);
        localStorage.setItem('token', token);
        this.$router.push('/home');

        //console.log(token);
      } catch (error) {
        this.errorMessage="Authentication failed";

        console.error('Authentication failed', error);
      }

    }
  }
};
</script>