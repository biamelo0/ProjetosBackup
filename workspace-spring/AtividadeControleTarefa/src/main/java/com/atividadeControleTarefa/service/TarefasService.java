package com.atividadeControleTarefa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atividadeControleTarefa.entities.Tarefas;
import com.atividadeControleTarefa.repository.TarefasRepository;


@Service
public class TarefasService {
	private final TarefasRepository tarefasRepository; 

	@Autowired 
	public TarefasService (TarefasRepository tarefasRepository) { 
		this.tarefasRepository = tarefasRepository; 
	} 

	public List<Tarefas> buscaTodosTarefass(){ 
		return tarefasRepository.findAll(); 
	} 

	public Tarefas buscaTarefasById(Long id) { 
		Optional <Tarefas> tarefas = tarefasRepository.findById(id); 
		return tarefas.orElse(null); 
	} 

	public Tarefas salvaTarefas (Tarefas tarefas) { 
		return tarefasRepository.save(tarefas); 
	} 

	public Tarefas alteraTarefas(long id, Tarefas alteraTarefas) { 
		Optional <Tarefas> existeTarefas = tarefasRepository.findById(id); 
		if (existeTarefas.isPresent()) { 
			alteraTarefas.setId(id); 
			return tarefasRepository.save(alteraTarefas); 
		} 
		return null; 
	} 

	public boolean apagarTarefas(Long id) { 
		Optional <Tarefas> existeTarefas = tarefasRepository.findById(id); 
		if (existeTarefas.isPresent()) { 
			tarefasRepository.deleteById(id); 
			return true; 
		} 
		return false; 
	} 
	
	

}