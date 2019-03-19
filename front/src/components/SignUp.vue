<template>
    <div class="sign-up">
        <img src="~@/assets/icon.png">
        <h1>sign up here</h1>
        <form @submit="checkform" @submit.prevent>
            <p v-if="password_error">
                Erreur : les password ne correspondent pas
            </p>
            <input type="text" v-model="username" class="input-box" placeholder="Enter your username">
            <input type="password" v-model="password" class="input-box" placeholder="Enter your password">
            <input type="password" v-model="confirm_password" class="input-box" placeholder="Confirm your password">
            <input type="submit" value="Sign up" class="signup-btn"/>
            
            <hr>
            <p class="or">OR</p>
            <a href="signin.html">
                <button type="button" class="signup-btn">sign in</button>
            </a>
        </form>
    </div>
</template>

<script>
export default {
  name: 'SignUp',
  data: function () {
    return {
      username: "",
      password: "",
      confirm_password: "",
      password_error: false
    }
  },
  methods:{
      checkform: function(e){

          if(this.confirm_password != this.password){
            this.password_error = true
          }
          else{
            this.password_error = false 
          }

          console.log(this.confirm_password)
          console.log(this.password)
          console.log(this.username)
      }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

    body {
        margin: 0;
        padding: 0;
        font-family: sans-serif;
        background-image: url(~@/assets/1.jpg);
        background-size: cover;
        background-position: center;
        
    }
    .sign-up {
        margin: 8% auto 0;
        padding: 20px;
        width: 300px;
        background: #fff;
        box-shadow: 0 03px rgba(0,0,0,0.3);
        text-align: center;
        
    }
    .sing-up h1{
        
    }
    .input-box{
        margin: 10px 0;
        padding: 10px;
        width: 100%;
        border: 1px solid #999;
        border-radius: 20px;
        
        
    }
    hr{
        margin-top: 20px;
        width: 80%;
        
    }
    .or{
        background: #fff;
        width: 30px;
        margin: -19px auto 10;
    }
    img{
        width: 70px;
        margin-top: -50px;
    }


</style>
