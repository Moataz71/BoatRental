package com.capgemini.molveno.BoatRental.api;

import com.capgemini.molveno.BoatRental.boat.Boat;
import com.capgemini.molveno.BoatRental.controller.BoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")

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
        System.out.println(boat.getId());
        return boatRepository.findById(boat.getId());
    }

    @RequestMapping(value = "/edit-boat", method = RequestMethod.POST,consumes = "application/json")
    public void editBoat(@RequestBody Boat boat) {
        Boat b = boatRepository.findById(boat.getId());
        b.setBoatNumber(boat.getBoatNumber());
        b.setNumberOfSeat(boat.getNumberOfSeat());
        b.setMaintance(boat.isMaintance());
        b.setOnTrip(boat.isOnTrip());
        boatRepository.save(b);
    }


}
