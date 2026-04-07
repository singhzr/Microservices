package com.serviceRegistry.serviceRegistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistryApplication.class, args);
	}

}

/*

@EnableEurekaServer is an annotation used in Spring Boot applications to turn your app
into a Eureka Service Registry Server (part of Spring Cloud Netflix Eureka).

What it does: When you add @EnableEurekaServer to your main class, it:
Starts a Eureka server
Allows microservices to register themselves
Enables service discovery (services can find and communicate with each other)

 */