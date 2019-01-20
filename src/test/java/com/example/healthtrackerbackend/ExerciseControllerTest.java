package com.example.healthtrackerbackend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ExerciseControllerTest {

//    https://www.blazemeter.com/blog/spring-boot-rest-api-unit-testing-with-junit
//    https://www.baeldung.com/spring-boot-testing

    @LocalServerPort
    private int port;

    @Autowired
    ExerciseController exerciseController;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() throws Exception {

        assertThat(exerciseController).isNotNull();
    }

    @Test
    public void indexExercise() {

        ResponseEntity<String> response =  this.restTemplate.getForEntity("http://localhost:" + port + "/exercises", String.class);
        assertEquals("The response code should be 200", 200, response.getStatusCodeValue());
    }
}