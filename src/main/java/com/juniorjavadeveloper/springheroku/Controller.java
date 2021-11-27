package com.juniorjavadeveloper.springheroku;

import com.github.javafaker.Faker;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * Created by www.JuniorJavaDeveloper.com
 */
@RestController
@RequestMapping("/api/v1/facts")
public class Controller {

    private final Faker faker = new Faker();

    @GetMapping
    public ResponseEntity<Response> getFact() {
        return ResponseEntity.ok(
                new Response(faker.chuckNorris().fact())
        );
    }
}

class Response {
    private final String fact;
    private final LocalDateTime createdOn;

    public Response(String fact) {
        this.fact = fact;
        this.createdOn = LocalDateTime.now();
    }

    public String getFact() {
        return fact;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }
}