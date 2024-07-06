package com.example.car_rental.reservation;

import java.util.List;

public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getAllReservations(){
        return (List<Reservation>) reservationRepository.findAll();
    }
    
}
