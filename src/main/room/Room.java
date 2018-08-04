package main.room;

import main.guest.Guest;

import java.util.ArrayList;

public abstract class Room {
    private int capacity;
    private ArrayList<Guest> guests;


    public Room(int capacity) {
        this.capacity = capacity;
        guests = new ArrayList<>();
    }

    public int getCapacity(){
        return capacity;
    }

    public int getRemainingSpaces(){
        return capacity - guests.size();
    }

    public boolean checkInGuest(Guest guest){
        if (guests.size() < capacity){
            guests.add(guest);
            return true;
        }
        else{
        return false;
    }}

    public ArrayList<Guest> getGuests(){
        return guests;
    }

    public boolean checkOutGuest(Guest guest){
        if (guests.contains(guest)){
            guests.remove(guest);
            return true;
        }
        else {
            return false;
        }

    }

    public abstract String getInfo();

}
