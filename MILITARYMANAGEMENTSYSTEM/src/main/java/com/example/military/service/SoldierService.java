package com.example.military.service;

import com.example.military.model.Soldier;

import java.util.List;
import java.util.ServiceLoader;

public interface SoldierService {
    Soldier saveSoldier(Soldier soldier);
    List<Soldier> displaySoldiers();
    Soldier findSolderByArmyNumber(Soldier soldier);
    Soldier updateSolder(Soldier soldier);
    void deleteSoldier(Soldier soldier);
}
