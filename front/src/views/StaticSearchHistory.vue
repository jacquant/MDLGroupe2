<template>
  <div id="StaticSearchHistory">
    <v-container grid-list-xl fluid>
      <h2>Research History</h2> <br>
      <h3>
        <ul>
          <a @click="etatdelart">
            <li>"Lifestyle of Triceratops in South America" - J.K. Rowling</li>
          </a>
          <a @click="etatdelart">
            <li>
              "How were treated T-Rex's in the Jurassic Park movie realisation"
              - Steven Spielberg
            </li>
          </a>
          <li>...</li>
        </ul>
      </h3>
    </v-container>
  </div>
</template>

<script>
export default {
  data: () => ({
    loading: false,
    model: {}
  }),

  methods: {
    etatdelart() {
      this.loading = true;
      setTimeout(() => {
        this.$router.push("../etatdelart");
      }, 1000);
    },

    getEtatDeLart() {
      var request = new XMLHttpRequest();

      // Modify the second argument (=link) to stick to the data we want to get

      request.open("GET", "", true);
      request.onload = function() {
        // Begin accessing JSON data here
        var data = JSON.parse(this.response);

        if (request.status >= 200 && request.status < 400) {
          // / ! \ Modifier en fct du back-end !!
          data.forEach(movie => {
            console.log(movie.title);
          });
        } else {
          console.log("error");
        }
      };

      request.send();
    }
  }
};
</script>
<style scoped lang="css"></style>
