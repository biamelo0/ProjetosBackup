package com.atividadeControleTarefa.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tarefas")
public class Tarefas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name="nome")
	@NotNull
	private String nome;
	
	@Column(name="dataFinalExecucao")
	@NotNull
	private String dataFinalExecucao;
	
	@Column(name="descricaoTarefa")
	@NotNull
	private String descricaoTarefa;
	
	@Column(name="statusTarefa")
	@NotNull
	private String statusTarefa;

}