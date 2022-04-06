package ru.skillbox;

public class Computer {
    private String vendor;
    private String name;
    private Cpu cpu;
    private Ram ram;
    private Hdd hdd;
    private Display display;
    private Keyboard keyboard;
    //private double
    public double calculateComputerWeight(){
        return cpu.getWEIGHT()+ ram.getWEIGHT()+hdd.getWEIGHT()+display.getWEIGHT()+ keyboard.getWEIGHT();
    }

    public Computer(String vendor, String name, Cpu cpu, Ram ram, Hdd hdd, Display display, Keyboard keyboard) {
        this.vendor = vendor;
        this.name = name;
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
        this.display = display;
        this.keyboard = keyboard;
    }

    public String getVendor() { return vendor; }
    public String getName() { return name; }
    public Cpu getCpu() { return cpu; }
    public Ram getRam() { return ram; }
    public Hdd getHdd() { return hdd; }
    public Display getDisplay() { return display; }
    public Keyboard getKeyboard() { return keyboard; }

    public void setVendor(String vendor) { this.vendor = vendor; }
    public void setName(String name) { this.name = name; }
    public void setCpu(Cpu cpu) { this.cpu = cpu; }
    public void setRam(Ram ram) { this.ram = ram; }
    public void setHdd(Hdd hdd) { this.hdd = hdd; }
    public void setDisplay(Display display) { this.display = display; }
    public void setKeyboard(Keyboard keyboard) { this.keyboard = keyboard; }

    /*public Computer setVendor(String vendor ){ return new Computer(vendor,name,cpu,ram,hdd,display,keyboard); }
    public Computer setName(String name ){ return new Computer(vendor,name,cpu,ram,hdd,display,keyboard); }
    public Computer setCpu(Cpu cpu ){ return new Computer(vendor,name,cpu,ram,hdd,display,keyboard); }
    public Computer setRam(Ram ram ){ return new Computer(vendor,name,cpu,ram,hdd,display,keyboard); }
    public Computer setHdd(Hdd hdd ){ return new Computer(vendor,name,cpu,ram,hdd,display,keyboard); }
    public Computer setDisplay(Display display ){ return new Computer(vendor,name,cpu,ram,hdd,display,keyboard); }
    public Computer setKeyboard(Keyboard keyboard ){ return new Computer(vendor,name,cpu,ram,hdd,display,keyboard); }*/

    public String toString(){
        return "=================================================="+"\n"+
                vendor + " "+ name + "\n"+
                "Основные характеристики:" + "\n"+
                cpu + ram + hdd + display + keyboard;
    }

}
