package com.example.military.repository;

import com.example.military.model.Soldier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoldierRepository extends JpaRepository<Soldier,Integer> {
    //Soldier findSoldierByArmynumber(Soldier soldier);
}
