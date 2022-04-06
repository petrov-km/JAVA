package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        Dimensions dimensions1 =new Dimensions(3,2,3);
        //Dimensions dimensions2 =new Dimensions(2,2,2);
        Shipment shipment =new Shipment(dimensions1,34,"Пушкинская 14", true, "234fsd43", true);

        System.out.println(shipment.setDimensions(dimensions1.setWidth(9999)));
        System.out.println("===============================");
        System.out.println(shipment);
    }
}
