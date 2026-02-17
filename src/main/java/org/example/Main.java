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


//            // 2 filtering
//            Scanner scanner = new Scanner(System.in);
//
//            System.out.print("\nSarcina 2 - Introduceti tipul navetei (Orion,Dragon,Starliner): ");
//            String typeStr = scanner.nextLine().toUpperCase().trim();
//
//            System.out.print("Sarcina 2 - Introduceti statusul astronautului  (ACTIVE, INACTIVE,LOST): ");
//            String statusStr = scanner.nextLine().toUpperCase().trim();
//
//            // Convert Strings to Enums
//            VehicleStatus status = VehicleStatus.valueOf(statusStr);
//            AstronautStatus type = AstronautStatus.valueOf(typeStr);
//
//
//            // Call the Service
//            List<Astronaut> filteredAstronauts = service.getAstronauts(type, status);
//
//            System.out.println("\nVehicule gasite:");
//            if (filteredAstronauts.isEmpty()) {
//                System.out.println("Nu s-au gasit vehicule care sa respecte ambele conditii.");
//            } else {
//                for (Astronaut v : filteredAstronauts) {
//                    System.out.println(v);
//                }
//            }







        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}