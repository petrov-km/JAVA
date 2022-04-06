package ru.skillbox;

public class ArithmeticCalculator {
    private int number1;
    private int number2;
    private double result;

    public ArithmeticCalculator(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    public double calculate(Operation operation) {
        switch (operation) {
            case ADD:
                result = number1 + number2;
                break;
            case MULTIPLY:
                result = number1 * number2;
                break;
            case SUBTRACT:
                result = number1 - number2;
                break;
        }
        return result;
    }
}
