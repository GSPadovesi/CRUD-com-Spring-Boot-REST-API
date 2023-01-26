package br.com.springboot.treinamento_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * Spring Boot application starter class
 */

/* Anotação para startar a aplicação web com o Spring Boot */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
    	
    	/* Execuntando a classe - Classe centro de uma aplicação Spring boot - Linha principal que roda o projeto Java Spring Boot */
    	SpringApplication.run(Application.class, args);
    }
}
