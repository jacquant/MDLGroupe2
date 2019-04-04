<template>
    <v-app id="editpassword" class="primary">
        <v-content>
            <v-container fluid fill-height>
                <v-layout align-center justify-center>
                    <v-flex xs12 sm8 md4 lg4>
                        <v-card class="elevation-1 pa-3">
                            <v-card-text>
                                <div class="layout column align-center">
                                    <img
                                            src="/static/m.png"
                                            alt="Vue Material Admin"
                                            width="120"
                                            height="120"
                                    />
                                    <h1 class="flex my-4 primary--text">Edit your password</h1>
                                </div>
                                <v-form>

                                    <v-text-field
                                            append-icon="lock"
                                            name="oldpassword"
                                            label="Old Password"
                                            id="oldpassword"
                                            type="password"
                                            v-model="model.password"
                                    ></v-text-field>
                                    <v-text-field
                                            append-icon="lock"
                                            name="newpassword"
                                            label="New Password"
                                            id="newpassword"
                                            type="password"
                                            v-model="model.password"
                                    ></v-text-field>
                                    <v-text-field
                                            append-icon="lock"
                                            name="newpasswordbis"
                                            label="Confirm New Password"
                                            id="newpasswordbis"
                                            type="password"
                                            v-model="model.password"
                                    ></v-text-field>
                                </v-form>
                            </v-card-text>
                            <v-card-actions>

                                <v-spacer></v-spacer>
                                <v-btn block color="primary" @click="login" :loading="loading"
                                >Edit</v-btn
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
                username: "",
                password: ""
            }
        }),

        methods: {
            login() {
                this.loading = true;
                setTimeout(() => {
                    this.$router.push("/editemail");
                }, 1000);
            }
        }
    };
</script>
<style scoped lang="css">
    #login {
        height: 50%;
        width: 100%;
        position: absolute;
        top: 0;
        left: 0;
        content: "";
        z-index: 0;
    }
</style>
