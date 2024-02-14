package org.example.repository;

import org.example.dto.Car;

import java.util.List;
import java.util.Set;

public interface ParkingRepository {
    void parkCar(String regNum, String color);

    void leaveSlot(int slot);

    List<Car> getParkedCars();

    Set<String> getRegNumsByColor(String color);

    Integer getSlotByRegNum(String regNum);
}

