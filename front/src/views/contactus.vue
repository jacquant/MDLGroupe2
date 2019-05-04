<template>
  <div id="contactus">
    <v-container grid-list-xl fluid>
      <h2 class="titre">Contact Us</h2>

      <h3>
        We are a team of students of the University of Namur (Belgium) and this
        website is the object of a project we had to realize as part of our
        studies.
        <br />
        <br />
        <ul>The team :</ul> <br>
          <li>
            <v-avatar size="50px">
              <img src="../assets/antoine.jpg" alt="Antoine Jacques" />
            </v-avatar> &nbsp;
            <a href="mailto:antoine.jacques@student.unamur.be">antoine.jacques@student.unamur.be</a>
          </li> <br>
          <li>
            <v-avatar size="50px">
              <img src="../assets/seba.jpg" alt="Sébastien Marbehant" />
            </v-avatar> &nbsp;
            <a href="mailto:sebastien.marbehant@student.unamur.be">sebastien.marbehant@student.unamur.be</a>
          </li> <br>
          <li>
            <v-avatar size="50px">
              <img src="../assets/max.jpg" alt="Maxime Van Speybroeck" />
            </v-avatar> &nbsp;
            <a href="mailto:maxime.vanspeybroeck@student.unamur.be">maxime.vanspeybroeck@student.unamur.be</a>
          </li> <br>
          <li>
            <v-avatar size="50px">
              <img src="../assets/dania.jpg" alt="Dania Otri" />
            </v-avatar> &nbsp;
            <a href="mailto:dania.otri@student.unamur.be">dania.otri@student.unamur.be</a>
          </li> <br>
          <li>
            <v-avatar size="50px">
              <img src="../assets/emmanuel.jpg" alt="Emmanuel Agossou" />
            </v-avatar> &nbsp;
            <a href="mailto:bidossessi.agossou@student.unamur.be">bidossessi.agossou@student.unamur.be</a>
          </li> <br>
          <li>
            <v-avatar size="50px">
              <img src="../assets/lion.jpg" alt="Lionel Abrassart" />
            </v-avatar> &nbsp;
            <a href="mailto:lionel.abrassart@student.unamur.be">lionel.abrassart@student.unamur.be</a>
          </li> <br>
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