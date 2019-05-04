<template>
  <div id="contactus">
    <v-container grid-list-xl fluid>
      <h2 class="titre">Contact Us</h2>

      <h3>
        We are a team of students of the University of Namur (Belgium) and this
        website is the object of a project we had to realise as part of our
        studies.
        <br />
        <br />Phone : (+32) ..
      </h3>
    </v-container>
  </div>
</template>

<script>
export default {
  data: () => ({
    loading: false
  })
};
</script>

<style scoped lang="css">
.titre {
color:lightslategrey;
font-weight: bold;
}
</style>