<template>
  <v-app id="editpassword" class="primary">
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
                </div>
                <div style="margin-top: 10px;">
                  <v-card-actions>
                    <v-btn block color @click="editpwd" class="active_btn"
                      >Edit password</v-btn
                    >
                    <v-btn block color @click="editmail" class="btn"
                      >Add email</v-btn
                    >
                    <v-btn block color @click="editprofile" class="btn"
                      >Edit profile</v-btn
                    >
                  </v-card-actions>
                </div>
                <div class="layout column align-center">
                  <h3 class="flex my-4 primary--text">Change Password</h3>
                </div>
                <v-form>
                  <v-text-field
                    append-icon="lock"
                    name="oldpassword"
                    label="Old Password"
                    id="oldpassword"
                    type="password"
                    v-model="model.oldpassword"
                  ></v-text-field>
                  <v-text-field
                    append-icon="lock"
                    name="newpassword"
                    label="New Password"
                    id="newpassword"
                    type="password"
                    v-model="model.newpassword"
                  ></v-text-field>
                  <v-text-field
                    append-icon="lock"
                    name="newpasswordbis"
                    label="Confirm New Password"
                    id="newpasswordbis"
                    type="password"
                    v-model="model.newpasswordbis"
                  ></v-text-field>
                </v-form>
              </v-card-text>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn block color="primary" @click="editpasswordValidate"
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
    editpasswordValidate() {},

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
#editpassword {
  height: 50%;
  width: 100%;
  position: absolute;
  top: 0;
  left: 0;
  content: "";
  z-index: 0;
}
.active_btn {
  width: 145px;
  background-color: deepskyblue;
  color: red;
}
.btn {
  width: 145px;
}
</style>
