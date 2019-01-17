package com.example.healthtrackerbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class ExerciseController {

    @Autowired
    private ExerciseRepo exerciseRepo;

    //Get Mapping to return all the things in the db

    //post mapping to add things to the database
    @PostMapping(value = "/exercise/add")
    public Exercise createExercise(@RequestParam String title, @RequestParam String quantity,
                                   @RequestParam String description){
        //create new exercise
        Exercise newExercise =  new Exercise(title, quantity, description, new Date().toString());
        return exerciseRepo.save(newExercise); // Save the entry to the database
    }
}
