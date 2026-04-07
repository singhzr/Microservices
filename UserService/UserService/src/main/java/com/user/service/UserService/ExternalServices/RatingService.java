package com.user.service.UserService.ExternalServices;

import com.user.service.UserService.Entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "RATINGSERVICE")
public interface RatingService {

    @PostMapping("/ratings")
    Rating createRating(Rating rating);

    @PutMapping("/ratings/{ratingId}")
    Rating updateRating(@PathVariable String ratingId, Rating rating);

    @DeleteMapping("/ratings/{ratingId}")
    void deleteRating(@PathVariable String ratingId);
}


/*
1. What Feign Client Really Is

    Feign (via Spring Cloud OpenFeign) is a declarative HTTP client.

    Declarative means:
    You describe what API you want to call, not how to call it.

    Instead of:

    Creating HTTP connections
    Serializing JSON
    Handling errors manually

    Feign does all of that behind the scenes.

2. Architecture & Internal Working

    When your Spring Boot app starts:

    Step-by-step flow:
    @EnableFeignClients triggers scanning
    Spring finds interfaces annotated with @FeignClient

    When you call a method:
    Feign intercepts it
    Builds an HTTP request
    Sends it using an HTTP client (like Apache HttpClient or OkHttp)
    Converts response → Java object


---> RestTemplate

    You explicitly create requests:

    RestTemplate restTemplate = new RestTemplate();
    User user = restTemplate.getForObject("http://localhost:8081/users/{id}", User.class, id);
    Developer controls request construction, serialization, headers, etc.
    Works as a generic HTTP client.

---> Feign

    You define an interface:

    @FeignClient(name = "user-service", url = "http://localhost:8081")
    public interface UserClient {
        @GetMapping("/users/{id}")
        User getUser(@PathVariable Long id);
    }
    Spring handles HTTP request/response automatically.
    Works best in microservices with service discovery.


---> @FeignClient(name = "RATINGSERVICE")

    @FeignClient tells Spring: “Create a proxy that calls another service.”
    A proxy is an object created at runtime that implements an interface you define.

    name = "RATINGSERVICE" can mean one of two things:
    With Service Discovery (Eureka / Consul): Spring will look for a running
    service registered under the name RATINGSERVICE and automatically get its URL.

    Without Service Discovery: You can add url = "http://localhost:8082" to specify
    the endpoint manually.


---> What @PostMapping Means in Feign
    In Spring MVC, @PostMapping("/ratings") is used in controllers to handle
    HTTP POST requests.

    In Feign, it works declaratively to tell the proxy:
    “When this method is called, send an HTTP POST request to /ratings.”

*/