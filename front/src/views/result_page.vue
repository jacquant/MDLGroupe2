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
                                            item-key="title"
                                            hide-default-footer
                                            disable-pagination="true"
                                           class="datatable1"

                                    >

                                        <template slot="headers" slot-scope="props">

                                            <tr class=""
                                                v-for="header in props.headers"
                                                :key="header.text"
                                                >

                                                <th

                                                >
                                                    <div v-if="filters.hasOwnProperty(header.value)">{{header.text}}
                                                        <v-select flat hide-details small multiple clearable :items="columnValueList(header.value)" v-model="filters[header.value]">

                                                        </v-select>

                                                    </div>
                                                </th>
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

                                <div class>
                                    <b>Criteria on State of art</b>
                                    <br />
                                    <input type="checkbox" class />critere1
                                    <input type="checkbox" class />critere2
                                    <br />
                                    <input type="checkbox" class />critere3
                                    <input type="checkbox" class />critere4
                                </div>

                        </div>
                    </td>

                    <td valign="top" width="80%">
                        <h2 class="titre">
                            Research Result ({{tailleResult()}})
                        </h2>
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
                                    <tr :active="props.selected" @click="props.selected = !props.selected">
                                        <td valign="top" @click="selectTrack(props.item)">{{ props.item.title }}<br>{{props.item.info }}</td>


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
    const axios = require('axios');
    var id,
        title,
        author,
        abstract,
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
                sortBy: 'title',
                rowsPerPage:25,
            },
            selected: [],
            headers: [
                { text: 'Title', value: 'title' },
                { text: 'Author', value: 'author' },
                { text: 'Published Date', value: 'date' },
            ],
            filters: {
                title: [],
                author: [],
                date: []

            },

          items:[],

        }),

        created(){
            this.items=this.searchfound()
        } ,

        computed: {
            filteredItems() {
                return this.items.filter(d => {
                    return Object.keys(this.filters).every(f => {
                        return this.filters[f].length < 1 || this.filters[f].includes(d[f])
                    })
                })
            }
        },
        methods: {
            tailleResult(){
                if (this.items.length == 0) return alert("No item found");
                else return this.items.length;
            },
            toggleAll () {
                if (this.selected.length) this.selected = []
                else this.selected = this.items.slice()
            },
            changeSort (column) {
                if (this.pagination.sortBy === column) {
                    this.pagination.descending = !this.pagination.descending
                } else {
                    this.pagination.sortBy = column
                    this.pagination.descending = false
                }
            },
            columnValueList(val) {
                return this.items.map(d => d[val])
            },

            searchfound() {

                var inputedText = this.$route.query.data;
                var thedata;
                //var thedata2=28;
                const axios = require("axios");
                // Make a request for a user with a given ID
                axios
                    .get(
                        "http://mdl-std02.info.fundp.ac.be:8181/MdlGroupe2-test/api/QuickSearch?keyword=",
                        {
                            params:{
                                keyword:inputedText
                            }
                        }
                    )
                    .then(function(response) {
                        /*
                          this.items= response;
                          for (i = 0; i < response.length; i++) {
                              this.items[i] = response[i];
                          }
                          */
                        console.log("la réponse:" + response);
                    })
                    .catch(function(error) {
                        // handle error
                        console.log(error);
                    })
                    .then(function() {
                        // always executed
                    });
                thedata = [
                    {
                        //avatar: '../assets/iconA.png',
                        id: 1,
                        author: "J.S. Yi, B. Shneiderman",
                        info: "J.S. Yi, B. Shneiderman - published 2011 and event 1",
                        title:
                            "Lorem ipsum25662 dolor sit amet, consectetur adipiscing elit, seddo1 ",
                        abstract: "Voici le abstact 1 ",
                        videoUrl: "lien video1",
                        publisher: "publisher  1",
                        ref: "ref 1",
                        pagerankscore: "ranking 1",
                        matriceref: "matriceref 1"
                    },
                    {
                        //avatar: '../assets/iconA.png',
                        id: 2,
                        author: "Paul LIYA, LOKo Ray",
                        info: "Paul LIYA, LOKo Ray - published 2005 and event 2",
                        title:
                            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, seddo2",
                        abstract: "Voici le abstact 2",
                        videoUrl: "lien video 2",
                        publisher: "publisher 2",
                        ref: "ref 2",
                        pagerankscore: "ranking 2",
                        matriceref: "matriceref 2"
                    },
                    {
                        //avatar: '../assets/iconA.png',
                        id: 3,
                        author: "Rowlins.J",
                        info: "Rowlins.J - published 2015 and event 3",
                        title:
                            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, seddo 3",
                        abstract: "Voici le abstact 3",
                        videoUrl: "lien video 3",
                        publisher: "publisher 3",
                        ref: "ref 3",
                        pagerankscore: "ranking 3",
                        matriceref: "matriceref 3"
                    },
                    {
                        //avatar: '../assets/iconA.png',
                        id: 4,
                        author: "D.Keim",
                        info: "D.Keim- published 2015 and event 4",
                        title:
                            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, seddo 4",
                        abstract: "Voici le abstact 4",
                        videoUrl: "lien video 4",
                        publisher: "publisher 4",
                        ref: "ref 4",
                        pagerankscore: "ranking 4",
                        matriceref: "matriceref 4"
                    },
                    {
                        //avatar: '../assets/iconA.png',
                        id: 5,
                        author: "J.S. Yi, B. Shneiderman",
                        info: "J.S. Yi, B. Shneiderman - published 2018 and event 5",
                        title:
                            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, seddo 5",
                        abstract: "Voici le abstact 5",
                        videoUrl: "lien video 5",
                        publisher: "publisher 5",
                        ref: "ref 5",
                        pagerankscore: "ranking 5",
                        matriceref: "matriceref 5"
                    },
                    {
                        //avatar: '../assets/iconA.png',
                        id: 6,
                        author: "LAFONT Jane, Kucher K., Kerren A.",
                        info:
                            "LAFONT Jane, Kucher K., Kerren A. - published 2015 and event 6",
                        title:
                            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, seddo 6",
                        abstract: "Voici le abstact 6",
                        videoUrl: "lien video 6",
                        publisher: "publisher 6",
                        ref: "ref 6",
                        pagerankscore: "ranking 6",
                        matriceref: "matriceref 6"
                    }

                ];

                /*
                var the_author = "";
                var taille = this.items.length;
                for (i = 0; i < taille; i++) {
                    this.itemsTitle[i] = this.items[i].title; //get all the titles
                    //this.itemsAuthor[i] = this.items[i].author;
                    if (i == taille - 1) the_author = the_author + this.items[i].author;
                    else the_author = the_author + this.items[i].author + ",";
                }
                this.itemsAuthor = the_author.split(",");
                */
                return thedata;
            },
            classic() {
                this.loading = true;
                setTimeout(() => {
                    this.$router.push({
                        path: "/etatdelart",
                        query: {
                            id: id,
                            title: title,
                            author: author,
                            abstract: abstract,
                            info: info,
                            videoUrl: videoUrl,
                            ref: ref,
                            publisher: publisher,
                            pagerankscore: pagerankscore,
                            matriceref: matriceref
                        }
                        //query: {...},
                        //moreData: {foo: 1}
                    });
                }, 1);
            },
            visual() {
                this.loading = true;
                setTimeout(() => {
                    this.$router.push("/visual");
                }, 1);
            },
            matrice() {
                this.loading = true;
                setTimeout(() => {
                    this.$router.push({
                        path: "/result_page_matrice",
                        query: {
                            id: id,
                            title: title,
                            author: author,
                            abstract: abstract,
                            info: info,
                            videoUrl: videoUrl,
                            ref: ref,
                            publisher: publisher,
                            pagerankscore: pagerankscore,
                            matriceref: matriceref
                        }
                        //query: {...},
                        //moreData: {foo: 1}
                    });
                }, 1);
            },
            selectTrack(item) {
                id = item.id;
                title = item.title;
                author = item.author;
                abstract = item.abstract;
                info = item.info;
                publisher = item.publisher;
                ref = item.ref;
                pagerankscore = item.pagerankscore;
                matriceref = item.matriceref;
                setTimeout(() => {
                    this.$router.push({
                        path: "/etatdelart",
                        query: {
                            id: id,
                            title: title,
                            author: author,
                            abstract: abstract,
                            info: info,
                            videoUrl: videoUrl,
                            ref: ref,
                            publisher: publisher,
                            pagerankscore: pagerankscore,
                            matriceref: matriceref
                        }
                        //query: {...},
                        //moreData: {foo: 1}
                    });
                }, 1);
                /*
                axios.get("http://mdl-std02.info.fundp.ac.be:8181/MdlGroupe2-test/api/articles/"+id)
                .then(function (response) {
                  console.log(response);
                  setTimeout(() => {
                    this.$router.push({
                      path: "/etatdelart",
                      query:{
                        data: response
                      }
                    })
                  })
                })
                .catch(function (error) {
                  // handle error
                  console.log(error);
                })*/
            },


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