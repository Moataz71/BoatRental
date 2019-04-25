package com.capgemini.molveno.BoatRental.controller;

import com.capgemini.molveno.BoatRental.boat.Boat;
import com.capgemini.molveno.BoatRental.reservation.Reservation;

import java.time.LocalDateTime;
import java.util.*;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class TripService {

    public static boolean checkDateTimeForTrip(LocalDateTime startTimeTrip , List<Reservation> currentReservations, Boat boat) {
        long boatId = boat.getId();
        if (currentReservations.size() == 0){
            return true;
        }


        for (Reservation current : currentReservations) {

            if (current.getBoat().getId() != boatId) {
                continue;
            }

            if (startTimeTrip.isAfter(current.getStartTime().minusHours(2)) & startTimeTrip.isBefore((current.getEndTime()).plusHours(1))) {
                return false;
            }
            if (startTimeTrip.isEqual(current.getStartTime())) {
                return false;
            }


        }
            return true;

    }
    public static HashMap<Long, LocalDateTime> getAvailableBoatsForTrip(LocalDateTime startTimeTrip, int numberOfPersons, List<Boat> allBoats, List<Reservation> reservations) {
        List<Boat> availableBoats = new ArrayList<>();
        List<Reservation> restoday = new ArrayList<>();


        HashMap<Long, LocalDateTime> boatsWithStartTime = new HashMap<Long, LocalDateTime>();

        for (Boat boat : allBoats) {
                    if (checkDateTimeForTrip(startTimeTrip, reservations,boat)) {
                        if ((numberOfPersons < boat.getNumberOfSeat()) & (boat.isOnTrip()==false)  )
                        availableBoats.add(boat);

                    }


            }

        for (Reservation current : reservations){
            if (startTimeTrip.toLocalDate().isEqual(current.getStartTime().toLocalDate())){
                restoday.add(current);
                restoday.sort(Comparator.comparingInt(Reservation::getStartTimeHour));
// Oh My  God *************************
            }
        }


        for (Boat boat : availableBoats){
            if (restoday.size() == 0){
                boatsWithStartTime.put(boat.getId(),LocalDateTime.now().plusDays(1));}




            for (Reservation res : restoday){
                if (boat.getId() == res.getBoat().getId()){
                    if(!boatsWithStartTime.containsKey(boat.getId())){
//                        LocalDateTime l2 = res.getStartTime();
//                        LocalDateTime l3 = LocalDateTime.parse("2019-04-22T20:00");
//                        if (l2.isAfter(l3))
                    boatsWithStartTime.put(boat.getId(),res.getStartTime());
                    }
                    else{
                        LocalDateTime l1 = boatsWithStartTime.get(boat.getId());
                        LocalDateTime l2 = res.getStartTime();
                        LocalDateTime l3 = LocalDateTime.now();
                        System.out.println(l3);
                        if (l2.isAfter(l1) & l2.isAfter(l3) & l1.isBefore(l3)){
                        boatsWithStartTime.replace(boat.getId(), l2);}
                        if (l2.isAfter(l1) & l2.isBefore(l3) & l1.isBefore(l3)){
                            boatsWithStartTime.replace(boat.getId(), l2);}
                    }
                }
               else if (boat.getId() != res.getBoat().getId()){
                    if(!boatsWithStartTime.containsKey(boat.getId())){
                        boatsWithStartTime.put(boat.getId(),LocalDateTime.now().plusDays(1));}

                }




            }
        }


        System.out.println(boatsWithStartTime.size());
        System.out.println(availableBoats.size());
        System.out.println(reservations.size());
        System.out.println(restoday.size());

        for(Reservation r: restoday){
            System.out.println(r.getStartTime());
        }
        for (LocalDateTime i : boatsWithStartTime.values()) {
            System.out.println(i);

        }
        for (long i : boatsWithStartTime.keySet()) {
            System.out.println(i);
        }

// Create a Iterator to EntrySet of HashMap
        Iterator<Map.Entry<Long, LocalDateTime>> entryIt = boatsWithStartTime.entrySet().iterator();

// Iterate over all the elements
        while (entryIt.hasNext()) {
            Map.Entry<Long, LocalDateTime> entry = entryIt.next();
            // Check if Value associated with Key is 10
            if (entry.getValue().isBefore(startTimeTrip)) {
                // Remove the element
                LocalDateTime l1 = entry.getValue().plusDays(1);
                boatsWithStartTime.replace(entry.getKey(), l1);
            }
        }






        return boatsWithStartTime;
    }
    }


