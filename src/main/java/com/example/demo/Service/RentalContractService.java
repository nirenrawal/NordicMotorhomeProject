package com.example.demo.Service;

import com.example.demo.Model.RentalContract;
import com.example.demo.Repository.RentalContractRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalContractService {
    @Autowired
    RentalContractRepo rentalContractRepo;

    public List<RentalContract> viewAllRentalContract() {
        return rentalContractRepo.viewAllRentalContract();
    }

    public RentalContract createRentalContract(RentalContract rentalContract) {
        return rentalContractRepo.createRentalContract(rentalContract);
    }

    public RentalContract findRentalContract(int rentalContract_id){
        return rentalContractRepo.findRentalContract(rentalContract_id);
    }

    public RentalContract updateRentalContract(int rentalContract_id, RentalContract rentalContract) {
        return rentalContractRepo.updateRentalContract(rentalContract_id, rentalContract);
    }

    public Boolean deleteRentalContract(int rentalContract_id) {
        return rentalContractRepo.deleteRentalContract(rentalContract_id);
    }
}
