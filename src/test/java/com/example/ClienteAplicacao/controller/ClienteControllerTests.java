package com.example.ClienteAplicacao.controller;

import com.example.ClienteAplicacao.clientes.piloto.domain.PilotoEntrada;
import com.example.ClienteAplicacao.clientes.piloto.domain.PilotoSaida;
import com.example.ClienteAplicacao.clientes.piloto.exceptions.ErroSolicitacao;
import com.example.ClienteAplicacao.service.PilotoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ClienteControllerTests {

    @InjectMocks
    private ClienteController clienteController;

    @Mock
    private PilotoService pilotoService;

    @Mock
    PilotoEntrada pilotoEntrada;

    @Mock
    PilotoSaida pilotoSaida;


    @Test
    public void testeAdicionaPilotoSucesso() {
        pilotoEntrada = new PilotoEntrada("Teste", "Teste", "Team1");
        pilotoSaida = new PilotoSaida(1L, "Teste", "Teste", "Team1");

        Mockito.when(pilotoService.adicionaPiloto(pilotoEntrada)).thenReturn(ResponseEntity.status(HttpStatus.CREATED).body(pilotoSaida));

        ResponseEntity<PilotoSaida> response = clienteController.adicionaPiloto(pilotoEntrada);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertEquals(pilotoSaida, response.getBody());
    }

    @Test
    public void testeAdicionaPilotoErro() {
        PilotoEntrada pilotoEntrada = new PilotoEntrada("", "", "");

        try {
            clienteController.adicionaPiloto(pilotoEntrada);
        } catch (Exception e) {
            Assertions.assertThrows(ErroSolicitacao.class, () -> clienteController.adicionaPiloto(pilotoEntrada));
        }
    }
}