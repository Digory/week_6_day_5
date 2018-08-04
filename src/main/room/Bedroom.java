package main.room;

import main.guest.Guest;

public class Bedroom extends Room {
    private int roomNumber;
    private BedroomType type;

    public Bedroom(int roomNumber, BedroomType type) {
        super(type.getCapacity());
        this.roomNumber = roomNumber;
        this.type = type;
    }

    public int getRoomNumber(){
        return roomNumber;
    }

    public double getCost(){
        return type.getNightlyRate();
    }

    public BedroomType getRoomType(){
        return type;
    }

    public boolean checkInGuest(Guest guest, int numberOfNights){
        if(guest.canAffordBedroom(this, numberOfNights) && getRemainingSpaces() > 0){
            guest.chargeBedroom(this, numberOfNights);
            checkInGuest(guest);
            return true;
        }
        return false;
    }

    @Override
    public String getInfo(){
        return "Bedroom";
    }





}
