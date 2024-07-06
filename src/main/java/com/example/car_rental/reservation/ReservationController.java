package com.example.car_rental.reservation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReservationController {

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
    
}
