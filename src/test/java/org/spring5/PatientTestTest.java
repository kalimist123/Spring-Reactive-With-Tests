package org.spring5;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring5.model.PatientTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.FluxExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureWebTestClient(timeout = "36000")
public class PatientTestTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void test() throws IOException{
        FluxExchangeResult<PatientTest> result = webTestClient.get().uri("/api/patienttest").accept(MediaType.APPLICATION_JSON)
                .exchange().returnResult(PatientTest.class);
        assert result.getStatus().value() == 200;
        List<PatientTest> patientTests = result.getResponseBody().collectList().block();
        assert patientTests.size() == 2;
        assert patientTests.iterator().next().getBiomarker().equals("BRAF");
    }

}
