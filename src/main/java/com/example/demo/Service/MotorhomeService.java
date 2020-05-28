package com.example.demo.Service;

import com.example.demo.Model.Motorhome;
import com.example.demo.Repository.MotorhomeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotorhomeService {
    @Autowired
    MotorhomeRepo motorhomeRepo;

    public List<Motorhome> viewAllMotorhome() {
        return motorhomeRepo.viewAllMotorhome();
    }

    public Motorhome createMotorhome(Motorhome motorhome) {
        return motorhomeRepo.createMotorhome(motorhome);
    }

    public Motorhome findMotorhome(int motorhome_id){
        return motorhomeRepo.findMotorhome(motorhome_id);
    }

    public Motorhome updateMotorhome(int motorhome_id, Motorhome motorhome) {
        return motorhomeRepo.updateMotorhome(motorhome_id, motorhome);
    }

    public Boolean deleteMotorhome(int motorhome_id) {
        return motorhomeRepo.deleteMotorhome(motorhome_id);
    }
}
