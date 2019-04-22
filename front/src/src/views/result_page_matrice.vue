<template>
  <div id="result_page">
    <v-container grid-list-xl fluid>
      <!--v-layout row wrap>
                <div style="float:left;">
                    <img src="/static/logo.jpg" alt="Research" width="120" height="120">
                </div>
      </v-layout-->

      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn color @click="classic" class="btn">Classic</v-btn>
        <v-btn color @click="visual" class="btn">Visual</v-btn>
        <v-btn color @click="matrice" class="active_btn">Matrice</v-btn>
      </v-card-actions>
      <h2 class="flex my-4 primary--text">Result page - Matrice</h2>
      <h3 class>
        <u>Title:</u> Lorem ipsum dolor sit amet, consectetur adipiscing elit
      </h3>

      <div id="table_matrice">
        <br>
        <table cellpadding="5px" border="1" style="font-size:24px;">
          <tr style="background-color:lightgrey;">
            <th>References</th>
            <th>Criteria 1</th>
            <th>Criteria 2</th>
            <th>Criteria 3</th>
          </tr>
          <tr>
            <td>ref 1</td>
            <td>v</td>
            <td>v</td>
            <td>x</td>
          </tr>
          <tr>
            <td>ref 2</td>
            <td>v</td>
            <td>v</td>
            <td>v</td>
          </tr>
          <tr>
            <td>ref 3</td>
            <td>v</td>
            <td>v</td>
            <td>x</td>
          </tr>
        </table>

        <!--template>
                    <v-data-table
                            :headers="headers"
                            :items="results"
                            :items-per-page="5"
                            class="elevation-1"
                    ></v-data-table>
        </template-->
      </div>
    </v-container>
  </div>
</template>

<script type="text/x-template" id="grid-template">
<table>
    <thead>
      <tr>
        <th v-for="key in columns"
          onclick="sortBy(key)"
          class="{ active: sortKey == key }">
          {{ key, capitalize }}
          <span class="arrow" class="sortOrders[key] > 0 ? 'asc' : 'dsc'">
          </span>
        </th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="entry in filteredHeroes">
        <td v-for="key in columns">
          {{entry[key]}}
        </td>
      </tr>
    </tbody>
  </table>

  methods: {
    classic() {
      this.loading = true;
      setTimeout(() => {
        this.$router.push("/etatdelart");
      }, 1000);
    },

    visual() {
      this.loading = true;
      setTimeout(() => {
        this.$router.push("/visual");
      }, 1000);
    },

    matrice() {
      this.loading = true;
      setTimeout(() => {
        this.$router.push("/result_page_matrice");
      }, 1000);
    }
  }
};
</script>
<style scoped lang="css">
.active_btn {
  width: 40px;
  background-color: deepskyblue;
  color: red;
}
.btn {
  width: 40px;
}
</style>
