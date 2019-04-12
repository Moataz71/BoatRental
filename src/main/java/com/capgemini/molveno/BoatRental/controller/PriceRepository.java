package com.capgemini.molveno.BoatRental.controller;

import com.capgemini.molveno.BoatRental.price.Price;
import com.capgemini.molveno.BoatRental.trip.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository

public interface PriceRepository extends CrudRepository<Price,Long > {

        List<Price> findAll();
        Price findById(long id);

}
