package org.example.service;

import org.example.dto.Car;
import org.example.repository.ParkingRepository;

import java.util.List;
import java.util.Set;

public class ParkingServiceImpl implements ParkingService{

    private final ParkingRepository parkingRepository;

    public ParkingServiceImpl(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    @Override
    public void parkCar(String regNum, String color) {
        try{
            parkingRepository.parkCar(regNum, color);
        }catch (Exception e){
            System.out.println("Failed to park the car " + e.getMessage());
        }

    }

    @Override
    public void leaveSlot(int slot) {
        try{
            parkingRepository.leaveSlot(slot);
        }catch (Exception ex){
            System.out.println("Failed to leave the slot " + slot + ex.getMessage());
        }

    }

    @Override
    public void getStatus() {
        List<Car> parkedCars = parkingRepository.getParkedCars();
        if (parkedCars.isEmpty()) {
            System.out.println("Parking lot is empty");
        } else {
            System.out.println("Slot No. Registration No Colour");
            for (Car car : parkedCars) {
                String regNum = car.getRegNum();
                int slotNum = parkingRepository.getSlotByRegNum(regNum);
                System.out.print (slotNum+  " ");
                System.out.print(regNum+" ");
                System.out.println(car.getColor()+ " ");
            }
        }
    }

    @Override
    public void getRegNumsByColor(String color) {
        try{
            Set<String> regNums = parkingRepository.getRegNumsByColor(color);
            if (regNums.isEmpty()) {
                System.out.println("No cars found with color " + color);
            } else {
                System.out.println(String.join(", ", regNums));
            }
        }catch (Exception ex){
            System.out.println(
                    "Failed to get registration numbers by color " + color +" "+ ex.getMessage());
        }

    }

    @Override
    public void getSlotByRegNum(String regNum) {
        try{
            Integer slot = parkingRepository.getSlotByRegNum(regNum);
            if (slot == null) {
                System.out.println("Not found");
            } else {
                System.out.println("Slot number: " + slot);
            }
        }catch (Exception ex){
            System.out.println("Failed to get slotNumber by regNum " + regNum + " " + ex.getMessage());
        }

    }

}
