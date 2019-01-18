package com.example.healthtrackerbackend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Exercise {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    public String title;
    public String quantity;
    public String description;
    public String timestamp;
    public String location;

    public Exercise(){
    }

    public Exercise(String title, String quantity, String description, String timestamp, String location){
        this.title = title;
        this.quantity = quantity;
        this.description = description;
        this.timestamp = timestamp;
        this.location = location;
    }

    public String toString(){
        return this.title + ", " + this.quantity + ": " + this.description;
    }

}
