import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//import javax.lang.model.util.Elements;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;
import java.net.HttpURLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

    public static final String my_site = "https://lenta.ru/"; /*"http://www.montessori-club.ru/";*/

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        SiteMap siteMap = new SiteMap(my_site, my_site);
        pool.execute(siteMap);
        TreeSet<String> result = siteMap.join();
        pool.shutdown();

        ArrayList<String> resultList = new ArrayList<>(result);
        for (int i = 1; i < resultList.size(); i++) {
            String link = resultList.get(i);
            int index = link.indexOf('/', my_site.length());
            if (!(index == -1)) {
                String s = link.substring(0, index);
                if (resultList.get(i - 1).contains(s)) {
                    int count = (int) link.codePoints().filter(ch -> ch == '/').count();
                    for (int j = 0; j < count - 3; j++) {
                        link = "\t" + link;
                    }
                }
            }
            link = "\t" + link;
            resultList.set(i, link);
        }
        resultList.forEach(System.out::println);
        try {
            Files.write(Paths.get("demo.txt"), resultList, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
