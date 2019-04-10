package com.capgemini.molveno.BoatRental.controller;

import com.capgemini.molveno.BoatRental.guest.Guest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface GuestRepository extends CrudRepository<Guest, Long> {
    List<Guest> findAll();
    Guest findById(long id);
}
