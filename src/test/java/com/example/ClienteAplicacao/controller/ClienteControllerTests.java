package com.example.ClienteAplicacao.controller;

import com.example.ClienteAplicacao.clientes.piloto.client.PilotoClient;
import com.example.ClienteAplicacao.clientes.piloto.domain.PilotoEntrada;
import com.example.ClienteAplicacao.clientes.piloto.domain.PilotoSaida;
import com.example.ClienteAplicacao.clientes.piloto.service.PilotoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class ClienteControllerTests {

    @InjectMocks
    ClienteController clienteController;

    @Mock
    private PilotoService pilotoService;

    PilotoEntrada pilotoEntrada = PilotoEntrada.builder()
            .nome("Pedro")
            .nacionalidade("Brasileiro")
            .equipe("Mercedes")
            .build();

    PilotoSaida pilotoSaida = PilotoSaida.builder()
            .id((long)2)
            .nome("Pedro")
            .nacionalidade("Brasileiro")
            .equipe("Mercedes")
            .build();

    @Test
    void quandoAdicionarPilotoRetornarSucesso(){
        Mockito.when(pilotoService.adicionaPiloto(pilotoEntrada)).thenReturn(ResponseEntity.status(HttpStatus.CREATED).body(pilotoSaida));

    }

}
