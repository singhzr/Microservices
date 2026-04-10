package com.gateway.ApiGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}

/*

1. What exactly is an API Gateway?

	An API Gateway is a reverse proxy server that:

	A reverse proxy server is a server that sits in front of backend servers and
	handles client requests on their behalf.

	Accepts all client requests
	Decides where to send them
	Applies common logic (security, logging, limits)
	Returns the response back to the client
	Request & response transformation

	Think of it as a traffic controller for your backend.

2. Why API Gateway is important in microservices

	Without a gateway:

	Client → User Service
	Client → Order Service
	Client → Payment Service

	Problems:

	Client must know all service URLs
	Repeated logic (auth, logging) in every service
	Hard to manage changes

	With API Gateway:

	Client → API Gateway → User Service
						 → Order Service
						 → Payment Service

	Benefits:

	Single entry point
	Centralized control
	Cleaner architecture
	Request & response transformation
 */