package com.example.car_rental.car;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CarController {

    private static final String VIEWS_CAR_CREATE_OR_UPDATE_FORM = "car/createCarForm";
    private static final String CAR_LIST = "car/carsList";

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping("/cars")
    public String getAllCars(Model model){
        model.addAttribute("allCars",carService.getAllCars());
        return CAR_LIST;
    }

    @GetMapping("/cars/new")
    public String initNewCar(Model model){
        model.addAttribute("car", new Car());
        return VIEWS_CAR_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/cars/new")
    public String processNewCar(@ModelAttribute("car") Car car){
        carService.saveCar(car);
        return "redirect:/cars";
    }



}
