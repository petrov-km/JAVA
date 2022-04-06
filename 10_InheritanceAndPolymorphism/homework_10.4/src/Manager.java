public class Manager implements Employee {

  private final int FIXED_SALARY = 100000;
  private final int MAX_SALES = 200000;
  private final int MIN_SALES = 115000;
  private int sales = (int) (MIN_SALES + Math.random() * (MAX_SALES - MIN_SALES));

  int salary = (int) (FIXED_SALARY + 0.05 * sales);

  @Override
  public int getMonthSalary() {
    return salary;
  }

  public int getSalary() {
    return salary;
  }
}
