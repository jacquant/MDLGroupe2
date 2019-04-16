<template>
    <div id="StaticSearchHistory">
        <v-container grid-list-xl fluid>

            <h2 class="flex my-4 primary--text">Research History</h2>
            <h3>
                <ul>
                    <a @click="etatdelart">
                        <li> "Lifestyle of Triceratops in South America" - J.K. Rowling</li>
                    </a>
                    <a @click="etatdelart">
                        <li> "How were treated T-Rex's in the Jurassic Park movie realisation" - Steven Spielberg</li>
                    </a>
                    <li> ...</li>
                </ul>
            </h3>

        </v-container>
    </div>
</template>

<script>
    export default {
        data: () => ({
            loading: false,
            model: {}
        }),

        methods: {

            etatdelart() {
                this.loading = true;
                setTimeout(() => {
                    this.$router.push("../etatdelart");
                }, 1000);
            }

        }
    };
</script>
<style scoped lang="css">

</style>
