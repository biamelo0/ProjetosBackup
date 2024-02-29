package com.projetoPet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoPet.entities.pet;

public interface PetRepository extends JpaRepository <pet, Long>{
}