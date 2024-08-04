package com.example.car_rental.reservation;

import com.example.car_rental.car.Car;
import com.example.car_rental.car.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReservationController {

    private static final String VIEWS_RESERVATION_CREATE_FORM = "createReservationForm";
    private static final String RESERVATIONS_LIST = "reservationsList";

    //Beans
    private final ReservationService reservationService;
    private final CarService carService;

    public ReservationController(ReservationService reservationService, CarService carService){
        this.reservationService = reservationService;
        this.carService = carService;
    }

    @GetMapping("/")
    public String getIndex(Model model){
        return "index";
    }

    //List all car page
    @GetMapping("/reservations")
    public String getAllReservations(Model model){
        model.addAttribute("allReservations", reservationService.getAllReservations() );
        return "reservationsList";
    }

    //Need to be looked at, doesn't work
    @GetMapping("/reservations/new")
    public String createReservation(Model model){
        Reservation reservation = new Reservation();
        //This is a problem because car doesn't have an id
        reservation.setCar(new Car());
        model.addAttribute("reservation", reservation);
        return VIEWS_RESERVATION_CREATE_FORM;
    }

    //Coming from carsList to create a reservation based on a car
    @GetMapping("/reservations/new/{id}")
    public String createReservationById(@PathVariable("id") Long id, Model model){
        Car car = carService.getCarById(id);
        Reservation reservation = new Reservation();
        reservation.setCar(car);
        model.addAttribute("reservation", reservation);
        return VIEWS_RESERVATION_CREATE_FORM;
    }

    //Old
    @PostMapping("/reservations/new")
    public String processCreationForm(@ModelAttribute("reservation") Reservation reservation){
        //System.out.println(reservation.getCar().getId() + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        reservationService.addReservation(reservation);
        return "redirect:/reservations";
    }
    
}
