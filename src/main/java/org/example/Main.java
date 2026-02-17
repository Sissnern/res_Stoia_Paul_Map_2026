package org.example;

import org.example.model.MissionEvent;
import org.example.model.Astronaut;
import org.example.model.Supply;
import org.example.repository.*;
import org.example.service.SpaceService;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            SpaceService service = new SpaceService(
                    new AstronautRepository(),
                    new MissionEventRepository(),
                    new SupplyRepository()
            );

            // 1 statistics
            List<Astronaut> astronauts = service.getAstronauts();
            List<MissionEvent> events = service.getMissionEvents();
            List<Supply> supplies = service.getSupplies();

            System.out.println("Astronauts loaded: " + astronauts.size());
            System.out.println("Events loaded: " + events.size());
            System.out.println("Supplies loaded: " + supplies.size());

            astronauts.forEach(a ->
                    System.out.println("[#" + a.getId() + "] "
                            + a.getName() + " | "
                            + a.getSpacecraft() + " | "
                            + a.getStatus() + " | exp="
                            + a.getExperiencelevel())
            );


            // 2 filtering
            Scanner scanner = new Scanner(System.in);

            System.out.print("\nInput Spacecraft: ");
            String spacecraft = scanner.nextLine().trim();

            List<Astronaut> filtered =
                    service.getActiveAstronautsBySpacecraft(spacecraft);

            filtered.forEach(a ->
                    System.out.println("[#" + a.getId() + "] "
                            + a.getName() + " | "
                            + a.getSpacecraft() + " | "
                            + a.getStatus() + " | exp="
                            + a.getExperiencelevel())
            );


            // 3 sorting
            System.out.println("\nExercise 3 - Sorted Astronauts:");

            List<Astronaut> sorted = service.getSortedAstronauts();

            sorted.forEach(a ->
                    System.out.println("[#" + a.getId() + "] "
                            + a.getName() + " | "
                            + a.getSpacecraft() + " | "
                            + a.getStatus() + " | exp="
                            + a.getExperiencelevel())
            );

            // 4 write to file (reversed order)
            Collections.reverse(sorted);

            try (PrintWriter pw = new PrintWriter(new FileWriter("astronauts_sorted.txt"))) {
                sorted.forEach(a ->
                        pw.println("[#" + a.getId() + "] "
                                + a.getName() + " | "
                                + a.getSpacecraft() + " | "
                                + a.getStatus() + " | exp="
                                + a.getExperiencelevel())
                );
            }

//            // 5 Computed points calculation
//            System.out.println("\nExercise 5 - Computed Points :");
//
//            List<MissionEvent> event = service.getMissionEvents();
//
//            for (int i = 0; i < 5 && i < event.size(); i++) {
//                MissionEvent event1 = events.get(i);
//                int computedPoints = service.m(event);
//
//                System.out.println("Event " + event.getId()
//                        + " -> severity=" + event.get()
//                        + " -> riskScore=" + riskScore);
//            }

//            // 6 ranking Astronauts
//            System.out.println("\nExercise 6 - Vehicle Ranking:");
//
//            Map<String, Integer> totalRiskMap = service.calculateTotalRiskPerVehicle();
//
//            List<Map.Entry<String, Integer>> sortedVehicles =
//                    totalRiskMap.entrySet().stream()
//                            .sorted(
//                                    Comparator.comparing(Map.Entry<String, Integer>::getValue)
//                                            .thenComparing(Map.Entry<String, Integer>::getKey, Comparator.reverseOrder())
//                            )
//                            .toList();
//
//            System.out.println("Top 5 Vehicles:");
//            for (int i = 0; i < 5 && i < sortedVehicles.size(); i++) {
//                Map.Entry<String, Integer> entry = sortedVehicles.get(i);
//                System.out.println((i + 1) + ". " + entry.getKey() + " -> " + entry.getValue());
//            }
//
//            if (!sortedVehicles.isEmpty()) {
//                Map.Entry<String, Integer> safest = sortedVehicles.get(0);
//                System.out.println("\nSafest vehicle: " + safest.getKey() + " -> " + safest.getValue());
//            }









        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}