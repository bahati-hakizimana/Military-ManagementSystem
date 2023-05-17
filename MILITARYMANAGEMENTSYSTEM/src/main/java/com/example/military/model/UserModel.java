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
public class UserModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    @Id
    private int army_number;
    private String password;

}
