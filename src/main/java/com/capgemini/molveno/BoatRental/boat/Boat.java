package com.capgemini.molveno.BoatRental.boat;

import javax.persistence.*;

@Entity
@Table (name = "Boat")
public class Boat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String boatNumber;
    private int numberOfSeat;
    private String type;
    private boolean onTrip;
    private boolean maintance;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBoatNumber() {
        return boatNumber;
    }

    public void setBoatNumber(String boatNumber) {
        this.boatNumber = boatNumber;
    }

    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    public void setNumberOfSeat(int numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isOnTrip() {
        return onTrip;
    }

    public void setOnTrip(boolean onTrip) {
        this.onTrip = onTrip;
    }

    public boolean isMaintance() {
        return maintance;
    }

    public void setMaintance(boolean maintance) {
        this.maintance = maintance;
    }
}
