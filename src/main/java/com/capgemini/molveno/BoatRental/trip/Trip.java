package com.capgemini.molveno.BoatRental.trip;

import com.capgemini.molveno.BoatRental.boat.Boat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table (name = "Trip")

public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id ;
    private LocalDateTime startTime;
    private int numberOfPersons;
    @JoinColumn(name = "boatid", referencedColumnName = "id")
    @OneToOne
    private Boat boat;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(int numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    public Boat getBoat() {
        return boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }
}
