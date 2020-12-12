<template>
  <div>
    <b-card>
      <b-form-group>
        <template #label>
          <b>Choose your materials:</b><br />
          <b-form-checkbox
            v-model="allMaterialsSelected"
            :indeterminate="indeterminateMaterial"
            @change="toggleAll"
          >
            {{ allMaterialsSelected ? "Alle nicht auswählen" : "Alle auswählen" }}
          </b-form-checkbox>
        </template>
      </b-form-group>
      <b-table
        :sticky-header="stickyHeader"
        :fields="fields"
        :items="material"
        :busy="isBusy"
        class="mt-3"
        hover
        outlined
      >
        <template #cell(checked)="data">
          <b-form-checkbox
            name="selected-items"
            v-model="selectedMaterials"
            :value="data.item"
          >
          </b-form-checkbox>
        </template>
        <template #table-busy>
          <div class="text-center text-danger my-2">
            <b-spinner class="align-middle"></b-spinner>
            <strong>Lade...</strong>
          </div>
        </template>
      </b-table>
    </b-card>
  </div>
</template>
<script>
export default {
  name: "materialSelectTable",
  
  data: function () {
    return {
      isBusy: false,
      fields: [
        { key: "checked", label: "" },
        { key: "name", label: "Name" },
        { key: "weight", label: "Gewicht (kg)" },
        { key: "volume", label: "Volumen (m^3)" },
        { key: "edit", label: "" },
      ],
      stickyHeader: true,
      allMaterialsSelected: false,
      indeterminateMaterial: false,
      selectedMaterials:[],
      material: [],
    };
  },
  methods: {
    toggleAll(checked) {
      this.selectedMaterials = checked ? this.material.slice() : [];
    },
    loadMaterials() {
      this.$http
        .get(process.env.VUE_APP_PATH+"materials", {
          responseType: "json",
        })
        .then((response) => {
          this.material = response.data;
        });
    },
  },
  watch: {
    selectedMaterials(newVal) {
        console.log(this.selectedMaterials)
        this.$emit("selectMaterial", this.selectedMaterials);
      // Handle changes in individual flavour checkboxes
      if (newVal.length === 0) {
        this.indeterminateMaterial = false;
        this.allMaterialsSelected = false;
      } else if (newVal.length === this.material.length) {
        this.indeterminateMaterial = false;
        this.allMaterialsSelected = true;
      } else {
        this.indeterminateMaterial = true;
        this.allMaterialsSelected = false;
      }
    },
  },
  created: function () {
    this.loadMaterials();
  },
};
</script>