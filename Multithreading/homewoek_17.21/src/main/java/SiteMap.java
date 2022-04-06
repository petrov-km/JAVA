import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.concurrent.RecursiveTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SiteMap extends RecursiveTask<TreeSet<String>> {

    private String url;
    private static TreeSet<String> uniqueURL = new TreeSet<>();
    List<SiteMap> tasksList = new ArrayList<SiteMap>();
    private String currentURL;
    volatile Document doc = null;
    private String mySite;
    private int maxDepth = 5;

    public SiteMap(String url, String mySite) {
        this.url = url;
        this.mySite = mySite;
    }

    @Override
    protected TreeSet<String> compute() {
        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            doc = Jsoup.connect(url).userAgent("Mozilla").ignoreContentType(true).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!(doc == null)) {
            Elements links = doc.select("a");
            if (!links.isEmpty()) {
                for (Element link : links) {
                    currentURL = link.attr("abs:href");
                    int depth = (int) currentURL.codePoints().filter(ch -> ch == '/').count();
                    if (depth<=maxDepth && linkIsAccessableAndCorrect(currentURL, mySite)) {
                        if (uniqueURL.add(currentURL)) {
                            SiteMap task = new SiteMap(currentURL, mySite);
                            task.fork();
                            // System.out.println("текущая ссылка   " + currentURL + "для задачи с " + url);
                            tasksList.add(task);
                            System.out.println("размер списка ссылок " + uniqueURL.size());
                            //System.out.println("колво задач " + tasksList.size());
                        }
                    }
                }
            }
        }

        for (SiteMap task : tasksList) {
            // System.out.println("новая задача   " + task.getUrl());
            task.join();
        }
        return uniqueURL;
    }

    private boolean linkIsAccessableAndCorrect(String url, String mySite) {
        int responseCode = 0;
        int timeout = 1500;
        if (url.contains("#") || !url.contains(mySite) || url.endsWith("index.html")) {
            return false;
        }
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url)
                    .openConnection();
            connection.setConnectTimeout(timeout);
            connection.setReadTimeout(timeout);
            connection.setRequestMethod("HEAD");
            responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                return false;
            }
        } catch (IOException exception) {
            return false;
        }
        return true;
    }
}
