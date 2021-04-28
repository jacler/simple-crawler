package com.example.demo.utils;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class pa1 {
    public static void main(String[] args) {
        try {
            Connection connect = Jsoup.connect("https://www.zhihu.com/");
            //设置单个请求头
            Connection conheader = connect.header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.108 Safari/537.36");
            Document document = conheader.get();
            System.out.println(document);

            String url = "https://www.zhihu.com/";


        }catch (Exception e){}
    }





}
