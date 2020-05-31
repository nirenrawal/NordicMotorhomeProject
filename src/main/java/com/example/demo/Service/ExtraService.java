package com.example.demo.Service;

import com.example.demo.Model.Extra;
import com.example.demo.Repository.ExtraRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtraService {
    @Autowired
    ExtraRepo extraRepo;

    public List<Extra> viewAllExtra() {
        return extraRepo.viewAllExtra();
    }
}
