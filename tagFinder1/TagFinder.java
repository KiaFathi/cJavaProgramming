/**
 * Finds a protein within a strand of DNA represented as a string of c,g,t,a letters.
 * A protein is a part of the DNA strand marked by start and stop codons (DNA triples)
 * that is a multiple of 3 letters long.
 *
 * @author Duke Software Team 
 */
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

  public String stopCodon(String dna) {
    dna = this.findProtein(dna);
    if(dna == ""){
      return dna;
    }
    return dna.substring(dna.length() - 3);
  }
	
	public void testing() {
		String a = "cccatggggtttaaataataataggagagagagagagagttt";
		String ap = "atggggtttaaataataatag";
		//String a = "atgcctag";
		//String ap = "";
		//String a = "ATGCCCTAG";
		//String ap = "ATGCCCTAG";
		String result = findProtein(a);
    System.out.println("codon " + stopCodon(a));
		if (ap.equals(result)) {
			System.out.println("success for " + ap + " length " + ap.length());
		}
		else {
			System.out.println("mistake for input: " + a);
			System.out.println("got: " + result);
			System.out.println("not: " + ap);
		}
	}
}
