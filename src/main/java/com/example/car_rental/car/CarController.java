package com.example.car_rental.car;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CarController {

    private static final String CREATE_NEW_CAR_FORM = "car/createCarForm";
    private static final String CAR_LIST = "car/carsList";
    private static final String CAR_UPDATE_FORM = "car/updateCarForm";


    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    //Get for listing all cars
    @GetMapping("/cars")
    public String getAllCars(Model model){
        model.addAttribute("allCars",carService.getAllCars());
        return CAR_LIST;
    }

    //GET for adding new car
    @GetMapping("/cars/new")
    public String initNewCar(Model model){
        model.addAttribute("car", new Car());
        return CREATE_NEW_CAR_FORM;
    }

    //POST for adding new car
    @PostMapping("/cars/new")
    public String processNewCar(@ModelAttribute("car") Car car){
        carService.saveCar(car);
        return "redirect:/cars";
    }

    //Update
    @GetMapping("/cars/updateCar/{id}")
    public String initUpdateCarForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("car", carService.getCarById(id));
        return CAR_UPDATE_FORM;
    }
    
    //Delete
    @GetMapping("/cars/deleteCar/{id}")
    public String deleteCar(@PathVariable("id") Long id){
        carService.deleteCarById(id);
        return "redirect:/cars";
    }



}
