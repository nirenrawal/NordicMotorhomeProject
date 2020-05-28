package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Motorhome {

    @Id
    private int motorhome_id;
    private String motorhome_type;
    private String motorhome_brand;
    private String motorhome_model;
    private int motorhome_beds;
    private String motorhome_registration;
    private int motorhome_odometer;
    private String motorhome_availability;
    private String motorhome_fuelType;
    private String motorhome_fuelAmount;
    private int motorhome_price;

    public Motorhome() {
    }

    public Motorhome(int motorhome_id, String motorhome_type, String motorhome_brand, String motorhome_model,
                     int motorhome_beds, String motorhome_registration, int motorhome_odometer,
                     String motorhome_availability, String motorhome_fuelType, String motorhome_fuelAmount,
                     int motorhome_price) {
        this.motorhome_id = motorhome_id;
        this.motorhome_type = motorhome_type;
        this.motorhome_brand = motorhome_brand;
        this.motorhome_model = motorhome_model;
        this.motorhome_beds = motorhome_beds;
        this.motorhome_registration = motorhome_registration;
        this.motorhome_odometer = motorhome_odometer;
        this.motorhome_availability = motorhome_availability;
        this.motorhome_fuelType = motorhome_fuelType;
        this.motorhome_fuelAmount = motorhome_fuelAmount;
        this.motorhome_price = motorhome_price;
    }

    public int getMotorhome_id() {
        return motorhome_id;
    }

    public void setMotorhome_id(int motorhome_id) {
        this.motorhome_id = motorhome_id;
    }

    public String getMotorhome_type() {
        return motorhome_type;
    }

    public void setMotorhome_type(String motorhome_type) {
        this.motorhome_type = motorhome_type;
    }

    public String getMotorhome_brand() {
        return motorhome_brand;
    }

    public void setMotorhome_brand(String motorhome_brand) {
        this.motorhome_brand = motorhome_brand;
    }

    public String getMotorhome_model() {
        return motorhome_model;
    }

    public void setMotorhome_model(String motorhome_model) {
        this.motorhome_model = motorhome_model;
    }

    public int getMotorhome_beds() {
        return motorhome_beds;
    }

    public void setMotorhome_beds(int motorhome_beds) {
        this.motorhome_beds = motorhome_beds;
    }

    public String getMotorhome_registration() {
        return motorhome_registration;
    }

    public void setMotorhome_registration(String motorhome_registration) {
        this.motorhome_registration = motorhome_registration;
    }

    public int getMotorhome_odometer() {
        return motorhome_odometer;
    }

    public void setMotorhome_odometer(int motorhome_odometer) {
        this.motorhome_odometer = motorhome_odometer;
    }

    public String getMotorhome_availability() {
        return motorhome_availability;
    }

    public void setMotorhome_availability(String motorhome_availability) {
        this.motorhome_availability = motorhome_availability;
    }

    public String getMotorhome_fuelType() {
        return motorhome_fuelType;
    }

    public void setMotorhome_fuelType(String motorhome_fuelType) {
        this.motorhome_fuelType = motorhome_fuelType;
    }

    public String getMotorhome_fuelAmount() {
        return motorhome_fuelAmount;
    }

    public void setMotorhome_fuelAmount(String motorhome_fuelAmount) {
        this.motorhome_fuelAmount = motorhome_fuelAmount;
    }

    public int getMotorhome_price() {
        return motorhome_price;
    }

    public void setMotorhome_price(int motorhome_price) {
        this.motorhome_price = motorhome_price;
    }
}
