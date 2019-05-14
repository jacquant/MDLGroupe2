<template>
  <div id="result_page">
    <v-container grid-list-xl fluid>
      <!--v-layout row wrap>
                      <div style="float:left; vertical-align: top;">
                          <img src="/static/logo.jpg" alt="Research" width="120" height="120">
                      </div>
            </v-layout-->

      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn @click="" class="titre">Visual</v-btn>
      </v-card-actions>

      <table style=" position: absolute; width:100%; " cellspacing="10">
        <tr>
          <td width="15%" valign="top">
            <div class="menu" valign="top">
              <button class="accordion">Filters Menu</button>

              <v-card-actions style="vertical-align: top;">
                <v-data-table
                  v-model="selected"
                  :headers="headers"
                  name="datatable1"
                  :items="filteredItems"
                  hide-actions
                  item-key="title"
                  class="datatable1"
                >
                  <template slot="headers" slot-scope="props">
                    <tr v-for="header in props.headers" :key="header.text">
                      <td>
                        <div v-if="filters.hasOwnProperty(header.value)">
                          {{ header.text }}
                          <v-select
                            multiple
                            clearable
                            :items="columnValueList(header.value)"
                            v-model="filters[header.value]"
                          >
                          </v-select>
                        </div>
                      </td>
                    </tr>
                  </template>
                </v-data-table>
              </v-card-actions>

              <!--v-card-actions>
                                    Author(s):
                                    <v-select
                                            name="author"
                                            v-model="authors"
                                            :items="author"
                                            label="Select Author(s)"
                                            multiple
                                            chips
                                            width="200px"
                                            @input="filteredAuthor"
                                    ></v-select>
                                </v-card-actions>
                                <v-card-actions>
                                    Title:
                                    <v-select
                                            name="title"
                                            v-model="title"
                                            :items="title"
                                            label="Select Titles(s)"
                                            multiple
                                            width="300px"
                                            @change="filteredTitle"
                                    ></v-select>
                                </v-card-actions>
                                <v-card-actions>
                                    Others details:
                                    <v-text-field
                                            label="details here"
                                            name="detail"
                                            v-model="model.detail"
                                    ></v-text-field>
                                </v-card-actions>

                                <v-card-actions>
                                    Pubished Year:
                                    <v-text-field
                                            label="year1"
                                            name="year1"
                                            v-model="model.year1"
                                    ></v-text-field>
                                    to

                                    <v-text-field
                                            label="year2"
                                            name="year2"
                                            v-model="model.year2"
                                    ></v-text-field>
                                </v-card-actions-->

              <!--<div class>
                <b>Criteria on State of art</b>
                <br />
                <input type="checkbox" class />critere1
                <input type="checkbox" class />critere2
                <br />
                <input type="checkbox" class />critere3
                <input type="checkbox" class />critere4
              </div>-->
            </div>
          </td>

          <td valign="top" width="80%">
            <h2 class="titre">Research Result ({{ tailleResult() }})</h2>
            <br />
            <div id="listResult" valign="top">
              <div id="app">
                <v-app id="inspire">
                  <v-data-table
                    v-model="selected"
                    :items="filteredItems"
                    name="datatable2"
                    :pagination.sync="pagination"
                    item-key="title"
                    class="elevation-1"
                  >
                    <template slot="items" slot-scope="props">
                      <tr
                        :active="props.selected"
                        @click="props.selected = !props.selected"
                      >
                        <td valign="top" @click="selectTrack(props.item)">
                          {{ props.item.title }}<br />{{ props.item.info }}
                        </td>
                      </tr>
                    </template>
                  </v-data-table>
                </v-app>
              </div>

              <!--v-list-- one-line>
                                <template v-for="(item, index) in items">
                                    <v-subheader v-if="item.header" :key="item.header">
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
                                            @click="selectTrack(item)"
                                    >


                                        <v-list-tile-content>
                                            <v-list-tile-title
                                                    v-html="item.title"
                                            ></v-list-tile-title>
                                            <v-list-tile-sub-title
                                                    v-html="item.info"
                                            ></v-list-tile-sub-title>
                                        </v-list-tile-content>
                                    </v-list-tile>
                                </template>
                            </v-list-->
            </div>
          </td>
        </tr>
      </table>
    </v-container>
  </div>
</template>

<script>
const axios = require("axios");
var id,
  title,
  author,
  abstract,
  keywords,
  info,
  videoUrl,
  publisher,
  ref,
  pagerankscore,
  matriceref;

