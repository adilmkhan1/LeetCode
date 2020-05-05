package May2020_Challenge;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class First_Unique_Char_String {
	
	public static int firstUniqChar(String s)
	{
		if (s.length() == 0 || s.equals(""))
            return -1;
        
        Map<Character,List<Integer>> map = new LinkedHashMap();
        
        for (int i = 0; i < s.length(); i++) 
        {
			if (! map.containsKey(s.charAt(i)))
			{
				map.put(s.charAt(i), new ArrayList<>());
			}
			
			map.get(s.charAt(i)).add(i);
		}

        
        for(List<Integer> values : map.values())
        {
        	if(values.size() == 1)
        	{
        		return values.get(0);
        	}
        }
        
        
        
       System.out.println(map);
        
        return -1;
	}

	public static void main(String[] args) {
		
		String s = "leetcode";
		
		String s1 = "loveleetcode";
		
		System.out.println(firstUniqChar(s1));

	}

}
