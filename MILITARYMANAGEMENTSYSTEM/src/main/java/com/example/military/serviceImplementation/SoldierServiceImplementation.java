package com.example.military.serviceImplementation;

import com.example.military.model.Soldier;
import com.example.military.repository.SoldierRepository;
import com.example.military.service.SoldierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoldierServiceImplementation implements SoldierService {
    @Autowired
    SoldierRepository repo;
    @Override
    public Soldier saveSoldier(Soldier soldier) {
        return repo.save(soldier);
    }

    @Override
    public List<Soldier> displaySoldiers() {
        return repo.findAll();
    }

    @Override
    public Soldier findSolderByArmyNumber(Soldier soldier) {
        return repo.findById(soldier.getArmy_no()).orElse(null);
    }

    @Override
    public Soldier updateSolder(Soldier soldier) {
        Soldier savedSoldier = repo.findById(soldier.getArmy_no()).orElse(null);
        if (savedSoldier!=null){
            Soldier foundSoldier = new Soldier();
            savedSoldier.setDepartment(soldier.getDepartment());
            savedSoldier.setBattalion(soldier.getBattalion());
            savedSoldier.setFirstname(soldier.getFirstname());
            savedSoldier.setLastname(soldier.getLastname());
            savedSoldier.setRank(soldier.getRank());
            savedSoldier.setId_no(soldier.getId_no());
            savedSoldier.setDob(soldier.getDob());

            return repo.save(savedSoldier);
        }else {
            return repo.save(soldier);
        }

    }

    @Override
    public void deleteSoldier(Soldier soldier) {
        Soldier savedSoldier = repo.findById(soldier.getArmy_no()).orElse(null);
        if (savedSoldier!=null){
            repo.delete(savedSoldier);
        }

    }
}
