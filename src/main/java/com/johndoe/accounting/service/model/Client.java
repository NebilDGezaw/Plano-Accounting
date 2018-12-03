package com.johndoe.accounting.service.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.johndoe.accounting.service.clientType.Type;

import javax.persistence.*;

/**
 * Created by nebil on 11/30/18.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Enumerated
    private Type type;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL,fetch = FetchType.LAZY, optional = false)
    @JsonManagedReference
    private Location location;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return String.valueOf(type);
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
