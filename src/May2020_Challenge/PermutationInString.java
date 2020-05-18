package May2020_Challenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
	
	public static boolean checkInclusion(String s1,String s2)
	{
		
		if (s1.length() > s2.length())
			return false;
		
		int hash1[] = new int[26];
		int hash2[] = new int[26];
		
		for (int i = 0; i < s1.length(); i++) {
			
			hash1[s1.charAt(i) - 'a']++;
			hash2[s2.charAt(i) - 'a']++;
			
		}
		
	    if (Arrays.equals(hash1, hash2))
	    	return true;
	    
	    int windowStart=0;
	    
	    int windowEnd=s1.length();
	    
	    while(windowEnd < s2.length())
	    {
	    	//slide the window of length == s1
	    	
	    	if(hash2[s2.charAt(windowStart) - 'a'] > 0) //if s2's map contain character
	    	{
	    		hash2[s2.charAt(windowStart) - 'a']--;
	    	}
	    	
	    	 
	    	hash2[s2.charAt(windowEnd)- 'a']++;
	    	
	    	//if start and end boundary contains same set of s1's map
	    	
	    	if (Arrays.equals(hash1, hash2))
		    	return true;
	    	
	    	windowStart++;
	    	windowEnd++;
	    	
	    }
	
		return false;
	}

	public static boolean checkInclusion_using_map(String s1, String s2) {
		if (s1.length() == 0 || s1 == null)
			return false;

		if (s2.length() == 0 || s2 == null)
			return false;

		if ((s1.length() == 0 || s1 == null) && (s2.length() == 0 || s2 == null))
			return true;

		Map<Character, Integer> map = new HashMap<>();

		for (char c : s1.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		//int start = 0;

		int match = 0;

		//first window
		
		for (int end = 0; end < s2.length(); end++) 
		{
			char current = s2.charAt(end);
			
			if (map.containsKey(current)) {
				map.put(current, map.get(current) - 1);

				if (map.get(current) == 0)
					match++;
			}
		
			//other windows (2nd onwards...)
			
			if (end >= s1.length())
			{
				current = s2.charAt(end - s1.length()); //get index of start
				
				if (map.containsKey(current))
				{
					if(map.get(current) == 0)
						match--;
					
					map.put(current, map.get(current)+1);
				}
			}
			
			if (match == map.keySet().size())
			{
				return true;
			}
				
				
		}

		return false;
	}

	public static void main(String[] args) {

		String s1 = "ab";

		String s2 = "eidbaooo"; // true

		String s1_1 = "ab";

		String s2_1 = "eidboaoo"; // false
		
		String s1_2 = "adc";
		
		String s2_2 = "dcda"; //true
		
		String s1_3 = "abcdxabcde";
		
		String s2_3 = "abcdeabcdx"; //true

		//System.out.println(checkInclusion(s1, s2));
		
		System.out.println(checkInclusion_using_map(s1_3, s2_3));

	}

}
