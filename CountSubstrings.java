import javax.swing.*;
import java.util.*;
import java.io.*;
public class CountSubstrings {
	public static int index = 0;
	public static void main(String [] args) throws IOException {
	File text1 =  new File("Les Miserables");
	File text2 = new File("A Tale of Two Cities.txt");
	String name = null;
  String pattern = "Javert";
  String line = "";
  LinkedList<Character> list = new LinkedList<Character>();
  ArrayList<Character> AList = new ArrayList<Character>();
	LinkedList<Character> patternList = new LinkedList<Character>();
	ArrayList<Character> patternArray = new ArrayList<Character>();
  int occuranceL = 0;
  int occuranceA = 0;
  double listTimeE = 0;
  double arrTimeE = 0;
  double listTimeS = 0;
  double arrTimeS = 0;

	for(int i=0;i < pattern.length();i++){ //put pattern into arraylist and linkedlist
		patternList.add(pattern.substring(i).charAt(0)); //add char at position i index 0 into list
		patternArray.add(pattern.substring(i).charAt(0));
	}
  FileReader fileRead = new FileReader (text1);
  BufferedReader reader = new BufferedReader(fileRead);
  line = reader.readLine();
  arrTimeS = System.currentTimeMillis();

    while(line != null){ //adds line to ArrayList
      for(char c : line.toCharArray()){
        AList.add(c);
      }
			occuranceA = occuranceA + patternFinder(AList,patternArray, pattern, 0);
			AList = new ArrayList<Character>();
			line = reader.readLine();
    }
		reader.close();
		arrTimeE = System.currentTimeMillis();

		fileRead = new FileReader (text1); //reset to read files into linked list
		reader = new BufferedReader (fileRead);
		line = reader.readLine();
		listTimeS = System.currentTimeMillis();

		while(line != null){
			for(char c : line.toCharArray()){
				list.add(c);
			}
			occuranceL = occuranceL + patternFinder(list, patternList,pattern, 0);
			list = new LinkedList<Character>();
			line = reader.readLine();
		}// inputs line into linked list
		reader.close();
		listTimeE = System.currentTimeMillis();

		System.out.println("Using LinkedList: "+occuranceL+" matches were found, derived in "+(listTimeE - listTimeS)+" milliseconds");
		System.out.println("Using ArrayList: "+occuranceA+" matches were found, derived in "+(arrTimeE - arrTimeS)+" milliseconds");
	} //end main



public static int patternFinder(List<Character> text, List<Character> pattern, String pattern1, int position){
	int count = 0;
	index = findBrute(text, pattern, position);
			while(index != -1){ //find brute returns -1 is match is not found so you dont need to go into the loop
				for(int i = index; i < index + pattern1.length(); i++){
					if(!(text.get(i).equals(pattern.get(i-index)))){
						count = count + 0;
					}
					else {
						if(i == index + pattern1.length() - 1){
							count = count + 1;
						}
					}//end of else
				}//end of for
				index = findBrute(text, pattern, index + pattern1.length());
			}//end of while
			return count;
}//end findPattern

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
