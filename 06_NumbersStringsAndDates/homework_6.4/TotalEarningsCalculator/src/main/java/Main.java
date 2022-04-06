public class Main {

  public static void main(String[] args) {

    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

    int result = 0;

    while ( !(text.indexOf(" руб") == -1) ) {
      String salary = text.substring(0, text.indexOf(" руб"));
      salary = salary.substring(salary.lastIndexOf(" "));
      salary = salary.trim();
      result += Integer.parseInt(salary);
      text = text.substring(text.indexOf(" руб"));
      text = text.trim();
    }
    System.out.println(result);
    /*int index = text.indexOf(" руб");
    String salary1 = text.substring(0, index);
    salary1 = salary1.substring(salary1.lastIndexOf(" ") + 1);

    String currentString = text.substring(index + 4);
    index = currentString.indexOf(" руб");
    String salary2 = currentString.substring(0, index);
    salary2 = salary2.substring(salary2.lastIndexOf(" ") + 1);

    currentString = currentString.substring(index + 4);
    index = currentString.indexOf(" руб");
    String salary3 = currentString.substring(0, index);
    salary3 = salary3.substring(salary3.lastIndexOf(" ") + 1);

    System.out
        .println(Integer.parseInt(salary1) + Integer.parseInt(salary2) + Integer.parseInt(salary3));*/
  }

}