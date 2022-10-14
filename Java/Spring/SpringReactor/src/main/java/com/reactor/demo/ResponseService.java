package com.reactor.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Service
public class ResponseService {

    public Mono<Object> getModel(int id){

        return Mono.just(new Model(id, "xavier", 424))
                .flatMap(model -> {
                    if(model.getId()==14){
                        return Mono.just(model);
                    }else if(model.getId()==15){
                        return Mono.error(new RuntimeException("Oops! something went wrong"));
                    }else {
                        return Mono.just(new Model(id, "somthing else", 894));
                    }
                });
    }
}
