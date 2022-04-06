package ru.skillbox;

public class Hdd {
    private final HddType TYPE;
    private final int CAPACITY;
    private final double WEIGHT;

    public Hdd(HddType TYPE, int CAPACITY, double WEIGHT) {
        this.TYPE = TYPE;
        this.CAPACITY = CAPACITY;
        this.WEIGHT = WEIGHT;
    }

    public HddType getTYPE() { return TYPE; }
    public int getCAPACITY() { return CAPACITY; }
    public double getWEIGHT() { return WEIGHT; }

    public String toString() {
        return "Жесткий диск: " +"\n"+
                "\t"+"тип - "+ TYPE + "\n"+
                "\t"+"объем - "+ CAPACITY+ "Тb" + "\n"+
                "\t"+"вес - " + WEIGHT + "g" +"\n";
    }
}
