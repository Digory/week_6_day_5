package main.room;

public class ConferenceRoom extends Room{
    private ConferenceRoomType type;

    public ConferenceRoom(ConferenceRoomType type) {
        super(type.getCapacity());
        this.type = type;
    }

    public ConferenceRoomType getType() {
        return type;
    }

    public String getDescription(){
        return type.getDescription();
    }

    public double getCost(){
        return type.getCost();
    }

    public int getCapacity(){
        return type.getCapacity();
    }

    @Override
    public String getInfo() {
        return "Conference Room";
    }
}

