package com.capgemini.molveno.BoatRental.controller;

import com.capgemini.molveno.BoatRental.boat.Boat;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface BoatRepository extends CrudRepository <Boat,Long >{
    List<Boat> findAll();
    Boat findById(long id);
}
