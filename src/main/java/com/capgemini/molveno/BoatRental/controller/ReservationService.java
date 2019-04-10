package com.capgemini.molveno.BoatRental.controller;

import com.capgemini.molveno.BoatRental.boat.Boat;
import com.capgemini.molveno.BoatRental.reservation.Reservation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReservationService {

    public static boolean checkDateTime(LocalDateTime endTimeRequest ,List<Reservation> currentReservations, Boat boat) {
        long boatId = boat.getId();


        LocalDateTime max = endTimeRequest.plusHours(1);

        for (Reservation current : currentReservations) {
            if (current.getBoat().getId() != boatId) {
                continue;
            }
            if (max.isAfter(current.getStartTime())) {
                return false;
            }
        }

        return true;
    }

    public static List<Boat> getAvailableBoats(LocalDateTime endTimeRequest, List<Boat> allBoats, List<Reservation> reservations) {
        List<Boat> availableBoats = new ArrayList<>();
        for (Boat boat : allBoats) {
            if (checkDateTime(endTimeRequest, reservations, boat)) {
                availableBoats.add(boat);

            }

        }

        return availableBoats;


    }
}
