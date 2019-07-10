package kr.or.ddit.crawling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class CrawlingTest {
   public static void main(String[] args) throws UnsupportedEncodingException, IOException {
      CrawlingTest ct = new CrawlingTest();
//      ct.realTimeCrawling();
//      ct.jsoupGet();
//      ct.jsoupPost();
//      ct.jsoupHtmlOrText();
      ct.jsoupSelect();
   }
   
   public void realTimeCrawling() throws UnsupportedEncodingException, IOException {
      URL url = new URL("https://finance.naver.com/");
      BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "euc-kr"));
      String line;
      int check_line = 0;
      while((line = reader.readLine()) != null) {
         if(line.contains("<a href=\"/marketindex/worldExchangeDetail.nhn?marketindexCd"))
            check_line = 1;
         if(line.contains("<a href=\"/marketindex/?tabSel=worldExchange#tab_section\""))
            check_line = 0;
         if(check_line == 1) {
            if(line.contains("<a href=\"/marketindex/worldExchangeDetail.nhn?marketindexCd=")) {
               String temp = line.split(">")[2].split("<")[0];
               temp = temp.trim();
               System.out.println(temp);
            }
            if(line.contains("<td>") && !line.contains("em")) {
               String temp = line.split(">")[1].split("<")[0];
               System.out.println(temp);
            }
            if(line.contains("<td>") && line.contains("em")) {
               String temp = line.split(">")[3].split("<")[0];
               System.out.println(temp);
               String temp2 = line.split(">")[5].split("<")[0];
               System.out.println(temp2);
               System.out.println();
            }
         }
      }
      reader.close();
   }
   
   public void jsoupGet() {
      try {
         // 1. URL 선언
         String connUrl = "http://www.daum.net";
      
         // 2. HTML 가져오기
         Document doc = Jsoup.connect(connUrl).get();
         
         // 3. 가져온 HTML Document 확인하기
         System.out.println(doc.toString());
         
      } catch (IOException e) {
         // Exp : Connection Fail
         e.printStackTrace();
      }
   }
   
   public void jsoupPost() {
      try {
          // 1. URL 선언
          String connUrl = "http://map.daum.net";
          
          // 2. HTML 가져오기
          Document doc = Jsoup.connect(connUrl).post();
          // TODO POST의 data 값은 Jsoup.data(...) 을 사용하시면 됩니다.
          
          // 3. 가져온 HTML Document 를 확인하기
          System.out.println(doc.toString());
          
      } catch (IOException e) {
          // Exp : Connection Fail
          e.printStackTrace();
      }
   }
   
   public void jsoupHtmlOrText() throws IOException {
      // 간략화된 GET, POST
      // Document naver1 = Jsoup.connect("https://www.naver.com").get();
      // Document naver2 = Jsoup.connect("https://www.naver.com").post();
      
      // Response로부터 Document 얻어오기
      Connection.Response response = Jsoup.connect("https://www.naver.com").method(Connection.Method.GET).execute();
      Document document = response.parse();
      
      String html = document.html();
      String text = document.text();
      
      System.out.println(html);
      System.out.println("=====================================================================");
      System.out.println(text);
   }
   
   public void jsoupSelect() throws IOException {
      Connection.Response response = Jsoup.connect("http://www.naver.com").method(Connection.Method.GET).execute();
      Document naverDocument = response.parse();
      Element select = naverDocument.select("a[id=ke_kbd_btn]").first();
      String selectRole = select.attr("role");
      
      System.out.println(selectRole);
   }
   
}