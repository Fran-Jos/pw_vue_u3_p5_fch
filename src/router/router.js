import { createRouter, createWebHashHistory } from "vue-router";



//a cada pagina le vamos asignar una ruta   

const routes = [
    {
        path: '/guardar',
        //component: EstudianteGuardar
        component: () => import('../pages/EstudianteGuardar.vue')
    },
    {
        path: '/consultar/:id',
       // component: EstudianteConsultar
         component: () => import('../pages/EstudianteConsultar.vue')
    },
    {
        path: '/actualizar',
        //component: EstudianteActualizar
        component: () => import('../pages/EstudianteActualizar.vue')
    },
    {
        path: '/eliminar',
        //component: EstudianteEliminar
        component: () => import('../pages/EstudianteEliminar.vue')
    },
    { 
        //wildcard para cuando ingrese mal una pagina
        path: '/:pathMatch(.*)*',
        //component:NoFoundPage
        component: () => import('../pages/NoFoundPage.vue')
    }
]

const router = createRouter(
    {
        history: createWebHashHistory(),
        routes
    }
)

export default router;
