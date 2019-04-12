package com.capgemini.molveno.BoatRental.api;

import com.capgemini.molveno.BoatRental.boat.Boat;
import com.capgemini.molveno.BoatRental.controller.BoatRepository;
import com.capgemini.molveno.BoatRental.controller.ReservationRepository;
import com.capgemini.molveno.BoatRental.controller.TripRepository;
import com.capgemini.molveno.BoatRental.trip.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
        tripRepository.save(trip);
    }


    @RequestMapping(value = "/get-alltrips", method = RequestMethod.GET)
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    @RequestMapping(value = "/edit-trip", method = RequestMethod.POST,consumes = "application/json")
    public void editTrip(@RequestBody Trip trip) {
        Trip t = tripRepository.findById(trip.getId());
        t.setBoat(trip.getBoat());
        t.setStartTime(trip.getStartTime());
        t.setNumberOfPersons(trip.getNumberOfPersons());
        tripRepository.save(t);
    }
    @RequestMapping(value = "/get-availableboatsfortrip", method = RequestMethod.GET)
    public List getAvailableForTrip(@RequestParam String localDateTime1) {

        LocalDateTime startTime = LocalDateTime.parse(localDateTime1);
        System.out.println(startTime);
        List<Boat> AvailableBoatsForTrip = getAvailableBoatsForTrip(startTime, boatRepository.findAll(), reservationRepository.findAll());
        return AvailableBoatsForTrip;
    }
}
