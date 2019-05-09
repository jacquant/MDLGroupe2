<template>
  <div id="pageDashboard" width="100%">
    <v-img v-bind:position="centerX" src=static/logo.jpg height="250" contain="true" alt="Logo ReSearch" />
    <br>

    <div style="margin-right: 100px; margin-left: 100px; width:80%;" >
      <v-text-field
              flat
              solo-inverted
              prepend-icon="search"
              label=""

              name="Search"
              v-model="searchedInput"
              v-on:keyup="wordCloudDisplay"
              v-on:keyup.enter="validateResearch"
      >
      </v-text-field>
    </div>
    <div class="text-xs-center">
      <v-btn outline color="indigo" @click="advancedSearch" >Advanced Search</v-btn>
    </div>

    <div id="app" hidden>
     <wordcloud
              :data="defaultWords"
              nameKey="name"
              valueKey="value"

              :color="['#1f77b4', '#629fc9', '#94bedb', '#c9e0ef']"
              :showTooltip="true"
              :wordClick="wordClickHandler">
      </wordcloud>

     <!-- <div id="app">
      {{ info }}
    </div-->

    </div>
  </div>
</template>




<script>
  import API from "@/api";
  import Material from "vuetify/es5/util/colors";
  import wordcloud from 'vue-wordcloud';
  import axios from "axios";

  var url = "http://mdl-std02.info.fundp.ac.be:8181/MdlGroupe2-test/api/Synonyme?keyword=" + this.searchedInput;

  new Vue({
    el: '#app',
    data () {
      return {
        info: null
      }
    },
    mounted () {
      axios
              .get(url)
              .then(response => (this.info = response))
    }
  })

  export default {
    components: {
      wordcloud
    },
    data: () => ({
      color: Material,
      selectedTab: "tab-1",
      defaultWords: [],
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

    methods:{
      validateResearch: function(e) {
        var inputedText = this.searchedInput; // la variable inputedText contient la phrase entrée dans la barre de recherche
        setTimeout(() => {
          this.$router.push({
            path: '/result_page',
            query: {data: inputedText},
            //query: {...},
            //moreData: {foo: 1}
          })}, 1000);
        this.log += e.key;
      },
      wordCloudDisplay:function(e){
        var inputedText = this.searchedInput; // The input word is in inputedText
        //................... call your API synonym from here and send it the inputedText as parameter
        //end of the call to API synonym. If the result of the call is good then get the synonyms if defaultWords
        this.defaultWords= [{
          "name": "Cat",
          "value": Math.floor(Math.random() * 30) + 1,

        },
          {
            "name": "fish",
            "value": Math.floor(Math.random() * 30) + 1
          },
          {
            "name": "things",
            "value": Math.floor(Math.random() * 30) + 1
          },
          {
            "name": "look",
            "value": Math.floor(Math.random() * 30) + 1
          },
          {
            "name": "two",
            "value": Math.floor(Math.random() * 30) + 1
          },
          {
            "name": "fun",
            "value": Math.floor(Math.random() * 30) + 1
          },
          {
            "name": "know",
            "value": Math.floor(Math.random() * 30) + 1
          },
          {
            "name": "good",
            "value": Math.floor(Math.random() * 30) + 1
          },
          {
            "name": "play",
            "value": Math.floor(Math.random() * 30) + 1
          }
        ];
        if(inputedText!=null) document.getElementById("app").style.display="block";
        else document.getElementById("app").style.display="none";
      },
      advancedSearch() {
        this.loading = true;
        setTimeout(() => {
          this.$router.push("../AdvancedSearch");
        }, 1000);
      },
      wordClickHandler(name, value, vm) {
        console.log('wordClickHandler', name, value, vm);
      }
    }
  }
</script>
<style scoped lang="css">