package com.example.ClienteAplicacao.service;

import com.example.ClienteAplicacao.clientes.piloto.client.PilotoClient;
import com.example.ClienteAplicacao.clientes.piloto.domain.PilotoEntrada;
import com.example.ClienteAplicacao.clientes.piloto.domain.PilotoSaida;
import com.example.ClienteAplicacao.clientes.piloto.exceptions.ErroSolicitacao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PilotoServiceTests {

    @InjectMocks
    private PilotoService pilotoService;

    @Mock
    private PilotoClient pilotoClient;


    @Test
    public void testeAdicionaPilotoSucesso() {
        PilotoEntrada pilotoEntrada = new PilotoEntrada();
        pilotoEntrada.setNome("Piloto Teste");
        pilotoEntrada.setNacionalidade("Brasil");
        pilotoEntrada.setEquipe("Equipe Teste");

        ResponseEntity<PilotoSaida> respostaEsperada = ResponseEntity.status(HttpStatus.CREATED).body(new PilotoSaida());
        Mockito.when(pilotoClient.postPiloto(pilotoEntrada)).thenReturn(respostaEsperada.getBody());
        ResponseEntity<PilotoSaida> resposta = pilotoService.adicionaPiloto(pilotoEntrada);
        Assertions.assertEquals(HttpStatus.CREATED, resposta.getStatusCode());
        Mockito.verify(pilotoClient).postPiloto(pilotoEntrada);
    }

    @Test
    public void testeAdicionaPilotoErro() {
        PilotoEntrada pilotoEntrada = new PilotoEntrada("", "", "");

        Assertions.assertThrows(ErroSolicitacao.class, () -> pilotoService.adicionaPiloto(pilotoEntrada));}
}