<template>
  <div id="pageDashboard" width="100%">
    <v-img v-bind:position="centerX" src=static/logo.jpg height="250" contain="true" alt="Logo ReSearch" />
    <br>


    <div style="margin-right: 100px; margin-left: 100px; width:80%;" >

      <v-text-field
<<<<<<< HEAD
              flat
              solo-inverted
              prepend-icon="search"
              label=""

              name="Search"
              v-model="searchedInput"
              v-on:keyup.enter="validateResearch"
      >
      </v-text-field>
=======
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

      <template>
        <div id="app" hidden>
          <wordcloud
                  :data="defaultWords"
                  nameKey="name"
                  valueKey="value"
                  :color="myColors"
                  :showTooltip="true"
                  :wordClick="wordClickHandler">
          </wordcloud>
        </div>
      </template>


      <vue-word-cloud
              :words="[['romance', 19], ['horror', 3], ['fantasy', 7], ['adventure', 3]]"
              :color="([, weight]) => weight > 10 ? 'DeepPink' : weight > 5 ? 'RoyalBlue' : 'Indigo'"
              font-family="Roboto"
      ></vue-word-cloud>

>>>>>>> 89efe9a2f9bf254c55e7a9c30ade34d34cc64ad0
    </div>
    <div class="text-xs-center">
      <v-btn outline color="indigo" @click="advancedSearch" >Advanced Search</v-btn>
    </div>
  </div>
</template>




<script>
  import API from "@/api";
  import EChart from "@/components/chart/echart";
  import MiniStatistic from "@/components/widgets/statistic/MiniStatistic";
  import PostListCard from "@/components/widgets/card/PostListCard";
  import ProfileCard from "@/components/widgets/card/ProfileCard";
  import PostSingleCard from "@/components/widgets/card/PostSingleCard";
  import WeatherCard from "@/components/widgets/card/WeatherCard";
  import PlainTable from "@/components/widgets/list/PlainTable";
  import PlainTableOrder from "@/components/widgets/list/PlainTableOrder";
  import VWidget from "@/components/VWidget";
  import Material from "vuetify/es5/util/colors";
  import VCircle from "@/components/circle/VCircle";
  import BoxChart from "@/components/widgets/chart/BoxChart";
  import ChatWindow from "@/components/chat/ChatWindow";
  import CircleStatistic from "@/components/widgets/statistic/CircleStatistic";
  import LinearStatistic from "@/components/widgets/statistic/LinearStatistic";
  import axios from "axios";
<<<<<<< HEAD
=======
  import VueWordCloud from 'vuewordcloud';
  import wordcloud from 'vue-wordcloud'
>>>>>>> 89efe9a2f9bf254c55e7a9c30ade34d34cc64ad0


export default {
  components: {
    VWidget,
    MiniStatistic,
    ChatWindow,
    VCircle,
    WeatherCard,
    PostSingleCard,
    PostListCard,
    ProfileCard,
    EChart,
    BoxChart,
    CircleStatistic,
    LinearStatistic,
    PlainTable,
<<<<<<< HEAD
    PlainTableOrder
=======
    PlainTableOrder,
    [VueWordCloud.name]: VueWordCloud

>>>>>>> 89efe9a2f9bf254c55e7a9c30ade34d34cc64ad0
  },
  data: () => ({

    color: Material,
    selectedTab: "tab-1",

    myColors: ['#1f77b4', '#629fc9', '#94bedb', '#c9e0ef'],
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

  name: 'app',
  components: {
    wordcloud
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
        "value": 26
      },
        {
          "name": "fish",
          "value": 19
        },
        {
          "name": "things",
          "value": 18
        },
        {
          "name": "look",
          "value": 16
        },
        {
          "name": "two",
          "value": 15
        },
        {
          "name": "fun",
          "value": 9
        },
        {
          "name": "know",
          "value": 9
        },
        {
          "name": "good",
          "value": 9
        },
        {
          "name": "play",
          "value": 6
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

    advancedSearch() {
      this.loading = true;
      setTimeout(() => {
        this.$router.push("../advancedSearch");
      }, 1000);
    },


    wordClickHandler(name, value, vm) {
      console.log('wordClickHandler', name, value, vm);
    }


  }
};

function appel_ajax(param){

 var xhr = getXhr();
 // On défini ce qu'on va faire quand on aura la réponse
 xhr.onreadystatechange = function(){
   // On ne fait quelque chose que si on a tout reçu et que le serveur est ok
   if(xhr.status < 400 && xhr.status >= 200) {
     //Ici sera afficher le résultat de notre script PHP ajax.php  alert(xhr.responseText);
     //alert(xhr.responseText);

   }
 }

 var url = "http://mdl-std02.info.fundp.ac.be:8181/MdlGroupe2-test/api/QuickSearch?keyword="+param;
 xhr.open("GET",url,true) ;
 xhr.send(null);
}

function getXhr(){
 var xhr = null;
 if(window.XMLHttpRequest) // Firefox et autres
   xhr = new XMLHttpRequest();
 else if(window.ActiveXObject){ // Internet Explorer
   try {
     xhr = new ActiveXObject("Msxml2.XMLHTTP");
   } catch (e) {
     xhr = new ActiveXObject("Microsoft.XMLHTTP");
   }
 }
 else { // XMLHttpRequest non supporté par le navigateur
   alert("Votre navigateur ne supporte pas les objets XMLHTTPRequest...");
   xhr = false;
 }
 return xhr
}
</script>



<style scoped lang="css">