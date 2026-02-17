package org.example.model;

import org.example.SupplyType;
import org.example.AstronautStatus;

public class Supply {
    int id;
    int astronautId;
    SupplyType type;
    int value;


    Supply() {}

    Supply(int id, int astronautId, SupplyType type, int value) {
        this.id = id;
        this.astronautId = astronautId;
        this.type = type;
        this.value = value;

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAstronautId(int astronautId) {
        this.astronautId = astronautId;
    }

    public  void setType(SupplyType type) {
        this.type = type;
    }

    public void setValue(int value) {
        this.value = value;
    }



    public int getId() {
        return id;
    }

    public int getAstronautId() {
        return astronautId;
    }

    public SupplyType getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

}