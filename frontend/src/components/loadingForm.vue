<template>
  <div>
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