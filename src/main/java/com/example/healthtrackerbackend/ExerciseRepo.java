package com.example.healthtrackerbackend;

import org.springframework.data.repository.CrudRepository;

public interface ExerciseRepo extends CrudRepository<Exercise, Long> {

}
