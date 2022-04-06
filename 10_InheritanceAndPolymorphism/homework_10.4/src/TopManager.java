public class TopManager implements Employee {

  private Company company;

  public TopManager(Company company) {
    setCompany(company);
  }

  private final int FIXED_SALARY = 120000;
  private final int MIN_INCOME_BONUS = 1_000_000;
  private final double BONUS_INDEX = 1.5;

  @Override
  public int getMonthSalary() {
    int salary =
        company.getIncome() <= MIN_INCOME_BONUS ? FIXED_SALARY : (int) (FIXED_SALARY
            + BONUS_INDEX * FIXED_SALARY);
    return salary;
  }

  public void setCompany(Company company) {
    this.company = company;
  }
}
