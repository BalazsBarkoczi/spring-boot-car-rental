package com.example.car_rental.reservation;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Reservation r WHERE r.car.id = :carId")
    void deleteReservationByCarId(@Param("carId") Long carId);
}
