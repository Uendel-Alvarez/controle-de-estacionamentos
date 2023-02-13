package com.api.contole.estacionamento.servicos;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.api.contole.estacionamento.modelos.VagaModel;
import com.api.contole.estacionamento.repositorios.VagaRepositorio;

import jakarta.transaction.Transactional;

@Service
public class VagaServico {

	//ponto de injeção da dependencia
	final VagaRepositorio vagaRepositorio;

	public VagaServico(VagaRepositorio vagaRepositorio) {
		//super();
		this.vagaRepositorio = vagaRepositorio;
	}

	@Transactional
	public VagaModel salvar(VagaModel vagaModel) {
		// TODO Auto-generated method stub
		return vagaRepositorio.save(vagaModel);
	}

	public Page<VagaModel> buscaTodas() {
		
		Sort sort = Sort.by("responsavelNome").ascending();
		Pageable pageable = PageRequest.of(0, 2, sort);
		
		return vagaRepositorio.findAll(pageable);
	}
	
	
	
	public Optional<VagaModel> buscaId(UUID id) {
		// TODO Auto-generated method stub
		return vagaRepositorio.findById(id);//atenção para retornar somente os metodos exclusivos da Jpa
	}

	@Transactional
	public void apagar(VagaModel vagaModel) {
		// TODO Auto-generated method stub
		 vagaRepositorio.delete(vagaModel);
		
	}

	
 
}
