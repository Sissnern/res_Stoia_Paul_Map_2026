package org.example.model;

import jdk.jshell.Snippet;
import org.example.MissionEventType;
import org.example.AstronautStatus;

public class MissionEvent {
    int id;
    int AstronautId;
    int day;
    MissionEventType type;
    int basePoints;

    MissionEvent(){}

    MissionEvent(int id, int AstronautId, int day, MissionEventType type, int basePoints) {
      this.id  = id;
      this.AstronautId = AstronautId;
      this.day = day;
      this.type = type;
      this.basePoints = basePoints;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setAstronautId(int AstronautId) {
        this.AstronautId = AstronautId;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setType(MissionEventType type) {
        this.type = type;
    }

    public void setBasePoints(int basePoints) {
        this.basePoints = basePoints;
    }


    public int  getId() {
        return id;
    }

    public int getAstronautId() {
        return AstronautId;
    }

    public int getDay() {
        return day;
    }

    public MissionEventType getType() {
        return type;
    }

    public int getBasePoints() {
        return basePoints;
    }

}