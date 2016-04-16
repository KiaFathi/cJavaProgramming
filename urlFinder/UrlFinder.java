import edu.duke.*;
import java.io.*;

public class UrlFinder {
  public void findYoutubeLink(String ln){
    String lln = ln.toLowerCase();
    int youtubeIdx = lln.indexOf("youtube.com");
    if(youtubeIdx != -1){
      int startQt = lln.lastIndexOf("\"", youtubeIdx);
      int endQt = lln.indexOf("\"", youtubeIdx);
      System.out.println(ln.substring(startQt + 1, endQt));
    }
  }
  public void findUrls(){
    String src = "http://www.dukelearntoprogram.com/course2/data/manylinks.html";
    URLResource urls = new URLResource(src);
    for (String line : urls.lines()){
      this.findYoutubeLink(line);
    }
  }
}

