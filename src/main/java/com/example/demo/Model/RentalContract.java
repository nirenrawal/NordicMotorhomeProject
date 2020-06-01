package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RentalContract {
    @Id
    private int rentalContract_id;
    private String rentalContract_startDate;
    private String rentalContract_endDate;
    private int customer_id;
    private int motorhome_id;
    private int extra_id;
    private String customer_firstName;
    private String customer_lastName;
    private String extra_name;
    private String motorhome_registration;

    public RentalContract() {
    }

    public RentalContract(int rentalContract_id, String rentalContract_startDate, String rentalContract_endDate,
                          int customer_id, int motorhome_id, int extra_id) {
        this.rentalContract_id = rentalContract_id;
        this.rentalContract_startDate = rentalContract_startDate;
        this.rentalContract_endDate = rentalContract_endDate;
        this.customer_id = customer_id;
        this.motorhome_id = motorhome_id;
        this.extra_id = extra_id;
    }

    public int getRentalContract_id() {
        return rentalContract_id;
    }

    public void setRentalContract_id(int rentalContract_id) {
        this.rentalContract_id = rentalContract_id;
    }

    public String getRentalContract_startDate() {
        return rentalContract_startDate;
    }

    public void setRentalContract_startDate(String rentalContract_startDate) {
        this.rentalContract_startDate = rentalContract_startDate;
    }

    public String getRentalContract_endDate() {
        return rentalContract_endDate;
    }

    public void setRentalContract_endDate(String rentalContract_endDate) {
        this.rentalContract_endDate = rentalContract_endDate;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getMotorhome_id() {
        return motorhome_id;
    }

    public void setMotorhome_id(int motorhome_id) {
        this.motorhome_id = motorhome_id;
    }

    public int getExtra_id() {
        return extra_id;
    }

    public void setExtra_id(int extra_id) {
        this.extra_id = extra_id;
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

    public String getExtra_name() {
        return extra_name;
    }

    public void setExtra_name(String extra_name) {
        this.extra_name = extra_name;
    }

    public String getMotorhome_registration() {
        return motorhome_registration;
    }

    public void setMotorhome_registration(String motorhome_registration) {
        this.motorhome_registration = motorhome_registration;
    }

}
