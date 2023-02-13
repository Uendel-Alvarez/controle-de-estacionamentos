package com.api.contole.estacionamento;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@RestController
@OpenAPIDefinition(
		info = @Info(title = "Api teste para Controle de Estacionamentos", version = "única", 
		description = "Testes" ),
		servers = {
				@Server(url = "http://localhost:8080")
				
		}
)
public class ControleEstacionamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControleEstacionamentoApplication.class, args);
	}
/**
	@GetMapping("/")
	public String index() {
		return "*****APLICAÇÃO DE CONTROLE DE VAGAS EM ESTACIONAMENTO*****";
	}
	*/
}
