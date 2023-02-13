package com.api.contole.estacionamento.modelos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TABELA_DE_VAGAS")
public class VagaModel implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 10)
    private String numeroVaga;
    @Column(nullable = false, unique = true, length = 7)
    private String placaCarro;
    @Column(nullable = false, length = 70)
    private String marcaCarro;
    @Column(nullable = false, length = 70)
    private String modeloCarro;
    @Column(nullable = false, length = 70)
    private String corCarro;
    @Column(nullable = false)
    private LocalDateTime registroData;
    @Column(nullable = false, length = 130)
    private String responsavelNome;
    @Column(nullable = false, length = 30)
    private String apartamento;
    @Column(nullable = false, length = 30)
    private String bloco;
}
