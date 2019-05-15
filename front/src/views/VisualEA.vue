<template>
  <div id="visualView">
    <v-card-actions>
      <v-spacer></v-spacer>
      <v-btn @click="$router.go(-1)" class="titre">Back</v-btn>
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
            <div slot="widget-content">
              <div v-html="index"></div>
            </div>
          </v-widget>
        </v-flex>
      </v-layout>

      <v-layout>
        <v-flex width="50%">
          <v-widget title="Domains treated" content-bg="white">
            <div slot="widget-content">
                <p>{{ erreurMessage }}</p>
              <e-chart
                :path-option="[
                  ['dataset.source', defaultWordsPieChart],
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
          <v-widget title="Tags" content-bg="white">
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
import EChart from "@/components/chart/echart";
import VWidget from "@/components/VWidget";
import wordcloud from "vue-wordcloud";
import Material from "vuetify/es5/util/colors";

export default {
  components: {
    VWidget,
    EChart,
    wordcloud
  },
  data: () => ({
    color: Material,
    defaultWords: [],
    defaultWordsPieChart: [],
    id: "",
    title: "",
    nbReferences: "",
      erreurMessage: ""
  }),
  created() {
    this.setData();
  },
  methods: {
    setData() {
      var refThis = this;
      var keywordsTab = this.$route.query.allkeywords;
      var domainsTab = this.$route.query.alldomains;
      refThis.defaultWords = keywordsTab.flat();
      refThis.defaultWordsPieChart = domainsTab.flat();

      refThis.defaultWords.forEach(function(element, index) {
        refThis.defaultWords[index] = {
          name: element,
          value: Math.floor(Math.random() * 30) + 1
        };
      });
      if (refThis.defaultWordsPieChart.length > 20) {
        refThis.erreurMessage="TOO MUCH DOMAINS FOR A PIE CHART!";
      } else {
        refThis.defaultWordsPieChart.forEach(function(element, index) {
          refThis.defaultWordsPieChart[index] = {
            value: 1,
            name: element
          };
        });
      }
    }
  }
};
</script>
<style scoped lang="css">
#textarea {
    margin-top: 10px;
}
.titre {
    color:lightslategrey;
    font-weight: bold;
}

#container {
    max-width: 1000px;
    height: 1000px;
    margin: auto;
}
</style>
