<template>
    //componente router
    // router es un componente que me permiter gestionar las paginas , rutas , 
    //reglas de navegacion.
    <h1>Página Guardar</h1>
 
    <div class="POST">
      <h2 id="titulo2">INGRESAR DATOS:</h2>
      <form class="form2" action="">
        <p type="DATOS DEL INGRESO DE ESTUDIANTE:"></p>
        <p type="Nombre: "><input v-model="nombreI" type="text"  /></p>
        <p type="Apellido: "><input v-model="apellidoI" type="text" /></p>
        <p type="Genero: "><input v-model="generoI" type="text" /></p>
        <p type="Fecha Nacimiento: ">
          <input v-model="fechaNacimientoI" type="datetime" />
        </p>
      </form>
      <button @click="insertar">Insertar</button>
   
    </div>

</template>

<script>

import { insertarFachada } from "../assets/helpers/clienteEstudiante.js";
export default {
    data() {
        return {

        nombreI: null,
        apellidoI: null,
        generoI: null,
        fechaNacimientoI: null,
        };
    },
    methods: {
        async insertar() {
            const body = {
                nombre: this.nombreI,
                apellido: this.apellidoI,
                genero: this.generoI,
                fechaNacimiento: this.fechaNacimientoI,
            };
            await insertarFachada(body);
        },
    },
    };


</script>

<style>

</style>