import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

  public static long timeIntervalLength = 7200000;

  public static void main(String[] args) {
    Airport airport = Airport.getInstance();
    System.out.println(findPlanesLeavingInTheNextTwoHours(airport));
  }

  public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
    return airport.getTerminals().stream()
        .flatMap(t -> t.getFlights().stream())
        .filter(f -> f.getType() == Flight.Type.DEPARTURE)
        .filter(f -> (f.getDate().getTime() - System.currentTimeMillis()) < timeIntervalLength
            && (f.getDate().toInstant().isAfter(new Date().toInstant())))
        .collect(Collectors.toList());
  }

}