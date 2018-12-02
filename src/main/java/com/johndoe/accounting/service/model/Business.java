package com.johndoe.accounting.service.model;

import com.johndoe.accounting.service.clientType.Type;

import javax.persistence.Entity;

/**
 * Created by nebil on 11/30/18.
 */
@Entity
public class Business extends Client{

    private String businessName;
    private int numberOfEmployee;


    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public int getNumberOfEmployee() {
        return numberOfEmployee;
    }

    public void setNumberOfEmployee(int numberOfEmployee) {
        this.numberOfEmployee = numberOfEmployee;
    }

    @Override
    public void setType(Type type) {
        super.setType(Type.Business);
    }
}
