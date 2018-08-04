package test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuestTest {

    private Seeds seeds;
    private boolean actual;

    @Before
    public void before(){
        seeds = new Seeds();
    }

    @Test
    public void canAffordBedroom__returns_true(){
        actual = seeds.guestOne.canAffordBedroom(seeds.singleRoom, 1);
        assertEquals(true, actual);
    }

    @Test
    public void canAffordBedroom__returns_false(){
        actual = seeds.guestOne.canAffordBedroom(seeds.singleRoom, 3);
        assertEquals(false, actual);
    }

    @Test
    public void getMoney(){
        assertEquals(100.0, seeds.guestOne.getMoney(), 0);
    }

    @Test
    public void chargeBedroom(){
        seeds.guestOne.chargeBedroom(seeds.singleRoom, 1);
        assertEquals(50.0, seeds.guestOne.getMoney(), 0);
    }
}
