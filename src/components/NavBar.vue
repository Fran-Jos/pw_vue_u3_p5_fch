<template>
  
  <div>
    <router-link to="/guardar">Guardar</router-link>
    <router-link to="/eliminar">Eliminar</router-link>
    <router-link to="/actualizar">Actualizar</router-link>
    <router-link to="/consultar">Buscar</router-link>
  </div>
</template>

<script>
export default {};
</script>

<style>
div a {
  color: rgb(163, 196, 164);
  margin: 0px 10px;
  font-weight: bold;
  border: solid;
  padding: 10px 10px;
  border-radius: 10px;
    background-color: #0a735c;
}

.router-link-exact-active{
  color: white;
  background-color: #06392d;
}
</style>