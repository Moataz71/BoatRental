package com.capgemini.molveno.BoatRental.api;

import com.capgemini.molveno.BoatRental.boat.Boat;
import com.capgemini.molveno.BoatRental.controller.BoatRepository;
import com.capgemini.molveno.BoatRental.controller.GuestRepository;
import com.capgemini.molveno.BoatRental.controller.ReservationRepository;
import com.capgemini.molveno.BoatRental.guest.Guest;
import com.capgemini.molveno.BoatRental.reservation.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static com.capgemini.molveno.BoatRental.controller.ReservationService.getAvailableBoats;

@RestController
@CrossOrigin(origins = "*")


public class ReservationEndPoint {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private GuestRepository guestRepository;
    @Autowired
    private BoatRepository boatRepository;

    @RequestMapping(value = "/add-reservation", method = RequestMethod.POST, consumes = "application/json")
    public void addReservation(@RequestBody Reservation reservation) {
        Guest guest1 = reservation.getGuest();
        System.out.println(guest1);
        guestRepository.save(guest1);
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
    public List getAvailable(@RequestParam String localDateTime1, String localDateTime2, String numberofpersons1) {

        LocalDateTime startTime = LocalDateTime.parse(localDateTime1);
        System.out.println(startTime);
        LocalDateTime endTime = LocalDateTime.parse(localDateTime2);
        System.out.println(endTime);
        int numberofpersons = Integer.parseInt(numberofpersons1);
        List<Boat> AvailableBoats = getAvailableBoats(startTime, endTime,numberofpersons ,boatRepository.findAll(), reservationRepository.findAll());
        System.out.println(AvailableBoats);
        return AvailableBoats;
    }
}
