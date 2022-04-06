package ru.skillbox;

public class Keyboard {
    private final String TYPE;
    private final boolean HASBACKLIGHT;
    private final double WEIGHT;

    public Keyboard(String TYPE, boolean HASBACKLIGHT, double WEIGHT) {
        this.TYPE = TYPE;
        this.HASBACKLIGHT = HASBACKLIGHT;
        this.WEIGHT = WEIGHT;
    }

    public String getTYPE() { return TYPE; }
    public boolean isHASBACKLIGHT() { return HASBACKLIGHT; }
    public double getWEIGHT() { return WEIGHT; }

    public String toString() {
        return "Клавиатура: " +"\n"+
                "\t"+"тип - "+ TYPE + "\n"+
                "\t"+"наличие подсветки - "+ HASBACKLIGHT + "\n"+
                "\t"+"вес - " + WEIGHT + "g" +"\n";
    }
}
