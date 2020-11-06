<template>
  <div>
      <b-card>
         <b-input
            id="input-1"
            v-model="name"
            required
            placeholder="Name eingeben"
          ></b-input>
      </b-card>
      <vehicleSelectTable @selectVehicle="handleVehicleSelectionEvent"></vehicleSelectTable>
      <materialSelectTable @selectMaterial="handleMaterialSelectionEvent"></materialSelectTable>
  </div>
</template>

<script>
import materialSelectTable from "./materialSelectTable";
import vehicleSelectTable from "./vehicleSelectTable";
export default {
  name: "loadingForm",
  components:{
      vehicleSelectTable:vehicleSelectTable,
      materialSelectTable:materialSelectTable
  },
  data: function () {
    return {
      name:"",
      materialSelection: [],
      vehicleSelection:[]
    };
  },
  methods: {
   handleMaterialSelectionEvent(eventdata){
       this.materialSelection = eventdata;
   },
   handleVehicleSelectionEvent(eventData){
       this.vehicleSelection = eventData;
   }
  },
  watch: {
   materialSelection(){
       console.log("Parent:", this.materialSelection)
   },
   vehicleSelection(){
       console.log("Parent: ", this.vehicleSelection)
   }
  },
 
};
</script>