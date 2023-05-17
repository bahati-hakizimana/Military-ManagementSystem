package com.example.military.repository;


import com.example.military.model.Batallion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BattalionRepository extends JpaRepository<Batallion,Integer> {
   // Batallion findByBattalionNo( Batallion batallion);

    //Batallion findByBattalionName(Batallion batallion);
}
