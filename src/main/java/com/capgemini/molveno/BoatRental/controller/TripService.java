package com.capgemini.molveno.BoatRental.controller;

import com.capgemini.molveno.BoatRental.boat.Boat;
import com.capgemini.molveno.BoatRental.reservation.Reservation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TripService {

    public static boolean checkDateTimeForTrip(LocalDateTime startTimeTrip , List<Reservation> currentReservations, Boat boat) {
        long boatId = boat.getId();

//        for (Reservation current : currentReservations){
//         if (   startTimeTrip.toLocalDate().isEqual(current.getStartTime().toLocalDate()) & (current.getStartTime()).isAfter(startTimeTrip) ){
//             return false;}
//        }

        for (Reservation current : currentReservations) {
            if ( startTimeTrip.toLocalDate().isEqual(current.getStartTime().toLocalDate()) & current.getBoat().getId() != boatId) {
                continue;
            }

                if (startTimeTrip.isAfter(current.getStartTime()) & startTimeTrip.isBefore((current.getEndTime()).plusHours(1))) {
                    return false;
                }

                if (startTimeTrip.isEqual(current.getStartTime())) {
                    return false;
                }


        }
            return true;

    }
    public static List<Boat> getAvailableBoatsForTrip(LocalDateTime startTimeTrip, int numberOfPersons, List<Boat> allBoats, List<Reservation> reservations) {
        List<Boat> availableBoats = new ArrayList<>();
        
        for (Boat boat : allBoats) {

                    if (checkDateTimeForTrip(startTimeTrip, reservations,boat)) {
                        if (numberOfPersons < boat.getNumberOfSeat())
                        availableBoats.add(boat);
                    }


            }



        return availableBoats;
    }
    }


