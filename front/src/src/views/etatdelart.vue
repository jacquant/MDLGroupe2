<template>
  <div id="etatdelart">
    <v-container grid-list-xl fluid>
      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn color @click="classic" class="active_btn">Classic</v-btn>
        <v-btn color @click="visual" class="btn">Visual</v-btn>
        <v-btn color @click="matrice" class="btn">Matrice</v-btn>
      </v-card-actions>

      <table style="margin-top:10px; width:100%; padding:10px; ">
        <tr>
          <td valign="top" width="70%">
            <div id="result" style="width:100%; margin-left:30px">
              <h2 style="vertical-align: top; color:blue;">State of art</h2>
              <h3>
                <b>Title: {{getTitle()}}</b>
              </h3>
              <br>
              <h3>
                Abstract &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href class>PDF</a>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Nb
                References: (8881) &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a
                        href
                        target="_blank"
                        class
                >
                  <img src="../assets/favoris.png" width="3%">
                </a>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href target="_blank" class>
                  <img src="../assets/partage.png">
                </a>
              </h3>

              <div id="textarea">
                <v-text-field
                        label="abstract"
                        name="abstract"
                        textarea
                        rows="10"
                        cols="25"
                        v-model="abstract"
                ></v-text-field>
              </div>
            </div>
          </td>

          <td valign="top" width="20%">
            <div style="border:1px solid black; margin-top:5px; ">
              <div style="margin-top:10px; margin-left:5px;">

                <b><u>Author(s):</u> </b> {{getAuthor()}}

                <br>
                <br>

                <b> <u>Published:</u></b>{{getPublish()}}

                <br>
                <br>
                <b>
                  <u>Rate:</u>
                </b> ....
                <br>
                <br>
                <br>
              </div>
            </div>
          </td>
        </tr>
      </table>

      <template>
        <v-tabs
                color="cyan"
                dark
                icons-and-text
        >
          <v-tabs-slider color="yellow"></v-tabs-slider>

          <v-tab href="#tab-1">
            Related Articles

          </v-tab>

          <v-tab href="#tab-2">
            Video

          </v-tab>

          <v-tab href="#tab-3">
            Comments

          </v-tab>

          <v-tab-item
                  v-for="i in 3"
                  :key="i"
                  :value="'tab-' + i"
          >
            <v-card flat>
              <v-card-text>{{ text[i-1] }}</v-card-text>
            </v-card>
          </v-tab-item>
        </v-tabs>
      </template>
    </v-container>
  </div>
</template>

<script>
  var id,title,author,the_abstract;
  export default {
    data() {
      return {
        text:["Related articles here","video here","comments here"]
      }
    },
    model: {
    },
    methods: {
      getTitle() {
        this.abstract=this.$route.query.abstract;
        id=this.$route.query.id;
        title=this.$route.query.title;
        author=this.$route.query.author;
        the_abstract=this.abstract;
        return this.$route.query.title;
      },
      getAuthor() {
        return this.$route.query.author;
      },
      getPublish() {
        return this.$route.query.id;
      },
      classic() {
        this.loading = true;
        setTimeout(() => {
          this.$router.push({
            path: '/etatdelart',
            query: {id: id,title:title,author:author,the_abstract:the_abstract},
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
            query: {id: id,title:title,author:author,the_abstract:the_abstract},
            //query: {...},
            //moreData: {foo: 1}
          })}, 1000);
      },
    }
  };
</script>
<style scoped lang="css">
  #textarea {
    margin-top: 20px;
  }
  .active_btn {
    width: 40px;
    background-color: deepskyblue;
    color: red;
  }
  .btn {
    width: 40px;
  }
</style>