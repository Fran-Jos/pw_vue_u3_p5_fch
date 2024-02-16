import { createRouter, createWebHashHistory } from "vue-router";

import EstudianteActualizar from '../pages/EstudianteActualizar.vue'
import EstudianteConsultar from '../pages/EstudianteConsultar.vue'
import EstudianteEliminar from '../pages/EstudianteEliminar.vue'
import EstudianteGuardar from '../pages/EstudianteGuardar.vue'


//a cada pagina le vamos asignar una ruta

const routes = [
    {
        path: '/guardar',
        component: EstudianteGuardar
    },
    {
        path: '/consultar',
        component: EstudianteConsultar
    },
    {
        path: '/actualizar',
        component: EstudianteActualizar
    },
    {
        path: '/eliminar',
        component: EstudianteEliminar
    }
]

const router = createRouter(
    {
        history: createWebHashHistory(),
        routes
    }
)

export default router;
