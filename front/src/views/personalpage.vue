<template>
  <div id="personalpage">
    <v-container grid-list-xl fluid>
      <div id style="float:right;">
        <v-btn @click="settings">
          <img height="30px" src="../assets/settings.png" width="40px" />
        </v-btn>
      </div>

      <h2 class="titre">Personal Page</h2>
      <h3 class>
        <u>User Name:</u>Le passage de Lorem Ipsum standard, utilisé depuis 1500
      </h3>
      <table>
        <tr>
          <td valign="top" width="65%">
            <h3 style="color:green;">
              <u>Uploaded articles:</u>
            </h3>
            <div id="uploadedArticle">
              Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
              eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
              enim ad minim veniam, quis nostrud exercitation ullamco laboris
              nisi ut aliquip ex ea commodo consequat. Duis aute irure
            </div>
          </td>
          <td valign="top" width="35%">
            <div id="favoris">
              <h3 style="color:green;">
                <u>Favorites Articles</u>
              </h3>
              <div id="myfavoris"></div>
            </div>
          </td>
        </tr>
      </table>
    </v-container>
  </div>
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
    settings() {
      this.loading = true;
      setTimeout(() => {
        this.$router.push("/editpassword");
      }, 1000);
    }
  }
};
</script>
<style scoped lang="css">
#textarea {
  margin-top: 10px;
}
#favoris {
  width: 95%;
  height: 300px;
  border: 1px solid #cccccc;
  background-color: #ffffff;
  margin: auto;
  margin-top: 5px;
  padding: 5px;
}

.titre {
  color:lightslategrey;
  font-weight: bold;
}
</style>
