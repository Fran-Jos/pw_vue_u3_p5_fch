/*
 * 
 */


package com.example.demo.controller;

// apunte de estas dos importaciones 
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;
import com.example.demo.service.IMateriaService;
import com.example.demo.service.to.EstudianteLigeroTO;
import com.example.demo.service.to.EstudianteTO;
import com.example.demo.service.to.MateriaTO;

//Una API puede tener muchos servicios
//API: determinada por el proyecto Java
//Un servicio tiene muchas capacidades
//Con una clase controller se implementa un controlador rest en una API
//Servicio -> Controller: Clase controller

@RestController // Servicio
@RequestMapping(path = "/estudiantes")
public class EstudianteControllerRestFul {

	@Autowired
	private IEstudianteService estudianteService;

	@Autowired
	private IMateriaService iMateriaService;
	// Métodos: Capacidades

	// Path Variable registro único
	// http://pokemon.com/API/v1/jugadores/pokemon/consultar/3
	// .../consultar/3
	// ...../consultar/{3}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/{id} GET
	// GET
	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<EstudianteTO> buscar(@PathVariable Integer id) {
		// 240: grupo de solicitud satisfactoria
		// 240: Recurso Estudiante encontrado satisfactoriamente
		EstudianteTO estu = this.estudianteService.buscarTO(id);
		System.out.println("Es este"+estu);

		Link link = linkTo(methodOn(EstudianteControllerRestFul.class).consultarMateriaPorId(estu.getId()))
				.withRel("materias");
		Link link2 = linkTo(methodOn(EstudianteControllerRestFul.class).buscar(estu.getId()))
				.withSelfRel();
		estu.add(link);
		estu.add(link2);

		// 200: ok
		// 401: autenticación

		return ResponseEntity.status(241).body(estu);
	}

	@GetMapping(path = "/cedula&nombre/{id}", produces = "application/json")
	public ResponseEntity<EstudianteLigeroTO> buscarLigero(@PathVariable Integer id) {
		// 240: grupo de solicitud satisfactoria
		// 240: Recurso Estudiante encontrado satisfactoriamente
		EstudianteLigeroTO estu = this.estudianteService.buscarLigeroTO(id);
		// 200: ok
		// 401: autenticación
		Link link = linkTo(methodOn(EstudianteControllerRestFul.class).buscarLigero(id)).withRel("estudianteLigeroTO");
		estu.add(link);
		return ResponseEntity.status(240).body(estu);
	} 

	// @RequestParam -> filtrar en un conjunto o lista de datos
	// http://pokemon.com/API/v1/jugadores/pokemon/consultar?genero=M
	// http://localhost:8080/API/v1.0/Matricula/estudiantes{genero} GET
	@GetMapping(path = "/tmp", produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<List<Estudiante>> buscarTodos(
			@RequestParam(required = false, defaultValue = "M") String genero) {
		List<Estudiante> lista = this.estudianteService.buscarTodos(genero);
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_242", "Lista consultada de maneras exitosa");
		return new ResponseEntity<>(lista, cabeceras, 242);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void guardar(@RequestBody Estudiante estudiante) {
		this.estudianteService.guardar(estudiante);
	}

	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualizar(@RequestBody Estudiante estudiante, @PathVariable Integer id) {
		estudiante.setId(id);
		this.estudianteService.actualizar(estudiante);
	}

	@PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualizarParcial(@RequestBody Estudiante estudiante, @PathVariable Integer id) {
		this.estudianteService.actualizarParcial(estudiante.getApellido(), estudiante.getNombre(), id);
	}

	@DeleteMapping(path = "/{id}")
	public void borrar(@PathVariable Integer id) {
		this.estudianteService.eliminar(id);

	}
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar

	// ------------------------HATEOAS
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EstudianteTO>> buscarTodosHateoas() {
		List<EstudianteTO> lista = this.estudianteService.buscarTodosTO();

		for (EstudianteTO est : lista) {
			Link link = linkTo(methodOn(EstudianteControllerRestFul.class).consultarMateriaPorId(est.getId()))
					.withRel("materias");
			est.add(link);

		}

		return ResponseEntity.status(HttpStatus.OK).body(lista);

	}

	// http://localhost:8080//API/v1.0/Matricula/estudiantes/ GET
	// http://localhost:8080//API/v1.0/Matricula/estudiantes/1 GET
	// http://localhost:8080//API/v1.0/Matricula/estudiantes/1/materias GET
	@GetMapping(path = "/{id}/materias", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MateriaTO>> consultarMateriaPorId(@PathVariable Integer id) {
		List<MateriaTO> lista = this.iMateriaService.buscarPorIdMateria(id);
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}

// http://localhost:8080//API/v1.0/Matricula/estudiantes/1 GET
	@GetMapping(path = "/completo/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EstudianteTO>consultar(@PathVariable Integer id){
		EstudianteTO estu =this.estudianteService.buscarTO(id) ;
		Link link1 = linkTo(methodOn(EstudianteControllerRestFul.class).buscarLigero(id)).withRel("estudianteLigero");
		Link link2 = linkTo(methodOn(EstudianteControllerRestFul.class).buscar(id)).withRel("EstudianteTO");
		
		estu.add(link1);
		estu.add(link2);
		return ResponseEntity.status(240).body(estu);
	}

}
