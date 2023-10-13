package com.example.ClienteAplicacao.clientes.piloto.domain;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class PilotoSaida {

    private Long id;
    @JsonProperty("nome")
    private String nome;

    @JsonProperty("nacionalidade")
    private String nacionalidade;

    @JsonProperty("equipe")
    private String equipe;
}
