package com.example.car_rental.car;


import com.example.car_rental.reservation.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final ReservationRepository reservationRepository;

    public CarService(CarRepository carRepository, ReservationRepository reservationRepository) {
        this.carRepository = carRepository;
        this.reservationRepository = reservationRepository;
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

    //Delete
    public void deleteCarById(Long id) {
        //check if a reservation has this car
        //if it does delete the reservation too
        reservationRepository.deleteReservationByCarId(id);
        carRepository.deleteById(id);
    }

    //Update
    public void updateCar(Car car){
        Optional<Car> optionalCar = carRepository.findById(car.getId());

        if(optionalCar.isPresent()){
            Car carToUpdate = optionalCar.get();
            carToUpdate.setBrand(car.getBrand());
            carToUpdate.setModel(car.getModel());
            carToUpdate.setYear(car.getYear());
            carToUpdate.setColor(car.getColor());
            carRepository.save(carToUpdate);
        }
    }

    
}
