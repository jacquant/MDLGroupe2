<template>
  <div id="advancedSearch" width="100%">
     <v-container>
         <v-layout row >
            <v-btn fab dark small color="primary" @click="remove">
                <v-icon dark>remove</v-icon>
            </v-btn>
            <v-flex xs12 md19>
              <v-card-actions>
                        <v-text-field label="" v-model="payload0.searchLine.field1"></v-text-field>
                        <v-select outline label="operator" :items="items" v-model="payload0.searchLine.op"></v-select>
                        <v-text-field label="" v-model="payload0.searchLine.field2"></v-text-field>
                        in
                        <v-select outline label="operator" :items="items2" v-model="payload0.searchLine.in"></v-select>
              </v-card-actions>
              <span v-for="item in payload">
                  
                    <span>
                         <v-card-actions>
                             
                        <v-select outline label="operator" :items="items" v-model="item.criterion"></v-select>
                        <v-text-field label="" v-model="item.searchLine.field1"></v-text-field> 
                        <v-select outline label="operator" :items="items" v v-model="item.searchLine.op"></v-select>
                        <v-text-field label="" v-model="item.searchLine.field2"></v-text-field> 
                         in
                        <v-select outline label="operator" :items="items2" v-model="item.searchLine.in"></v-select>

                         </v-card-actions>                     
                    </span>
              </span>
            </v-flex>
            <v-btn fab dark small color="red" @click="add">
                <v-icon dark>add</v-icon>
            </v-btn>
        </v-layout>
        <v-btn color="warning" @click="Search" dark>search</v-btn>
     </v-container>
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
    items:["AND", "OR", "NOT"],
    items2:["AAA", "TTT", "ZZZ"],
    payload0: { "searchLine":{
            "field1": "",
            "op": "AND",
            "field2": "",
            "in":""
        },
        "criterion":"empty"
    },
    payload:[]
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
        var added = {}
        added["searchLine"] = {
            "field1": "",
            "op": "AND",
            "field2" : "",
            "in": ""
        }
        added["criterion"] = "AND" 

        this.payload.push(added)
    },
    
    remove:function(){
        if(this.payload.length > 0){
            this.payload.splice(-1,1)
        }
    },
    Search() {
      this.loading = true;

          var query = this.payload.slice()
          query = query.unshift(this.payload0)
      //axios
      setTimeout(() => {
        this.$router.push("../result_page");
      }, 1000);
    },
  }
};

</script>


<style scoped lang="css">

</style>