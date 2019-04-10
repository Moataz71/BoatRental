package com.capgemini.molveno.BoatRental.api;

import com.capgemini.molveno.BoatRental.boat.Boat;
import com.capgemini.molveno.BoatRental.controller.BoatRepository;
import com.capgemini.molveno.BoatRental.controller.ReservationRepository;
import com.capgemini.molveno.BoatRental.reservation.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static com.capgemini.molveno.BoatRental.controller.ReservationService.getAvailableBoats;

@RestController

public class ReservationEndPoint {

    @Autowired
    private ReservationRepository reservationRepository;
    private BoatRepository boatRepository;

    @RequestMapping(value = "/add-reservation", method = RequestMethod.POST, consumes = "application/json")
    public void addReservation(@RequestBody Reservation reservation) {
        reservationRepository.save(reservation);
    }

    @RequestMapping(value = "/get-allreservations", method = RequestMethod.GET)
    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }

    @RequestMapping(value = "/delete-reservation", method = RequestMethod.DELETE)
    public void deleteReservation(@RequestBody Reservation reservation) {
        reservationRepository.deleteById(reservation.getId());
    }

    @RequestMapping(value = "/get-reservation", method = RequestMethod.GET)
    public Reservation getReservation(@RequestBody Reservation reservation) {
        return reservationRepository.findById(reservation.getId());
    }

    @RequestMapping(value = "/get-availableboats", method = RequestMethod.GET)
    public List getAvailable(@RequestParam String localDateTime) {


        LocalDateTime endTime = LocalDateTime.parse(localDateTime);
        List<Boat> AvailableBoats = getAvailableBoats(endTime, boatRepository.findAll(), reservationRepository.findAll());
return AvailableBoats;
    }
}
