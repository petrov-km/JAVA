package ru.skillbox;

public class Elevator {
    private int currentFloor = 1;
    private int minFloor = 0;
    private int maxFloor = 0;

    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    private void moveDown() {
        --currentFloor;
    }

    private void moveUp() {
        ++currentFloor;
    }

    public void move(int floor) {
        if (floor < minFloor || floor > maxFloor) {
            System.out.println("Некорректный номер этажа");
            return;
        }
        while (currentFloor != floor) {
            if (floor > currentFloor) {
                moveUp();
                System.out.println(currentFloor + " этаж");
            } else {
                moveDown();
                System.out.println(currentFloor + " этаж");
            }
        }
    }

}
