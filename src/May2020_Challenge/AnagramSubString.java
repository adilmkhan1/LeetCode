package May2020_Challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


//Different approaches

//https://massivealgorithms.blogspot.com/2016/10/leetcode-438-find-all-anagrams-in-string.html

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
     
    //Map approach in O(n) time 
     
	public static List<Integer> findAnagrams_using_map(String s, String t) {

		List<Integer> result = new LinkedList<>();

		if(s.length() == 0 || s.equals("")) return result;

		Map<Character, Integer> map = new HashMap<>();

		for (char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		int counter = map.size();

		int begin = 0, end = 0;

		while (end < s.length()) {

			char c = s.charAt(end);

			if (map.containsKey(c)) {
				map.put(c, map.get(c) - 1);

				if (map.get(c) == 0)
					counter--;
			}

			while (counter <= 0 ) {

				char tempc = s.charAt(begin);
												
				if (map.containsKey(tempc)) {
					map.put(tempc, map.get(tempc) + 1);
					if (map.get(tempc) > 0)
						counter++;
				}

				
				if(end - begin +1 == t.length())
				{
					result.add(begin);
				}
			
				begin++;
			}
			
			end++;

		}

		return result;
	}

	public static void main(String[] args) {
		
		String s = "cbaebabacd";
		
		String p = "abc"; //[0,6]
		
		String s1 = "abab";
		
		String p1 = "ab";//[0,1,2]
		
		//List<Integer> answer = findAnagrams(s1,p1);
		
		List<Integer> answer = findAnagrams_using_map(s1,p1);
		
		System.out.println(answer);

		

	}

}
