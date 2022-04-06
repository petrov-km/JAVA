import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        /*Date date = new Date();
        StringBuilder result = new StringBuilder();
        Calendar calendar = new GregorianCalendar(year, month - 1, day);
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.y - E", Locale.ENGLISH);
        int i = 0;
        while (calendar.getTime().before(date)) {
            result.append(i++ + " - " + formatter.format(calendar.getTime()) + System.lineSeparator());
            calendar.add(calendar.YEAR, 1);
        }
        return result.toString();*/

        StringBuilder result = new StringBuilder();
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.y - E", Locale.ENGLISH);
        LocalDate date = LocalDate.of(year, month, day);
        int i = 0;
        while (!date.isAfter(now)) {
            result.append(i++ + " - " + formatter.format(date) + System.lineSeparator());
            date = date.plusYears(1);
        }
        return result.toString();
    }
}
