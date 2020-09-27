package com.example.eshopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"com.example.*"})
@EntityScan({"com.example.*"})
@EnableAutoConfiguration
public class EshoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EshoppingApplication.class, args);
	}

}
