package com.capgemini.molveno.BoatRental.controller;

import com.capgemini.molveno.BoatRental.boat.Boat;
import com.capgemini.molveno.BoatRental.reservation.Reservation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReservationService {

    public static boolean checkDateTime(LocalDateTime startTimeRequest,LocalDateTime endTimeRequest ,List<Reservation> currentReservations, Boat boat) {
        long boatId = boat.getId();

        LocalDateTime min = startTimeRequest;
        LocalDateTime max = endTimeRequest.plusHours(1);

        for (Reservation current : currentReservations) {
            if (current.getBoat().getId() != boatId) {
                continue;
            }
            if (max.isAfter(current.getStartTime()) & max.isBefore((current.getEndTime()).plusHours(1))) {
                return false;
            }
            if (min.isAfter(current.getStartTime()) & min.isBefore((current.getEndTime()).plusHours(1))) {
                return false;
            }
            if (min.isEqual(current.getStartTime()) & max.isEqual((current.getEndTime()).plusHours(1))) {
                return false;
            }

        }

        return true;
    }

    public static List<Boat> getAvailableBoats(LocalDateTime startTimeRequrest,LocalDateTime endTimeRequest, List<Boat> allBoats, List<Reservation> reservations) {
        List<Boat> availableBoats = new ArrayList<>();
        for (Boat boat : allBoats) {
            if (checkDateTime(startTimeRequrest ,endTimeRequest, reservations, boat)) {
                availableBoats.add(boat);

            }

        }

        return availableBoats;


    }
}
