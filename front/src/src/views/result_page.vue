<template>
  <div id="result_page_matrice">
    <v-container grid-list-xl fluid>
      <!--v-layout row wrap>
                <div style="float:left; vertical-align: top;">
                    <img src="/static/logo.jpg" alt="Reseach" width="120" height="120">
                </div>
            </v-layout-->

      <!--v-card-actions>

                <v-spacer></v-spacer>
                <v-btn  color="" @click="classic"  class="btn">Classic</v-btn>
                <v-btn  color="" @click="visual"  class="btn">Visual</v-btn>
                <v-btn  color="" @click="matrice"  class="btn">Matrice</v-btn>
            </v-card-actions-->

      <table style=" position: absolute; width:100%; " cellspacing="10">
        <tr>
          <td width="15%" valign="top">
            <div class="menu" valign="top">
              <button class="accordion">Filters Menu <---</button>
              <div class="panel">
                <v-card-actions>
                  Author(s):<br />
                  <v-text-field
                    label="Author(s) here"
                    name="author"
                  ></v-text-field>
                </v-card-actions>
                <v-card-actions>
                  Title:<br />
                  <v-text-field label="Title here" name="title"></v-text-field>
                </v-card-actions>
                <v-card-actions>
                  Others details:<br />
                  <v-text-field
                    label="details here"
                    name="detail"
                  ></v-text-field>
                </v-card-actions>

                Pubished Year:<br /><input
                  type="text"
                  style="border-color:blue;"
                  placeholder="year 1"
                  size="3"
                  maxlength="4"
                />
                -
                <input
                  type="text"
                  style="border-color:blue;"
                  size="3"
                  maxlength="4"
                  placeholder="year 2"
                /><br />

                <br />
                <div class="">
                  <b>Criteria on State of art</b> <br />
                  <input type="checkbox" class="" />critere1
                  <input type="checkbox" class="" />critere2 <br /><input
                    type="checkbox"
                    class=""
                  />critere3 <input type="checkbox" class="" />critere4
                </div>
              </div>
            </div>
          </td>

          <td valign="top" width="80%">
            <div id="listResult" valign="top">
              <h2 class="flex my-4 primary--text">Research Result (88888)</h2>
              <br />

              <a href="#/etatdelart">
                <img align="center" src="../assets/iconA.png" width="20px" />
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
                do</a
              ><br /><br />
              <a href="#/etatdelart">
                <img align="center" src="../assets/iconA.png" width="20px" />
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
                do</a
              ><br /><br />
              <a href="#/etatdelart">
                <img align="center" src="../assets/iconA.png" width="20px" />
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
                do</a
              ><br /><br />
              <a href="#/etatdelart">
                <img align="center" src="../assets/iconA.png" width="20px" />
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
                do</a
              ><br /><br />
              <a href="#/etatdelart">
                <img align="center" src="../assets/iconA.png" width="20px" />
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
                do</a
              ><br /><br />
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

/****** script pour la gestion du panel d'expansion*****/
var acc = document.getElementsByClassName("accordion");
var i;

for (i = 0; i < acc.length; i++) {
  acc[i].addEventListener("click", function() {
    this.classList.toggle("active");

    var panel = this.nextElementSibling;
    panel.style.overflow = "hidden";
    if (panel.style.maxHeight) {
      panel.style.maxHeight = null;
    } else {
      panel.style.maxHeight = panel.scrollHeight + "px";
    }
  });
}
</script>
<style scoped lang="css">
.active_btn{
    width:40px;
    background-color: deepskyblue;
    color: red;
}
.btn{
    width:40px;
}

.accordion {
    background-color: #eee;
    color: #444;
    cursor: pointer;
    padding: 5px;
    width: 100%;
    border: none;
    text-align: left;
    outline: none;
    font-size: 17px;
    transition: 0.4s;
    font-weight:bold;
}

.active, .accordion:hover {
    background-color: #ccc;
}

.panel {
    padding: 0 2px;
    background-color: white;
    max-height: 0;
    overflow: visible;
    transition: max-height 0.2s ease-out;
    margin-top:5px;
}


.previous {
    float: left;
    margin-left: 5%;
    margin-top: 0.6%;
    background-color: #f1f1f1;
    color: black;
}

.round {
    border-radius: 100%
}
</style>
