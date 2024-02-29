package com.atividadeControleTarefa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atividadeControleTarefa.entities.Tarefas;

public interface TarefasRepository extends JpaRepository <Tarefas, Long>{

}