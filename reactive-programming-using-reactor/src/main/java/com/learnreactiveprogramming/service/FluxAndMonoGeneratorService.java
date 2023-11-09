package com.learnreactiveprogramming.service;

import reactor.core.publisher.Flux;

import java.util.List;

public class FluxAndMonoGeneratorService {

    public Flux<String> empNames(){

        return Flux.fromIterable(List.of("Joydeep","Soutan","Debjyoti","Loknath","Kittu"));
    }

    public static void main(String[] args) {
        FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();
        fluxAndMonoGeneratorService.empNames()
                .subscribe(name-> System.out.println("Name is : " + name));
    }
}
