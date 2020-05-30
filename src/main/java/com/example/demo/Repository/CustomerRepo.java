package com.example.demo.Repository;

import com.example.demo.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepo {
    @Autowired
    JdbcTemplate template;

    public List<Customer> viewAllCustomer() {
        String sql = "SELECT * FROM customer";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return template.query(sql, rowMapper);
    }

    public Customer createCustomer(Customer customer){
        String sql = "INSERT INTO customer(customer_firstName, customer_lastName, " +
                "customer_address, customer_city, customer_zip, customer_phoneNo, customer_email, " +
                "customer_driver_licenseNo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        template.update(sql, customer.getCustomer_firstName(),
                customer.getCustomer_lastName(), customer.getCustomer_address(),customer.getCustomer_city(),
                customer.getCustomer_zip(), customer.getCustomer_phoneNo(),
                customer.getCustomer_email(), customer.getCustomer_driver_licenseNo());
        return null;
    }

    public Customer findCustomer(int customer_id){
        String sql = "SELECT * FROM customer WHERE customer_id=?";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        Customer customer = template.queryForObject(sql, rowMapper, customer_id);
        return customer;
    }

    public Customer updateCustomer(int customer_id, Customer customer) {
        String sql = "UPDATE customer SET customer_firstName=?, customer_lastName=?, customer_address=?, " +
                "customer_city=?, customer_zip=?, customer_phoneNo=?, customer_email=?, customer_driver_licenseNo=?" +
                "WHERE customer_id=?";
       template.update(sql, customer.getCustomer_firstName(), customer.getCustomer_lastName(), customer.getCustomer_address(),
                customer.getCustomer_city(), customer.getCustomer_zip(), customer.getCustomer_phoneNo(),
                customer.getCustomer_email(), customer.getCustomer_driver_licenseNo(), customer.getCustomer_id());
        return null;
    }


    public Boolean deleteCustomer(int customer_id) {
        String sql = "DELETE FROM customer WHERE customer_id =?";
        return template.update(sql, customer_id) < 0;
    }
}
