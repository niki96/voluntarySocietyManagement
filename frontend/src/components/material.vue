<template>
  <div class="hello">
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
            <strong>Loading...</strong>
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
        { key: "id", label: "ID" },
        { key: "name", label: "Name" },
        { key: "weight", label: "Gewicht (kg)" },
        { key: "volume", label: "Volumen (m^3)" },
        { key: "edit", label: "" },
      ],
      stickyHeader: true,
      url: "http://localhost:8080/api/v1/",
    };
  },
  methods: {
    loadMaterials() {
      this.isBusy = true;
      this.$http
        .get(this.url + "material", {
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


