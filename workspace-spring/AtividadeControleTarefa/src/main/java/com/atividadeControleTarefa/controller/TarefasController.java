package com.atividadeControleTarefa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atividadeControleTarefa.entities.Tarefas;
import com.atividadeControleTarefa.service.TarefasService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tarefas")
public class TarefasController {
	private final TarefasService tarefasService;  

	@Autowired  
	public TarefasController(TarefasService tarefasService) {  
	this.tarefasService = tarefasService;  
	}  

	@PostMapping("/")  
	public ResponseEntity<Tarefas> createTarefas(@RequestBody @Valid Tarefas tarefas) {  
		Tarefas salvaTarefas = tarefasService.salvaTarefas(tarefas);  
	return ResponseEntity.status(HttpStatus.CREATED).body(salvaTarefas);  
	}  

	@PutMapping("/{id}")   
	public ResponseEntity<Tarefas> alteraTarefasControl(@PathVariable Long id, @RequestBody @Valid Tarefas tarefas){  
		Tarefas alteraTarefas = tarefasService.alteraTarefas(id, tarefas);  
		if (alteraTarefas != null) { 
			return ResponseEntity.ok(tarefas);  
		}  
		else {  
			return ResponseEntity.notFound().build();  
		}  
	}  

	@GetMapping("/{id}")  
		public ResponseEntity<Tarefas> buscaTarefasControlId (@PathVariable Long id){  
			Tarefas tarefas = tarefasService.buscaTarefasById(id);  
			if(tarefas != null) {  
				return ResponseEntity.ok(tarefas);  
			} 
			else {  
				return ResponseEntity.notFound().build();  
			} 
		}  

	@GetMapping("/")   
	public ResponseEntity<List<Tarefas>> buscaTodosTarefassControl(){  
		List<Tarefas> tarefas = tarefasService.buscaTodosTarefass();  
		return ResponseEntity.ok(tarefas);  
	}  

	@DeleteMapping("/{id}")  
	public ResponseEntity<Tarefas> apagarTarefasControl(@PathVariable Long id){  
		boolean apagar = tarefasService.apagarTarefas(id);  
		if (apagar) {  
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  
		}  
		else {  
			return ResponseEntity.notFound().build(); 	}  

	} 

}