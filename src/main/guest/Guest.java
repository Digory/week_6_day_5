package main.guest;

import main.room.Bedroom;

public class Guest {
    private double money;

    public Guest(double money) {
        this.money = money;
    }

    public double getMoney(){
        return money;
    }

    public boolean canAffordBedroom(Bedroom bedroom, int numberOfNights){
        double costOfStay = bedroom.getCost() * numberOfNights;
        return money >= costOfStay;
    }

    public void chargeBedroom(Bedroom bedroom, int numberOfNights){
        double costOfStay = bedroom.getCost() * numberOfNights;
        if(money >= costOfStay) {
            money -= costOfStay;
        }
    }
}
