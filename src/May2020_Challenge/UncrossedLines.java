package May2020_Challenge;

import java.util.Arrays;

public class UncrossedLines {
	
	
	//Longest Common SubSequence
	public static int maxUncrossedLines(int[] A,int[] B)
	{
		
		int T[][] = new int[A.length+1][B.length+1];
		
		int max=0;
		
		for(int i=1;i<=A.length;i++)
		{
			for (int j = 1; j <=B.length; j++) 
			{
				if (A[i-1] == B[j-1])
				{
					T[i][j] = T[i-1][j-1]+1;
				}else
				{
					T[i][j] = Math.max(T[i-1][j],T[i][j-1]);
				}
				
			}
			
			
		}
		
		return T[A.length][B.length];
	}

	public static void main(String[] args) {
		
       int a[] = {2,5,1,2,5};
       
       int b[] = {10,5,2,1,5,2}; //3
       
       int a1[] = {1,4,2};
       
       int b1[] = {1,2,4};//2
       
       System.out.println(maxUncrossedLines(a1,b1));
		

	}

}
