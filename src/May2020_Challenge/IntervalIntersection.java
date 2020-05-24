package May2020_Challenge;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersection {
	
   public static int[][] intervalIntersection(int[][] A, int[][] B) 
   {
      
      int A_size = A.length;
      
      int A_ptr = 0;
      
      int B_size = B.length;
      
      int B_ptr = 0;
      
      List<int[]> result = new ArrayList();
      
      int temp[] = new int[2];
      
      while(A_ptr < A_size && B_ptr < B_size)
      {
    	  if(B[B_ptr][0] <= A[A_ptr][1] && A[A_ptr][0] <= B[B_ptr][1])
    	  {
    		  temp[0] = Math.max(A[A_ptr][0],B[B_ptr][0]);
    		  temp[1] = Math.min(A[A_ptr][1],B[B_ptr][1]);
    		  
    		  result.add(new int[] {temp[0],temp[1]});
    		 
    		  
    	  }
    	  
    	  if (A[A_ptr][1]>B[B_ptr][1])
    	  {
    		  B_ptr+=1;
    	  }else
    		  A_ptr+=1;
      }
      
      return result.toArray(new int[result.size()][]);
	   
   }

	public static void main(String[] args) {
		
      int a[][] = {
    		       {0,2},
    		       {5,10},
    		       {13,23},
    		       {24,25}
	               };
      
      int b[][] = {
			       {1,5},
			       {8,12},
			       {15,24},
			       {25,26}
              
                  };
      
      //[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
      
      int answer[] = new int[100];
      
      intervalIntersection(a,b);
      
      

}
	
}
