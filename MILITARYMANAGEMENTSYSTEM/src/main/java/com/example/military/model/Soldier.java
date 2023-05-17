package com.example.military.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Soldier {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int army_no;

    private int id;

    private long id_no;
    private String firstname;
    private String lastname;
    private int department;
    private int battalion;
    private String dob;
    private String joined_date;
    private String rank;


}
