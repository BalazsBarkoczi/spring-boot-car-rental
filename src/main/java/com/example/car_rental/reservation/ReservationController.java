package com.example.car_rental.reservation;

import com.example.car_rental.car.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReservationController {

    private static final String VIEWS_RESERVATION_CREATE_FORM = "createReservationForm";

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    @GetMapping("/")
    public String getIndex(Model model){
        return "index";
    }

    @GetMapping("/reservations")
    public String getAllReservations(Model model){
        model.addAttribute("allReservations", reservationService.getAllReservations() );
        return "reservationsList";
    }

    @GetMapping("/reservations/new")
    public String intiCreationForm(Model model){
        Reservation reservation = new Reservation();
        reservation.setCar(new Car());
        model.addAttribute("reservation", reservation);
        return VIEWS_RESERVATION_CREATE_FORM;
    }

    @PostMapping("/reservations/new")
    public String processCreationForm(@ModelAttribute("reservation") Reservation reservation){
        reservationService.addReservation(reservation);
        return "redirect:/";
    }
    
}
