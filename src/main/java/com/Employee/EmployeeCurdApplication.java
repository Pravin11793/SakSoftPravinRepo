package com.Employee;


import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeCurdApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeCurdApplication.class, args);
	}
	@Bean
	public ModelMapper modelMaper() {
		return new ModelMapper();

	}
	
}
