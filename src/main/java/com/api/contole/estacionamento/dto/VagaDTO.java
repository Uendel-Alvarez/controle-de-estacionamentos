package com.api.contole.estacionamento.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class VagaDTO {

	    @NotBlank
	    private String numeroVaga;
	    @NotBlank
	    @Size(max = 7)
	    private String placaCarro;
	    @NotBlank
	    private String marcaCarro;
	    @NotBlank
	    private String modeloCarro;
	    @NotBlank
	    private String corCarro;
	    @NotBlank
	    private String responsavelNome;
	    @NotBlank
	    private String apartamento;
	    @NotBlank
	    private String bloco;
}
