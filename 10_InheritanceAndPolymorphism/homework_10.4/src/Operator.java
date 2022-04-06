public class Operator implements Employee {
    private final int FIXED_SALARY = 50000;
    private int salary = (int) (FIXED_SALARY + Math.random()*FIXED_SALARY/2);
    @Override
    public int getMonthSalary() {
        return salary;
    }
}
