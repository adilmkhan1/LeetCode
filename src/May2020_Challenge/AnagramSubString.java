package May2020_Challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnagramSubString {
	
     public static List<Integer> findAnagrams(String s, String p) 
     {
        
    	 List<Integer> result = new ArrayList<>();
    	 
    	 if(s.length() == 0 || s.equals("")) return result;
    	 
    	
    	 //freq array
    	 int char_count[] = new int[26];
    	 
    	 for(char c : p.toCharArray())
    	 {
    		 char_count[c-'a']++;
    	 }
    	 
    	 int left = 0;
    	 int right = 0;
    	 int count = p.length();
    	 
    	 while(right < s.length())
    	 {
    		 
    		 //contains char in freq array
    		 if(char_count[s.charAt(right++)-'a']-- >= 1)
    			 count--;
    		 
    		 //all p characters are found
    		 if(count == 0)
    			 result.add(left);
    		 
    		 //increase left boundary and add back character in freq array already used
    		 
    		 if(right - left == p.length() && char_count[s.charAt(left++)- 'a']++ >=0)
    			 //reset count
    			 count++;
    	
    		 
    	 }
    	
    	 return result;
     }

	public static void main(String[] args) {
		
		String s = "cbaebabacd";
		
		String p = "abc"; //[0,6]
		
		String s1 = "abba";
		
		String p1 = "ab";
		
		
		List<Integer> answer = findAnagrams(s1,p1);
		
		System.out.println(answer);

		

	}

}
