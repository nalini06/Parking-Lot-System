package org.example;

import org.example.repository.ParkingRepositoryImpl;
import org.example.service.ParkingServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ParkingLotSystem parkingLot = null;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String command = scanner.nextLine().trim();
            String[] tokens = command.split(" ");

            switch (tokens[0]) {
                case "create_parking_lot":
                    int capacity = Integer.parseInt(tokens[1]);
                    parkingLot = new ParkingLotSystem(new ParkingServiceImpl(
                            new ParkingRepositoryImpl(capacity)));
                    System.out.println("Created a parking lot with " + capacity + " slots");
                    break;
                case "park":
                    if (parkingLot != null) {
                        parkingLot.parkCar(tokens[1], tokens[2]);
                    } else {
                        System.out.println("Parking lot not created");
                    }
                    break;
                case "leave":
                    if (parkingLot != null) {
                        int slot = Integer.parseInt(tokens[1]);
                        parkingLot.leaveSlot(slot);
                    } else {
                        System.out.println("Parking lot not created");
                    }
                    break;
                case "status":
                    if (parkingLot != null) {
                        parkingLot.getStatus();
                    } else {
                        System.out.println("Parking lot not created");
                    }
                    break;
                case "registration_numbers_for_cars_with_colour":
                    if (parkingLot != null) {
                        parkingLot.registrationNumbersForCarsWithColor(tokens[1]);
                    } else {
                        System.out.println("Parking lot not created");
                    }
                    break;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("Invalid command");
            }
        }
    }
}
