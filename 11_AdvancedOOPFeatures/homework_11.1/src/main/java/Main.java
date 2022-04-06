import java.util.Collections;
import java.util.List;

public class Main {

    public static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        System.out.println(staff);
        System.out.println("----------------");
        sortBySalaryAndAlphabet(staff);
        System.out.println(staff);
    }

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {
        Collections.sort(staff, (o1, o2) -> {
            int compareSalary = o1.getSalary().compareTo(o2.getSalary());
            return compareSalary != 0 ? compareSalary : o1.getName().compareTo(o2.getName());

//            if (compareSalary != 0) {
//                return compareSalary;
//            } else {
//                return o1.getName().compareTo(o2.getName());
//            }
        });

        //TODO Метод должен отсортировать сотрудников по заработной плате и алфавиту.
    }
}