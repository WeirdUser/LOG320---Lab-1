
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
	}
	
	public boolean EstUnAnagrammeNaif(String chaine1, String chaine2){
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
	
	public boolean EstUnAnagrammeEfficace(String chaine1, String chaine2){
		
		// Letter/Number Array goes here.
		
		// Multiply all of the letters' values together,
		// ignoring spaces, creating a key for each word 
		// to compare with. Add the key with a counter to 
		// the HashMap, and add it to the key array.

		// For each word to compare, multiply all of the 
		// letters' values together, just like previously. 
		// If the resulting key exists, add 1 to the associated 
		// counter in the HashMap.
		
		// With the key array and the HashMap, you now have
		// a list of how many anagrams exist for each word!
		
		return true;
	}

}
