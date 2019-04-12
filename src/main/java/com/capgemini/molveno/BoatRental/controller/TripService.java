package com.capgemini.molveno.BoatRental.controller;

import com.capgemini.molveno.BoatRental.boat.Boat;
import com.capgemini.molveno.BoatRental.reservation.Reservation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TripService {

    public static boolean checkDateTimeForTrip(LocalDateTime startTimeTrip , List<Reservation> currentReservations) {


        for (Reservation current : currentReservations) {

            if (startTimeTrip.isAfter(current.getStartTime()) & startTimeTrip.isBefore((current.getEndTime()).plusHours(1))) {
                return false;
            }

            if (startTimeTrip.isEqual(current.getStartTime()) ) {
                return false;
            }


        }

        return true;
    }
    public static List<Boat> getAvailableBoatsForTrip(LocalDateTime startTimeTrip, List<Boat> allBoats, List<Reservation> reservations) {
        List<Boat> availableBoats = new ArrayList<>();
        for (Boat boat : allBoats) {
            for (Reservation current : reservations) {
                if (boat.getId() != (current.getBoat().getId())) {
                    availableBoats.add(boat);
                } else {
                    if (checkDateTimeForTrip(startTimeTrip, reservations))

                        availableBoats.add(boat);

                }

            }


        }
        return availableBoats;
    }
    }

//        public static List<LocalTime> getReservationsStartTimes(LocalDateTime startTimeTrip, List<Reservation> reservations) {
//            List reservationStartTimes = new ArrayList();
//            for (Reservation res : reservations) {
//                if ( startTimeTrip.isBefore(res.getStartTime()) & (startTimeTrip.toLocalDate().isEqual(res.getStartTime().toLocalDate())))
//                {
//                    reservationStartTimes.add(res.getStartTime().toLocalTime());
//                }
//            }
//            return reservationStartTimes;
//        }
//
//}
