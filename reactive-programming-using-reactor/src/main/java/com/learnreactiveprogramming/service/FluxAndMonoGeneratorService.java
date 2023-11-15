package com.learnreactiveprogramming.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.Function;

public class FluxAndMonoGeneratorService {

    public Flux<String> empNames(){

        //return Flux.fromIterable(List.of("Joydeep","Soutan","Debjyoti","Loknath","Kittu"));
        return Flux.just("Joydeep","Soutan","Debjyoti","Loknath","Kittu").log();
    }



    public Flux<String> empNamesUppercase(){
        return Flux.just("abc","def","sdf","kir","fkdfhdf","dkjfdkfjdkfjd")
                .map(e->e.length() + "-" + e.toUpperCase())
                .filter(e->e.length()>5);
    }
    Function<Flux<String>,Flux<String>> transformFun = e->e.map(e1->e1.toUpperCase()).filter(e2->e2.length()>5);
    //same with transform method
    public Flux<String> empNames3(){
        return Flux.just("abc","def","sdf","kir","fkdfhdf","dkjfdkfjdkfjd")
                .transform(transformFun);
    }

    public Mono<String> namesMono(){
        return Mono.just("Alex");
    }
    //flatmap does not preserve the sequence, but its faster
    //concatmap preserve the sequence ,  but takes more time.

    public Mono<List<String>> namesMono2(){
        return Mono.just("alex")
                .map(e->e.toUpperCase())
                .flatMap(this::splitstringmono);
    }

    private Mono<List<String>> splitstringmono(String s) {

        var stringarray = s.split("");
        var strList = List.of(stringarray);
        return Mono.just(strList);
    }






    public static void main(String[] args) {
        FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();
        fluxAndMonoGeneratorService.empNames()
                .subscribe(name-> System.out.println("Name is : " + name));

        fluxAndMonoGeneratorService.namesMono()
                .subscribe(e-> System.out.println("Mono Name is :: " + e));

        fluxAndMonoGeneratorService.empNamesUppercase()
                .subscribe(name-> System.out.println(name));

    }
}
