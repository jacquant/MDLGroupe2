<template>
  <v-app id="editprofil" class="blue-grey">
    <v-content>
      <v-container fluid fill-height>
        <v-layout align-center justify-center>
          <v-flex xs12 sm8 md4 lg4>
            <v-card class="elevation-1 pa-3">
              <v-card-text>
                <div style="margin-top: 10px;">
                  <v-card-actions>
                    <v-btn block color @click="editpwd"
                      >Edit password</v-btn
                    >
                    <v-btn block color @click="editmail"
                      >Add email</v-btn
                    >
                    <v-btn block color @click="editprofile" disabled="true"
                      >Edit profile</v-btn
                    >
                  </v-card-actions>
                </div>
                <div class="layout column align-center">
                  <h3 class="titre">Edit Profile</h3>
                </div>
                <v-form>
                  <v-text-field
                    append-icon="person"
                    name="firstname"
                    label="First Name"
                    type="text"
                    v-model="model.firstname"
                  ></v-text-field>
                  <v-text-field
                    append-icon="person"
                    name="lastname"
                    label="Last Name"
                    type="text"
                    v-model="model.lastname"
                  ></v-text-field>
                  <v-text-field
                    append-icon
                    name="title"
                    label="Title"
                    type="text"
                    v-model="model.title"
                  ></v-text-field>
                  <v-text-field
                    append-icon
                    name="organisation"
                    label="organisation"
                    type="text"
                    v-model="model.organisation"
                  ></v-text-field>
                  <!--v-text-field
                    append-icon="lock"
                    name="password"
                    label="Password"
                    id="password"
                    type="password"
                    v-model="model.password"
                  ></v-text-field>
                  <v-text-field
                    append-icon="lock"
                    name="password_bis"
                    label="Retype Password"
                    id="password"
                    type="password"
                    v-model="model.password_bis"
                  ></v-text-field-->
                </v-form>
              </v-card-text>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn block color="green lighten-3" @click="editprofilValidate"
                  >Validate</v-btn
                >
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
    model: {}
  }),

  methods: {
    editprofilValidate() {},

    editpwd() {
      this.loading = true;
      setTimeout(() => {
        this.$router.push("/editpassword");
      }, 1000);
    },

    editmail() {
      this.loading = true;
      setTimeout(() => {
        this.$router.push("/editemail");
      }, 1000);
    },
    editprofile() {
      this.loading = true;
      setTimeout(() => {
        this.$router.push("/editprofil");
      }, 1000);
    }
  }
};
</script>
<style scoped lang="css">
#editprofil {
  height: 100%;
  width: 100%;
  position: absolute;
  top: 0;
  left: 0;
  content: "";
  z-index: 0;
}
.titre {
  color:lightslategrey;
  font-weight: bold;
}
.btn {
  width: 145px;
}
</style>
