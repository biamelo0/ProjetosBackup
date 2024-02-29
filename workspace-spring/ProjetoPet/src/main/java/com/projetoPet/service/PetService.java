package com.projetoPet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoPet.dto.PetDTO;
import com.projetoPet.entities.pet;
import com.projetoPet.repository.PetRepository;

@Service
public class PetService {
	private final PetRepository petRepository; 

	@Autowired 
	public PetService (PetRepository petRepository) { 
		this.petRepository = petRepository; 
	} 
	public PetDTO salvar (PetDTO petDTO) {
		pet pet = new pet (petDTO.nome(),petDTO.documento(), petDTO.nascimento());
		pet salvarPet = petRepository.save(pet);
		return new PetDTO(salvarPet.getId(), salvarPet.getNome(),salvarPet.getDocumento(),
		        salvarPet.getNascimento());
	}
	 public PetDTO atualizar(Long id,PetDTO petDTO) {
		 pet existePet = petRepository.findById(id).orElseThrow(() -> new 
				 RuntimeException ("Pet não encontrado"));
				 
				 existePet.setNome(petDTO.nome());
		 		 existePet.setDocumento(petDTO.documento());
		 		existePet.setNascimento(petDTO.nascimento());
		 		 
		 		pet updatePet = petRepository.save(existePet);
		 		 return new PetDTO (updatePet.getId(), updatePet.getNome(),updatePet.getDocumento(),updatePet.getNascimento());
	 }
	 public boolean deletar (Long id) {
		 Optional <pet> existePet = petRepository.findById(id);
		 if (existePet.isPresent()) {
			 petRepository.deleteById(id);
			 return true;
		 }
		 return false;
	 }
	 public List<pet>buscarTodos(){
		 return petRepository.findAll();
	 }
	 public pet buscarPorId(Long id) {
		 Optional <pet> pet = petRepository.findById(id);
		 return pet.orElse(null);
	 } 
}