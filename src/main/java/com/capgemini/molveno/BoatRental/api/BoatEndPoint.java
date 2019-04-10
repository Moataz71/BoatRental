package com.capgemini.molveno.BoatRental.api;

import com.capgemini.molveno.BoatRental.boat.Boat;
import com.capgemini.molveno.BoatRental.controller.BoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BoatEndPoint {
    @Autowired
    private BoatRepository boatRepository;
    @RequestMapping(value = "/add-boat", method = RequestMethod.POST,consumes = "application/json")
    public void addBoat(@RequestBody Boat boat) {
        boatRepository.save(boat);
    }

    @RequestMapping(value = "/get-allboats", method = RequestMethod.GET)
    public List<Boat> getAllBoat() {
        return boatRepository.findAll();
    }

    @RequestMapping(value = "/delete-boat", method = RequestMethod.DELETE)
    public void deleteBoat(@RequestBody Boat boat) {
        boatRepository.deleteById(boat.getId());
    }

    @RequestMapping(value = "/get-boat", method = RequestMethod.GET)
    public Boat getBoat(@RequestBody Boat boat) {
        return boatRepository.findById(boat.getId());
    }


}
