package com.capgemini.molveno.BoatRental.api;

import com.capgemini.molveno.BoatRental.controller.GuestRepository;
import com.capgemini.molveno.BoatRental.guest.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")


public class GuestEndPoint {
    @Autowired
    private GuestRepository guestRepository;
    @RequestMapping(value = "/add-guest", method = RequestMethod.POST,consumes = "application/json")
    public void addGuest(@RequestBody Guest guest) {
        guestRepository.save(guest);
    }

    @RequestMapping(value = "/get-allguests", method = RequestMethod.GET)
    public List<Guest> getAllGuest() {
        return guestRepository.findAll();
    }

    @RequestMapping(value = "/delete-guest", method = RequestMethod.DELETE)
    public void deleteGuest(@RequestBody Guest guest) {
        guestRepository.deleteById(guest.getId());
    }

    @RequestMapping(value = "/get-guest", method = RequestMethod.GET)
    public Guest getGuest(@RequestBody Guest guest) {
        return guestRepository.findById(guest.getId());
    }


}
