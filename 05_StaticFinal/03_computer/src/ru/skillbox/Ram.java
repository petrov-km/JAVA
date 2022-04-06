package ru.skillbox;

public class Ram {
    private final String TYPE;
    private final int CAPACITY;
    private final double WEIGHT;

    public Ram(String TYPE, int CAPACITY, double WEIGHT) {
        this.TYPE = TYPE;
        this.CAPACITY = CAPACITY;
        this.WEIGHT = WEIGHT;
    }

    public String getTYPE() { return TYPE; }
    public int getCAPACITY() { return CAPACITY; }
    public double getWEIGHT() { return WEIGHT; }


    public String toString() {
        return "Оперативная память: " +"\n"+
                "\t"+"тип - "+ TYPE + "\n"+
                "\t"+"объем - "+ CAPACITY+ "Gb" + "\n"+
                "\t"+"вес - " + WEIGHT + "g" +"\n";
    }
}
