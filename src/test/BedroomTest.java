package test;

import main.room.BedroomType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BedroomTest {
    private Seeds seeds;

    @Before
    public void before(){
        seeds = new Seeds();
    }


    @Test
    public void getCost(){
        assertEquals(50.0, seeds.singleRoom.getCost(), 0);
        assertEquals(83.5, seeds.doubleRoom.getCost(), 0);
        assertEquals(132.5, seeds.partyRoom.getCost(), 0);
    }

    @Test
    public void getCapacity(){
        assertEquals(1, seeds.singleRoom.getCapacity());
        assertEquals(2, seeds.doubleRoom.getCapacity());
        assertEquals(3, seeds.partyRoom.getCapacity());
    }

    @Test
    public void getRoomNumber(){
        assertEquals(1, seeds.singleRoom.getRoomNumber());
        assertEquals(2, seeds.doubleRoom.getRoomNumber());
        assertEquals(3, seeds.partyRoom.getRoomNumber());
    }

    @Test
    public void getRoomType(){
        assertEquals(BedroomType.SINGLE, seeds.singleRoom.getRoomType());
        assertEquals(BedroomType.DOUBLE, seeds.doubleRoom.getRoomType());
        assertEquals(BedroomType.PARTY_ROOM, seeds.partyRoom.getRoomType());
    }

    @Test
    public void getInfo(){
        assertEquals("Bedroom", seeds.singleRoom.getInfo());
        assertEquals("Bedroom", seeds.doubleRoom.getInfo());
        assertEquals("Bedroom", seeds.partyRoom.getInfo());
    }

    @Test
    public void checkInGuest__returns_true(){
        assertEquals(true, seeds.singleRoom.checkInGuest(seeds.guestOne));
        assertEquals(true, seeds.doubleRoom.checkInGuest(seeds.guestTwo));
        assertEquals(true, seeds.partyRoom.checkInGuest(seeds.guestThree));
    }

    @Test
    public void checkInGuest__returns_false(){
        seeds.singleRoom.checkInGuest(seeds.guestOne);
        seeds.doubleRoom.checkInGuest(seeds.guestTwo);
        seeds.doubleRoom.checkInGuest(seeds.guestThree);
        seeds.partyRoom.checkInGuest(seeds.guestFour);
        seeds.partyRoom.checkInGuest(seeds.guestFive);
        seeds.partyRoom.checkInGuest(seeds.guestSix);
        assertEquals(false, seeds.singleRoom.checkInGuest(seeds.guestSeven));
        assertEquals(false, seeds.doubleRoom.checkInGuest(seeds.guestEight));
        assertEquals(false, seeds.partyRoom.checkInGuest(seeds.guestNine));
    }

    @Test
    public void checkOutGuest__returns_true(){
        seeds.singleRoom.checkInGuest(seeds.guestOne);
        seeds.doubleRoom.checkInGuest(seeds.guestTwo);
        seeds.partyRoom.checkInGuest(seeds.guestThree);
        assertEquals(true, seeds.singleRoom.checkOutGuest(seeds.guestOne));
        assertEquals(true, seeds.doubleRoom.checkOutGuest(seeds.guestTwo));
        assertEquals(true, seeds.partyRoom.checkOutGuest(seeds.guestThree));
    }

    @Test
    public void checkOutGuest__returns_false_no_guests_in_room(){
        assertEquals(false, seeds.singleRoom.checkOutGuest(seeds.guestOne));
        assertEquals(false, seeds.doubleRoom.checkOutGuest(seeds.guestTwo));
        assertEquals(false, seeds.partyRoom.checkOutGuest(seeds.guestThree));
    }

    @Test
    public void checkOutGuest__returns_false_wrong_guest_in_room(){
        seeds.singleRoom.checkInGuest(seeds.guestOne);
        seeds.doubleRoom.checkInGuest(seeds.guestTwo);
        seeds.partyRoom.checkInGuest(seeds.guestThree);
        assertEquals(false, seeds.singleRoom.checkOutGuest(seeds.guestFour));
        assertEquals(false, seeds.doubleRoom.checkOutGuest(seeds.guestFive));
        assertEquals(false, seeds.partyRoom.checkOutGuest(seeds.guestSix));
    }

    @Test
    public void getRemainingSpaces__no_guests(){
        assertEquals(1, seeds.singleRoom.getRemainingSpaces());
        assertEquals(2, seeds.doubleRoom.getRemainingSpaces());
        assertEquals(3, seeds.partyRoom.getRemainingSpaces());
    }

    @Test
    public void getRemainingSpaces__one_guest(){
        seeds.singleRoom.checkInGuest(seeds.guestOne);
        seeds.doubleRoom.checkInGuest(seeds.guestTwo);
        seeds.partyRoom.checkInGuest(seeds.guestThree);
        assertEquals(0, seeds.singleRoom.getRemainingSpaces());
        assertEquals(1, seeds.doubleRoom.getRemainingSpaces());
        assertEquals(2, seeds.partyRoom.getRemainingSpaces());
    }

    @Test
    public void getGuests(){
        seeds.singleRoom.checkInGuest(seeds.guestOne);
        seeds.doubleRoom.checkInGuest(seeds.guestTwo);
        seeds.doubleRoom.checkInGuest(seeds.guestThree);
        seeds.partyRoom.checkInGuest(seeds.guestFour);
        seeds.partyRoom.checkInGuest(seeds.guestFive);
        seeds.partyRoom.checkInGuest(seeds.guestSix);
        assertEquals(1, seeds.singleRoom.getGuests().size());
        assertEquals(2, seeds.doubleRoom.getGuests().size());
        assertEquals(3, seeds.partyRoom.getGuests().size());
    }
}
