package main.room;

public enum BedroomType {

    SINGLE(1, 50.0),
    DOUBLE(2, 83.5),
    PARTY_ROOM(3, 132.5);

    private final int capacity;
    private final double nightlyRate;

    BedroomType(int capacity, double nightlyRate){
        this.capacity = capacity;
        this.nightlyRate = nightlyRate;
    }

    public int getCapacity(){
        return capacity;
    }

    public double getNightlyRate(){
        return nightlyRate;
    }
}
