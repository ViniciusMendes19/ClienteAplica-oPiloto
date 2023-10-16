package com.example.ClienteAplicacao.clientes.piloto.domain;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PilotoSaida {

    private Long id;
    @JsonProperty("nome")
    private String nome;

    @JsonProperty("nacionalidade")
    private String nacionalidade;

    @JsonProperty("equipe")
    private String equipe;
}
