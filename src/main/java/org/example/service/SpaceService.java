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

    // Exercise 2
    public List<Astronaut> getActiveAstronautsBySpacecraft(String spacecraft) throws Exception {

        return astronautRepository.findAll().stream()
                .filter(a -> a.getSpacecraft().equals(spacecraft))
                .filter(a -> a.getStatus() == AstronautStatus.ACTIVE)
                .collect(Collectors.toList());
    }
    // Exercise 3
    public List<Astronaut> getSortedAstronauts() throws Exception {

        return astronautRepository.findAll().stream()
                .sorted(
                        Comparator.comparing(Astronaut::getExperiencelevel)
                                .reversed()
                                .thenComparing(Astronaut::getName)
                )
                .collect(Collectors.toList());
    }


    // Exercise 5
    public int calculateComputedPoints(MissionEvent event) {

        return switch (event.getType()) {
            case EVA -> event.getBasePoints() + 2 * event.getDay();
            case SYSTEM_FAILURE -> event.getBasePoints() - 3 - event.getDay();
            case SCIENCE -> event.getBasePoints() + (event.getDay() % 4);
            case MEDICAL -> event.getBasePoints() - 2 * (event.getDay() % 3);
            case COMMUNICATION -> event.getBasePoints() + 5;
        };
    }


//    // Exercise 6
//    public Map<String, Integer> calculateTotalRiskPerVehicle() throws Exception {
//
//        List<Vehicle> vehicles = vehicleRepository.findAll();
//        List<TrafficEvent> events = trafficEventRepository.findAll();
//        List<Fine> fines = fineRepository.findAll();
//
//        Map<Integer, Integer> riskPerVehicle = new HashMap<>();
//        Map<Integer, Integer> finePerVehicle = new HashMap<>();
//
//        // Sum risk scores
//        for (TrafficEvent event : events) {
//            int riskScore = calculateRiskScore(event);
//            riskPerVehicle.merge(event.getVehicleId(), riskScore, Integer::sum);
//        }
//
//        // Sum fines
//        for (Fine fine : fines) {
//            finePerVehicle.merge(fine.getVehicleid(), fine.getAmount(), Integer::sum);
//        }
//
//        Map<String, Integer> totalRiskMap = new HashMap<>();
//
//        for (Vehicle vehicle : vehicles) {
//            int totalRisk = riskPerVehicle.getOrDefault(vehicle.getId(), 0)
//                    - finePerVehicle.getOrDefault(vehicle.getId(), 0);
//
//            totalRiskMap.put(vehicle.getLicensePlate(), totalRisk);
//        }
//
//        return totalRiskMap;
//    }











}