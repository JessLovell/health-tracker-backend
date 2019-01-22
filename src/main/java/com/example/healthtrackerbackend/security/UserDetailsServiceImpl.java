package com.example.healthtrackerbackend.security;

import com.example.healthtrackerbackend.healthUser.HealthUser;
import com.example.healthtrackerbackend.healthUser.HealthUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private HealthUserRepo healthUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{

        HealthUser healthUser = this.healthUserRepo.findByUsername(username);

        if (healthUser == null){
            System.out.println(username + " not found!");
            throw new UsernameNotFoundException("User " + username + " was not found in the database.");

        }
        return healthUser;
    }
}
