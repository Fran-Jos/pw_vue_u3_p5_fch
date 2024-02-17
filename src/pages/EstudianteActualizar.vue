<template>
  
  <h1>Página actualizar</h1>
  <h2>Buscar por ID:</h2>
  <input id="id" v-model="id" type="text" placeholder="Ingrese id" />
      <div class="POST">
      <h2 >INGRESAR DATOS:</h2>
      <form class="form2" action="">
        <p type="DATOS DE ACTUALIZACION DE ESTUDIANTE:"></p>
        <p type="Nombre: "><input v-model="nombreI" type="text"  /></p>
        <p type="Apellido: "><input v-model="apellidoI" type="text" /></p>
        <p type="Genero: "><input v-model="generoI" type="text" /></p>
        <p type="Fecha Nacimiento: ">
          <input v-model="fechaNacimientoI" type="datetime" />
        </p>
      </form>
      <button @click="actualizar">Actualizar</button>
   
    </div>
  

</template>

<script>
import { actualizarFachada } from "../assets/helpers/clienteEstudiante.js";
export default {
  data() {
    return {
      id: null,
      nombreI: null,
      apellidoI: null,
      generoI: null,
      fechaNacimientoI: null,
    };
  },
  methods: {
    async actualizar() {
      const body = {
        nombre: this.nombreI,
        apellido: this.apellidoI,
        genero: this.generoI,
        fechaNacimiento: this.fechaNacimientoI,
      };
      await actualizarFachada(this.id, body);
    },
  },
};


</script>

<style>

</style>