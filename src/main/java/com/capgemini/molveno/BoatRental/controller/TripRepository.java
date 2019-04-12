package com.capgemini.molveno.BoatRental.controller;


import com.capgemini.molveno.BoatRental.guest.Guest;
import com.capgemini.molveno.BoatRental.trip.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository

public interface TripRepository  extends CrudRepository <Trip,Long > {
    List<Trip> findAll();
    Trip findById(long id);

}
