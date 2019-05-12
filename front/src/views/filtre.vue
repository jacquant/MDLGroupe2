<div id="app">

    <div v-for="item in filteredItems" >
        <p>{{item.name}}<p>
    </div>

    <input type="text" v-model="search">

</div>

<script>
const app = new Vue({
  el: "#app",

  data: {
    search: "",
    items: [
      { name: "Stackoverflow", type: "development" },
      { name: "Game of Thrones", type: "serie" },
      { name: "Jon Snow", type: "actor" }
    ]
  },

  computed: {
    filteredItems() {
      return this.items.filter(item => {
        return item.type.toLowerCase().indexOf(this.search.toLowerCase()) > -1;
      });
    }
  }
});
</script>
