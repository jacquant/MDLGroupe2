<template>
  <div id="advancedSearch" width="100%">
    <v-container>
      <v-layout row>
        <v-btn fab small class="titre" @click="removeh">
          <v-icon dark>remove</v-icon>
        </v-btn>
        <v-btn fab small class="titre" @click="addh">
          <v-icon dark>add</v-icon>
        </v-btn>

        <v-flex xs12 md19>
          <v-card-actions>
            in &nbsp;
            <v-select
                    outline
                    label="operator"
                    :items="items2"
                    v-model="payload0.searchLine.in"
            ></v-select> &nbsp;
            ,&nbsp;search &nbsp;
            <v-text-field
              label=""
              v-model="payload0.searchLine.field1"
            ></v-text-field>
            <v-select
              outline
              label="operator"
              :items="items"
              v-model="payload0.searchLine.op"
            ></v-select>
            <v-text-field
              label=""
              v-model="payload0.searchLine.field2"
            ></v-text-field>
            <v-select
                    outline
                    label="operator"
                    :items="items"
                    v-model="payload0.searchLine.op"
            ></v-select>
            <v-text-field
                    label=""
                    v-model="payload0.searchLine.field2"
            ></v-text-field>
            <v-select
                    outline
                    label="operator"
                    :items="items"
                    v-model="payload0.searchLine.op"
            ></v-select>
            <v-text-field
                    label=""
                    v-model="payload0.searchLine.field2"
            ></v-text-field>

          </v-card-actions>
          <span v-for="item in payload">
            <span>
              <v-card-actions>
                <v-select
                  outline
                  label="operator"
                  :items="items"
                  v-model="item.criterion"
                ></v-select> &nbsp;
                in &nbsp;
                <v-select
                        outline
                        label="operator"
                        :items="items2"
                        v-model="item.searchLine.in"
                ></v-select> &nbsp;
                 ,&nbsp;search &nbsp;
                <v-text-field
                  label=""
                  v-model="item.searchLine.field1"
                ></v-text-field>
                <v-select
                  outline
                  label="operator"
                  :items="items"
                  v-model="item.searchLine.op"
                ></v-select>
                <v-text-field
                  label=""
                  v-model="item.searchLine.field2"
                ></v-text-field>
                <v-select
                        outline
                        label="operator"
                        :items="items"
                        v-model="item.searchLine.op"
                ></v-select>
                <v-text-field
                        label=""
                        v-model="item.searchLine.field2"
                ></v-text-field>
                <v-select
                        outline
                        label="operator"
                        :items="items"
                        v-model="item.searchLine.op"
                ></v-select>
                <v-text-field
                        label=""
                        v-model="item.searchLine.field2"
                ></v-text-field>

              </v-card-actions>
            </span>
          </span>
        </v-flex>
        <v-btn fab small class="titre" @click="removev">
          <v-icon dark>remove</v-icon>
        </v-btn>
        <v-btn fab small class="titre" @click="addv">
          <v-icon dark>add</v-icon>
        </v-btn>
      </v-layout>
      <v-btn class="titre" @click="Search">search</v-btn>
    </v-container>
  </div>
</template>

<script>
import API from "@/api";
import Material from "vuetify/es5/util/colors";
import axios from "axios";

export default {
  data: () => ({
    color: Material,
    selectedTab: "tab-1",
    test: 1,
    items: ["AND", "OR", "NOT"],
    items2: ["AAA", "TTT", "ZZZ"],
    payload0: {
      searchLine: {
        field1: "",
        op: "AND",
        field2: "",
        in: "",
      },
      criterion: "empty",

    },
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
      added["searchLine"] = {
        field1: "",
        op: "AND",
        field2: "",
        in: ""
      };
      added["criterion"] = "AND";

      this.payload.push(added);
    },

    removeh: function() {
      if (this.payload.length > 0) {
        this.payload.splice(-1, 1);
      }
    },

    addv: function() {

      },


    removev: function() {

    },

    Search(params) {
      this.loading = true;

      var query = this.payload.slice();
      query = query.unshift(this.payload0);

      axios.get('http://mdl-std02.info.fundp.ac.be:8181/MdlGroupe2-test/api/AdvancedSearch?params='+params)
      .then(function (response) {
        console.log(response);
      })
      .catch(function (error) {
        console.log(error);
      })
      .then(function () {
      });

      setTimeout(() => {
        this.$router.push("../result_page");
      }, 1000);
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
