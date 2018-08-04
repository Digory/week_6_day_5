package test;

import main.guest.Guest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiningRoomTest {

    private Seeds seeds;

    @Before
    public void before(){
        seeds = new Seeds();
    }


    @Test
    public void getCapacity(){
        assertEquals(15, seeds.diningRoom.getCapacity());
    }

    @Test
    public void getInfo(){
        assertEquals("Dining Room", seeds.diningRoom.getInfo());
    }

    @Test
    public void checkInGuest__returns_true(){
        assertEquals(true, seeds.diningRoom.checkInGuest(seeds.guestOne));
    }

    @Test
    public void checkInGuest__returns_false(){
        for(int i = 0; i < 15; i++){
            seeds.diningRoom.checkInGuest(new Guest(100.0));
        }
        assertEquals(false, seeds.diningRoom.checkInGuest(seeds.guestOne));
    }

    @Test
    public void checkOutGuest__returns_true(){
        seeds.diningRoom.checkInGuest(seeds.guestOne);
        assertEquals(true, seeds.diningRoom.checkOutGuest(seeds.guestOne));
    }

    @Test
    public void checkOutGuest__returns_false_no_guests_in_room(){
        assertEquals(false, seeds.diningRoom.checkOutGuest(seeds.guestOne));
    }

    @Test
    public void checkOutGuest__returns_false_wrong_guest_in_room(){
        seeds.diningRoom.checkInGuest(seeds.guestOne);
        assertEquals(false, seeds.singleRoom.checkOutGuest(seeds.guestTwo));
    }

    @Test
    public void getRemainingSpaces__no_guests(){
        assertEquals(15, seeds.diningRoom.getRemainingSpaces());
    }

    @Test
    public void getRemainingSpaces__one_guest(){
        seeds.diningRoom.checkInGuest(seeds.guestOne);
        assertEquals(14, seeds.diningRoom.getRemainingSpaces());
    }

    @Test
    public void getGuests(){
        seeds.diningRoom.checkInGuest(seeds.guestOne);
        seeds.diningRoom.checkInGuest(seeds.guestTwo);
        seeds.diningRoom.checkInGuest(seeds.guestThree);
        assertEquals(3, seeds.diningRoom.getGuests().size());
    }
}
