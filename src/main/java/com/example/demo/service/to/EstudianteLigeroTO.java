package com.example.demo.service.to;

import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

public class EstudianteLigeroTO extends RepresentationModel<EstudianteLigeroTO> implements Serializable{

    private static final long serialVersionUID = 2L;

    private String nombre;

    private String cedula;

    public EstudianteLigeroTO(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public EstudianteLigeroTO() {
    }

    //Set y Get 

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

}
