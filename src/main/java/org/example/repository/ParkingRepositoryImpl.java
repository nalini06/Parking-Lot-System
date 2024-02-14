package org.example.repository;

import org.example.dto.Car;

import java.util.*;

public class ParkingRepositoryImpl implements ParkingRepository {
    private final int capacity;
    private final Map<Integer, Car> parkedCars;
    private final Map<String, Set<String>> carsByColor;
    private final Map<String, Integer> slotByRegNum;
    private final TreeSet<Integer> availableSlots;

    public ParkingRepositoryImpl(int capacity) {
        this.capacity = capacity;
        this.parkedCars = new HashMap<>();
        this.carsByColor = new HashMap<>();
        this.slotByRegNum = new HashMap<>();
        this.availableSlots = new TreeSet<>();
        for (int i = 1; i <= capacity; i++) {
            availableSlots.add(i);
        }
    }

    @Override
    public void parkCar(String regNum, String color) {
        if (availableSlots.isEmpty()) {
            System.out.println("Sorry, parking lot is full");
            return;
        }
        if(slotByRegNum.containsKey(regNum)){
            System.out.println("The car with + " + regNum + " is already parked");
            return;
        }
        int slot = availableSlots.pollFirst();
        Car car = new Car(regNum, color);
        parkedCars.put(slot, car);
        slotByRegNum.put(regNum, slot);
        carsByColor.putIfAbsent(color, new HashSet<>());
        carsByColor.get(color).add(regNum);
        System.out.println("Allocated slot number: " + slot);
    }

    @Override
    public void leaveSlot(int slot) {
        if (parkedCars.containsKey(slot)) {
            Car car = parkedCars.remove(slot);
            slotByRegNum.remove(car.getRegNum());
            carsByColor.get(car.getColor()).remove(slot);
            availableSlots.add(slot);
            System.out.println("Slot number " + slot + " is free");
        } else {
            System.out.println("Slot number " + slot + " is already free");
        }
    }

    @Override
    public List<Car> getParkedCars() {
        return new ArrayList<>(parkedCars.values());
    }

    @Override
    public Set<String> getRegNumsByColor(String color) {
        return carsByColor.getOrDefault(color, Collections.emptySet());
    }

    @Override
    public Integer getSlotByRegNum(String regNum) {
        return slotByRegNum.get(regNum);
    }
}

