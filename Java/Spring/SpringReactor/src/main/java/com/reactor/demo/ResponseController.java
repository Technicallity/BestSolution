package com.reactor.demo;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.function.Predicate;

@RestController
@RequestMapping("/model")
public class ResponseController {

    @Autowired
    private ResponseService responseService;

    @GetMapping("/{id}")
    public Mono<Object> getModel(@PathVariable int id){
        return responseService.getModel(id)
                .onErrorResume(exception-> Mono.just(exception.getMessage()))
                .flatMap(response -> {
                    return Mono.just("hello");
                });
    }

    @GetMapping("/diff")
    public Mono<Product> getDiff(@RequestBody Product product){
        System.out.println(product);
        return Mono.just(product);
    }
}
