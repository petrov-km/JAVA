package ru.skillbox;

public class Display {
    private final double SIZE;
    private final DisplayType TYPE;
    private final double WEIGHT;

    public Display(double SIZE, DisplayType TYPE, double WEIGHT) {
        this.SIZE = SIZE;
        this.TYPE = TYPE;
        this.WEIGHT = WEIGHT;
    }

    public double getSIZE() { return SIZE; }
    public DisplayType getTYPE() { return TYPE; }
    public double getWEIGHT() { return WEIGHT; }

    public String toString() {
        return "Экран: " +"\n"+
                "\t"+"диагональ - "+ SIZE + " Inches" + "\n"+
                "\t"+"тип - "+ TYPE + "\n"+
                "\t"+"вес - " + WEIGHT + "g" +"\n";
    }
}
