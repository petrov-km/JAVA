import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Company {

  //private int income = 10_000_001;
  private List<Employee> employees = new ArrayList<>();

  public void hire(Employee employee) {
    employee.setCompany(this);
    employees.add(employee);
  }

  public void hireAll(List<Employee> employees) {
    for (Employee e : employees) {
      hire(e);
    }
  }

  public void fire(Employee employee) {
    employee.setCompany(null);
    employees.remove(employee);
  }

  public int getIncome() {
    int income = 0;
    for (Employee e : employees) {
      if (e instanceof Manager) {
        income += ((Manager) e).getSalary();
      }
    }
    return income;
  }

  public List<Employee> getTopSalaryStaff(int count) {
    return getCheckedList(count, Comparator.reverseOrder());
  }

  public List<Employee> getLowestSalaryStaff(int count) {
    return getCheckedList(count, Comparator.naturalOrder());
  }

  private List<Employee> getCheckedList(int count, Comparator cmp) {
    if (count < 0) {
      System.out.println("Передано отрицательное число сотрудников!");
      return Collections.emptyList();
    }
    if (count > employees.size()) {
      count = employees.size();
    }
    Collections.sort(employees);
    return employees.subList(0, count);
  }


  public List<Employee> getEmployees() {
    return new ArrayList<>(employees);
  }


}
