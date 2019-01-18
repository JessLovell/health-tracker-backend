package com.example.healthtrackerbackend;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class ExerciseController {

    @Autowired
    private ExerciseRepo exerciseRepo;

    //Get Mapping to return all the things in the db
    @GetMapping(value = "/exercises")
    public String indexExercises(){

        //get all the entries in the db and json it
        Gson gson = new Gson();
        return gson.toJson(exerciseRepo.findAll());
    }

    //post mapping to add things to the database
    @PostMapping(value = "/exercises")
    public Exercise createExercise(@RequestParam String title, @RequestParam String quantity,
                                   @RequestParam String description, @RequestParam String location){
        //create new exercise
        Exercise newExercise =  new Exercise(title, quantity, description, new Date().toString(), location);
        return exerciseRepo.save(newExercise); // Save the entry to the database
    }
}
