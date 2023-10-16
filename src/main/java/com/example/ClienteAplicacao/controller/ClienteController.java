package com.example.ClienteAplicacao.controller;
import com.example.ClienteAplicacao.clientes.piloto.domain.PilotoEntrada;
import com.example.ClienteAplicacao.clientes.piloto.domain.PilotoSaida;
import com.example.ClienteAplicacao.service.PilotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ClienteController {

    @Autowired
    private PilotoService pilotoService;

    public ClienteController(PilotoService pilotoService) {
        this.pilotoService = pilotoService;
    }

    @PostMapping("/adicionar_piloto")
    public ResponseEntity<PilotoSaida> adicionaPiloto(@RequestBody PilotoEntrada pilotoEntrada) {
        return pilotoService.adicionaPiloto(pilotoEntrada);
    }

}
