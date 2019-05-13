<template>
  <div id="pageDashboard" width="100%">
    <v-img id="logo" v-bind:position="centerX" src=static/logo.jpg
    :height="logoHeight" contain="true" alt="Logo ReSearch" />
    <br />

    <div style="margin-right: 100px; margin-left: 100px; width:80%;">
      <v-text-field
        flat
        background-color="white"
        solo
        prepend-icon="search"
        label="Search something here"
        color="black"
        name="Search"
        v-model="searchedInput"
        v-on:keyup="wordCloudDisplay"
        v-on:keyup.enter="validateResearch"
      >
      </v-text-field>
    </div>

    <div class="text-xs-center">
      <v-btn class="titre" @click="advancedSearch">Advanced Search</v-btn>
      <v-btn class="titre" @click="getResults">Validate Search</v-btn>
       <v-btn class="titre" @click="addArt">Add State Of Art</v-btn>

      <!--v-btn class="titre" @click="searchHistory"
      >Search History</v-btn
      -->
    </div>

    <div id="app" class="appClass" hidden>
      <wordcloud
        :data="defaultWords"
        nameKey="name"
        valueKey="value"
        :color="['#C0C0C0', '#808080', '#C0C0C0']"
        :rotate="{ from: 0, to: 0, numOfOrientation: 0 }"
        :fontSize="[50, 60]"
        :showTooltip="true"
        :margin="{ top: 15, right: 5, bottom: 15, left: 5 }"
        :wordClick="wordClickHandler"
      >
      </wordcloud>
    </div>
  </div>
</template>

<script>
import API from "@/api";
import Material from "vuetify/es5/util/colors";
import wordcloud from "vue-wordcloud";
import axios from "axios";

export default {
  components: {
    wordcloud
  },
  data: () => ({
    color: Material,
    selectedTab: "tab-1",
    defaultWords: [],
    logoHeight: "400",
    searchedInput: ""
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
  name: "app",
  methods: {
    validateResearch: function(e) {
      var inputedText = this.searchedInput; // la variable inputedText contient la phrase entrée dans la barre de recherche
      setTimeout(() => {
        this.$router.push({
          path: "/result_page",
          query: { data: inputedText }
          //query: {...},
          //moreData: {foo: 1}
        });
      }, 0.00001);
      this.log += e.key;
    },
    getResults: function(e) {
      var refThis = this;
      var inputedTextArray = refThis.searchedInput.split(" ");
      var apiMapParameter = new Map();
      inputedTextArray.forEach(function(element, index) {
        apiMapParameter.set("keyword" + index, element);
      });
      console.log(apiMapParameter);

      var apiResponse = "";

      axios
        .get(
          "http://mdl-std02.info.fundp.ac.be:8181/MdlGroupe2-test/api/QuickSearch" +
            apiMapParameter
        )
        .then(response => {
          console.log(response);
        });
    },

    wordClickHandler(name, value, vm) {
      this.searchedInput = this.searchedInput + " " + name;
    },

    advancedSearch() {
      this.loading = true;
      setTimeout(() => {
        this.$router.push("../AdvancedSearch");
      }, 1000);
    },
    addArt() {
      this.loading = true;
      setTimeout(() => {
        this.$router.push("../addstateofart");
      }, 1000);
    },

    searchHistory() {
      this.loading = true;
      setTimeout(() => {
        this.$router.push("../StaticSearchHistory");
      }, 1000);
    },

    wordCloudDisplay: function(e) {
      var refThis = this;
      var inputedText = refThis.searchedInput;
      var apiResponse = "";
      axios
        .get("http://localhost:8181/api/Synonyme?keyword=" + inputedText)
        .then(response => {
          if (response.request.status >= 200 && response.request.status < 400) {
            apiResponse = response.data;
            apiResponse.forEach(function(element, index) {
              apiResponse[index] = {
                name: element,
                value: Math.floor(Math.random() * 30) + 1
              };
            });
            refThis.defaultWords = apiResponse;
            if (refThis.defaultWords.length > 0) {
              refThis.logoHeight = 150;
              document.getElementById("app").style.display = "block";
            } else {
              document.getElementById("app").style.display = "none";
            }
          }
        });
    }
  }
};
</script>
<style scoped lang="css">
.appClass {
  align: center;
  width: 50%;
  height: 75%;
  margin-left: 25%;
  margin-right: 50%;
}
.titre {
  color:lightslategrey;
  font-weight: bold;
}
</style>
