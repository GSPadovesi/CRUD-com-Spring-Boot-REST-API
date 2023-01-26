package br.com.springboot.treinamento_springboot;

import javax.persistence.Entity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 *
 * Spring Boot application starter class
 */

@EntityScan(basePackages = "br.com.springboot.model") /* Comando para forçar criação da tabela no banco de dados - 
 * obs: apenas se application.properties não de certo */
@SpringBootApplication /* Anotação para startar a aplicação web com o Spring Boot */
public class Application {
    public static void main(String[] args) {
    	
    	/* Execuntando a classe - Classe centro de uma aplicação Spring boot - Linha principal que roda o projeto Java Spring Boot */
    	SpringApplication.run(Application.class, args);
    }
}
