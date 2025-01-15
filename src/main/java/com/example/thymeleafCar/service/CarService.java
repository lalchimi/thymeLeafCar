package com.example.thymeleafCar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.thymeleafCar.model.Car;

@Service
public class CarService {

    private static final List<Car> carList = new ArrayList<>();

    static {
        carList.add(new Car("12DF12", "modelTest", "marqueTest", "berline", false));
    }
    
    public List<Car> findAll() {
        return carList;
    }

    public Car findByImmatriculation(String immatriculation) {
        return carList.stream()
                .filter(p -> p.getImmatriculation().equals(immatriculation))
                .findFirst()
                .orElse(null);
    }

    public void save(Car car) {
        Car existingCar = findByImmatriculation(car.getImmatriculation());
        if (existingCar != null) {
            existingCar.setModel(car.getModel());
            existingCar.setMarque(car.getMarque());
            existingCar.setCategory(car.getCategory());
            existingCar.setAvailable(car.getAvailable());
        } else {
            carList.add(car);
        }
    }

    public void deleteById(String immatriculation) {
        carList.removeIf(p -> p.getImmatriculation().equals(immatriculation));
    }
}
