package com.api.contole.estacionamento.repositorios;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.contole.estacionamento.modelos.VagaModel;

@Repository
public interface VagaRepositorio extends JpaRepository<VagaModel, UUID>{

	boolean findByPlacaCarro(String placaCarro);

	
	
   

}
