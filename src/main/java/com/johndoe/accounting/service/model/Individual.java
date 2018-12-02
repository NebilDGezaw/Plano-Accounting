package com.johndoe.accounting.service.model;

import com.johndoe.accounting.service.clientType.Type;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDate;

/**
 * Created by nebil on 11/30/18.
 */
@Entity
public class Individual extends Client{

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String title;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Temporal(TemporalType.DATE)
    public LocalDate getBithDate() {
        return birthDate;
    }

    @Temporal(TemporalType.DATE)
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setType(Type type) {
        super.setType(Type.Individual);
    }
}
