import static java.lang.Character.getNumericValue;

public class Main {

  public static void main(String[] args) {
    Container container = new Container();
    container.count += 7843;

    int sum = sumDigits(23);

    System.out.println(sum);

  }

  /* Реализуйте метод sumDigits который возвращает сумму цифр числа, пример:
  передано 12345, метод должен вернуть 15
  если передано null, то должен вернуть -1

  Запустите тесты TestSumDigits для проверки корректности работы метода

  не меняйте название метода, его возвращаемое значение и модификаторы доступа (public).
  В противном случае тестовый метод не сможет проверить ваш код
   */

  /*public static int sumDigits(Integer number) {
    if (number == null) {
      return -1;
    }
    int result = 0;
    String s = Integer.toString(number);
    for (int i = 0; i < s.length(); i++) {
      result += Integer.parseInt("" + s.charAt(i));
    }
    return result;
  }*/
  public static int sumDigits(Integer number) {
    if (number == null) {
      return -1;
    }
    int result = 0;
    String s = Integer.toString(number);
    for (int i = 0; i < s.length(); i++) {
      result += getNumericValue(s.charAt(i));
    }
    return result;
  }


}
