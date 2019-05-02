<template>
  <div id="visual">
    <v-card-actions>
      <v-spacer></v-spacer>
      <v-btn color @click="classic" class="btn">Classic</v-btn>
      <v-btn color @click="visual" class="active_btn">Visual</v-btn>
      <v-btn color @click="matrice" class="btn">Matrice</v-btn>
    </v-card-actions>
    <!--v-card-actions>
      <v-btn type="button" class="btn">Author</v-btn>
      <v-btn type="button" class="btn">Title</v-btn>
    </v-card-actions-->
    <v-container grid-list-xl fluid>
      <v-layout row wrap>
        <v-flex height="400px" width="100%">
          <v-widget title="Graph of words" content-bg="white">
            <v-btn icon slot="widget-header-action">
              <v-icon class="text--secondary">refresh</v-icon>
            </v-btn>
            <div slot="widget-content"></div>
          </v-widget>
        </v-flex>
      </v-layout>

      <v-layout>
        <v-flex width="50%">
          <v-widget title="Pie chart" content-bg="white">
            <div slot="widget-content">
              <e-chart
                :path-option="[
                  ['dataset.source', pieChartData],
                  ['legend.bottom', '0'],
                  [
                    'color',
                    [
                      color.lightBlue.base,
                      color.indigo.base,
                      color.pink.base,
                      color.green.base,
                      color.cyan.base,
                      color.teal.base
                    ]
                  ],
                  ['xAxis.show', false],
                  ['yAxis.show', false],
                  ['series[0].type', 'pie'],
                  ['series[0].avoidLabelOverlap', true],
                  ['series[0].radius', ['50%', '70%']]
                ]"
                height="400px"
                width="100%"
              ></e-chart>
            </div>
          </v-widget>
        </v-flex>

        <v-flex width="50%">
          <v-widget title="Cloud of words" content-bg="white">
            <div id="app" slot="widget-content">
              <wordcloud
                :data="defaultWords"
                nameKey="name"
                valueKey="value"
                :color="['#1f77b4', '#629fc9', '#94bedb', '#c9e0ef']"
                :rotate="{ from: 0, to: 0, numOfOrientation: 0 }"
                :spiral="rectangular"
                :fontSize="[50, 60]"
                :showTooltip="true"
                :margin="{ top: 15, right: 5, bottom: 15, left: 5 }"
                :wordClick="wordClickHandler"
              >
              </wordcloud>
            </div>
          </v-widget>
        </v-flex>
      </v-layout>

      <div id="sigma-container"></div>
    </v-container>
  </div>
</template>

<script>
import API from "@/api";
import EChart from "@/components/chart/echart";
import VWidget from "@/components/VWidget";
import Material from "vuetify/es5/util/colors";
import wordcloud from 'vue-wordcloud';


export default {
  data() {
    return {

      active: null,

      color: Material,
      selectedTab: "tab-1",
      defaultWords: [{"name": "car", "value":Math.floor(Math.random() * 30) + 1}, {"name": "computer", "value":Math.floor(Math.random() * 30) + 1}, {"name": "data", "value":Math.floor(Math.random() * 30) + 1}, {"name": "vizualisation", "value":Math.floor(Math.random() * 30) + 1}, {"name": "engineering", "value":Math.floor(Math.random() * 30) + 1}, {"name": "IT", "value":Math.floor(Math.random() * 30) + 1}]


    };
  },
  name: "app",
  methods: {
    classic() {
      this.loading = true;
      setTimeout(() => {
        this.$router.push({
          path: "/etatdelart",
          query: {
            item:this.$route.query.item
          }
          //query: {...},
          //moreData: {foo: 1}
        });
      }, 1);
    },
    visual() {
      this.loading = true;
      setTimeout(() => {
        this.$router.push({
          path: "/visual",
          query: {
            item:this.$route.query.item
          }
          //query: {...},
          //moreData: {foo: 1}
        });
      }, 1);
    },
    matrice() {
      this.loading = true;
      setTimeout(() => {
        this.$router.push({
          path: "/result_page_matrice",
          query: {
            item:this.$route.query.item
          }
          //query: {...},
          //moreData: {foo: 1}
        });
      }, 1);
    }
  },

  components: {
    VWidget,
    EChart,
    wordcloud
  },
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
    pieChartData() {
      return API.getData;
    }
  }
};
</script>
<style scoped lang="css">
#textarea {
  margin-top: 20px;
}
.active_btn {
  width: 40px;
  background-color: deepskyblue;
  color: red;
}
.btn {
  width: 40px;
}
</style>
