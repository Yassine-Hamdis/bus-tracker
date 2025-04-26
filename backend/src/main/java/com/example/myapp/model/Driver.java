package com.example.myapp.model;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data 
@EqualsAndHashCode(callSuper = false)
public class Driver extends User {
    private String phoneNumber;
}
