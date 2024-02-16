<template>
  <h1>Página eliminar</h1>
  <input id="id" v-model="id" type="text" placeholder="Ingrese id" />

  <button @click="eliminar">ELIMINAR</button>
</template>

<script>

import { eliminarFachada } from "../assets/helpers/clienteEstudiante.js";
export default {
  data() {
    return {
      id: null,
    };
  },
  methods: {
    async eliminar() {
      await eliminarFachada(this.id);
    },
  },
};

</script>

<style>
</style>