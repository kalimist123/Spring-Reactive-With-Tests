package org.spring5.handler;

import org.spring5.model.PatientTest;
import org.spring5.repository.PatientTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Service
public class PatientTestHandler {

    @Autowired
    private PatientTestRepository patientTestRepository;

    public Mono<ServerResponse> handleGetPatientTests(ServerRequest request) {
        return ServerResponse.ok().body(patientTestRepository.getPatientTests(), PatientTest.class);
    }

    public Mono<ServerResponse> handleGetPatientTestsById(ServerRequest request) {
        return patientTestRepository.getPatientTestsById(request.pathVariable("id"))
                .flatMap(patientTest -> ServerResponse.ok().body(Mono.just(patientTest), PatientTest.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

}
