<template>
  <v-app id="login" class="primary">
    <v-content>
      <v-container fluid fill-height>
        <v-layout align-center justify-center>
          <v-flex xs12 sm8 md4 lg4>
            <v-card class="elevation-1 pa-3">
              <v-card-text>
                <div class="layout column align-center">
                  <img
                    src="/static/logo.jpg"
                    alt="Research"
                    width="120"
                    height="120"
                  />
                  <h1 class="flex my-4 primary--text">Login</h1>
                </div>
                <v-form>
                  <v-text-field
                    append-icon="person"
                    name="login"
                    label="Login"
                    type="text"
                    v-model="username"
                  ></v-text-field>
                  <v-text-field
                    append-icon="lock"
                    name="password"
                    label="Password"
                    id="password"
                    type="password"
                    v-model="password"
                  ></v-text-field>
                </v-form>
              </v-card-text>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn block color="primary" @click="login">Login</v-btn>
              </v-card-actions>
            </v-card>
          </v-flex>
        </v-layout>
      </v-container>
    </v-content>
  </v-app>
</template>

<script>
export default {
  data: () => ({
    loading: false,
    model: {
      username: "",
      password: ""
    }
  }),

  methods: {
    login() {
      this.loading = true;

      setTimeout(() => {
        this.$router.push("/dashboard");
      }, 1000);
    }
  }
};

function appel_ajax() {
  var xhr = getXhr();
  // On défini ce qu'on va faire quand on aura la réponse
  xhr.onreadystatechange = function() {
    // On ne fait quelque chose que si on a tout reçu et que le serveur est ok
    if (xhr.readyState == 4 && xhr.status == 200) {
      //Ici sera afficher le résultat de notre script PHP ajax.php  alert(xhr.responseText);
      alert(xhr.responseText);
      //xhr.responseText;
    }
  };
  var param1 = this.username;
  var param2 = this.password;
  var url =
    "http://mdl-std02.info.fundp.ac.be:8181/MdlGroupe2-test/user?email=" +
    param1 +
    "& password=" +
    param2;
  xhr.open("GET", url, true);
  xhr.send(null);
}
function getXhr() {
  var xhr = null;
  if (window.XMLHttpRequest)
    // Firefox et autres
    xhr = new XMLHttpRequest();
  else if (window.ActiveXObject) {
    // Internet Explorer
    try {
      xhr = new ActiveXObject("Msxml2.XMLHTTP");
    } catch (e) {
      xhr = new ActiveXObject("Microsoft.XMLHTTP");
    }
  } else {
    // XMLHttpRequest non supporté par le navigateur
    alert("Votre navigateur ne supporte pas les objets XMLHTTPRequest...");
    xhr = false;
  }
  return xhr;
}
</script>
<style scoped lang="css">
#login {
  height: 50%;
  width: 100%;
  position: absolute;
  top: 0;
  left: 0;
  content: "";
  z-index: 0;
}
</style>
