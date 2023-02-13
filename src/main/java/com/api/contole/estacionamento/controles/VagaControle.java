package com.api.contole.estacionamento.controles;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.contole.estacionamento.dto.VagaDTO;
import com.api.contole.estacionamento.modelos.VagaModel;
import com.api.contole.estacionamento.servicos.VagaServico;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/vagas-estacionamento")
public class VagaControle {

	final VagaServico vagaServico;

	public VagaControle(VagaServico vagaServico) {
		super();
		this.vagaServico = vagaServico;
	}
	
	@PostMapping
	public ResponseEntity<Object> salvaVaga(@RequestBody @Valid VagaDTO vagaDTO) {
		
		VagaModel vagaModel = new VagaModel();
		BeanUtils.copyProperties(vagaDTO, vagaModel);
		vagaModel.setRegistroData(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.CREATED).body(vagaServico.salvar(vagaModel));
	}
	
	@GetMapping
	public ResponseEntity<Page<VagaModel>> listaTodas(){
		return ResponseEntity.status(HttpStatus.OK).body(vagaServico.buscaTodas());
		
	}
		
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> listaPorId(@PathVariable(value = "id")UUID id){
		Optional<VagaModel> vagaModelOptional = vagaServico.buscaId(id);
		if (!vagaModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga não encontrada!");
		}
		return ResponseEntity.status(HttpStatus.OK).body(vagaModelOptional.get());
 	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> apagarVaga(@PathVariable(value = "id")UUID id){
		Optional<VagaModel> vagaModelOptional = vagaServico.buscaId(id);
		if (!vagaModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga não encontrada!");
		}
		vagaServico.apagar(vagaModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Vaga foi apagada com sucesso!!!");
		
	
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> autalizar(@PathVariable(value = "id") UUID id, @RequestBody @Valid VagaDTO vagaDTO){
		
			Optional<VagaModel> vagaModelOptional = vagaServico.buscaId(id);
			if (!vagaModelOptional.isPresent()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga não encontrada!");
			}
		/** primera maneira: abaixo é uma variavel que invoca o get
		 
	    var vagaModel= vagaModelOptional.get();
	    vagaModel.setNumeroVaga(vagaDTO.getNumeroVaga());
		vagaModel.setPlacaCarro(vagaDTO.getPlacaCarro());
		vagaModel.setModeloCarro(vagaDTO.getModeloCarro());
		vagaModel.setMarcaCarro(vagaDTO.getMarcaCarro());
		vagaModel.setCorCarro(vagaDTO.getCorCarro());
		vagaModel.setResponsavelNome(vagaDTO.getResponsavelNome());
		vagaModel.setApartamento(vagaDTO.getApartamento());
		vagaModel.setBloco(vagaDTO.getBloco());
		*/
	    
	    /**segunda maneira*/
			
		var vagaModel = new VagaModel();
		BeanUtils.copyProperties(vagaDTO, vagaModel);
		vagaModel.setId(vagaModelOptional.get().getId());
		vagaModel.setRegistroData(vagaModelOptional.get().getRegistroData());
		return ResponseEntity.status(HttpStatus.OK).body(vagaServico.salvar(vagaModel));
		
	}
	
	
}
