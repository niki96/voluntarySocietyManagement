<template>
  <div>
    <b-button class="btn btn-success" @click="modalVehicleShow = !modalVehicleShow">
      <font-awesome-icon icon="plus-square"
    /> </b-button>
    <!-- Modal Component -->
    <b-modal id="modal2" v-model="modalVehicleShow" @ok="saveVehicle">
      <div class="text-left" slot="modal-header">{{$t("forms.addVehicle")}}</div>
      <b-form id="VehicleForm" ref="vehicleForm">
        <b-form-group
          id="input-group-1"
          :label="$t('forms.lableName', {msg:'Fahrzeug'})"
          label-for="input-1"
        >
          <b-form-input
            id="input-1"
            v-model="vehicle.name"
            required
            :placeholder="$t('forms.placeholderName')"
          ></b-form-input>
        </b-form-group>
        <b-form-group
          id="input-group-2"
          :label="$t('columns.additionalLoadingVolume')"
          label-for="input-2"
        >
          <b-form-input
            id="input-2"
            v-model="vehicle.maxVolume"
            type="number"
            required
            placeholder="Volumen eingeben"
          ></b-form-input>
        </b-form-group>
        <b-form-group
          id="input-group-3"
          :label="$t('columns.additionalLoadingWeight')"
          label-for="input-3"
        >
          <b-form-input
            id="input-3"
            v-model="vehicle.maxWeight"
            type="number"
            required
            placeholder="Gewicht eingeben"
          ></b-form-input>
        </b-form-group>
      </b-form>
      <div class="text-left">{{responsemsg}}</div>
      <div slot="modal-footer" class="">
        
        <button class="btn btn-success" @click="saveVehicle()">{{$t("forms.save")}}</button>
      </div>
    </b-modal>
  </div>
</template>
<script>
export default {
  name: "vehicleForm",
  data: function () {
    return {
    responsemsg:"",
      modalVehicleShow: false,
      vehicle: {
        name: "",
        maxVolume: 0,
        maxWeight: 0,
      },
    };
  },
  methods: {
    saveVehicle() {
       // this.$refs.materialForm.submit();
      console.log("Save Material Input");
      this.axios
        .post(
          process.env.VUE_APP_PATH+"vehicle",
          JSON.stringify(this.vehicle),
          {
            headers: {
              accept: "application/json",
              "content-type": "application/json",
            },
          }
        )
        .then(function (response) {
          console.log(response);
          this.responsemsg="Successfully created";
        }.bind(this))
        .catch(function (error) {
          console.log(error);
          this.responsemsg="Errors during Creation created";
        });
   
    },
  },
 
};
</script>