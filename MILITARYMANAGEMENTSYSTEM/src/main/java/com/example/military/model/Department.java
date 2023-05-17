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
public class Department {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Id
    private int depart_no;
    private String depart_name;

}
