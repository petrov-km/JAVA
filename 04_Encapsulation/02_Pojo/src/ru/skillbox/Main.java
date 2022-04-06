package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        Country country=new Country();
        country.setName("Russia");
        country.setPopulation(146171015);
        country.setCapitalName("Moscow");
        country.setArea(17130000);
        country.setAccessToSea(false);
        System.out.println( country.getName()+"\n"+
                            country.getCapitalName()+"\n"+
                            country.getPopulation()+"\n"+
                            country.getArea()+"\n"+
                            country.getAccessToSea());
        System.out.println("=================================================");
        Smartphone smartphone = new Smartphone("Samsung","Galaxy S100500");
        smartphone.setColor("pink");
        smartphone.setScreenSize(10.5);
        smartphone.setWidth(120);
        smartphone.setOperatingSystem("Android");
        smartphone.setStorageCapacity(64);
        System.out.println( smartphone.getBrandName()+"\n"+
                            smartphone.getModelName()+"\n"+
                            smartphone.getColor()+"\n"+
                            smartphone.getOperatingSystem()+"\n"+
                            smartphone.getScreenSize()+"\n"+
                            smartphone.getWidth()+"\n"+
                            smartphone.getStorageCapacity());
    }

}
