package com.learnreactiveprogramming.service;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FluxAndMonoGeneratorServiceTest {

    FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();

    @Test
    void testNames(){
        Flux<String> namesFlux = fluxAndMonoGeneratorService.empNames();

        StepVerifier.create(namesFlux)
                    .expectNext("Joydeep","Soutan","Debjyoti","Loknath","Kittu")
                .verifyComplete();

    }

    @Test
    void testEmpNamesUpperCase(){
        Flux<String> names = fluxAndMonoGeneratorService.empNamesUppercase();
        StepVerifier.create(names)
                .expectNext("7-FKDFHDF","13-DKJFDKFJDKFJD")
                .verifyComplete();

    }


    @Test
    void namesMono2() {

        Mono<List<String>> monoList = fluxAndMonoGeneratorService.namesMono2();
        StepVerifier.create(monoList)
                .expectNext(List.of("A","L","E","X"))
                .verifyComplete();

    }
}