import edu.duke.*;
import java.io.*;

public class UrlFinder {
  public String findUrl(String ln){
    String lln = ln.toLowerCase();
    int href = lln.indexOf("href=");
    if(href != -1 && lln.indexOf("http", href) != -1){
      int startQt = lln.indexOf("\"", href);
      int endQt = lln.indexOf("\"", startQt + 1);
      String foundUrl = ln.substring(startQt + 1, endQt);
      return foundUrl; 
    }
    return "";
  }
  public StorageResource findUrls(String src){
    StorageResource store = new StorageResource();
    URLResource urls = new URLResource(src);
    for (String line : urls.lines()){
      String url = this.findUrl(line);
      if(url != ""){
        System.out.println("Adding URL: " + url);
        store.add(url);
      }
    }
    return store;
  }
  public void printAllURLS(StorageResource sr){
    for(String url : sr.data()){
      System.out.println(url);
    }
  }
  public int countTest(StorageResource sr, String test){
    int count = 0;
    for(String url : sr.data()){
      if(url.indexOf(test) != -1){
        count = count + 1;
      }
    }
    return count;
  }
  public int countEndsTest(StorageResource sr, String test){
    int count = 0;
    for(String url : sr.data()){
      if(url.endsWith(test)){
        count = count + 1;
      }
    }
    return count;
  }

  public int countStartsTest(StorageResource sr, String test){
    int count = 0;
    for(String url : sr.data()){
      if(url.startsWith(test)){
        count = count + 1;
      }
    }
    return count;
  }

  public int countPeriod(StorageResource sr){
    int count = 0;
    for(String url : sr.data()){
      int idx = url.indexOf(".");
      while(idx != -1){
        count = count + 1;
        idx = url.indexOf(".", idx + 1);
      }
    }
    return count;
  }

  public void testURLWithStorage(){
    String src = "./newyorktimes.html";
    StorageResource urls = this.findUrls(src);
    System.out.println("Count of URLs: " + urls.size());

    int countHTTPS = countStartsTest(urls, "https");
    System.out.println("Count of Secure URLs: "  + countHTTPS);

    int countCom = countTest(urls, ".com");
    System.out.println("Count of .com URLS: " + countCom);

    int countEndCom = countEndsTest(urls, ".com/") + countEndsTest(urls, ".com");
    System.out.println("Count of .com URLS: " + countEndCom);

    int countOfPeriod = countPeriod(urls);
    System.out.println("Count of . in URLS: " + countOfPeriod);
  }
}

