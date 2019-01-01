package org.example.apache.commons.beanutils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Company {

    private String name;
    private HashMap address = new HashMap();
    private String[] otherInfo;
    private ArrayList product;
    private ArrayList employee;
    private HashMap telephone;
    private Date esDate;

    public Company() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap getAddress() {
        return address;
    }

    public void setAddress(HashMap address) {
        this.address = address;
    }

    public String[] getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String[] otherInfo) {
        this.otherInfo = otherInfo;
    }

    public ArrayList getProduct() {
        return product;
    }

    public void setProduct(ArrayList product) {
        this.product = product;
    }

    public ArrayList getEmployee() {
        return employee;
    }

    public void setEmployee(ArrayList employee) {
        this.employee = employee;
    }

    public HashMap getTelephone() {
        return telephone;
    }

    public void setTelephone(HashMap telephone) {
        this.telephone = telephone;
    }
}
