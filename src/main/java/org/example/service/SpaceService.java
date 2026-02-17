package org.example.service;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.example.AstronautStatus;
import org.example.MissionEventType;
import org.example.model.*;
import org.example.repository.*;

import java.util.*;
import java.util.stream.Collectors;

public class SpaceService {
    private final AstronautRepository astronautRepository;
    private final MissionEventRepository missionEventRepository;
    private final SupplyRepository supplyRepository;

    public SpaceService(AstronautRepository ar, MissionEventRepository er, SupplyRepository sr) {
        this.astronautRepository = ar;
        this.missionEventRepository = er;
        this.supplyRepository = sr;
    }

    // Sarcina 1
    public List<Astronaut> getAstronauts() throws Exception {
        return astronautRepository.findAll();
    }

    public List<MissionEvent> getMissionEvents() throws Exception {
        return missionEventRepository.findAll();
    }

    public List<Supply> getSupplies() throws Exception {
        return supplyRepository.findAll();
    }

//    // Exercise 2
//    public List<Astronaut> getVehicleByTypeAndStatus(AstronautS) throws Exception {
//        return vehicleRepository.findAll().stream()
//                .filter(v -> v.getType() == type)
//                .filter(v -> v.getStatus() == status)
//                .collect(Collectors.toList());
//    }




}