package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        ArithmeticCalculator calculator=new ArithmeticCalculator(3,4);
        System.out.println(calculator.calculate(Operation.MULTIPLY));
        System.out.println(calculator.calculate(Operation.ADD));
        System.out.println(calculator.calculate(Operation.SUBTRACT));
    }
}
