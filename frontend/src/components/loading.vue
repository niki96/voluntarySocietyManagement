<template>
  <div>
    <b-card>
      <b-button class="btn btn-success" @click="createLoading()">
        <font-awesome-icon icon="plus-square" />
      </b-button>
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
        <template #cell(pdf)="data">
          <b-button @click="getLoadingPdf(data.item)"> </b-button>
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
  components: {},
  data: function () {
    return {
      loadings: [],
      isBusy: false,
      fields: [
        { key: "id", label: this.$i18n.t("columns.id") },
        { key: "name", label: this.$i18n.t("columns.name") },
        { key: "pdf", label: "" },
      ],
      stickyHeader: true
    };
  },
  methods: {
    loadLoadings() {
      this.isBusy = true;
      this.$http
        .get(process.env.VUE_APP_PATH + "knapsackSolutions", {
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
    createLoading() {
      this.$router.push({ name: "loadingForm" });
    },
    getLoadingPdf(loading) {
      console.log(loading);
      this.axios(process.env.VUE_APP_PATH + "knapsackSolutions/" + loading.id, {
        method: "GET",
        responseType: "blob",
      })
        .then((response) => {
          //Create a Blob from the PDF Stream
          const file = new Blob([response.data], { type: "application/pdf" });
          //Build a URL from the file
          const fileURL = URL.createObjectURL(file);
          //Open the URL on new Window
          window.open(fileURL);
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
  created: function () {
    this.loadLoadings();
  },
};
</script>