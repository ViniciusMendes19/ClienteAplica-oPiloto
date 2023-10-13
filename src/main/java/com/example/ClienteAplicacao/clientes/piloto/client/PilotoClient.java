package com.example.ClienteAplicacao.clientes.piloto.client;
import com.example.ClienteAplicacao.clientes.piloto.domain.PilotoEntrada;
import com.example.ClienteAplicacao.clientes.piloto.domain.PilotoSaida;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "Pilotos", url = "http://localhost:8081/piloto")
public interface PilotoClient {

    @PostMapping("/adicionarPiloto")
    PilotoSaida postPiloto(PilotoEntrada pilotoEntrada);

}
