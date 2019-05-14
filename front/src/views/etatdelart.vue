<template>
  <div id="etatdelart">
    <v-container grid-list-xl fluid>
      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn color @click="classicView" class="titre">Classic</v-btn>
        <v-btn color @click="visualView" class="titre">Visual</v-btn>
        <v-btn color @click="matriceView" class="titre">Matrix</v-btn>
      </v-card-actions>

      <div id="classicView">
        <table style="margin-top:10px; width:100%; padding:10px; ">
          <tr>
            <td valign="top" width="70%">
              <div id="result" style="width:100%; margin-left:30px">
                <h2 style="vertical-align: top;" class="titre">State of art</h2>

                <h3>
                  <b>Title: {{ title }}</b>
                </h3>
                <h5>
                  <i> {{ info }}</i>
                </h5>
                <h4><b>Keywords:</b> {{ keywords }}</h4>
                <br />
                <h3>
                  Abstract &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <a href class>PDF</a>
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Nb References: {{ nbReferences }}
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <a href target="_blank" class>
                    <img src="../assets/favoris.png" width="3%" />
                  </a>
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <a href target="_blank" class>
                    <img src="../assets/partage.png" />
                  </a>
                </h3>

                <div id="textarea">
                  <v-text-field
                    label="abstract"
                    readonly="true"
                    name="abstract"
                    textarea
                    rows="10"
                    cols="25"
                    v-model="the_abstract"
                  ></v-text-field>
                </div>
              </div>
            </td>
          </tr>
        </table>

        <v-tabs color="blue-grey lighten-1" dark icons-and-text>
          <v-tabs-slider color="yellow"></v-tabs-slider>

          <v-tab href="#tab-1">
            Related Articles
          </v-tab>

          <v-tab href="#tab-2">
            Video
          </v-tab>

          <v-tab href="#tab-3">
            Comments
          </v-tab>

          <v-tab-item v-for="i in 3" :key="i" :value="'tab-' + i">
            <v-card flat>
              <v-card-text>{{ text[i - 1] }}</v-card-text>
            </v-card>
          </v-tab-item>
        </v-tabs>
      </div>

      <div id="visualView" style="display: none">
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

      <div id="matriceView" style="display: none">
        <v-container grid-list-xl fluid>
          <h2 class="titre">Reference's matrix</h2>
          <h3>
            <b><u>Title:</u> {{ title }}</b>
          </h3>
          <h5>
            <i> {{ info }}</i>
          </h5>
          <h4><b>Keywords:</b> {{ keywords }}</h4>

          <div id="table_matrice">
            <br />
            <table cellpadding="5px" border="1" style="font-size:24px;">
              <tr style="background-color:lightgrey;">
                <th>References</th>
                <th>DataDimension</th>
                <th>DataType</th>
                <th>VisAttributes</th>
                <th>VisTechniques</th>
              </tr>
              <tr v-for="dim in visu_datadimension, map in visu_mapType, attr in visu_visAttribute, tech in visu_visTechnique" >
                <td>ref</td>
                <td>{{ dim }}/td>
                <td>{{ map }}</td>
                <td> {{ attr }}</td>
                <td> {{ tech }}</td>

              </tr>
            </table>
          </div>
        </v-container>
      </div>
    </v-container>
  </div>
</template>

<script>
import API from "@/api";
import EChart from "@/components/chart/echart";
import VWidget from "@/components/VWidget";
import Material from "vuetify/es5/util/colors";
import wordcloud from "vue-wordcloud";



export default {
  components: {
    VWidget,
    EChart,
    wordcloud
  },
  data() {
    return {
      text: [
        this.$route.query.ref,
        this.$route.query.videoUrl,
        "comments here"
      ],
      color: Material,
      selectedTab: "tab-1",
      defaultWords: [],
      defaultWordsPieChart: [],
      id: "",
      title: "",
      nbReferences: "",
      the_abstract: "",
      domains: "",
      keywords: "",
      visu_datadimension: [],
      visu_mapType: [],
      visu_visAttribute: [],
      visu_visTechnique: [],
      bibliographyLiteratureReview: [],
      bibliographyArticle: [],
      ref: []

      /*headers: [
          {
            text: 'References',
            align: 'left',
            sortable: false,
            value: 'name'
          },
          {text: 'Criteria1', value: 'Criteria1'},
          {text: 'Criteria2', value: 'Criteria2'},
          {text: 'Criteria3', value: 'Criteria3'},
          {text: 'Criteria4', value: 'Criteria4'}
        ],
        results: [
          {
            name: 'Ref1',
            Criteria1: v,
            Criteria2: v,
            Criteria3: x,
            Criteria4: x,
          },
          {
            name: 'Ref2',
            Criteria1: v,
            Criteria2: x,
            Criteria3: v,
            Criteria4: v,
          },
          {
            name: 'Ref3',
            Criteria1: v,
            Criteria2: x,
            Criteria3: x,
            Criteria4: v,
          },
        ]*/
    };
  },
  created() {
    this.setData();
    this.classicView();
  },
  model: {
    //paper: this.$route.query.data
  },
  methods: {
    setData() {
      var refThis = this;
      refThis.id = this.$route.query.id;
      var request = new XMLHttpRequest();

      request.open(
        "GET",
        "http://mdl-std02.info.fundp.ac.be:8181/MdlGroupe2-test/api/literature_reviews/" +
          refThis.id,
        false
      );

      request.onload = function() {
        var data = JSON.parse(this.response);
        console.log(data);
        /*if (request.status >= 200 && request.status < 400) {
          refThis.title = data.title;
          refThis.the_abstract = data.abstractArticle;
          refThis.author = data.countries;
          refThis.nbReferences = data.metric;
          refThis.defaultWords = data.tag;
          refThis.defaultWordsPieChart = data.domain;
          refThis.keywords = data.tag.toString();
          refThis.domains = data.domain.toString();
          refThis.visu_datadimension=data.visu_datadimension;
          refThis.visu_mapType=data.visu_mapType;
          refThis.visu_visAttribute=data.visu_visAttribute;
          refThis.visu_visTechnique=data.visu_visTechnique;
          refThis.bibliographyLiteratureReview=data.bibliographyLiteratureReview;
          refThis.bibliographyArticle=data.bibliographyArticle;
          refThis.ref=data.ref;

          refThis.defaultWords.forEach(function(element, index) {
            refThis.defaultWords[index] = {
              name: element,
              value: Math.floor(Math.random() * 30) + 1
            };
          });
          console.log(refThis.defaultWords);
          refThis.defaultWordsPieChart.forEach(function(element, index) {
            refThis.defaultWordsPieChart[index] = {
              value: 1,
              name: element
            };
          });

          refThis.info = null;
          refThis.videoUrl = data.videoUrl;
          refThis.publisher = data.publisher;
          refThis.ref = data.ref;
          refThis.pagerankscore = data.pagerankscore;
          refThis.matriceref = null;
        }*/
      };
      request.send();
    },
    visualView() {
      document.getElementById("visualView").style.display = "block";
      document.getElementById("matriceView").style.display = "none";
      document.getElementById("classicView").style.display = "none";
    },
    classicView() {
      document.getElementById("visualView").style.display = "none";
      document.getElementById("matriceView").style.display = "none";
      document.getElementById("classicView").style.display = "block";
    },
    matriceView() {
      document.getElementById("visualView").style.display = "none";
      document.getElementById("matriceView").style.display = "block";
      document.getElementById("classicView").style.display = "none";
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
