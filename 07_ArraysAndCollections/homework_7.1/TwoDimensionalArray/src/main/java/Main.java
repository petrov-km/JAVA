import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Распечатайте сгенерированный в классе TwoDimensionalArray.java двумерный массив
        char[][] array = TwoDimensionalArray.getTwoDimensionalArray(9);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j< array[i].length; j++){
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
}
