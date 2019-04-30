<template>
  <div id="result_page_matrice">
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
      <h3>
        <b><u>Title:</u> {{getTitle()}}</b>
      </h3>
        <h5> <i> {{getInfo()}}</i> </h5>

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

<script>
  var id,title,author,the_abstract,info;
  export default {
    /*
          data() {
              return {
                  headers: [
                      {
                          text: 'References',
                          align: 'left',
                          sortable: false,
                          value: 'name'
                      },
                      {text: 'Criteria1', value: 'Criteria1'},
                      {text: 'Criteria2', value: 'Criteria2'},
                      {text: 'Criteria3', value: 'Criteria3'},
                      {text: 'Criteria4', value: 'Criteria4'}
                  ],
                  results: [
                      {
                          name: 'Ref1',
                          Criteria1: v,
                          Criteria2: v,
                          Criteria3: x,
                          Criteria4: x,
                      },
                      {
                          name: 'Ref2',
                          Criteria1: v,
                          Criteria2: x,
                          Criteria3: v,
                          Criteria4: v,
                      },
                      {
                          name: 'Ref3',
                          Criteria1: v,
                          Criteria2: x,
                          Criteria3: x,
                          Criteria4: v,
                      },
                  ]
              }
          },*/
    methods: {
      getTitle() {
            id=this.$route.query.id;
            title=this.$route.query.title;
            author=this.$route.query.author;
            info=this.$route.query.info;
            the_abstract=this.$route.query.the_abstract;
            return title;
        },
        getInfo() {
            return this.$route.query.info;
        },

        classic() {
        this.loading = true;
        setTimeout(() => {
          this.$router.push({
            path: '/etatdelart',
              query: {id: id,title:title,author:author,abstract:the_abstract,info:info},
            //query: {...},
            //moreData: {foo: 1}
          })}, 1000);
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
          this.$router.push({
            path: '/result_page_matrice',
              query: {id: id,title:title,author:author,abstract:the_abstract,info:info},
            //query: {...},
            //moreData: {foo: 1}
          })}, 1000);
      },
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
