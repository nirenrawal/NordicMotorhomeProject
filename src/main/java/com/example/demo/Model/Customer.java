package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    private int customer_id;
    private String customer_firstName;
    private String customer_lastName;
    private String customer_address;
    private String customer_city;
    private int customer_zip;
    private String customer_phoneNo;
    private String customer_email;
    private String customer_driver_licenseNo;

    public Customer() {
    }

    public Customer(int customer_id, String customer_firstName, String customer_lastName, String customer_address,
                    String customer_city, int customer_zip, String customer_phoneNo, String customer_email,
                    String customer_driver_licenseNo) {
        this.customer_id = customer_id;
        this.customer_firstName = customer_firstName;
        this.customer_lastName = customer_lastName;
        this.customer_address = customer_address;
        this.customer_city = customer_city;
        this.customer_zip = customer_zip;
        this.customer_phoneNo = customer_phoneNo;
        this.customer_email = customer_email;
        this.customer_driver_licenseNo = customer_driver_licenseNo;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_firstName() {
        return customer_firstName;
    }

    public void setCustomer_firstName(String customer_firstName) {
        this.customer_firstName = customer_firstName;
    }

    public String getCustomer_lastName() {
        return customer_lastName;
    }

    public void setCustomer_lastName(String customer_lastName) {
        this.customer_lastName = customer_lastName;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public String getCustomer_city() {
        return customer_city;
    }

    public void setCustomer_city(String customer_city) {
        this.customer_city = customer_city;
    }

    public int getCustomer_zip() {
        return customer_zip;
    }

    public void setCustomer_zip(int customer_zip) {
        this.customer_zip = customer_zip;
    }

    public String getCustomer_phoneNo() {
        return customer_phoneNo;
    }

    public void setCustomer_phoneNo(String customer_phoneNo) {
        this.customer_phoneNo = customer_phoneNo;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getCustomer_driver_licenseNo() {
        return customer_driver_licenseNo;
    }

    public void setCustomer_driver_licenseNo(String customer_driver_licenseNo) {
        this.customer_driver_licenseNo = customer_driver_licenseNo;
    }
}
