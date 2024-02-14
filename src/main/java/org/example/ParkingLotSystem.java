package org.example;

import org.example.repository.ParkingRepositoryImpl;
import org.example.service.ParkingService;

public class ParkingLotSystem {

    private final ParkingService parkingService;


    public ParkingLotSystem(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    public void createParkingLot(int capacity) {

        System.out.println("Created a parking lot with " + capacity + " slots");
    }

    public void parkCar(String regNum, String color) {
        parkingService.parkCar(regNum, color);
    }

    public void leaveSlot(int slot) {
        parkingService.leaveSlot(slot);
    }

    public void getStatus() {
        parkingService.getStatus();
    }

    public void registrationNumbersForCarsWithColor(String color) {
        parkingService.getRegNumsByColor(color);
    }

    public void slotNumberForRegistrationNumber(String regNum) {
        parkingService.getSlotByRegNum(regNum);
    }

}
