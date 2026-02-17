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

//            // 5 risk score calculation
//            System.out.println("\nExercise 5 - Computed Points :");
//
//            List<MissionEvent> event = service.getMissionEvents();
//
//            for (int i = 0; i < 5 && i < event.size(); i++) {
//                MissionEvent event1 = events.get(i);
//                int computedPoints = service.m(event);
//
//                System.out.println("Event " + event.getId()
//                        + " -> severity=" + event.getSeverity()
//                        + " -> riskScore=" + riskScore);
//            }









        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}