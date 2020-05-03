package May2020_Challenge;

import java.util.HashSet;

public class JewelsandStones {
	
public static  int numJewelsInStones(String J, String S) {
        
        int count = 0;
        
        char stone[] = S.toCharArray();
        
        HashSet<Character> jewels = new HashSet();
        
        for(int i=0;i<J.length();i++)
        {
            jewels.add(J.charAt(i));
        }
        
        for(int j=0;j<stone.length;j++)
        {
            if (jewels.contains(stone[j]) )
            {
                count ++;
            }
        }
        
        return count;
        
    }

	public static void main(String[] args) {
		
		String J =  "z"; //"aA";
		
		String S = "ZZ"; //"aAAbbbb";
		
		System.out.println(numJewelsInStones(J,S));
		  

	}

}
