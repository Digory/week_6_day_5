package main.room;

public enum ConferenceRoomType {

    RICARDO_ROOM("Ricardo's lorry-themed room", 10, 100.0),
    KIRSTIN_ROOM("Kirstin's happiness and rainbows room", 15, 200.0),
    GEMMA_ROOM("Fashion room plus glitterbomb", 12, 325.5);

    private String description;
    private int capacity;
    private double cost;

    ConferenceRoomType(String description, int capacity, double cost) {
        this.description = description;
        this.capacity = capacity;
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getCost() {
        return cost;
    }
}
