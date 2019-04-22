package com.capgemini.molveno.BoatRental.reservation;

import com.capgemini.molveno.BoatRental.boat.Boat;
import com.capgemini.molveno.BoatRental.guest.Guest;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table (name = "Reservation")

public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JoinColumn(name = "guestid", referencedColumnName = "id")
    @OneToOne
    private Guest guest;
    @JoinColumn(name = "boatid", referencedColumnName = "id")
    @OneToOne
    private Boat boat;
    private int numberOfPersons;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Boat getBoat() {
        return boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }

    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(int numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public int getStartTimeHour() {
        return startTime.getHour();
    }




    // created by Moataz
}
