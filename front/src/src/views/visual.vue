nn <template>
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
        <v-flex height="400px"   width="100%" >
          <v-widget title="Graph of words" content-bg="white">
            <v-btn icon slot="widget-header-action">
              <v-icon class="text--secondary">refresh</v-icon>
            </v-btn>
            <div slot="widget-content">






            </div>
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
            <div slot="widget-content">







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


export default {
  data() {
    return {
      active: null,
      relatedArticle: " Related articles here",
      comments: " Comments here",
      video: " Video  here"
    };
  },

  methods: {
    classic() {
      this.loading = true;
      setTimeout(() => {
        this.$router.push("/etatdelart");
      }, 1000);
    },

    visual() {
      this.loading = true;
      setTimeout(() => {
        this.$router.push("/visual");
      }, 1000);
    },

    matrice() {
      this.loading = true;
      setTimeout(() => {
        this.$router.push("/result_page_matrice");
      }, 1000);
    }
  },

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
