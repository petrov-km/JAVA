package ru.skillbox;

public class Cpu {

    private final double FREQUENCY;
    private final int CORE_AMOUNT;
    private final String BRAND;
    private final int WEIGHT;

    public Cpu(double FREQUENCY, int CORE_AMOUNT, String BRAND, int WEIGHT) {
        this.FREQUENCY = FREQUENCY;
        this.CORE_AMOUNT = CORE_AMOUNT;
        this.BRAND = BRAND;
        this.WEIGHT = WEIGHT;
    }

    public double getFREQUENCY() { return FREQUENCY; }
    public int getCORE_AMOUNT() { return CORE_AMOUNT; }
    public String getBRAND() { return BRAND; }
    public int getWEIGHT() { return WEIGHT; }

    public Cpu setFREQUENCY(double FREQUENCY ){ return new Cpu(FREQUENCY,CORE_AMOUNT,BRAND,WEIGHT); }
    public Cpu setCORE_AMOUNT(int CORE_AMOUNT ){ return new Cpu(FREQUENCY,CORE_AMOUNT,BRAND,WEIGHT); }
    public Cpu setBRAND(String BRAND ){ return new Cpu(FREQUENCY,CORE_AMOUNT,BRAND,WEIGHT); }
    public Cpu setWEIGHT(int WEIGHT ){ return new Cpu(FREQUENCY,CORE_AMOUNT,BRAND,WEIGHT); }

    public String toString() {
        return "Процессор: " +"\n"+
                "\t"+"частота - "+ FREQUENCY + " GHz"+ "\n"+
                "\t"+"количество ядер - "+ CORE_AMOUNT+ "\n"+
                "\t"+"производитель - " + BRAND + "\n"+
                "\t"+"вес - " + WEIGHT + "g" +"\n";
    }
}
