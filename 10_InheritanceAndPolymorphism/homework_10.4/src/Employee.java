import java.util.Comparator;

public interface Employee extends Comparable<Employee> {

    int getMonthSalary();

    @Override
    default int compareTo(Employee o) {
        return Integer.compare(getMonthSalary(), o.getMonthSalary());
    }
    default void setCompany(Company company){};
}
