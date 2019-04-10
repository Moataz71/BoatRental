package com.capgemini.molveno.BoatRental.controller;

import com.capgemini.molveno.BoatRental.boat.Boat;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface BoatRepository extends CrudRepository <Boat,Long >{
    List<Boat> findAll();
    Boat findById(long id);
}
