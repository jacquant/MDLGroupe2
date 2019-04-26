<template>
  <div id="result_page">
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
              <button class="accordion">Filters Menu</button>
              <div class="panel">
                <v-card-actions style="vertical-align: top;">
                  Author(s):
                  <!--v-text-field
                    label="Author(s) here"
                    name="author"
                    v-model="model.author"
                  ></v-text-field-->
                  <v-select
                          name="author"
                          v-model="authors"
                          :items="itemsAuthor"
                          attach
                          chips
                          label="Select Author(s)"
                          multiple

                  ></v-select>
                </v-card-actions>
                <v-card-actions>
                  Title:
                  <v-text-field label="Title here" name="title"   v-model="title" ></v-text-field>
                </v-card-actions>
                <v-card-actions>
                  Others details:
                  <v-text-field label="details here" name="detail" v-model="model.detail"></v-text-field>
                </v-card-actions>

                <v-card-actions>
                  Pubished Year:
                  <v-text-field label name="year1" v-model="model.year1"></v-text-field>

                  <v-text-field label name="year2" v-model="model.year2"></v-text-field>
                </v-card-actions>

                <div class>
                  <b>Criteria on State of art</b>
                  <br>
                  <input type="checkbox" class>critere1
                  <input type="checkbox" class>critere2
                  <br>
                  <input type="checkbox" class>critere3
                  <input type="checkbox" class>critere4
                </div>
              </div>
            </div>
          </td>

          <td valign="top" width="80%">
            <h2 class="flex my-4 primary--text">Research Result ({{searchfound()}})</h2>
            <br />
            <div id="listResult" valign="top">
              <v-list one-line  >
                <template  v-for="(item, index) in items">
                  <v-subheader
                          v-if="item.header"
                          :key="item.header"
                  >
                    {{ item.header }}
                  </v-subheader>

                  <v-divider
                          v-else-if="item.divider"
                          :key="index"
                          :inset="item.inset"
                  ></v-divider>

                  <v-list-tile
                          v-else
                          :key="item.id"
                          avatar
                          @click='selectTrack(item)'

                  >
                    <!--v-list-tile-avatar>
                      <img :src="item.avatar">
                    </v-list-tile-avatar-->

                    <v-list-tile-content>
                      <v-list-tile-title v-html="item.title"></v-list-tile-title>
                    </v-list-tile-content>
                  </v-list-tile>
                </template>
              </v-list>

              <template>
                <div class="text-xs-center">
                  <v-pagination
                          v-model="page"
                          :length="4"
                  ></v-pagination>
                </div>
              </template>
                   <!--a href="#/etatdelart">
                <img align="center" src="../assets/iconA.png" width="20px" />
              <h2 class="flex my-4 primary--text">Research Result (88888)</h2>
              <br>

              <a href="#/etatdelart">
                <img align="center" src="../assets/iconA.png" width="20px">
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
                do
              </a>
              <br>
              <br>
              <a href="#/etatdelart">
                <img align="center" src="../assets/iconA.png" width="20px">
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
                do
              </a>
              <br>
              <br>
              <a href="#/etatdelart">
                <img align="center" src="../assets/iconA.png" width="20px">
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
                do
              </a>
              <br>
              <br>
              <a href="#/etatdelart">
                <img align="center" src="../assets/iconA.png" width="20px">
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
                do
              </a>
              <br>
              <br>
              <a href="#/etatdelart">
                <img align="center" src="../assets/iconA.png" width="20px" />
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, seddo</a><br /><br /-->
            </div>
          </td>
        </tr>
      </table>
    </v-container>
  </div>
</template>

<script>
    var id,title,author,abstract;

export default {
  data: () => ({
    loading: false,
    page:1,


    itemsAuthor: ['author1', 'author2', 'author3', 'author4','author5'],
      items: [],

      model: {
         //items:this.$route.params.data,

    }
  }),

  methods: {

    searchfound() {
       var inputedText=this.$route.query.data;
       var thedata;
        //var thedata2=28;
        const axios = require('axios');

// Make a request for a user with a given ID
        axios.get('http://mdl-std02.info.fundp.ac.be:8181/MdlGroupe2-test/api/QuickSearch?keyword='+inputedText)
            .then(function (response) {
                // handle success
                //thedata=response;
                alert("la réponse:"+response);
            })
            .catch(function (error) {
                // handle error
                console.log(error);
            })
            .then(function () {
                // always executed
            });

        thedata= [

            {
                //avatar: '../assets/iconA.png',
                id:1,
                author:"Emmanuel AGOSSOU",
                title: 'Lorem ipsum25662 dolor sit amet, consectetur adipiscing elit, seddo ',
                abstract: 'Voici le abstact 1 ',
            },

            {
                //avatar: '../assets/iconA.png',
                id:2,
                author:"Paul LIYA, LOKo Ray",
                title: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, seddo',
                abstract: 'Voici le abstact 2',
            },

            {
                //avatar: '../assets/iconA.png',
                id:3,
                author:"Rowlins,J",
                title: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, seddo',
                abstract: 'Voici le abstact 3',
            },
            {
                //avatar: '../assets/iconA.png',
                id:4,
                author:"Paul LIYA",
                title: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, seddo',
                abstract: 'Voici le abstact 4',
            },
            {
                //avatar: '../assets/iconA.png',
                id:5,
                author:"Emmanuel AGOSSOU",
                title: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, seddo',
                abstract: 'Voici le abstact 5',
            },
            {
                //avatar: '../assets/iconA.png',
                id:6,
                author:"LAFONT Jane",
                title: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, seddo',
                abstract: 'Voici le abstact 6',
            }
        ];
  this.items=thedata;
       return this.items.length;
    },
    classic() {

      this.loading = true;
        setTimeout(() => {
            this.$router.push({
                path: '/etatdelart',
                query: {id: id,title:title,author:author,abstract:abstract},
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
                query: {id: id,title:title,author:author,abstract:abstract},
                //query: {...},
                //moreData: {foo: 1}
            })}, 1000);
    },
    selectTrack(item){
      id=item.id;
       title=item.title;
      author=item.author;
        abstract=item.abstract;

        setTimeout(() => {
            this.$router.push({
                path: '/etatdelart',
                query: {id: id,title:title,author:author,abstract:abstract},
                //query: {...},
                //moreData: {foo: 1}
            })}, 1000);


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
.active_btn {
  width: 40px;
  background-color: deepskyblue;
  color: red;
}
.btn {
  width: 40px;
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
  font-weight: bold;
}

.active,
.accordion:hover {
  background-color: #ccc;
}

.panel {
  padding: 0 2px;
  background-color: white;
  max-height: 0;
  overflow: visible;
  transition: max-height 0.2s ease-out;
}

.previous {
  float: left;
  margin-left: 5%;
  margin-top: 0.6%;
  background-color: #f1f1f1;
  color: black;
}

.round {
  border-radius: 100%;
}
</style>
