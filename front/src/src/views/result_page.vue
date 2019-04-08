<template>
    <div id="result_page_matrice">
        <v-container grid-list-xl fluid>
            <!--v-layout row wrap>
                <div style="float:left; vertical-align: top;">
                    <img src="/static/logo.jpg" alt="Vue Material Admin" width="120" height="120">
                </div>
            </v-layout-->

            <v-card-actions>

                <v-spacer></v-spacer>
                <v-btn  color="" @click="classic"  class="btn">Classic</v-btn>
                <v-btn  color="" @click="visual"  class="btn">Visual</v-btn>
                <v-btn  color="" @click="matrice"  class="btn">Matrice</v-btn>
            </v-card-actions>
            <h2 class="flex my-4 primary--text">Research Result (88888)</h2>
            <br/>

            <div id="listResult">
                <a href="#/etatdelart"> <img align="center" src="../assets/iconA.png" width="20px"> Lorem
                    ipsum dolor sit amet, consectetur adipiscing elit, sed do</a><br/><br/>
                <a href="#/etatdelart"> <img align="center" src="../assets/iconA.png" width="20px"> Lorem
                    ipsum dolor sit amet, consectetur adipiscing elit, sed do</a><br/><br/>
                <a href="#/etatdelart"> <img align="center" src="../assets/iconA.png" width="20px"> Lorem
                    ipsum dolor sit amet, consectetur adipiscing elit, sed do</a><br/><br/>
                <a href="#/etatdelart"> <img align="center" src="../assets/iconA.png" width="20px"> Lorem
                    ipsum dolor sit amet, consectetur adipiscing elit, sed do</a><br/><br/>
                <a href="#/etatdelart"> <img align="center" src="../assets/iconA.png" width="20px"> Lorem
                    ipsum dolor sit amet, consectetur adipiscing elit, sed do</a><br/><br/>


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
                    this.$router.push('/etatdelart');
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
                    this.$router.push('/result_page_matrice');
                }, 1000);
            }
        }

    };
</script>
<style scoped lang="css">
    .active_btn{
        width:40px;
        background-color: deepskyblue;
        color: red;
    }
    .btn{
        width:40px;
    }
</style>
