<template>
  <div >
    <b-card>
      <b-button class="btn btn-success" @click="createLoading()">
      <font-awesome-icon icon="plus-square"
    /> </b-button>
      <b-table
        :sticky-header="stickyHeader"
        :fields="fields"
        :items="loadings"
        :busy="isBusy"
        class="mt-3"
        hover
        outlined
      >
        <template #table-busy>
          <div class="text-center text-danger my-2">
            <b-spinner class="align-middle"></b-spinner>
            <strong>Lade...</strong>
          </div>
        </template>
      </b-table>
      <b-button @click="reload()">
        <font-awesome-icon icon="sync" />
      </b-button>
    </b-card>
  </div>
</template>

<script>

export default {
  components: {

  },
  data: function () {
    return {
      loadings: [],
      isBusy: false,
      fields: [
        { key: "id", label: "ID" },
        { key: "name", label: "Name" },
        
      ],
      stickyHeader: true,
      url: "http://localhost:8080/api/v1/",
    };
  },
  methods: {
    loadLoadings() {
      this.isBusy = true;
      this.$http
        .get(this.url + "knapsackSolutions", {
          responseType: "json",
        })
        .then((response) => {
          this.loadings = response.data;
          this.isBusy = false;
        });
    },
    reload() {
      this.loadings = [];
      this.loadLoadings();
    },
    createLoading(){
      this.$router.push({name:'loadingForm'})
    }
  },
  created: function () {
    this.loadLoadings();
  },
};
</script>