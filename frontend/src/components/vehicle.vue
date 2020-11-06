<template>
  <div >
    <b-card>
      <vehicleForm></vehicleForm>
      <b-table
        :sticky-header="stickyHeader"
        :fields="fields"
        :items="vehicles"
        :busy="isBusy"
        class="mt-3"
        hover
        outlined
      >
        <template #cell(edit)="data">
          <b-button @click="updateVehicle(data.item)">
            <font-awesome-icon icon="edit" />
          </b-button>
        </template>
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
import  vehicleForm from "./vehicleForm";
export default {
  components: {
    vehicleForm:vehicleForm
  },
  data: function () {
    return {
      vehicles: [],
      isBusy: false,
      fields: [
        { key: "id", label: "ID" },
        { key: "name", label: "Name" },
        { key: "maxWeight", label: "Zuladungsgewicht (kg)" },
        { key: "maxVolume", label: "Zuladungsvolumen (m^3)" },
        { key: "edit", label: "" },
      ],
      stickyHeader: true,
      url: "http://localhost:8080/api/v1/",
    };
  },
  methods: {
    loadVehicles() {
      this.isBusy = true;
      this.$http
        .get(this.url + "vehicles", {
          responseType: "json",
        })
        .then((response) => {
          this.vehicles = response.data;
          this.isBusy = false;
        });
    },
    reload() {
      this.materials = [];
      this.loadVehicles();
    },
    updateVehicle(vehicle) {
      console.log(vehicle);
    },
  },
  created: function () {
    this.loadVehicles();
  },
};
</script>