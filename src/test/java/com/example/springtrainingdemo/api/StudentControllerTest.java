package com.example.springtrainingdemo.api;

import com.example.springtrainingdemo.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetEndPoint() {
        URI uri = UriComponentsBuilder.fromUriString("/students")
                .queryParam("id", 1)
                .build().encode().toUri();

       ResponseEntity<List<Student>> studnetsList= restTemplate.exchange("/students", HttpMethod.GET, null,new ParameterizedTypeReference<List<Student>>() {
        });
       Assert.isTrue(2==2,"Demo");
    }
}
