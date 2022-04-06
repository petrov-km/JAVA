import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Main {

  public static void main(String[] args) {

    int day = 31;
    int month = 12;
    int year = 1990;

    System.out.println(collectBirthdays(year, month, day));

  }

  public static String collectBirthdays(int year, int month, int day) {
    Date date = new Date();
    StringBuilder result = new StringBuilder();
    Calendar calendar = new GregorianCalendar(year, month - 1, day);
    SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.y - E", Locale.ENGLISH);
    int i = 0;
    while (calendar.getTime().before(date)) {
      result.append(i++ + " - " + formatter.format(calendar.getTime()) + System.lineSeparator());
      calendar.add(calendar.YEAR, 1);
    }
    return result.toString();
  }
}
