package com.example.car_rental.reservation;

import com.example.car_rental.car.Car;
import jakarta.persistence.*;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "days")
    private String days;

    @Column(name = "reservation_price")
    private String reservationPrice;

    public Reservation() {
    }

    public Reservation(Long id, Car car, String name, String email, String address, String phone, String days, String reservationPrice) {
        this.id = id;
        this.car = car;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.days = days;
        this.reservationPrice = reservationPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getReservationPrice() {
        return reservationPrice;
    }

    public void setReservationPrice(String reservationPrice) {
        this.reservationPrice = reservationPrice;
    }
}
