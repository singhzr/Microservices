package com.user.service.UserService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}

/*

---> What @EnableFeignClients Does

1. Scans for interfaces with @FeignClient
    Looks through your package to find all interfaces annotated
	with @FeignClient.

2. Generates runtime proxies for each interface
    A dynamic proxy is a Java object that implements the interface at runtime.
    The proxy intercepts method calls and performs the HTTP request (GET, POST, etc.)
    for you.

3. Registers the proxies as Spring beans
    This makes it possible to @Autowired the Feign interface anywhere.
    The bean you inject is not the interface itself, it’s the proxy object that
    implements it.

The proxy knows how to handle every method, but it doesn’t actually perform any
HTTP calls until the method is invoked.

 */