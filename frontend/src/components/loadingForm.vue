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

       <b-button class="btn btn-success" @click="createLoading()">
         Starte Berechnung
    /> </b-button>
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
   },
   createLoading(){
      if(this.materialSelection.length >0 && this.vehicleSelection.length>0 && this.name != ""){
        let materialIds = this.materialSelection.map(a =>a.id);
        console.log("MaterialIDs: ",materialIds);
        let vehicleIds = this.vehicleSelection.materialIds(b=>b.id);
        console.log("Vehicle IDs: ", vehicleIds);
        let reqestObj = {};
        reqestObj.name = this.name;
        reqestObj.materialIdCollection = materialIds;
        reqestObj.vehicleIdCollection = vehicleIds;
        this.axios.post("http://localhost:8080/api/v1/knapsackSolutions",
          JSON.stringify(reqestObj),
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
      }
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