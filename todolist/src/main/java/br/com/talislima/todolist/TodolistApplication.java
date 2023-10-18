package br.com.talislima.todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodolistApplication {

	//http://localhost:8080/h2-console
	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}

}