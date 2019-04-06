<template>
    <div id="etatdelart">
        <v-container grid-list-xl fluid>
            <v-layout row wrap>

            </v-layout>

            <v-card-actions>

                <v-spacer></v-spacer>
                <v-btn block color="" @click="classic" :loading="loading">Classic</v-btn>
                <v-btn block color="" @click="visual" :loading="loading">Visual</v-btn>
                <v-btn block color="" @click="matrice" :loading="loading">Matrice</v-btn>
            </v-card-actions>
            <h2 class="flex my-4 primary--text">State of art</h2>
            <h4 class="">Title:</h4>
            <h3 class="">Abstract  <a href="" class="">PDF</a>  Nb Referernces: (8881)</h3>

            <div id="textarea">

                            <v-text-field
                                    label="abstract"
                                    textarea
                                    rows="20"
                                    cols="30"
                                    v-model="abstract"
                            ></v-text-field>

            </div>

        </v-container>
    </div>
</template>

<script>
    export default {
        data: () => ({
            loading: false,
            model: {
                username: '',
                password: ''
            }
        }),

        methods: {
            classic () {
                this.loading = true;
                setTimeout(() => {
                    this.$router.push('/classic');
                }, 1000);
            },

            visual () {
                this.loading = true;
                setTimeout(() => {
                    this.$router.push('/visual');
                }, 1000);
            },

            matrice () {
                this.loading = true;
                setTimeout(() => {
                    this.$router.push('/matrice');
                }, 1000);
            }
        }

    };
</script>
<style scoped lang="css">
    #textarea {
        margin-top: 10px;
    }
</style>
