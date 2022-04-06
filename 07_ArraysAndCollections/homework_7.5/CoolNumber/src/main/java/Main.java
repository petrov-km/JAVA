import java.util.*;

public class Main {
    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска введимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */

    public static void main(String[] args) {
        List<String> coolNumbersList =CoolNumbers.generateCoolNumbers();
        HashSet<String> coolNumbersHashSet = new HashSet<>(coolNumbersList);
        TreeSet<String> coolNumbersTreeSet = new TreeSet<>(coolNumbersList);
        String inputNumber = "Х999ХdХ199";

        long start = System.nanoTime();
        String cheсk= CoolNumbers.bruteForceSearchInList(coolNumbersList, inputNumber)?"":"не ";
        long time = System.nanoTime() - start;
        System.out.printf("Поиск перебором: номер %sнайден, поиск занял %s нс\n", cheсk, time);

        Collections.sort(coolNumbersList);
        start = System.nanoTime();
        cheсk = CoolNumbers.binarySearchInList(coolNumbersList, inputNumber)?"":"не ";
        time = System.nanoTime() - start;
        System.out.printf("Бинарный поиск: номер %sнайден, поиск занял %s нс\n", cheсk, time);

        start = System.nanoTime();
        cheсk = CoolNumbers.searchInHashSet(coolNumbersHashSet, inputNumber)?"":"не ";
        time = System.nanoTime() - start;
        System.out.printf("Поиск в HashSet: номер %sнайден, поиск занял %s нс\n", cheсk, time);

        start = System.nanoTime();
        cheсk = CoolNumbers.searchInTreeSet(coolNumbersTreeSet, inputNumber)?"":"не ";
        time = System.nanoTime() - start;
        System.out.printf("Поиск в TreeSet: номер %sнайден, поиск занял %s нс\n", cheсk, time);
    }
}
