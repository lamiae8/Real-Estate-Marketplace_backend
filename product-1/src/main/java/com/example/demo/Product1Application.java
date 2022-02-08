package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableDiscoveryClient
@ComponentScan({"entities","repositories","services","request","restController","openFeign"})
@SpringBootApplication(scanBasePackages={"entities","repositories","services","request","openFeign","restController"})  //scanner les packages de l'app
@EntityScan({"entities","services"})
@EnableMongoRepositories( basePackages = "repositories")
@EnableFeignClients(basePackages ="openFeign")
public class Product1Application {

	public static void main(String[] args) {
		SpringApplication.run(Product1Application.class, args);
		System.out.println("hey");
	}

}
