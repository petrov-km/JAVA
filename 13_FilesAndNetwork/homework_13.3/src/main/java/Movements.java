import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.w3c.dom.ls.LSOutput;

public class Movements {

  private HashMap<String, TotalIncomeAndExpenses> infoMap = new HashMap<>();

  public Movements(String path) {
    readInfo(path);
  }

  private void readInfo(String path) {
    List<String> operations = new ArrayList<>();
    try {
      operations = new ArrayList<>(Files.readAllLines(Paths.get(path)));
    } catch (Exception e) {
      e.printStackTrace();
    }
    operations = leadToFormat(operations);
    fillInfoMap(operations);
  }

  private List<String> leadToFormat(List<String> operations) {
    operations.remove(0);
    for (String stringOfOperation : operations) {
      Pattern p = Pattern.compile("\".*,.*\"");
      Matcher matcher = p.matcher(stringOfOperation);
      int index = operations.indexOf(stringOfOperation);
      while (matcher.find()) {
        String fragmentToChange = matcher.group();
        String changedFragment = fragmentToChange.replaceAll("\"", "").replace(",", ".");
        stringOfOperation = stringOfOperation.replace(fragmentToChange, changedFragment);
      }
      stringOfOperation = stringOfOperation.replaceAll("/", "\\\\");
      operations.set(index, stringOfOperation);
    }
    return operations;
  }

  private void fillInfoMap(List<String> operations) {
    for (String stringOfOperation : operations) {
      String[] values = stringOfOperation.split(",");
      if (values.length != 8) {
        System.out.println("Wrong line: " + stringOfOperation);
        continue;
      }
      var tempName = values[5];
      var tempIncomes = Double.parseDouble(values[6]);
      var tempExpenses = Double.parseDouble(values[7]);

      String NameOfOrganization = tempName.substring(tempName.indexOf("\\") + 1).trim();
      NameOfOrganization = NameOfOrganization.substring(0, NameOfOrganization.indexOf("       "))
          .trim().replaceAll("\\\\", "");

      TotalIncomeAndExpenses totalIncAndExp = infoMap.get(NameOfOrganization);
      if (totalIncAndExp == null) {
        infoMap.put(NameOfOrganization, new TotalIncomeAndExpenses(tempIncomes, tempExpenses));
      } else {
        totalIncAndExp.setTotalExpenses(totalIncAndExp.getTotalExpenses() + tempExpenses);
        totalIncAndExp.setTotalIncome(totalIncAndExp.getTotalIncome() + tempIncomes);
        infoMap.put(NameOfOrganization, totalIncAndExp);
      }
    }
  }

  public HashMap<String,Double> getSumExpensesByOrganizations() {
    return  (HashMap<String, Double>) infoMap.keySet().stream()
        .collect(Collectors.toMap(name->name, name-> infoMap.get(name).getTotalExpenses()));
  }
  public HashMap<String,Double> getSumIncomesByOrganizations() {
    return  (HashMap<String, Double>) infoMap.keySet().stream()
        .collect(Collectors.toMap(name->name, name-> infoMap.get(name).getTotalIncome()));
  }


  /*public void printSumExpensesByOrganizations() {
    System.out.println("Суммы расходов по организациям:");
    infoMap.keySet().forEach(
        name -> System.out.println(name + "           " + infoMap.get(name).getTotalExpenses()));
  }

  public void printSumIncomesByOrganizations() {
    System.out.println("Суммы доходов по организациям:");
    infoMap.keySet().forEach(
        name -> System.out.println(name + "           " + infoMap.get(name).getTotalIncome()));
  }*/

  public double getExpenseSum() {
    return infoMap.keySet().stream().mapToDouble(name -> infoMap.get(name).getTotalExpenses())
        .sum();
  }

  public double getIncomeSum() {
    return infoMap.keySet().stream().mapToDouble(name -> infoMap.get(name).getTotalIncome()).sum();
  }
}
