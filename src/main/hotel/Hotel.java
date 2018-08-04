package main.hotel;

import main.guest.Guest;
import main.room.Bedroom;
import main.room.ConferenceRoom;
import main.room.DiningRoom;
import main.room.Room;

import java.util.ArrayList;

public class Hotel {

    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private ArrayList<DiningRoom> diningRooms;


    public Hotel(){
        bedrooms = new ArrayList<>();
        conferenceRooms = new ArrayList<>();
        diningRooms = new ArrayList<>();
    }


    public void addRoom(Room room){
        switch(room.getInfo()){
            case "Bedroom": bedrooms.add((Bedroom)room);
            break;
            case "Conference Room": conferenceRooms.add((ConferenceRoom)room);
            break;
            case "Dining Room": diningRooms.add((DiningRoom)room);
        }
    }

    public boolean checkInGuestToRoom(Guest guest, Room room) {
        return room.checkInGuest(guest);
    }

    public boolean checkInGuestToBedroom(Guest guest, Bedroom bedroom, int numberOfNights){
        return bedroom.checkInGuest(guest, numberOfNights);
    }

    public boolean checkOutGuest(Guest guest, Room room){
        return room.checkOutGuest(guest);
    }

    public boolean checkInListOfGuests(ArrayList<Guest> guests, Room room){
        if(room.getRemainingSpaces() >= guests.size()){
            for (Guest guest : guests){
                room.checkInGuest(guest);
            }
            return true;
        }
        return false;
    }

    public ArrayList<Bedroom> getAllBedrooms(){
        return bedrooms;
    }

    public ArrayList<ConferenceRoom> getAllConferenceRooms(){
        return conferenceRooms;
    }

    public ArrayList<DiningRoom> getAllDiningRooms(){
        return diningRooms;
    }

    public ArrayList<Bedroom> getEmptyBedrooms(){
        ArrayList<Bedroom> emptyBedrooms = new ArrayList<>();
        for(Bedroom bedroom : bedrooms){
            if(bedroom.getGuests().size() == 0){
                emptyBedrooms.add(bedroom);
            }
        }
        return emptyBedrooms;
    }
}
