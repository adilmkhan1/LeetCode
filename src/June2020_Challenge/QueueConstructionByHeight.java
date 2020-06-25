package June2020_Challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.youtube.com/watch?v=_DtZIPUt8jo

public class QueueConstructionByHeight {
	
  public static int[][] reconstructQueue(int[][] people) 
  {
      List<int[]>result = new ArrayList();
      
      //if heights are same then sort based on 2nd value
      //else sort heights in descending order 
      
      Arrays.sort(people,(a,b) -> {
    	  
    	  return (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
      });
      
      //[[7, 0], [7, 1], [6, 1], [5, 0], [5, 2], [4, 4]]
      
      //System.out.println(Arrays.deepToString(people));
      
      for(int x[] :people)
      {
    	  result.add(x[1],x); //add element x  at index x[1]
      }
      
	  return result.toArray(new int[people.length][2]);
	  
  }

	public static void main(String[] args) {
		
       int people[][] = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};//[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
       
       
       System.out.println(Arrays.deepToString(reconstructQueue(people)));
		
		

	}

}
