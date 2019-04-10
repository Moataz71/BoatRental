package com.capgemini.molveno.BoatRental.controller;

import com.capgemini.molveno.BoatRental.guest.Guest;
import com.capgemini.molveno.BoatRental.reservation.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationRepository extends CrudRepository <Reservation, Long> {
   List<Reservation> findAll();
   Reservation findById(long id);
}
