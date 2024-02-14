package org.example.service;

import java.util.List;
import java.util.Set;

public interface ParkingService {
    void parkCar(String regNum, String color);

    void leaveSlot(int slot);

    void getStatus();

    void getRegNumsByColor(String color);

    void getSlotByRegNum(String regNum);
}

