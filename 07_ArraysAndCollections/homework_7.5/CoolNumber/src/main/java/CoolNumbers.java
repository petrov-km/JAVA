import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class CoolNumbers {

    static String[] letters = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};

    public static List<String> generateCoolNumbers() {
        ArrayList<String> coolNumbers = new ArrayList<>();
        for (int i = 0; i < letters.length; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 0; k < letters.length; k++) {
                    for (int m = 0; m < letters.length; m++) {
                        for (int n = 1; n <= 199; n++) {
                            String s = "";
                            if (n < 10) {
                                s += "0" + n;
                            } else {
                                s += "" + n;
                            }
                            coolNumbers.add(letters[i] + j + j + j + letters[k] + letters[m] + s);
                        }
                    }
                }
            }
        }
        return coolNumbers;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        return list.contains(number);
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        if (Collections.binarySearch(sortedList, number) < 0) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        return hashSet.contains(number);
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        return treeSet.contains(number);
    }

}
