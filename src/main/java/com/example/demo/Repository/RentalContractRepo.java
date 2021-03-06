package com.example.demo.Repository;

import com.example.demo.Model.RentalContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RentalContractRepo {
    @Autowired
    JdbcTemplate template;

    public List<RentalContract> viewAllRentalContract() {
        //String sql = "SELECT * FROM rentalContract";
        String sql = "SELECT r.*, c.customer_firstName, c.customer_lastName, e.extra_name, m.motorhome_registration\n" +
                "FROM rentalContract r, customer c, extra e, motorhome m \n" +
                "where r.customer_id = c.customer_id and r.motorhome_id = m.motorhome_id and e.extra_id = r.extra_id";
        RowMapper<RentalContract> rowMapper = new BeanPropertyRowMapper<>(RentalContract.class);
        return template.query(sql, rowMapper);
    }

    public RentalContract createRentalContract(RentalContract rentalContract) {
        String sql = "INSERT INTO rentalContract (rentalContract_id, rentalContract_startDate, rentalContract_endDate, " +
                "customer_id, motorhome_id, extra_id) VALUES (?, ?, ?, ?, ?, ?)";
        template.update(sql, rentalContract.getRentalContract_id(), rentalContract.getRentalContract_startDate(),
                rentalContract.getRentalContract_endDate(), rentalContract.getCustomer_id(),
                rentalContract.getMotorhome_id(), rentalContract.getExtra_id());
        return null;
    }

    public RentalContract findRentalContract(int rentalContract_id){
        String sql = "SELECT r.*, c.customer_firstName, c.customer_lastName, e.extra_name, m.motorhome_registration " +
                "FROM rentalContract r, customer c, extra e, motorhome m " +
                "where r.customer_id = c.customer_id and r.motorhome_id = m.motorhome_id and e.extra_id = r.extra_id and r.rentalContract_id = ?";
        RowMapper<RentalContract> rowMapper = new BeanPropertyRowMapper<>(RentalContract.class);
        RentalContract rentalContract = template.queryForObject(sql, rowMapper, rentalContract_id);
        return rentalContract;

    }

    public RentalContract updateRentalContract(int rentalContract_id, RentalContract rentalContract) {
        String sql = "UPDATE rentalContract SET rentalContract_startDate=?, rentalContract_endDate=?, " +
                "extra_id=? WHERE rentalContract_id=?";
        template.update(sql, rentalContract.getRentalContract_startDate(), rentalContract.getRentalContract_endDate(),
                rentalContract.getExtra_id(), rentalContract.getRentalContract_id());
        return null;
    }

    public Boolean deleteRentalContract(int rentalContract_id) {
        String sql = "DELETE FROM rentalContract WHERE rentalContract_id =?";
        return template.update(sql, rentalContract_id) < 0;
    }
}
