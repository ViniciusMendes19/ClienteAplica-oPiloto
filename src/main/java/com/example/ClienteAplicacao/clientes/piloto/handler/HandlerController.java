package com.example.ClienteAplicacao.clientes.piloto.handler;

import com.example.ClienteAplicacao.clientes.piloto.exceptions.ErroSolicitacao;
import com.example.ClienteAplicacao.clientes.piloto.exceptions.RespostasExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerController {

    @ExceptionHandler(ErroSolicitacao.class)
    public ResponseEntity<RespostasExceptions> handleErroSolicitacao(ErroSolicitacao ex) {
        return new ResponseEntity<>(
                RespostasExceptions.builder()
                        .status(HttpStatus.BAD_REQUEST.value())
                        .titulo("Bad Request Exception")
                        .detalhes(ex.getMessage())
                        .msgdev(ex.getClass().getName())
                        .build(), HttpStatus.BAD_REQUEST);
    }
}
