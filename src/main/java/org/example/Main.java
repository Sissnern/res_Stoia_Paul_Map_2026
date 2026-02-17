package org.example;

import org.example.model.MissionEvent;
import org.example.model.Astronaut;
import org.example.model.Supply;
import org.example.repository.*;
import org.example.service.SpaceService;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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








        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}