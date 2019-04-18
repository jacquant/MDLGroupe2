<template>
  <div id="etatdelart">
    <v-container grid-list-xl fluid>

      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn color="" @click="classic" class="active_btn">Classic</v-btn>
        <v-btn color="" @click="visual" class="btn">Visual</v-btn>
        <v-btn color="" @click="matrice" class="btn">Matrice</v-btn>
      </v-card-actions>

      <table style="margin-top:10px; width:100%; padding:10px; ">
        <tr>

            <td valign="top" width="70%">
                <div id="result" style="width:100%; margin-left:30px">
                    <h2 style="vertical-align: top; color:blue;">State of art</h2>
                    <h3>
                        <b>Title: Le passage de Lorem Ipsum standard, utilisé depuis 1500 </b>
                    </h3>
                    <br />
                    <h3>
                        Abstract &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="" class="">PDF</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Nb
                        References: (8881) &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                        <a href="" target="_blank" class=""
                        ><img src="../assets/favoris.png" width="3%"/></a
                        >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                        <a href="" target="_blank" class=""
                        ><img src="../assets/partage.png"
                        /></a>
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
                <b><u> Author(s):</u></b> ....... <br /><br />
                <b><u> Published:</u></b> ........ <br /><br />
                <b><u> Rate:</u></b> .... <br /><br />
                <br />
              </div>
            </div>
          </td>
        </tr>
      </table>

      <template>
        <div>
          <v-tabs v-model="active" color="cyan" dark slider-color="yellow">
            <v-tab ripple>
              Related articles
            </v-tab>

            <v-tab ripple>
              Video
            </v-tab>
            <v-tab ripple>
              Comments
            </v-tab>

            <v-tab-item>
              <v-card flat>
                <v-card-text>{{ relatedArticle }}</v-card-text>
              </v-card>
            </v-tab-item>

            <v-tab-item>
              <v-card flat>
                <v-card-text>{{ video }}</v-card-text>
              </v-card>
            </v-tab-item>

            <v-tab-item>
              <v-card flat>
                <v-card-text>{{ comments }}</v-card-text>
              </v-card>
            </v-tab-item>
          </v-tabs>

          <div class="text-xs-center mt-3">
            <v-btn @click="next">next tab</v-btn>
          </div>
        </div>
      </template>

    </v-container>
  </div>
</template>

<script>
export default {
  data() {
    return {
      active: null,
      relatedArticle: " Related articles here",
      comments: " Comments here",
      video: " Video  here"
    };
  },

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
    },
    next() {
      const active = parseInt(this.active);
      this.active = active < 2 ? active + 1 : 0;
    }
  }
};
</script>
<style scoped lang="css">
#textarea {
    margin-top: 20px;
}
.active_btn{
    width:40px;
    background-color: deepskyblue;
    color: red;
}
.btn{
    width:40px;
}
</style>
