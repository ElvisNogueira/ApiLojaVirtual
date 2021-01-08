package com.api.ApiLojaVirtual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EntityScan({"com.api.model"})
@ComponentScan(basePackages = "com.api.controller")
@EnableSwagger2
//@ComponentScan(basePackages = "config")
@EnableJpaRepositories(basePackages = "com.api.repository")
public class ApiLojaVirtualApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiLojaVirtualApplication.class, args);
	}

}
