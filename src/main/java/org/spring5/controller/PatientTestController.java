package org.spring5.controller;

import org.spring5.model.PatientTest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;
@ControllerAdvice
//@RestController("/api/v2")
public class PatientTestController {



    @GetMapping("/patienttest")
    public Mono<ServerResponse> handleGetPatientTests(){

    return WebClient.create("http://localhost:9000").get().uri("/api/patienttest")
            .accept(MediaType.APPLICATION_JSON).exchange().flatMap(resp -> ServerResponse.ok().body(resp.bodyToFlux(PatientTest.class), PatientTest.class));
}


    @GetMapping("/patienttest/{id}")
    public Mono<ServerResponse> handleGetPatientTestsById(@PathVariable String id) {
        return WebClient.create("http://localhost:9000").get().uri("/api/patienttest/" + id)
                .accept(MediaType.APPLICATION_JSON).exchange().flatMap(resp -> ServerResponse.ok().body(resp.bodyToMono(PatientTest.class), PatientTest.class));
    }
}
