package edu.bim207;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class App 
{
    public static void main( String[] args )
    {
        Document doc;
        try {

            // ceng.anadolu.edu.tr/OgretimElemanlari
            doc = Jsoup.connect("http://ceng.ogu.edu.tr/bolum/ogretim-uyeleri/").get();


            // get mail links
            Elements links = doc.select("div").select("a");

            for (Element link : links) {
                String s = link.attr("href").trim();

                if (s.startsWith("mailto:"))
                    System.out.println(s.substring(7));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
