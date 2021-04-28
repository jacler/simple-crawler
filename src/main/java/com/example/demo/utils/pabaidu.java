package com.example.demo.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
//爬baidu搜索
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//知乎采用hash加密，目前能力不够处理
public class pabaidu {
    public static void main(String[] args) throws Exception {
        List<Content> list=Searchbaidu("赵日天");    //要抓取数据的 url 返回多条数据，
        POItoExcel.toExcel(list,false); //导出到Excel 根据业务可以存入数据库
    }


    public static List<Content> Searchbaidu(String keywords) throws Exception{
        ArrayList<Content> baiduList = new ArrayList<>();
        String url = "http://www.baidu.com/s?wd="+keywords+"&rn=50";

        try {
            Document document = Jsoup.connect(url)
                    // 手动设置cookies
                    .header("Cookie", "_zap=db5b2690-ddfa-45d0-a381-fee0ed902f54; d_c0=\"AHCfsmDvKBKPTtuLTT4xDan4Ft_eRzyJS4w=|1604764751\"; Hm_lvt_98beee57fd2ef70ccdd5ca52b9740c49=1606024255,1606056713,1606099862,1606129814; z_c0=Mi4xcmtlS0F3QUFBQUFBY0oteVlPOG9FaGNBQUFCaEFsVk54dmpXWUFEWndXaUswU2pSRzZ6Q1FhOFAwSTM2M1V1eVVR|1609149126|20e50e9589b30f6374ef96b7b13ce3cae74ab3a7; _xsrf=e9d3771d-555c-4aee-8e42-2301ee0f6ea0; SESSIONID=mU9tPqp8mkvjtyDN1vVM8XB7gOsV2Tdb6pIxrCm7Sso; JOID=VVsUBk3NX2xjN8qiN88KeyhUIo4jpAhRFGa_0AuhMBgNQLLie6VM4gEyzKQwwqOwgCMkzfbS4tKWVjBqz2KZaIY=; osd=VV8VAEvNW21lMcqmNskMeyxVJIgjoAlXEma70Q2nMBwMRrTif6RK5AE2zaI2wqexhiUkyffU5NKSVzZsz2aYboA=; tshl=; q_c1=c97064f0bdf94a26a5fb70c14ddafdcd|1619612954000|1606395594000; tst=h; KLBRSID=57358d62405ef24305120316801fd92a|1619615528|1619605715")

            .get();
            //
//                    System.out.println(document);

            Elements ele = document.select("#content_left .result");

//           System.out.println(ele);
            int i = 0;
            for(Element e : ele){
                i++;
                System.out.println(i+"：" + e.select(".t a").text());
                System.out.println("描述："+ e.select(".c-abstract").text());


                Content content = new Content();
                content.setI(i);
                content.setTitle(e.select(".t a").text());
                content.setDesc(e.select(".c-abstract").text());
                baiduList.add(content);
            }



        }catch (Exception E){}
        return baiduList;
    }

}
