package com.example.military.service;

import com.example.military.model.Batallion;

import java.util.List;

public interface BattalionService {
    Batallion saveBattalion(Batallion batallion);
    List<Batallion> displayBattalions();
    Batallion updateBattalion(Batallion batallion);
    Batallion findBattalionBbyId(Batallion batallion);
    //Batallion findBattalionByName(Batallion batallion);
    void deleteBattalion(Batallion batallion);
}
