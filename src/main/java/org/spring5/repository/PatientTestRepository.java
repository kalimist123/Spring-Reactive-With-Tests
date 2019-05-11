package org.spring5.repository;

import java.util.Arrays;
import java.util.List;

import org.spring5.model.PatientTest;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class PatientTestRepository {

    private final List<PatientTest> patientTests = Arrays.asList(new PatientTest(1L,"BRAF",100),
            new PatientTest(2L,"EGFR",200));


    public Mono<PatientTest> getPatientTestsById(String id){
        return Mono.justOrEmpty(patientTests.stream().filter(patienttest->{
            return patienttest.getId().equals(Long.valueOf(id));
        }).findFirst().orElse(null));
    }

    public Flux<PatientTest> getPatientTests(){return Flux.fromIterable(patientTests);}
}
