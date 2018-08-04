package test;

import main.guest.Guest;
import main.room.ConferenceRoomType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConferenceRoomTest {

    private Seeds seeds;

    @Before
    public void before(){
        seeds = new Seeds();
    }


    @Test
    public void getCost(){
        assertEquals(100.0, seeds.ricardoRoom.getCost(), 0);
        assertEquals(200.0, seeds.kirstinRoom.getCost(), 0);
        assertEquals(325.5, seeds.gemmaRoom.getCost(), 0);
    }

    @Test
    public void getCapacity(){
        assertEquals(10, seeds.ricardoRoom.getCapacity());
        assertEquals(15, seeds.kirstinRoom.getCapacity());
        assertEquals(12, seeds.gemmaRoom.getCapacity());
    }

    @Test
    public void getDescription(){
        assertEquals("Ricardo's lorry-themed room", seeds.ricardoRoom.getDescription());
        assertEquals("Kirstin's happiness and rainbows room", seeds.kirstinRoom.getDescription());
        assertEquals("Fashion room plus glitterbomb", seeds.gemmaRoom.getDescription());
    }

    @Test
    public void getRoomType(){
        assertEquals(ConferenceRoomType.RICARDO_ROOM, seeds.ricardoRoom.getType());
        assertEquals(ConferenceRoomType.KIRSTIN_ROOM, seeds.kirstinRoom.getType());
        assertEquals(ConferenceRoomType.GEMMA_ROOM, seeds.gemmaRoom.getType());
    }

    @Test
    public void getInfo(){
        assertEquals("Conference Room", seeds.ricardoRoom.getInfo());
        assertEquals("Conference Room", seeds.kirstinRoom.getInfo());
        assertEquals("Conference Room", seeds.gemmaRoom.getInfo());
    }

    @Test
    public void checkInGuest__returns_true(){
        assertEquals(true, seeds.ricardoRoom.checkInGuest(seeds.guestOne));
        assertEquals(true, seeds.kirstinRoom.checkInGuest(seeds.guestTwo));
        assertEquals(true, seeds.gemmaRoom.checkInGuest(seeds.guestThree));
    }

    @Test
    public void checkInGuest__returns_false(){
        for(int i = 0; i < 15; i++){
            seeds.ricardoRoom.checkInGuest(new Guest(100));
            seeds.kirstinRoom.checkInGuest(new Guest(100));
            seeds.gemmaRoom.checkInGuest(new Guest(100));
        }
        assertEquals(false, seeds.ricardoRoom.checkInGuest(seeds.guestOne));
        assertEquals(false, seeds.kirstinRoom.checkInGuest(seeds.guestTwo));
        assertEquals(false, seeds.gemmaRoom.checkInGuest(seeds.guestThree));
    }

    @Test
    public void checkOutGuest__returns_true(){
        seeds.ricardoRoom.checkInGuest(seeds.guestOne);
        seeds.kirstinRoom.checkInGuest(seeds.guestTwo);
        seeds.gemmaRoom.checkInGuest(seeds.guestThree);
        assertEquals(true, seeds.ricardoRoom.checkOutGuest(seeds.guestOne));
        assertEquals(true, seeds.kirstinRoom.checkOutGuest(seeds.guestTwo));
        assertEquals(true, seeds.gemmaRoom.checkOutGuest(seeds.guestThree));
    }

    @Test
    public void checkOutGuest__returns_false_no_guests_in_room(){
        assertEquals(false, seeds.ricardoRoom.checkOutGuest(seeds.guestOne));
        assertEquals(false, seeds.kirstinRoom.checkOutGuest(seeds.guestTwo));
        assertEquals(false, seeds.gemmaRoom.checkOutGuest(seeds.guestThree));
    }

    @Test
    public void checkOutGuest__returns_false_wrong_guest_in_room(){
        seeds.ricardoRoom.checkInGuest(seeds.guestOne);
        seeds.kirstinRoom.checkInGuest(seeds.guestTwo);
        seeds.gemmaRoom.checkInGuest(seeds.guestThree);
        assertEquals(false, seeds.ricardoRoom.checkOutGuest(seeds.guestFour));
        assertEquals(false, seeds.kirstinRoom.checkOutGuest(seeds.guestFive));
        assertEquals(false, seeds.gemmaRoom.checkOutGuest(seeds.guestSix));
    }

    @Test
    public void getRemainingSpaces__no_guests(){
        assertEquals(10, seeds.ricardoRoom.getRemainingSpaces());
        assertEquals(15, seeds.kirstinRoom.getRemainingSpaces());
        assertEquals(12, seeds.gemmaRoom.getRemainingSpaces());
    }

    @Test
    public void getRemainingSpaces__one_guest(){
        seeds.ricardoRoom.checkInGuest(seeds.guestOne);
        seeds.kirstinRoom.checkInGuest(seeds.guestTwo);
        seeds.gemmaRoom.checkInGuest(seeds.guestThree);
        assertEquals(9, seeds.ricardoRoom.getRemainingSpaces());
        assertEquals(14, seeds.kirstinRoom.getRemainingSpaces());
        assertEquals(11, seeds.gemmaRoom.getRemainingSpaces());
    }

    @Test
    public void getGuests(){
        seeds.ricardoRoom.checkInGuest(seeds.guestOne);
        seeds.kirstinRoom.checkInGuest(seeds.guestTwo);
        seeds.kirstinRoom.checkInGuest(seeds.guestThree);
        seeds.gemmaRoom.checkInGuest(seeds.guestFour);
        seeds.gemmaRoom.checkInGuest(seeds.guestFive);
        seeds.gemmaRoom.checkInGuest(seeds.guestSix);
        assertEquals(1, seeds.ricardoRoom.getGuests().size());
        assertEquals(2, seeds.kirstinRoom.getGuests().size());
        assertEquals(3, seeds.gemmaRoom.getGuests().size());
    }
}
