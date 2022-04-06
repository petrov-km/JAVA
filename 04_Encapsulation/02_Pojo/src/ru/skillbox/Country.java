package ru.skillbox;

public class Country {
    private String name;
    private int population;
    private int area;
    private String capitalName;
    private boolean accessToSea;
    public Country(){};
    public Country(String name){ this.name= name;}

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getCapitalName() {
        return capitalName;
    }

    public void setCapitalName(String capitalName) {
        this.capitalName = capitalName;
    }

    public boolean getAccessToSea() {
        return accessToSea;
    }

    public void setAccessToSea(boolean accessToSea) {
        this.accessToSea = accessToSea;
    }



}
