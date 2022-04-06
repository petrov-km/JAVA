import core.Line;
import core.Station;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

public class RouteCalculatorTest extends TestCase {

    List<Station> route;
    List<Station> stations;
    StationIndex stationIndex;
    RouteCalculator calculator;
    Station station1L1;
    Station station2L1;
    Station station3L1;

    Station station1L2;
    Station station2L2;
    Station station3L2;

    Station station1L3;
    Station station2L3;
    Station station3L3;

    Station station1L4;
    Station station2L4;

    @Override
    protected void setUp() throws Exception {
        Line line1 = new Line(1, "Кирово-выборгская");
        station1L1 = new Station("Чернышевская", line1);
        station2L1 = new Station("Площадь восстания", line1);
        station3L1 = new Station("Владимирская", line1);
        line1.addStation(station1L1);
        line1.addStation(station2L1);
        line1.addStation(station3L1);

        Line line2 = new Line(2, "Московско-Петроградская");
        station1L2 = new Station("Горьковская", line2);
        station2L2 = new Station("Невский проспект", line2);
        station3L2 = new Station("Сенная площадь", line2);
        line2.addStation(station1L2);
        line2.addStation(station2L2);
        line2.addStation(station3L2);

        Line line3 = new Line(3, "Невско-Василеостровская");
        station1L3 = new Station("Васильеостровская", line3);
        station2L3 = new Station("Гостинный двор", line3);
        station3L3 = new Station("Маяковская", line3);
        line3.addStation(station1L3);
        line3.addStation(station2L3);
        line3.addStation(station3L3);

        Line line4 = new Line(4, "Правобережная");
        station1L4 = new Station("Достоевская", line4);
        station2L4 = new Station("Лиговский проспект", line4);
        line4.addStation(station1L4);
        line4.addStation(station2L4);

        stations = Arrays.asList(station1L1, station2L1, station3L1, station1L2, station2L2, station3L2,
                station1L3, station2L3, station3L3, station1L4, station2L4);

        stationIndex = new StationIndex();
        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);
        for (Station station : stations) {
            stationIndex.addStation(station);
        }
        stationIndex.addConnection(Arrays.asList(station2L2, station2L3));
        stationIndex.addConnection(Arrays.asList(station2L1, station3L3));
        stationIndex.addConnection(Arrays.asList(station3L1, station1L4));

        calculator = new RouteCalculator(stationIndex);
        route = Arrays.asList(station1L3, station2L3, station3L3, station2L1, station3L1, station1L4, station2L4);
    }

    public void testGetShortestRouteOnTheLine() {
        List<Station> actual = calculator.getShortestRoute(station1L1, station3L1);
        List<Station> expected = Arrays.asList(station1L1, station2L1, station3L1);
        assertEquals(expected, actual);
    }

    public void testGetShortestRouteOneConnection() {
        List<Station> actual = calculator.getShortestRoute(station1L3, station1L2);
        List<Station> expected = Arrays.asList(station1L3, station2L3, station2L2, station1L2);
        assertEquals(expected, actual);
    }

    public void testGetShortestRouteTwoConnection() {
        List<Station> actual = calculator.getShortestRoute(station1L3, station2L4);
        List<Station> expected = Arrays.asList(station1L3, station2L3, station3L3, station2L1, station3L1, station1L4, station2L4);
        assertEquals(expected, actual);
    }

    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 17.0;
        assertEquals(expected, actual);
    }


    @Override
    protected void tearDown() throws Exception {

    }
}
