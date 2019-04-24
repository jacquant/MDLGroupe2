<template>
  <div id="advancedSearch" width="100%">
      <v-btn fab dark small color="primary" @click="remove">
          <v-icon dark>remove</v-icon>
      </v-btn>
      <v-flex>
      <span v-for="item in test">
        <span v-if="item > 1">
            <v-select outline label="Logic" :items="items">
            </v-select>
        </span>
        <v-text-field label="search"></v-text-field>
      </span>
      </v-flex>

      <v-btn fab dark small color="red" @click="add">
          <v-icon dark>add</v-icon>
      </v-btn>
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
  data: () => ({
    color: Material,
    selectedTab: "tab-1",
    test: 1,
    items:["AND", "OR", "NOT"]
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
    },

    add:function(){
        this.test += 1
    },
    
    remove:function(){
        if(this.test > 3){
            this.test -= 1
        }
    }
  }
};

</script>


<style scoped lang="css">

</style>