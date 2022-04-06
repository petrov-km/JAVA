package ru.skillbox;

public class Shipment {
    private final Dimensions dimensions;
    private final double weight;
    private final String deliveryAddress;
    private final boolean allowUpend;
    private final String regNumber;
    private final boolean isDelicate;

    @Override
    public String toString() {
        return dimensions + "\n" + weight + "\n" + deliveryAddress + "\n" + allowUpend + "\n" + regNumber + "\n" + isDelicate;
    }

    public Shipment(Dimensions dimensions, double weight, String deliveryAddress, boolean allowUpend, String regNumber, boolean isDelicate) {
        this.dimensions = dimensions;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.allowUpend = allowUpend;
        this.regNumber = regNumber;
        this.isDelicate = isDelicate;
    }
    public Shipment setDimensions(Dimensions dimensions){
        return new Shipment(dimensions, weight,deliveryAddress,allowUpend,regNumber,isDelicate);
    }

    public Shipment setWeight(double weight) {
        return new Shipment(dimensions, weight, deliveryAddress, allowUpend, regNumber, isDelicate);
    }
    public Shipment setDeliveryAddress(String deliveryAddress) {
        return new Shipment(dimensions, weight, deliveryAddress, allowUpend, regNumber, isDelicate);
    }
    public Shipment setAllowUpend(boolean allowUpend){
        return new Shipment(dimensions, weight,deliveryAddress,allowUpend,regNumber,isDelicate);
    }
    public Shipment setRegNumber(String regNumber){
        return new Shipment(dimensions, weight,deliveryAddress,allowUpend,regNumber,isDelicate);
    }
    public Shipment setIsDelicate(boolean isDelicate){
        return new Shipment(dimensions, weight,deliveryAddress,allowUpend,regNumber,isDelicate);
    }

}

