import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {
  String text = " 500 рублей, Петя - 100 руб, а Маша -xzxcczc 300 рублей 20 sdfds ";
    System.out.println(calculateSalarySum(text));
  }

  public static int calculateSalarySum(String text){
    String[] words = text.split("\\s*(\\s|,|!|-|\\.)\\s*"); // [\W+&&[^а-яА-Я]]
    int result = 0;
        for (int i = 0; i< words.length; i++){
          if ((words[i].matches("\\d+")) && ( words[i+1].matches("руб(.*)") )  ) {
            result += Integer.parseInt(words[i]);
          }
        }
    return result;
  }

}