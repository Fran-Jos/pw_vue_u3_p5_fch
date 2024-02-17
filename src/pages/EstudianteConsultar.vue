<template>
  <h1>Página consultar</h1>
  <h2>Buscar por ID:</h2>
  <input id="id" v-model="id" type="text" placeholder="Ingrese id" />
  <button @click="consultar ">CONSULTAR</button>

  <form class="form" action="">
    <p type="DATOS DEL ESTUDIANTE:"></p>
    <p type="Nombre: ">
      <input v-model="nombre" type="text" placeholder="Ingrese nombre" />
    </p>
    <p type="Apellido: ">
      <input v-model="apellido" type="text" placeholder="Ingrese apellido" />
    </p>
    <p type="Genero: "><input v-model="genero" type="text" /></p>
    <p type="Fecha Nacimiento: ">
      <input v-model="fechaNacimiento" type="text" />
    </p>
  </form>
</template>

<script>
import { consutarEstudianteFachada } from "../assets/helpers/clienteEstudiante.js";

export default {
  data() {
    return {
      id: null,
      nombre: null,
      apellido: null,
      genero: null,
      fechaNacimiento: null,
    };
  },
  methods: {
    async consultar() {
      const estudiante = await consutarEstudianteFachada(this.id);
      this.nombre = estudiante.nombre;
      this.apellido = estudiante.apellido;
      this.genero = estudiante.genero;
      this.fechaNacimiento = estudiante.fechaNacimiento;
    },
  },
};
</script>

<style>
</style>