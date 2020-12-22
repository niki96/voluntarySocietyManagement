<template>
  <div >
    <b-card>
      <b-form-group>
        <template #label>
          <b>{{$t("table.selectVehicles")}}</b><br />
          <b-form-checkbox
            v-model="allVehiclesSelected"
            :indeterminate="indeterminateVehicle"
            @change="toggleAll"
          >
            {{ allVehiclesSelected ? $t("table.unselectAll") : $t("table.selectAll")}}
          </b-form-checkbox>
        </template>
      </b-form-group>
      <b-table
        :sticky-header="stickyHeader"
        :fields="fields"
        :items="vehicles"
        :busy="isBusy"
        class="mt-3"
        hover
        outlined
      >
      <template #cell(checked)="data">
          <b-form-checkbox
            name="selected-items"
            v-model="selectedVehicles"
            :value="data.item"
          >
          </b-form-checkbox>
        </template>
        <template #table-busy>
          <div class="text-center text-danger my-2">
            <b-spinner class="align-middle"></b-spinner>
            <strong>{{$t("table.load")}}</strong>
          </div>
        </template>
      </b-table>
    </b-card>
  </div>
</template>

<script>
export default {
    name: "vehicleSelectTable",
  data: function () {
    return {
      allVehiclesSelected: false,
      indeterminateVehicle: false,
      selectedVehicles: [],
      vehicles: [],
      isBusy: false,
      fields: [
        { key: "checked", label: "" },
        { key: "name", label: this.$i18n.t("columns.name") },
        { key: "maxWeight", label: this.$i18n.t("columns.additionalLoadingWeight") },
        { key: "maxVolume", label: this.$i18n.t("columns.additionalLoadingVolume") }
      ],
      stickyHeader: true
    };
  },
  methods: {
      toggleAll(checked) {
      this.selectedVehicles = checked ? this.vehicles.slice() : [];
    },
    loadVehicles() {
      this.isBusy = true;
      this.$http
        .get(process.env.VUE_APP_PATH + "vehicles", {
          responseType: "json",
        })
        .then((response) => {
          this.vehicles = response.data;
          this.isBusy = false;
        });
    },
  },
  watch: {
    selectedMaterials(newVal) {
        console.log(this.selectedVehicles)
        this.$emit("selectVehicle", this.selectedVehicles);
      // Handle changes in individual flavour checkboxes
      if (newVal.length === 0) {
        this.indeterminateMaterial = false;
        this.allMaterialsSelected = false;
      } else if (newVal.length === this.vehicles.length) {
        this.indeterminateMaterial = false;
        this.allMaterialsSelected = true;
      } else {
        this.indeterminateMaterial = true;
        this.allMaterialsSelected = false;
      }
    },
  },
  created: function () {
    this.loadVehicles();
  },
};
</script>