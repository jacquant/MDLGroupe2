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
              v-on:keyup.enter="validateResearch"
      >
      </v-text-field>
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
    PlainTableOrder
  },
  data: () => ({

    color: Material,
    selectedTab: "tab-1",
    linearTrending: [
      {
        subheading: "Sales",
        headline: "2,55",
        caption: "increase",
        percent: 15,
        icon: {
          label: "trending_up",
          color: "success"
        },
        linear: {
          value: 15,
          color: "success"
        }
      },
      {
        subheading: "Revenue",
        headline: "6,553",
        caption: "increase",
        percent: 10,
        icon: {
          label: "trending_down",
          color: "error"
        },
        linear: {
          value: 15,
          color: "error"
        }
      },
      {
        subheading: "Orders",
        headline: "5,00",
        caption: "increase",
        percent: 50,
        icon: {
          label: "arrow_upward",
          color: "info"
        },
        linear: {
          value: 50,
          color: "info"
        }
      }
    ],
    trending: [
      {
        subheading: "Email",
        headline: "15+",
        caption: "email opens",
        percent: 15,
        icon: {
          label: "email",
          color: "info"
        },
        linear: {
          value: 15,
          color: "info"
        }
      },
      {
        subheading: "Tasks",
        headline: "90%",
        caption: "tasks completed.",
        percent: 90,
        icon: {
          label: "list",
          color: "primary"
        },
        linear: {
          value: 90,
          color: "success"
        }
      },
      {
        subheading: "Issues",
        headline: "100%",
        caption: "issues fixed.",
        percent: 100,
        icon: {
          label: "bug_report",
          color: "primary"
        },
        linear: {
          value: 100,
          color: "error"
        }
      }
    ]
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