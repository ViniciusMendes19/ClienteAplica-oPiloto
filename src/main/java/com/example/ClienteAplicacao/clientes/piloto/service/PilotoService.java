package com.example.ClienteAplicacao.clientes.piloto.service;
import com.example.ClienteAplicacao.clientes.piloto.client.PilotoClient;
import com.example.ClienteAplicacao.clientes.piloto.domain.PilotoEntrada;
import com.example.ClienteAplicacao.clientes.piloto.domain.PilotoSaida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PilotoService {

    @Autowired
    private PilotoClient pilotoClient;

    public ResponseEntity<PilotoSaida> adicionaPiloto(PilotoEntrada pilotoEntrada){
    return ResponseEntity.status(HttpStatus.CREATED).body(pilotoClient.postPiloto(pilotoEntrada));
    }

}
