package com.capgemini.molveno.BoatRental.api;


import com.capgemini.molveno.BoatRental.controller.PriceRepository;
import com.capgemini.molveno.BoatRental.price.Price;
import com.capgemini.molveno.BoatRental.trip.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")


public class PriceEndPoint {

    @Autowired
    private PriceRepository priceRepository;


    @RequestMapping(value = "/add-price", method = RequestMethod.POST,consumes = "application/json")
    public void addPrice(@RequestBody Price price) {
        priceRepository.save(price);
    }



    @RequestMapping(value = "/edit-price", method = RequestMethod.POST,consumes = "application/json")
    public void editPrice(@RequestBody Price price) {
        Price p = priceRepository.findById(price.getId());
        p.setPricePerHour(price.getPricePerHour());
        priceRepository.save(p);
    }
}
