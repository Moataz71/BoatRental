package com.capgemini.molveno.BoatRental.api;

import com.capgemini.molveno.BoatRental.boat.Boat;
import com.capgemini.molveno.BoatRental.controller.BoatRepository;
import com.capgemini.molveno.BoatRental.controller.ReservationRepository;
import com.capgemini.molveno.BoatRental.controller.TripRepository;
import com.capgemini.molveno.BoatRental.trip.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import static com.capgemini.molveno.BoatRental.controller.TripService.getAvailableBoatsForTrip;

@RestController
@CrossOrigin(origins = "*")


public class TripEndPoint {
    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private BoatRepository boatRepository;
    @Autowired
    private ReservationRepository reservationRepository;

    @RequestMapping(value = "/add-trip", method = RequestMethod.POST,consumes = "application/json")
    public void addTrip(@RequestBody Trip trip) {
        Boat b = boatRepository.findById(trip.getBoat().getId());
        b.setOnTrip(true);
        tripRepository.save(trip);
    }

    @RequestMapping(value = "/delete-trip", method = RequestMethod.DELETE)
    public void deleteTrip(@RequestBody Trip trip) {
        tripRepository.deleteById(trip.getId());
    }


    @RequestMapping(value = "/get-alltrips", method = RequestMethod.GET)
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    @RequestMapping(value = "/end-trip", method = RequestMethod.POST,consumes = "application/json")
    public void endTrip(@RequestBody Trip trip) {
        Trip t = tripRepository.findById(trip.getId());
        Boat b = boatRepository.findById(t.getBoat().getId());
        b.setOnTrip(false);
        tripRepository.save(t);
    }
    @RequestMapping(value = "/get-availableboatsfortrip", method = RequestMethod.GET)
    public HashMap<Long, LocalDateTime> getAvailableForTrip(@RequestParam String localDateTime1, String numberofpersons1) {

        LocalDateTime startTime = LocalDateTime.parse(localDateTime1);
        System.out.println(startTime);
        int numberofpersons = Integer.parseInt(numberofpersons1);
        HashMap<Long, LocalDateTime> AvailableBoatsForTrip = getAvailableBoatsForTrip(startTime,numberofpersons, boatRepository.findAll(), reservationRepository.findAll());
        return AvailableBoatsForTrip;
    }
}
