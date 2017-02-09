import java.util.*;
import java.io.*;
public class CountSubstrings {
	public static void main(String [] args) throws IOException {
	File text1 =  new File("Les Miserables.txt");
	File text2 = new File("A Tale of Two Cities.txt");
	String name = null;
	BufferedReader reader = new BufferedReader (new FileReader(name));
  public static int index = 0;
	}


  private static int findBrute(List<Character> text, List<Character> pattern, int pos) {
    int n = text.size();
    int m = pattern.size();
    for (int i = pos; i <= n - m; i++) { // try every starting index
                                      // within text
      int k = 0; // k is index into pattern
      while (k < m && text.get(i + k).equals(pattern.get(k))){
          // kth character of pattern matches
          k++;
          if (k == m) // if we reach the end of the pattern,
            return i; // substring text[i..i+m-1] is a match
      }
    }
    return -1; // search failed

}

}
