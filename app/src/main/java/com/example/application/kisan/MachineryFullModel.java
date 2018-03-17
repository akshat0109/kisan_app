package com.example.application.kisan;

import java.util.List;

/**
 * Created by HP on 21-02-2018.
 */

public class MachineryFullModel {
    private String Contact_no;
    private String emi;
    private String location;
    private String name;
    private Integer rate_int;

    private List<MachineryModel> Machines;

    public String getContact_no() {
        return Contact_no;
    }

    public void setContact_no(String contact_no) {
        Contact_no = contact_no;
    }

    public String getEmi() {
        return emi;
    }

    public void setEmi(String emi) {
        this.emi = emi;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRate_int() {
        return rate_int;
    }

    public void setRate_int(Integer rate_int) {
        this.rate_int = rate_int;
    }

    public List<MachineryModel> getMachines() {
        return Machines;
    }

    public void setMachines(List<MachineryModel> machines) {
        Machines = machines;
    }
}
