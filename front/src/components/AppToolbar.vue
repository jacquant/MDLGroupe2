<template>
  <v-toolbar color="primary" fixed dark app>
    <v-toolbar-title class="ml-0 pl-3"> </v-toolbar-title>

    <v-spacer></v-spacer>
    <v-toolbar-items>
      <v-btn flat @click="contactus" class="">
        Contact Us
      </v-btn>

      <v-btn flat @click="dashboard" class="">
        Home
      </v-btn>
    </v-toolbar-items>

    <v-menu
      offset-y
      origin="center center"
      class="elelvation-1"
      :nudge-bottom="14"
      transition="scale-transition"
    >
    </v-menu>
    <v-menu
      offset-y
      origin="center center"
      :nudge-bottom="10"
      transition="scale-transition"
    >
      <v-btn icon large flat slot="activator">
        <v-avatar size="30px">
          <img src="/static/avatar/man_4.jpg" alt="Michael Wang" />
        </v-avatar>
      </v-btn>
      <v-list class="pa-0">
        <v-list-tile
          v-for="(item, index) in items"
          :to="!item.href ? { name: item.name } : null"
          :href="item.href"
          @click="item.click"
          ripple="ripple"
          :disabled="item.disabled"
          :target="item.target"
          rel="noopener"
          :key="index"
        >
          <v-list-tile-action v-if="item.icon">
            <v-icon>{{ item.icon }}</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title>{{ item.title }}</v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>
      </v-list>
    </v-menu>
  </v-toolbar>
</template>
<script>
import NotificationList from "@/components/widgets/list/NotificationList";
import Util from "@/util";
export default {
  name: "app-toolbar",
  components: {
    NotificationList
  },
  data: () => ({
    items: [
      {
        icon: "account_circle",
        href: "",

        title: "Profile",
        click: e => {
          //this.$router.push("../personnalpage");
          window.getApp.$emit("APP_PERSONAL_PAGE");
        }
      },
      {
        icon: "settings",
        href: "#",
        title: "Settings",
        click: e => {
          window.getApp.$emit("APP_SETTINGS");
        }
      },
      {
        icon: "fullscreen_exit",
        href: "#",
        title: "Logout",
        click: e => {
          window.getApp.$emit("APP_LOGOUT");
        }
      }
    ]
  }),
  computed: {
    toolbarColor() {
      return this.$vuetify.options.extra.mainNav;
    }
  },
  methods: {
    validateResearch: function(e) {
      if (e.keyCode === 13) {
        var inputedText = this.searchedInput; // la variable inputedText contient la phrase entrée dans la barre de recherche
        // alert(inputedText);
        // getQuickSearch(inputedText);
        appel_ajax(inputedText);
      }
      this.log += e.key;
    },

    handleDrawerToggle() {
      window.getApp.$emit("APP_DRAWER_TOGGLED");
    },
    handleFullScreen() {
      Util.toggleFullScreen();
    },

    contactus() {
      this.loading = true;
      setTimeout(() => {
        this.$router.push("../contactus");
      }, 1000);
    },

    dashboard() {
      this.loading = true;
      setTimeout(() => {
        this.$router.push("../dashboard");
      }, 1000);
    },

    getQuickSearch(param) {
      var request = new XMLHttpRequest();

      var url =
        "http://mdl-std02.info.fundp.ac.be:8181/MdlGroupe2-test/api/QuickSearch?keyword=" +
        param;

      // Modifier le deuxième argument en fct de ce qu'on veut récup
      request.open("GET", url, true);
      request.onload = function() {
        // Begin accessing JSON data here
        var data = JSON.parse(this.response);

        if (request.status >= 200 && request.status < 400) {
          //data.forEach(word => {
          //Same here (idem commentaire ligne 152)
          // console.log(word);
          // });
        } else {
          console.log("error");
        }
      };

      request.send();
    }
  }
};
</script>
