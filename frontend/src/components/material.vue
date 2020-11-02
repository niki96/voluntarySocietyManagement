<template>
  <div class="hello">
    <b-table :items="materials" :busy="isBusy" class="mt-3" outlined>
      <template #table-busy>
        <div class="text-center text-danger my-2">
          <b-spinner class="align-middle"></b-spinner>
          <strong>Loading...</strong>
        </div>
      </template>
    </b-table>
  </div>
</template>

<script>
export default {
  name: 'Material',
  data: function(){
    return {
      materials:[],
      isBusy:false,
      url:'http://localhost:8080/'
    }
  },
  props: {
    msg: String
  }, 
  methods:{
    loadMaterials(){
      this.isBusy = true;
       this.$http
         .get(this.url + "material", {
           responseType: "json"
             })
        .then(response => {
          this.materials= response.data;
          this.isBusy=false;
       },
           response=>{});
    },
    updateMaterial(){

    }, 
    createMaterial(){

    }
  },
  created: function(){
    this.loadMaterials();
  }
}
</script>


