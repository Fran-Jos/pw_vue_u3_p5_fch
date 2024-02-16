<template>
  <img alt="Vue logo" src="./assets/logo.png">
  <!--<EstudiantePagina/>>-->
  <h1>UCE</h1>
  <router-view/>
  <h1>todos los derechos reservados</h1>
</template>

<script>
import EstudiantePagina from '../src/pages/EstudiantePagina.vue'

export default {
  name: 'App',
  components: {
    EstudiantePagina
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
