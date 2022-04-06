public class Operation {
  private String name;
  private String date;
  private double income;
  private double expense;

  public Operation(String name, String date, double income, double expense) {
    this.name = name;
    this.date = date;
    this.income = income;
    this.expense = expense;
  }

  public String getName() {
    return name;
  }

  public String getDate() {
    return date;
  }

  public double getIncome() {
    return income;
  }

  public double getExpense() {
    return expense;
  }

  @Override
  public String toString() {
    return "Operation{" +
        "name='" + name + '\'' +
        ", date='" + date + '\'' +
        ", income=" + income +
        ", expense=" + expense +
        '}';
  }
}