export default {
  data: () => ({
    loading: false,
    page: 1,
    itemsAuthor: [],
    itemsTitle: [],

    model: {
      //items:this.$route.params.data,
    },

    pagination: {
      sortBy: "",
      rowsPerPage: 25
    },
    selected: [],
    headers: [
      { text: "Title", value: "title" },
      { text: "Author", value: "author" },
      { text: "Published Year", value: "year" }
    ],
    filters: {
      title: [],
      author: [],
      year: []
    },

    items: []
  }),

  created() {
    this.items = this.searchfound();
  },

  computed: {
    filteredItems() {
      return this.items.filter(d => {
        return Object.keys(this.filters).every(f => {
          return this.filters[f].length < 1 || this.filters[f].includes(d[f]);
        });
      });
    }
  },
  methods: {
    tailleResult() {
      //if (this.items.length == 0) return alert("No item found");
      return this.items.length;
    },
    toggleAll() {
      if (this.selected.length) this.selected = [];
      else this.selected = this.items.slice();
    },
    changeSort(column) {
      if (this.pagination.sortBy === column) {
        this.pagination.descending = !this.pagination.descending;
      } else {
        this.pagination.sortBy = column;
        this.pagination.descending = false;
      }
    },
    columnValueList(val) {
      return this.items.map(d => d[val]);
    },

    searchfound() {
      var type = this.$route.query.type;
      var parametres = this.$route.query.data;
      var thedata;
      var theRef=this;

console.log("parametre "+parametres);

      if (type == "quickSearch") {
        var request = new XMLHttpRequest();
        request.open(
          "GET",
          "http://mdl-std02.info.fundp.ac.be:8181/MdlGroupe2-test/api/literature_reviews",
          false
        );
        request.onload = function() {
          var data = JSON.parse(this.response);
         
          if (request.status >= 200 && request.status < 400) {
             
             var i,j,cpt=0;
             var authors=[];
             var lesAuthor="";
             var allAuthor=[];

             for(i=0;i<data.length;i++){
               if (i==15) break;
               authors=data[i].author;
               console.log("taille "+this.response);
               
                  for(j=0;j<authors.length;j++){                 
                   lesAuthor+=authors[j].firstName+" "+authors[j].surname+", ";
                    allAuthor[cpt]=authors[j].firstName+" "+authors[j].surname;
                    cpt++;
                    
                }

                theRef.items.push({id: data[i].id,
                author: lesAuthor,
                info: lesAuthor + "--" + data[i].publisher,
                year: data[i].year,
                title: data[i].title,
                abstract: data[i].abstractArticle,
                keywords: data[i].tag,
                videoUrl: data[i].videoUrl,
                publisher: data[i].publisher,
                ref: data[i].ref,
                pagerankscore: data[i].pagerankscore,
                matriceref: "matriceref 1"});               
            }

          }
        };
        request.send();
      }
       else if(type=="advancedSearch") {

        var request = new XMLHttpRequest();
        request.open(
          "GET",
          "http://mdl-std02.info.fundp.ac.be:8181/MdlGroupe2-test/api/literature_reviews",
          false
        );
        request.onload = function() {
          var data = JSON.parse(this.response);
         
          if (request.status >= 200 && request.status < 400) {
             
             var i,j,cpt=0;
             var authors=[];
             var lesAuthor="";
             var allAuthor=[];

             for(i=0;i<data.length;i++){
               if (i==15) break;
               authors=data[i].author;
               console.log("taille "+this.response);
               
                  for(j=0;j<authors.length;j++){                 
                   lesAuthor+=authors[j].firstName+" "+authors[j].surname+", ";
                    allAuthor[cpt]=authors[j].firstName+" "+authors[j].surname;
                    cpt++;
                    
                }

                theRef.items.push({id: data[i].id,
                author: lesAuthor,
                info: lesAuthor + "--" + data[i].publisher,
                year: data[i].year,
                title: data[i].title,
                abstract: data[i].abstractArticle,
                keywords: data[i].tag,
                videoUrl: data[i].videoUrl,
                publisher: data[i].publisher,
                ref: data[i].ref,
                pagerankscore: data[i].pagerankscore,
                matriceref: "matriceref 1"});               
            }

          }
        };
        request.send();
      }      
                
      return theRef.items;
    },
    selectTrack(item) {
      id = item.id;

      setTimeout(() => {
        this.$router.push({
          path: "/etatdelart",
          query: {
            id: id
          }
        });
      }, 1);

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
.datatable1 {
    background-color: gainsboro;
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
.titre {
    color:lightslategrey;
    font-weight: bold;
}
</style>
