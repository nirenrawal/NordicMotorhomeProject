package com.example.demo.Repository;

import com.example.demo.Model.Motorhome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MotorhomeRepo {
    @Autowired
    JdbcTemplate template;

    public List<Motorhome> viewAllMotorhome() {
        String sql = "SELECT * FROM motorhome";
        RowMapper<Motorhome> rowMapper = new BeanPropertyRowMapper<>(Motorhome.class);
        return template.query(sql, rowMapper);
    }

    public Motorhome createMotorhome(Motorhome motorhome) {
        String sql = "INSERT INTO motorhome(motorhome_id, motorhome_type, motorhome_brand, motorhome_model, " +
                "motorhome_beds, motorhome_registration, motorhome_odometer, motorhome_availability, motorhome_fuelType, " +
                "motorhome_fuelAmount, motorhome_price) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
        template.update(sql, motorhome.getMotorhome_id(), motorhome.getMotorhome_type(), motorhome.getMotorhome_brand(),
                motorhome.getMotorhome_model(), motorhome.getMotorhome_beds(), motorhome.getMotorhome_registration(),
                motorhome.getMotorhome_odometer(), motorhome.getMotorhome_availability(), motorhome.getMotorhome_fuelType(),
                motorhome.getMotorhome_fuelAmount(), motorhome.getMotorhome_price());
        return null;
    }

    public Motorhome findMotorhome(int motorhome_id){
        String sql = "SELECT * FROM motorhome WHERE motorhome_id = ?";
        RowMapper<Motorhome> rowMapper = new BeanPropertyRowMapper<>(Motorhome.class);
        Motorhome motorhome = template.queryForObject(sql, rowMapper, motorhome_id);
        return motorhome;

    }

    public Motorhome updateMotorhome(int motorhome_id, Motorhome motorhome) {
        String sql = "UPDATE motorhome SET motorhome_type=?, motorhome_brand=?, motorhome_model=?, motorhome_beds=?, " +
                "motorhome_registration=?, motorhome_odometer=?, motorhome_availability=?, motorhome_fuelType=?, " +
                "motorhome_fuelAmount=?, motorhome_price=? WHERE motorhome_id=?";
        template.update(sql, motorhome.getMotorhome_type(), motorhome.getMotorhome_brand(), motorhome.getMotorhome_model(),
                motorhome.getMotorhome_beds(), motorhome.getMotorhome_registration(), motorhome.getMotorhome_odometer(),
                motorhome.getMotorhome_availability(), motorhome.getMotorhome_fuelType(),
                motorhome.getMotorhome_fuelAmount(), motorhome.getMotorhome_price(), motorhome.getMotorhome_id());
        return null;
    }

    public Boolean deleteMotorhome(int motorhome_id) {
        String sql = "DELETE FROM motorhome WHERE motorhome_id =?";
        return template.update(sql, motorhome_id) < 0;
    }
}
