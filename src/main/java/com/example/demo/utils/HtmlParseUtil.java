package com.example.demo.utils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class HtmlParseUtil {
    public static void main(String[] args) throws IOException {
        try {
            String url = "http://www.cssmoban.com/tags.asp?n=%E5%B0%8F";
            Document doc =  Jsoup.parse(new URL(url),30000);
            Elements element =  doc.getElementsByTag("span");
//            System.out.println(element.html());
        System.out.println(element.html());
        }catch (Exception e){}

    }





}
