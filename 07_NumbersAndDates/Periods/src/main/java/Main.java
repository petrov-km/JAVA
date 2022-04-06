import java.security.Timestamp;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Main {

  public static void main(String[] args) {
    LocalDate day = LocalDate.of(1970, 1, 1);
    System.out.println(getPeriodFromBirthday(day));
  }

  private static String getPeriodFromBirthday(LocalDate birthday) {
    Period period = Period.between(birthday, LocalDate.now());
    return period.getYears() + " years, " +
        period.getMonths() + " months, " +
        period.getDays() + " days";
  }

}
