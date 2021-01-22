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
        { key: "id", label: this.$i18n.t("columns.id") },
        { key: "name", label: this.$i18n.t("columns.name") },
        { key: "maxWeight", label: this.$i18n.t("columns.additionalLoadingWeight") },
        { key: "maxVolume", label: this.$i18n.t("columns.additionalLoadingVolume") },
        { key: "edit", label: "" },
      ],
      stickyHeader: true
    };
  },
  methods: {
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