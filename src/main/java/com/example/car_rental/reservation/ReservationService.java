package com.example.car_rental.reservation;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getAllReservations(){
        return (List<Reservation>) reservationRepository.findAll();
    }

    public void addReservation(Reservation reservation){
        reservationRepository.save(reservation);
    }
    
}
