import java.util.HashMap;

public class Main {
    public static final String PATH = "C:\\Users\\petrov\\IdeaProjects\\java_basics\\13_FilesAndNetwork\\homework_13.3\\src\\test\\resources\\movementList.csv";

    public static void main(String[] args) {
        Movements movements = new Movements(PATH);

       /* System.out.println("Сумма расходов: " + movements.getExpenseSum());
        System.out.println("Сумма доходов: " + movements.getIncomeSum());
        movements.printSumExpensesByOrganizations();
        System.out.println("======================================");
        movements.printSumIncomesByOrganizations();*/


        HashMap<String,Double> sumExp = movements.getSumExpensesByOrganizations();
        HashMap<String,Double> sumIncome = movements.getSumIncomesByOrganizations();
        System.out.println("Суммы расходов по организациям:");
        sumExp.keySet().forEach(name -> System.out.println(name + "           " + sumExp.get(name)));
        System.out.println("Суммы доходов по организациям:");
        sumIncome.keySet().forEach(name -> System.out.println(name + "           " + sumIncome.get(name)));
    }
}
