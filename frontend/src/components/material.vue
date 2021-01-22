<template>
  <div >
    <b-card>
      <materialForm></materialForm>
      <b-table
        :sticky-header="stickyHeader"
        :fields="fields"
        :items="materials"
        :busy="isBusy"
        class="mt-3"
        hover
        outlined
      >
        <template #cell(edit)="data">
          <b-button @click="updateMaterial(data.item)">
            <font-awesome-icon icon="edit" />
          </b-button>
        </template>
        <template #table-busy>
          <div class="text-center text-danger my-2">
            <b-spinner class="align-middle"></b-spinner>
            <strong>{{$t("table.load")}}</strong>
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
import materialForm from "./materialForm.vue";
export default {
  components: {
    materialForm: materialForm,
  },
  data: function () {
    return {
      materials: [],
      isBusy: false,
      fields: [
        { key: "id", label: this.$i18n.t("columns.id") },
        { key: "name", label: this.$i18n.t("columns.name") },
        { key: "weight", label: this.$i18n.t("columns.weight") },
        { key: "volume", label: this.$i18n.t("columns.volume") },
        { key: "edit", label: "" },
      ],
      stickyHeader: true
    };
  },
  methods: {
    loadMaterials() {
      this.isBusy = true;
      this.$http
        .get(process.env.VUE_APP_PATH + "materials", {
          responseType: "json",
        })
        .then((response) => {
          this.materials = response.data;
          this.isBusy = false;
        });
    },
    reload() {
      this.materials = [];
      this.loadMaterials();
    },
    updateMaterial(material) {
      console.log(material);
    },
  },
  created: function () {
    this.loadMaterials();
  },
};
</script>


