<template>
    <div id="advancedSearch" width="100%">
        <v-container>
            <v-layout column>
                <v-layout row>
                    <v-tooltip bottom>
                        <template v-slot:activator="{ on }">
                            <v-btn fab small class="titre" @click="removeh" v-on="on">
                                <v-icon dark>remove</v-icon>
                            </v-btn>
                        </template>
                        <span>remove a line</span>
                    </v-tooltip>
                    <v-tooltip bottom>
                        <template v-slot:activator="{ on }">
                            <v-btn fab small class="titre" @click="addh" v-on="on">
                                <v-icon dark>add</v-icon>
                            </v-btn>
                        </template>
                        <span>add a line</span>
                    </v-tooltip>

                </v-layout>
                <v-card-actions>
                    in
                    <v-select
                            outline
                            label="criteria"
                            :items="items2"
                            v-model="payload0.criterion"
                    ></v-select>
                    &nbsp; ,&nbsp;search &nbsp;

                    <span v-for="field in payload0.searchLine">
               <v-layout row>
                <div style="padding-left:10px;padding-right:10px">
                  <v-select
                          outline
                          label="operator"
                          :items="items"
                          v-model="field.op"
                          v-if="field.op != 'empty'"
                  ></v-select>
                </div>
                <div style="padding-left:10px;padding-right:10px">
                  <v-text-field
                          label=""
                          v-model="field.field"
                  ></v-text-field>
                </div>
              </v-layout>
            </span>

                    <v-btn fab small class="titre" @click="removev(payload0)">
                        <v-icon dark>remove</v-icon>
                    </v-btn>
                    <v-btn fab small class="titre" @click="addv(payload0)">
                        <v-icon dark>add</v-icon>
                    </v-btn>
                </v-card-actions>

                <span v-for="item in payload">
            <v-layout row>
              <v-card-actions>
                <v-select
                        outline
                        label="operator"
                        :items="items"
                        v-model="item.criterion"
                ></v-select>
                &nbsp; in &nbsp;&nbsp;&nbsp;
                <v-select
                        outline
                        label="criteria"
                        :items="items2"
                        v-model="payload0.criterion"
                ></v-select>
                &nbsp; ,&nbsp;search &nbsp;

                <span v-for="field in item.searchLine">
                  <v-layout row>
                     <div style="padding-left:10px;padding-right:10px">
                      <v-select
                              outline
                              label="operator"
                              :items="items"
                              v-model="field.op"
                              v-if="field.op != 'empty'"
                      ></v-select>
                      </div>
                      <div style="padding-left:10px;padding-right:10px">
                        <v-text-field label="" v-model="field.field"></v-text-field>
                      </div>
                   </v-layout>
                </span>

                <v-btn fab small class="titre" @click="removev(item)">
                  <v-icon dark>remove</v-icon>
                </v-btn>
                <v-btn fab small class="titre" @click="addv(item)">
                  <v-icon dark>add</v-icon>
                </v-btn>
              </v-card-actions>
            </v-layout>
          </span>

                <span v-for="item2 in addedv">
            <span>
              <v-card-actions>
                <v-select
                        outline
                        label="operator"
                        :items="items"
                        v-model="item2.addedv.op"
                ></v-select>
                <v-text-field
                        label=""
                        v-model="item2.addedv.field"
                ></v-text-field>
              </v-card-actions>
            </span>
          </span>

            </v-layout>
            <v-btn class="titre" @click="Search">search</v-btn>
        </v-container>
    </div>
</template>

<script>
    import API from "@/api";
    import Material from "vuetify/es5/util/colors";
    import axios from "axios";
    import { setTimeout } from 'timers';
    export default {
        data: () => ({
            color: Material,
            selectedTab: "tab-1",
            test: 1,
            items: ["AND", "OR", "NOT"],
            items2: ["Author", "Title", "Article"],
            payload0: {
                searchLine: [{ op: "empty", field: "" }, { op: "AND", field: "" }],
                criterion: ""
            },
            addedv: {},
            payload: []
        }),
        computed: {
            activity() {
                return API.getActivity();
            },
            posts() {
                return API.getPost(3);
            },
            siteTrafficData() {
                return API.getMonthVisit;
            },
            locationData() {
                return API.getLocation;
            }
        },
        methods: {
            validateResearch: function(e) {},
            addh: function() {
                var added = {};
                added["searchLine"] = [
                    { op: "empty", field: "" },
                    { op: "AND", field: "" }
                ];
                added["criterion"] = "AND";
                this.payload.push(added);
            },
            removeh: function() {
                if (this.payload.length > 0) {
                    this.payload.splice(-1, 1);
                }
            },
            addv: function(item) {
                var field = {
                    op: "AND",
                    field: ""
                };
                item.searchLine.push(field);
                console.log(item.searchLine.length);
            },
            removev: function(item) {
                if (item.searchLine.length > 1) {
                    item.searchLine.splice(-1, 1);
                }
            },
            Search() {
                this.loading = true;
                var query = this.payload.slice();
                query = query.unshift(this.payload0);
                axios.get(
                    "http://mdl-std02.info.fundp.ac.be:8181/MdlGroupe2-test/api/AdvancedSearch",
                    {
                        params: {
                            params: query
                        }
                    })
                    .then(function(response){
                        console.log(response);
                        setTimeout(() => {
                            this.$router.push({
                                path:"/result_page",
                                query:{
                                    data: response
                                }
                            })
                        })
                    })
                    .catch(function(error){
                        console.log(error)
                    })
            }
        }
    };
</script>

<style scoped lang="css">
    .titre {
        color:lightslategrey;
        font-weight: bold;
    }
</style>