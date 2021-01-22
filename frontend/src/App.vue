<template>
  <div id="app">
    <b-navbar toggleable="lg" type="dark" variant="info">
      <b-navbar-brand href="#">{{$t("navigation.title")}}</b-navbar-brand>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav>
          <b-nav-item href="#/">{{$t("navigation.material")}}</b-nav-item>
          <b-nav-item href="#/vehicle">{{$t("navigation.vehicle")}}</b-nav-item>
          <b-nav-item href="#/loading">{{$t("navigation.loading")}}</b-nav-item>
        </b-navbar-nav>

        <!-- Right aligned nav items -->
        <b-navbar-nav class="ml-auto">
          <b-nav-item-dropdown right>
            <!-- Using 'button-content' slot -->
            <template #button-content>
              <em>{{$t("navigation.user")}}</em>
            </template>
            <b-dropdown-item href="#">{{$t("navigation.profile")}}</b-dropdown-item>
            <b-dropdown-item href="#">{{$t("navigation.logoff")}}</b-dropdown-item>
          </b-nav-item-dropdown>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
    
    <router-view />
  </div>
</template>

<script>
import "bootstrap/dist/css/bootstrap.css";
import "bootstrap-vue/dist/bootstrap-vue.css";
export default {
  name: "App",
};
</script>

