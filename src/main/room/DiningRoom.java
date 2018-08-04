package main.room;

public class DiningRoom extends Room{

    public DiningRoom() {
        super(15);
    }

    @Override
    public String getInfo() {
        return "Dining Room";
    }
}
