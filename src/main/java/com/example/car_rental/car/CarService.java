package com.example.car_rental.car;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    //GET
    public List<Car> getAllCars() {
        return (List<Car>) carRepository.findAll();
    }

    //POST
    public void saveCar(Car car) {
        carRepository.save(car);
    }

    //Find by id
    public Car getCarById(Long id) {
        return carRepository.findById(id).get();
    }

    
}
