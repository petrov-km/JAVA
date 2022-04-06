import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    Company company = new Company();

    for (int i = 0; i < 180; i++) {
      company.hire(new Operator());
    }
    ArrayList<Employee> workers = new ArrayList<>();
    for (int i = 0; i < 80; i++) {
      workers.add(new Manager());
    }
    company.hireAll(workers);

    for (int i = 0; i < 10; i++) {
      company.hire(new TopManager(company));
    }
    List<Employee> topSalaryStaff = company.getTopSalaryStaff(15);
    for (Employee e: topSalaryStaff){
      System.out.println(e.getMonthSalary());
    }
    System.out.println("--------------");

    List<Employee> lowestSalaryStaff = company.getLowestSalaryStaff(10);
    for (Employee e: lowestSalaryStaff){
      System.out.println(e.getMonthSalary());
    }
    System.out.println("--------------");
    System.out.println("количество рабочих:"+ company.getEmployees().size());
    List<Employee> employees = company.getEmployees();
    for (int i = 0; i < company.getEmployees().size()*0.5; i++) {
      company.fire(employees.get(i));
    }
    System.out.println("количество рабочих:"+ company.getEmployees().size());
    topSalaryStaff = company.getTopSalaryStaff(15);
    for (Employee e: topSalaryStaff){
      System.out.println(e.getMonthSalary());
    }
    System.out.println("--------------");

   lowestSalaryStaff = company.getLowestSalaryStaff(10);
    for (Employee e: lowestSalaryStaff){
      System.out.println(e.getMonthSalary());
    }
    System.out.println("Доход компании - " + company.getIncome());

  }
}
