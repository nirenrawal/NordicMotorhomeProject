package com.example.demo.Repository;

import com.example.demo.Model.Extra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExtraRepo {
    @Autowired
    JdbcTemplate template;

    public List<Extra> viewAllExtra() {
        String sql = "SELECT * FROM extra";
        RowMapper<Extra> rowMapper = new BeanPropertyRowMapper<>(Extra.class);
        return template.query(sql, rowMapper);
    }
}
