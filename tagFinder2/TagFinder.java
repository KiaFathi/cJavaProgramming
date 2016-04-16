import edu.duke.*;
import java.io.*;

public class TagFinder {
	public String findProtein(String dna) {
    dna = dna.toLowerCase();
		int start = dna.indexOf("atg");
		if (start == -1) {
			return "";
		}
		int stop = dna.indexOf("tag", start+3);
		if ((stop - start) % 3 == 0) {
			return dna.substring(start, stop+3);
		}
    int stop2 = dna.indexOf("tga", start + 3);
    if((stop2 - start) % 3 == 0){
      return dna.substring(start, stop2 + 3);
    }
    int stop3 = dna.indexOf("taa", start + 3);
    if((stop3 - start) % 3 == 0){
      return dna.substring(start, stop3 + 3);
    }
    return "";
	}

  public void printAllGenes(String dna){
    dna = dna.toLowerCase();
    int startIdx = dna.indexOf("atg");
    while(startIdx != -1){
      int stopIdx = findStopIndex(dna, startIdx);
      if(stopIdx != dna.length()){
        System.out.println(dna.substring(startIdx, stopIdx + 3));
      }
      startIdx = dna.indexOf("atg", startIdx + 3);
    }
  }

  public int findStopIndex(String dna, int index) {
    int stop1 = dna.indexOf("tga", index);
    int stop2 = dna.indexOf("taa", index);
    int stop3 = dna.indexOf("tag", index);
    if(stop1 == -1 || (stop1 - index) % 3 != 0){
      stop1 = dna.length();
    }
    if(stop2 == -1 || (stop2 - index) % 3 != 0){
      stop2 = dna.length();
    }
    if(stop3 == -1 || (stop3 - index) % 3 != 0){
      stop3 = dna.length();
    }
    return Math.min(stop1, Math.min(stop2, stop3));
  }
}
