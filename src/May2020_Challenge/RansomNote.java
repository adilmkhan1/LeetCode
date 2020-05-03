package May2020_Challenge;

import java.util.Arrays;
import java.util.HashMap;

public class RansomNote {
	
	public static boolean canConstruct(String ransomNote,String magazine)
	{
		if (ransomNote.length() == 0 && magazine.length() == 0)
            return true;
        
        if (ransomNote.equals("")|| ransomNote.length() == 0 && magazine.length() != 0)
            return true;
        
        if (ransomNote.length() != 0 && (magazine.equals("") || magazine.length() == 0))
            return false;
		
        HashMap<Character,Integer> counts = new HashMap();
        
        for(char c : magazine.toCharArray())
        {
        	counts.put(c, counts.getOrDefault(c, 0)+1);
        }
        
        for(char c : ransomNote.toCharArray())
        {
        	if (! counts.containsKey(c) || counts.get(c) <= 0)
        	{
        		return false;
        	}
        	
        	counts.put(c, counts.get(c)-1);
        }
        
        return true;
	}
	

	public static void main(String[] args) {
		
//		canConstruct("a", "b") -> false
//		canConstruct("aa", "ab") -> false
//		canConstruct("aa", "aab") -> true
		
		String ransomNote = "bg";
		
		String magazine = "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj";
		
//        String ransomNote = "aa";
//		
//		String magazine = "ab";
		
		System.out.println(canConstruct(ransomNote,magazine));
		
		

	}

}
