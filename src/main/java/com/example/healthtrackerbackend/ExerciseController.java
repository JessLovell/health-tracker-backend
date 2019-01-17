package com.example.healthtrackerbackend;

import com.google.gson.Gson;
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
    @GetMapping(value = "/exercises")
    public String  indexExercises(){

        //get all the entries in the db
        //turn the list into a Json
        Gson gson = new Gson();

        return gson.toJson(exerciseRepo.findAll());
    }

    //post mapping to add things to the database
    @PostMapping(value = "/exercises/add")
    public Exercise createExercise(@RequestParam String title, @RequestParam String quantity,
                                   @RequestParam String description){
        //create new exercise
        Exercise newExercise =  new Exercise(title, quantity, description, new Date().toString());
        return exerciseRepo.save(newExercise); // Save the entry to the database
    }
}
