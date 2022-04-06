import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

  public static void main(String[] args) throws IOException {

    Document doc = Jsoup.connect("https://lenta.ru/").get();
    Elements elements = doc.select("img");
    System.out.println("Список скачанных фалов:");
    try {
      for (Element e : elements) {
        String src = e.attr("abs:src");
        String name = src.substring(src.lastIndexOf("/") + 1);
        if (!name.endsWith(".jpg")&&!name.endsWith(".jpeg")) {
          name += ".jpg";
        }
        //System.out.println(name);
        name = name.replaceAll("\\?", "");
        URL url = new URL(src);
        InputStream in = url.openStream();
        //URI uri = new URI("images/" + name);
        //Files.copy(in, Paths.get(uri.getPath()), StandardCopyOption.REPLACE_EXISTING);
        Files.copy(in, Paths.get("images/" + name), StandardCopyOption.REPLACE_EXISTING);
        in.close();

        System.out.println(name);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
