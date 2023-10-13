package com.example.ClienteAplicacao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ClienteAplicacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClienteAplicacaoApplication.class, args);
	}

}
