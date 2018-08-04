package test;

import main.guest.Guest;
import main.hotel.Hotel;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    private Hotel hotel;
    private Seeds seeds;
    private boolean actual;

    @Before
    public void before(){
        hotel = new Hotel();
        seeds = new Seeds();
    }

    @Test
    public void addRoom__diningRoom(){
        hotel.addRoom(seeds.diningRoom);
        assertEquals(1, hotel.getAllDiningRooms().size());
    }

    @Test
    public void addRoom__conferenceRoom(){
        hotel.addRoom(seeds.kirstinRoom);
        assertEquals(1, hotel.getAllConferenceRooms().size());
    }

    @Test
    public void addRoom__bedroom(){
        hotel.addRoom(seeds.singleRoom);
        assertEquals(1, hotel.getAllBedrooms().size());
    }

    @Test
    public void addRoom__bedroom_multiple(){
        hotel.addRoom(seeds.singleRoom);
        hotel.addRoom(seeds.doubleRoom);
        hotel.addRoom(seeds.partyRoom);
        assertEquals(3, hotel.getAllBedrooms().size());
    }

    @Test
    public void checkInGuestToRoom__returns_true(){
        actual = hotel.checkInGuestToRoom(seeds.guestOne, seeds.singleRoom);
        assertEquals(true, actual);
    }

    @Test
    public void checkInGuestToRoom__returns_false(){
        hotel.checkInGuestToRoom(seeds.guestOne, seeds.singleRoom);
        actual = hotel.checkInGuestToRoom(seeds.guestTwo, seeds.singleRoom);
        assertEquals(false, actual);
    }

    @Test
    public void checkOutGuest__returns_true(){
        hotel.addRoom(seeds.singleRoom);
        hotel.checkInGuestToRoom(seeds.guestOne, seeds.singleRoom);
        actual = hotel.checkOutGuest(seeds.guestOne, seeds.singleRoom);
        assertEquals(true, actual);
    }

    @Test
    public void checkOutGuest__returns_false(){
        hotel.addRoom(seeds.singleRoom);
        actual = hotel.checkOutGuest(seeds.guestOne, seeds.singleRoom);
        assertEquals(false, actual);
    }

    @Test
    public void checkInListOfGuests__returns_true(){
        hotel.addRoom(seeds.partyRoom);
        ArrayList<Guest> guestList = new ArrayList<>();
        guestList.add(seeds.guestOne);
        guestList.add(seeds.guestTwo);
        guestList.add(seeds.guestThree);
        actual = hotel.checkInListOfGuests(guestList, seeds.partyRoom);
        assertEquals(true, actual);
    }

    @Test
    public void checkInListOfGuests__returns_false(){
        hotel.addRoom(seeds.partyRoom);
        ArrayList<Guest> guestList = new ArrayList<>();
        guestList.add(seeds.guestOne);
        guestList.add(seeds.guestTwo);
        guestList.add(seeds.guestThree);
        guestList.add(seeds.guestFour);
        actual = hotel.checkInListOfGuests(guestList, seeds.partyRoom);
        assertEquals(false, actual);
    }

    // EXTENSIONS

    @Test
    public void getEmptyBedrooms(){
        hotel.addRoom(seeds.singleRoom);
        hotel.addRoom(seeds.doubleRoom);
        hotel.addRoom(seeds.partyRoom);
        seeds.singleRoom.checkInGuest(seeds.guestOne);
        assertEquals(2, hotel.getEmptyBedrooms().size());
    }

    @Test
    public void checkInGuestToBedroomMultipleNights__guest_can_afford(){
        hotel.addRoom(seeds.singleRoom);
        actual = hotel.checkInGuestToBedroom(seeds.guestOne, seeds.singleRoom, 1);
        assertEquals(true, actual);
    }

    @Test
    public void checkInGuestToBedroomMultipleNights__guest_cannot_afford(){
        hotel.addRoom(seeds.singleRoom);
        actual = hotel.checkInGuestToBedroom(seeds.guestOne, seeds.singleRoom, 3);
        assertEquals(false, actual);
    }



}
