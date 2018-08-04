package test;

import main.guest.Guest;
import main.room.*;

public class Seeds {

    public Bedroom singleRoom;
    public Bedroom doubleRoom;
    public Bedroom partyRoom;

    public ConferenceRoom ricardoRoom;
    public ConferenceRoom kirstinRoom;
    public ConferenceRoom gemmaRoom;

    public DiningRoom diningRoom;

    public Guest guestOne;
    public Guest guestTwo;
    public Guest guestThree;
    public Guest guestFour;
    public Guest guestFive;
    public Guest guestSix;
    public Guest guestSeven;
    public Guest guestEight;
    public Guest guestNine;

    public Seeds(){
        singleRoom = new Bedroom(1, BedroomType.SINGLE);
        doubleRoom = new Bedroom(2, BedroomType.DOUBLE);
        partyRoom = new Bedroom(3, BedroomType.PARTY_ROOM);

        ricardoRoom = new ConferenceRoom(ConferenceRoomType.RICARDO_ROOM);
        kirstinRoom = new ConferenceRoom(ConferenceRoomType.KIRSTIN_ROOM);
        gemmaRoom = new ConferenceRoom(ConferenceRoomType.GEMMA_ROOM);

        diningRoom = new DiningRoom();

        guestOne = new Guest(100.0);
        guestTwo = new Guest(200.0);
        guestThree = new Guest(300.0);
        guestFour = new Guest(400.0);
        guestFive = new Guest(500.0);
        guestSix = new Guest(1000.0);

    }
}
