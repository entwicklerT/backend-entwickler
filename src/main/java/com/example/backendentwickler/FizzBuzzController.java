package com.example.backendentwickler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
@RestController
@RequestMapping("/api/fizzbuzz")
public class FizzBuzzController {

     FizzBuzzService fizzBuzzService;

    @Autowired
    public FizzBuzzController(FizzBuzzService fizzBuzzService) {
        this.fizzBuzzService = fizzBuzzService;
    }

    @GetMapping("/{number}")
    public ResponseEntity<List<String>> getFizzBuzzList(@PathVariable int number) {
        List<String> result = IntStream.rangeClosed(1, number)
                .mapToObj(fizzBuzzService::generateFizzBuzz)
                .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }
}