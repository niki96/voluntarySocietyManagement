<template>
  <div>
    <b-button class="btn btn-success" @click="modalShow = !modalShow">
      <font-awesome-icon icon="plus-square"
    /> </b-button>
    <!-- Modal Component -->
    <b-modal id="modal1" v-model="modalShow" @ok="saveMaterial">
      <div class="text-left" slot="modal-header">Material hinzufügen</div>
      <b-form id="materialForm" ref="materialForm">
        <b-form-group
          id="input-group-1"
          label="Material Name"
          label-for="input-1"
        >
          <b-form-input
            id="input-1"
            v-model="material.name"
            
            required
            placeholder="Name eingeben"
          ></b-form-input>
        </b-form-group>
        <b-form-group
          id="input-group-2"
          label="Volumen (m^3)"
          label-for="input-2"
        >
          <b-form-input
            id="input-2"
            v-model="material.volume"
            type="number"
            required
            placeholder="Volumen eingeben"
          ></b-form-input>
        </b-form-group>
        <b-form-group
          id="input-group-3"
          label="Gewicht (kg)"
          label-for="input-3"
        >
          <b-form-input
            id="input-3"
            v-model="material.weight"
            type="number"
            required
            placeholder="Gewicht eingeben"
          ></b-form-input>
        </b-form-group>
      </b-form>
      <div class="text-left">{{responsemsg}}</div>
      <div slot="modal-footer" class="">
        
        <button class="btn btn-success" @click="saveMaterial()">Save</button>
      </div>
    </b-modal>
  </div>
</template>
<script>
export default {
  name: "materialForm",
  data: function () {
    return {
    responsemsg:"",
      modalShow: false,
      material: {
        name: "",
        volume: 0,
        weight: 0,
      },
    };
  },
  methods: {
    saveMaterial() {
       // this.$refs.materialForm.submit();
      console.log("Save Material Input");
      this.axios
        .post(
          "http://localhost:8080/api/v1/material",
          JSON.stringify(this.material),
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
      //TODO: REST Call for saving
    },
  },
 
};
</script>