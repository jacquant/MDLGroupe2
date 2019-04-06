<template>
    <v-app id="addstateofart" class="primary">
        <v-content>
            <v-container fluid fill-height>
                <v-layout align-center justify-center>
                    <v-flex xs12 sm8 md4 lg4>
                        <v-card class="elevation-1 pa-3">
                            <v-card-text>
                                <div class="layout column align-center">
                                    <img src="/static/logo.jpg" alt="Vue Material Admin" width="120" height="120">
                                    <h1 class="flex my-4 primary--text">Add state of art</h1>
                                </div>
                                <v-form>
                                    <v-text-field
                                        append-icon=""
                                        name="Title"
                                        label="Title"
                                        textarea
                                        rows="2"
                                        cols="10"
                                        v-model="title"
                                ></v-text-field>
                                    <v-text-field
                                            name="Authors"
                                            label="Authors"
                                            textarea
                                            rows="5"
                                            cols="10"
                                            v-model="authors"
                                    ></v-text-field>

                                    <v-text-field
                                            name="Areas"
                                            label="Area(s)"
                                            textarea
                                            rows="5"
                                            cols="10"
                                            v-model="area"
                                    ></v-text-field>

                                    <v-text-field
                                            name="Details"
                                            label="Details"
                                            textarea
                                            rows="5"
                                            cols="10"
                                            v-model="details"
                                    ></v-text-field>
                                    <v-text-field
                                            name="Abstract"
                                            label="Abstract"
                                            textarea
                                            rows="5"
                                            cols="10"
                                            v-model="abstract"
                                    ></v-text-field>
                                    Add Contribution:

                                            <v-radio-group v-model="radios" :mandatory="false">
                                                <v-radio label="Yes" value="Yes"></v-radio>
                                                <v-radio label="No" value="No"></v-radio>
                                                <v-radio label="Under my supervision" value="Under my supervision"></v-radio>
                                            </v-radio-group>


                                    References:<div id="reference">



                                </div>
                                    PDF File:<v-text-field append-icon="" name="pdffile" label="" type="text" v-model="pdffile"></v-text-field>

                                    <v-text-field  name="videourl" label="Youtube Video Url" type="text" v-model="videourl"></v-text-field>


                                </v-form>
                            </v-card-text>
                            <v-card-actions>

                                <v-spacer></v-spacer>
                                <v-btn block color="primary" @click="login" :loading="loading"
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
    export default {
        data: () => ({
            loading: false,
            model: {


            }
        }),

        methods: {
            login() {
                this.loading = true;
                setTimeout(() => {
                    this.$router.push("/editprofil");
                }, 1000);
            }
        }
    };
</script>
<style scoped lang="css">
    .radiobtn {

    }
</style>
