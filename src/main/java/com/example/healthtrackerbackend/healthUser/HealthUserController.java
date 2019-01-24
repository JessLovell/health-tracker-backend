package com.example.healthtrackerbackend.healthUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class HealthUserController {

    @Autowired
    private HealthUserRepo healthUserRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

//    @PostMapping("/login")
//    public void login(@RequestParam String username, @RequestParam String password){
//
//        return
//    }

    @PostMapping("/signup")
    public String signup(@RequestParam String username, @RequestParam String password,
                       @RequestParam String firstName, @RequestParam String lastName,
                       @RequestParam String dateOfBirth){

        password = bCryptPasswordEncoder.encode(password);

        HealthUser newHealthUser = new HealthUser(username, password, firstName, lastName, dateOfBirth);
        healthUserRepo.save(newHealthUser);

        // Auto login for users
        Authentication authentication = new UsernamePasswordAuthenticationToken(newHealthUser, null, new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // redirect user back to their profile once created?
        return "Hello from Signup";
    }

    @GetMapping("/my-dashboard")
    public String returnDashboard(){
        return "Logged in !!! ";
    }


}
