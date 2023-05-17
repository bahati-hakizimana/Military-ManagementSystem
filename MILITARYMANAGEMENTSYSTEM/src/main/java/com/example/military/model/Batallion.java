package com.example.military.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Batallion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Id
    private int batallion_no;
    private String battalion_name;

}
