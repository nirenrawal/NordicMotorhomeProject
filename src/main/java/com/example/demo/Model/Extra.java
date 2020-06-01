package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Extra {

    @Id
    private int extra_id;
    private String extra_name;
    private int extra_price;

    public Extra(){}

    public Extra(int extra_id, String extra_name, int extra_price) {
        this.extra_id = extra_id;
        this.extra_name = extra_name;
        this.extra_price = extra_price;
    }

    public int getExtra_id() {
        return extra_id;
    }

    public void setExtra_id(int extra_id) {
        this.extra_id = extra_id;
    }

    public String getExtra_name() {
        return extra_name;
    }

    public void setExtra_name(String extra_name) {
        this.extra_name = extra_name;
    }

    public int getExtra_price() {
        return extra_price;
    }

    public void setExtra_price(int extra_price) {
        this.extra_price = extra_price;
    }


}
