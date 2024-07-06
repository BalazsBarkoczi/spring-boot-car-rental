package com.example.car_rental.reservation;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    @GetMapping("/hello")
    public String getIndex(Model model){
        return "hello";
    }

    @GetMapping
    public String getAllReservations(Model model){
        model.addAttribute("allReservations", reservationService.getAllReservations() );
        return "reservationsList";
    }
    
}
