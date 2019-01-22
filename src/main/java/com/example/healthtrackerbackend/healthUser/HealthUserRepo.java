package com.example.healthtrackerbackend.healthUser;

import org.springframework.data.repository.CrudRepository;

public interface HealthUserRepo extends CrudRepository<HealthUser, Long> {

    HealthUser findByUsername(String username);
}
