package com.user.service.UserService.Configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfiguration {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

/*

@LoadBalanced makes RestTemplate capable of service discovery + client-side load balancing

It allows you to use service names instead of IP addresses, and automatically
spreads requests across instances.
This annotation comes from Spring Cloud.
It enables client-side load balancing using a library like Spring Cloud LoadBalancer.
Instead of calling a fixed URL, you can use service names.


Client-side load balancing -> Client picks which server instance to call

Without @LoadBalanced
restTemplate.getForObject("http://localhost:8081/users", String.class);
You must use actual host + port
No load balancing
Tight coupling between services

With @LoadBalanced
restTemplate.getForObject("http://USER-SERVICE/users", String.class);
USER-SERVICE is not a real URL
It’s a service ID
Spring resolves it via a registry like Eureka

 */