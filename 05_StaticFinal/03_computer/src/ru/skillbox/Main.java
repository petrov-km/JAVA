package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        Cpu cpu1 = new Cpu(2.5, 2, "Intel", 900);
        Ram ram1 = new Ram("DDR4", 8, 300);
        Hdd hdd1 = new Hdd(HddType.SSD, 2, 350);
        Display display1 = new Display(14.5, DisplayType.IPS, 250);
        Keyboard keyboard1 = new Keyboard("Membrane", true, 180);

        Computer computer1 = new Computer("Acer", "Aspire 5", cpu1, ram1, hdd1, display1, keyboard1);
        computer1.setCpu(cpu1.setFREQUENCY(4.5));
        Computer computer2= new Computer("Asus", "LaptopL210", cpu1.setWEIGHT(300),ram1,hdd1,display1,keyboard1);
        Computer computer3 = new Computer("Lenovo", "ThinkPad", cpu1.setCORE_AMOUNT(4), ram1, hdd1, display1, keyboard1);

        System.out.println(computer1  + "Вес компьютера - " + computer1.calculateComputerWeight() +"g"+"\n"+
                computer2  + "Вес компьютера - " + computer2.calculateComputerWeight()+"g"+ "\n"+
                computer3  + "Вес компьютера - " + computer3.calculateComputerWeight()+"g");
    }
}
