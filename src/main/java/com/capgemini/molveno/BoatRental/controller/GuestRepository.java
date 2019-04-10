package com.capgemini.molveno.BoatRental.controller;

import com.capgemini.molveno.BoatRental.guest.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository

public interface GuestRepository extends CrudRepository<Guest, Long> {
    List<Guest> findAll();
    Guest findById(long id);
}
