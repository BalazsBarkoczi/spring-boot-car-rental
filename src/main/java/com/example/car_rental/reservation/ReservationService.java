package com.example.car_rental.reservation;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }

    //List all reservations
    public List<Reservation> getAllReservations(){
        return (List<Reservation>) reservationRepository.findAll();
    }

    //Add new or update reservation
    public void addReservation(Reservation reservation){
        reservationRepository.save(reservation);
    }

    //Find by id
    public Reservation getReservationById(Long id){
        return reservationRepository.findById(id).get();
    }


    
}
