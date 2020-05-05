package May2020_Challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class First_Unique_Char_String {

	public static int firstUniqChar(String s) {
		if (s.length() == 0 || s.equals(""))
			return -1;

		Map<Character, List<Integer>> map = new LinkedHashMap();

		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), new ArrayList<>());
			}

			map.get(s.charAt(i)).add(i);
		}

		for (List<Integer> values : map.values()) {
			if (values.size() == 1) {
				return values.get(0);
			}
		}

		System.out.println(map);

		return -1;
	}
	
	//Simpler approach
	
	public static int firsUniqChar_2(String s)
	{
		
		int freq[] = new int[26];
		
		for (int i = 0; i < s.length(); i++) {
			
			freq[s.charAt(i)- 'a']++;
			
		}
		
		//System.out.println(Arrays.toString(freq));
		
		for (int i = 0; i < freq.length; i++) 
		{
			if(freq[s.charAt(i)- 'a'] == 1)
				return i;
		}
	
		
		return -1;
	}
	

	public static void main(String[] args) {

		String s = "leetcode"; //0

		String s1 = "loveleetcode"; //2
		
		String s3 = "techtricks"; //1

		//System.out.println(firstUniqChar(s1));
		
		System.out.println(firsUniqChar_2(s3));

	}

}
