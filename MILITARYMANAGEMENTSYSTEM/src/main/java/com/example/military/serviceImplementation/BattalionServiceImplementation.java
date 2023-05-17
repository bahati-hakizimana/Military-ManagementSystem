package com.example.military.serviceImplementation;

import com.example.military.model.Batallion;
import com.example.military.repository.BattalionRepository;
import com.example.military.service.BattalionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BattalionServiceImplementation implements BattalionService {
    @Autowired
    BattalionRepository repo;
    @Override
    public Batallion saveBattalion(Batallion batallion) {
        return repo.save(batallion);
    }

    @Override
    public List<Batallion> displayBattalions() {
        return repo.findAll();
    }

    @Override
    public Batallion updateBattalion(Batallion batallion) {
        Batallion savedBattalion = repo.findById(batallion.getBatallion_no()).orElse(null);
        if (savedBattalion!=null){
            savedBattalion.setBattalion_name(batallion.getBattalion_name());

            return repo.save(savedBattalion);
        }else {
            return repo.save(batallion);
        }

    }

    @Override
    public Batallion findBattalionBbyId(Batallion batallion) {
        return repo.findById(batallion.getBatallion_no()).orElse(null);
    }

//    @Override
//    public Batallion findBattalionByName(Batallion batallion) {
//        return repo.findByBattalionName(batallion);
//    }

    @Override
    public void deleteBattalion(Batallion batallion) {
        Batallion savedBattalion = repo.findById(batallion.getBatallion_no()).orElse(null);
        if (savedBattalion != null) {
            repo.delete(savedBattalion);
        }
    }
}
