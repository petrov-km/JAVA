import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

  private static JSONObject finalObject = new JSONObject();
  private static String dataFile;

  public static void main(String[] args) throws IOException {
    Document doc = Jsoup.connect("https://www.moscowmap.ru/metro.html#lines").maxBodySize(0).get();
    readInfoAndCreateJSONObject(doc);
    dataFile = createAndWriteJSONFile();
    parseAndPrintResultInfo();
  }

  private static void parseAndPrintResultInfo() {
    try {
      JSONParser parser = new JSONParser();
      JSONObject jsonData = (JSONObject) parser.parse(getJsonFile());
      JSONArray connectionsArray = (JSONArray) jsonData.get("connections");
      System.out.println("Кол-во переходов - " + connectionsArray.size());

      JSONObject stationsObject = (JSONObject) jsonData.get("stations");
      stationsObject.keySet().forEach(lineNumberObject ->
      {
        JSONArray stationsArray = (JSONArray) stationsObject.get(lineNumberObject);
        System.out.println("Линия " + lineNumberObject + "; кол-во станций: " + stationsArray.size());
        System.out.println("===================");
      });
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private static String getJsonFile() {
    StringBuilder builder = new StringBuilder();
    try {
      List<String> lines = Files.readAllLines(Paths.get(dataFile));
      lines.forEach(line -> builder.append(line));
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return builder.toString();
  }

  private static String createAndWriteJSONFile() throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    String s = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(finalObject);
    File jsonFile = new File("file.json");
    FileWriter writer = new FileWriter(jsonFile);
    writer.write(s);
    writer.flush();
    writer.close();
    return jsonFile.getAbsolutePath();
  }


  private static void readInfoAndCreateJSONObject(Document doc) {
    Elements allInfoForEachLine = doc.select("div[data-line]");
    JSONObject lineNumber2ItsStations = new JSONObject();
    JSONArray arrayLines = new JSONArray();
    JSONArray allConnections = new JSONArray();
    HashSet<HashSet> allConnectionsSet = new HashSet<>();
    for (Element infoOfCurrentLine : allInfoForEachLine) {
      addConnections(infoOfCurrentLine, allConnectionsSet);
      putInfoToLineNumber2ItsStations(infoOfCurrentLine, lineNumber2ItsStations);
    }
    putInfoToArrayLines(doc, arrayLines);
    allConnections.addAll(allConnectionsSet);
    finalObject.put("connections", allConnections);
    finalObject.put("stations", lineNumber2ItsStations);
    finalObject.put("lines", arrayLines);
  }

  private static void addConnections(Element infoOfCurrentLine, HashSet<HashSet> allConnectionsSet){
      for (Element infoOfCurrentStation : infoOfCurrentLine.select("a")) {
        Elements connectionsOfThisStation = infoOfCurrentStation.getElementsByAttribute("title");
        if (!connectionsOfThisStation.isEmpty()) {
          HashMap<String, String> currentStationInfo = new HashMap<>();
          currentStationInfo.put("line", infoOfCurrentLine.attr("data-line") );
          currentStationInfo.put("station", infoOfCurrentStation.select("span.name").text());

          HashSet<HashMap> connectionsOfThisLine= new HashSet<>();
          connectionsOfThisLine.add(currentStationInfo);

          for (Element connection : connectionsOfThisStation) {
            String numberOfline = connection.attr("class");
            String nameOfLine = connection.attr("title");
            numberOfline = numberOfline.substring(numberOfline.lastIndexOf("-") + 1);
            nameOfLine = nameOfLine.substring(nameOfLine.indexOf("«") + 1, nameOfLine.indexOf("»"));
            HashMap<String, String> connectedStationInfo = new HashMap<>();
            connectedStationInfo.put("line",numberOfline);
            connectedStationInfo.put("station", nameOfLine);
            connectionsOfThisLine.add(connectedStationInfo);
          }
          allConnectionsSet.add(connectionsOfThisLine);
        }
      }
  }

  private static void putInfoToLineNumber2ItsStations(Element infoOfCurrentLine, JSONObject lineNumber2ItsStations) {
    Elements namesOfStationsOfCurrentLine = infoOfCurrentLine.select("span.name");
    JSONArray arrayStationsOfCurrentLine = new JSONArray();
    for (Element stations : namesOfStationsOfCurrentLine) {
      arrayStationsOfCurrentLine.add(stations.text());
    }
    lineNumber2ItsStations.put(infoOfCurrentLine.attr("data-line"), arrayStationsOfCurrentLine);
  }

  private static void putInfoToArrayLines(Document doc, JSONArray arrayLines) {
    Elements allLinesInfo = doc.select("span[data-line]");
    for (Element currentLine : allLinesInfo) {
      JSONObject objLineNumberAndName = new JSONObject();
      objLineNumberAndName.put("number", currentLine.attr("data-line"));
      objLineNumberAndName.put("name", currentLine.text());
      arrayLines.add(objLineNumberAndName);
    }
  }
}

