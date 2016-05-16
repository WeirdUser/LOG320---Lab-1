import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static HashMap<Long, Integer> anagramMap = new HashMap<Long, Integer>();
	public static HashMap<Character, Integer> valueMap = new HashMap<Character, Integer>();
	
	public static void main(String[] args) {
		setUpValueMap();
		// TODO Auto-generated method stub

		// Multiply all of the letters' values together,
		// ignoring spaces, creating a key for each word 
		// to compare with. Add the key with a counter to 
		// the HashMap, and add it to the key array.

		/////////////////////////////////////////
		// Reading the files
		/////////////////////////////////////////

		// members
		FileReaderBasic basicFileReader = new FileReaderBasic();
		ArrayList<String> listDictionary = (ArrayList<String>) basicFileReader.readDictionary();
		ArrayList<String> listLines = (ArrayList<String>) basicFileReader.readLines();

		setUpAnagramMap(listDictionary);
		/////////////////////////////////////////
		// Algorithm execution
		/////////////////////////////////////////
		
		// Calculate the time for each algorithm.
		
		//Premier algorithme.
		//Insert stopwatch here.
		for(int i = 0; i < listLines.size(); i++){
			
			for(int j = 0; j < listDictionary.size(); j++){
				
				EstUnAnagrammeNaif((String)listLines.toArray()[i], (String)listDictionary.toArray()[j]);
			
			}
		}
		
		//Deuxième algorithme.
		//Insert stopwatch here.
		for(int i = 0; i < listLines.size(); i++){
			
			EstUnAnagrammeEfficace((String)listLines.toArray()[i]);
		
		}
		
	}
	
	public static boolean EstUnAnagrammeNaif(String chaine1, String chaine2){
		boolean found = false;
		StringBuilder chaine2StringBuild = new StringBuilder(chaine2);
		
		for(int i = 0; i < chaine1.length(); i++){
			
			found = false;
			
			for(int j = 0; j < chaine2.length(); j++){
				
				while(!found){
					
					if (chaine1.toCharArray()[i] == chaine2.toCharArray()[j]){
						
						//Remove char from string
						chaine2 = chaine2StringBuild.deleteCharAt(j).toString();
						found = true;
					}
					
				}
			}
		}
		
		if(!found){
			
			return false;
		
		}
		
		if(chaine2.length() != 0){
			
			return false;
		
		}
		
		return true;
	}
	
	public static void EstUnAnagrammeEfficace(String chaine){
		
		long dictionaryKey = 1;
		char[] chaineArray = chaine.toCharArray();
		
		// For each word to compare, multiply all of the 
		// letters' values together, just like previously. 
		// If the resulting key exists, add 1 to the associated 
		// counter in the HashMap.
		for(int i = 0; i < chaine.length(); i++){
			
			dictionaryKey = dictionaryKey * valueMap.get(chaineArray[i]);
			
		}
		
		// With the key array and the HashMap, you now have
		// a list of how many anagrams exist for each word!

		anagramMap.put(dictionaryKey, anagramMap.get(dictionaryKey) + 1);
	}
	
	public static void setUpValueMap(){
		valueMap.put('a', 2);
		valueMap.put('b', 3);
		valueMap.put('c', 5);
		valueMap.put('d', 7);
		valueMap.put('e', 11);
		valueMap.put('f', 13);
		valueMap.put('g', 17);
		valueMap.put('h', 19);
		valueMap.put('i', 23);
		valueMap.put('j', 29);
		valueMap.put('k', 31);
		valueMap.put('l', 37);
		valueMap.put('m', 41);
		valueMap.put('n', 43);
		valueMap.put('o', 47);
		valueMap.put('p', 53);
		valueMap.put('q', 59);
		valueMap.put('r', 61);
		valueMap.put('s', 67);
		valueMap.put('t', 71);
		valueMap.put('u', 73);
		valueMap.put('v', 79);
		valueMap.put('w', 83);
		valueMap.put('x', 89);
		valueMap.put('y', 97);
		valueMap.put('z', 101);
		valueMap.put('0', 103);
		valueMap.put('1', 107);
		valueMap.put('2', 109);
		valueMap.put('3', 113);
		valueMap.put('4', 127);
		valueMap.put('5', 131);
		valueMap.put('6', 137);
		valueMap.put('7', 139);
		valueMap.put('8', 149);
		valueMap.put('9', 151);
	}
	
	public static void setUpAnagramMap(ArrayList<String> listDictionary){
		
		String[] dictionaryArray = (String[])listDictionary.toArray();
		long dictionaryKey = 1;
		
		for(int i = 0; i < dictionaryArray.length; i++){
			
			for(int j = 0; j < dictionaryArray[i].length(); j++){
				
				dictionaryKey = dictionaryKey * valueMap.get(dictionaryArray[j]);
				
			}
			
			anagramMap.put(dictionaryKey, 0);
			dictionaryKey = 1;
		}
		
	}

}
