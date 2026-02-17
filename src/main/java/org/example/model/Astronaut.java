package org.example.model;

import jdk.jshell.Snippet;
import org.example.AstronautStatus;
import org.example.MissionEventType;
import org.example.SupplyType;

public class Astronaut {
    int id;
    String name;
    String spacecraft;
    AstronautStatus status;
    int experiencelevel;

    Astronaut(){}

    Astronaut(int id, String name, String spacecraft, AstronautStatus status, int experiencelevel) {
        this.id = id;
        this.name = name;
        this.spacecraft = spacecraft;
        this.status = status;
        this.experiencelevel = experiencelevel;

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpacecraft(String spacecraft) {
        this.spacecraft = spacecraft;
    }

    public void setExperiencelevel(int experiencelevel) {
        this.experiencelevel = experiencelevel;
    }

    public void setStatus(AstronautStatus status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpacecraft() {
        return spacecraft;
    }

    public AstronautStatus getStatus() {
        return status;
    }

    public int getExperiencelevel() {
        return experiencelevel;
    }

    @Override
    public String toString() {
        return "[" + id +"]" + " " + name + "(" + spacecraft +")" + " - "+status + "," + " Exp=" + experiencelevel;
    }
}