package com.example.healthtrackerbackend;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;


@RunWith(SpringRunner.class)
@WebMvcTest(ExerciseController.class)
public class ExerciseControllerTest {

//    https://www.blazemeter.com/blog/spring-boot-rest-api-unit-testing-with-junit
//    https://www.baeldung.com/spring-boot-testing

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ExerciseRepo exerciseRepo;

    @Test
    public void indexExercises() {

        Exercise exercise = new Exercise("Testing", "12", "This is a test.", "1/17/2019", "Seattle");
        List<Exercise> allExercises = Arrays.asList(exercise);

        given(exerciseRepo.).willReturn(allExercises);

        mvc.perform()

    }

    @Test
    public void createExercise() {
    }
}