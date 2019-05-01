<template>
  <v-app id="addstateofart" class="primary">
    <v-content>
      <v-container fluid fill-height>
        <v-layout align-center justify-center>
          <v-flex xs12 sm8 md4 lg4>
            <v-card class="elevation-1 pa-3" style="width:140%">
              <v-card-text>
                <div class="layout column align-center">
                  <img
                    src="/static/logo.jpg"
                    alt="Research"
                    width="120"
                    height="120"
                  />
                  <h1 class="flex my-4 primary--text">Add state of art</h1>
                </div>
                <v-form>
                  <v-text-field
                    append-icon=""
                    name="title"
                    label="Title"
                    textarea
                    rows="1"
                    cols="10"
                    v-model="model.title"
                  ></v-text-field>
                  <v-text-field
                    name="authors"
                    label="Authors"
                    textarea
                    rows="2"
                    cols="10"
                    v-model="model.authors"
                  ></v-text-field>

                  <v-text-field
                    name="areas"
                    label="Area(s)"
                    textarea
                    rows="2"
                    cols="10"
                    v-model="model.areas"
                  ></v-text-field>

                  <v-text-field
                    name="details"
                    label="Details"
                    textarea
                    rows="5"
                    cols="10"
                    v-model="model.details"
                  ></v-text-field>
                  <v-text-field
                    name="abstract"
                    label="Abstract"
                    textarea
                    rows="3"
                    cols="10"
                    v-model="model.abstract"
                  ></v-text-field>
                  Add Contribution:

                  <v-radio-group
                    name="contribution"
                    v-model="model.contribution"
                    :mandatory="false"
                  >
                    <v-radio label="Yes" value="Yes"></v-radio>
                    <v-radio label="No" value="No"></v-radio>
                    <v-radio
                      label="Under my supervision"
                      value="Under my supervision"
                    ></v-radio>
                  </v-radio-group>

                  References:
                  <div id="reference">
                    <v-btn class="btn" @click="createTable">Add Table</v-btn>
                    <v-btn class="btn" @click="deleteTable">Delete Table</v-btn>
                    <table>
                      <tr>
                        <td valign="top">
                          <div class="scrollable">
                            <table
                              id="myTable"
                              border="1"
                              name="reference"
                            ></table>
                          </div>
                        </td>
                      </tr>
                    </table>
                  </div>

                  <!--v-text-field
                                            append-icon=""
                                            name="file_url"
                                            label="upload file here"
                                            type="text"
                                            v-model="file_url"
                                    ></v-text-field>
                                        <template>
                                            <upload-btn icon
                                            :fileChangedCallback="fileChanged">
                                            <template slot="icon">
                                                <v-icon>add</v-icon>
                                             </template>
                                             </upload-btn>
                                        </template-->
                  <template>
                    <div class="container">
                      <div class="large-12 medium-12 small-12 cell">
                        <label
                          >File
                          <input
                            type="file"
                            id="file"
                            ref="file"
                            v-on:change="handleFileUpload(event)"
                          />
                        </label>
                      </div>
                    </div>
                  </template>

                  <v-text-field
                    name="videourl"
                    label="Youtube Video Url"
                    type="text"
                    v-model="model.videourl"
                  ></v-text-field>
                </v-form>
              </v-card-text>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn width="50px" color="primary" @click="add_article"
                  >Add</v-btn
                >
              </v-card-actions>
            </v-card>
          </v-flex>
        </v-layout>
      </v-container>
    </v-content>
  </v-app>
</template>

<script>
import UploadButton from "vuetify-upload-button";
export default {
  data: () => ({
    loading: false,
    model: {}
  }),

  methods: {
    add_article() {},

    handleFileUpload(event) {
      /*
                var input = event.target;
                var dataURL;
                var reader = new FileReader();
                reader.onload = function(){
                    dataURL =  reader.readAsDataURL(input.this.file);

                };
              */
      this.file = this.$refs.file.files[0];

      //alert(dataURL);
    },

    createTable: function() {
      var rn = window.prompt("Number of references", 1);
      var cn = window.prompt("Number of criteria", 1);

      for (var r = 0; r <= parseInt(rn, 10); r++) {
        var x = document.getElementById("myTable").insertRow(r);
        for (var c = 0; c <= parseInt(cn, 10); c++) {
          var y = x.insertCell(c);
          if (r == 0 && c == 0)
            y.innerHTML =
              "<div style='font-size:14; font-weight: bold;'> References / Criteria-></div>";
          else if (r == 0 || c == 0)
            y.innerHTML = "<input type='text' width='100%' height='100%'>";
          else
            y.innerHTML =
              "<div align='center'><input type='checkbox' name='checkbox' ></div>";
        }
      }
    },

    deleteTable: function() {
      document.getElementById("myTable").innerHTML = "";
    }
  },
  components: {
    "upload-btn": UploadButton
  }
};
</script>

<style scoped lang="css">
.btn {
    width:45px;
}
.scrollable
{
    width: 500px;
    height: 300px;
    overflow: auto;
}
</style>
