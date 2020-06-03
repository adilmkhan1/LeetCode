package June2020_Challenge;

import java.util.Arrays;

//https://www.youtube.com/watch?v=cevaICIEyjs

//Time Complexity - O(nlogn)

public class TwoCityScheduling {
	
	
	public static int twoCitySchedCost(int costs[][])
	{
		int total_cost = 0;
		
		
		Arrays.sort(costs,(a,b) -> {
			
			return (a[0] - a[1]) - (b[0] - b[1]); //(A - B) sorting in asc order
		});
		
		
		for (int i = 0; i < costs.length/2; i++) {
			total_cost+=costs[i][0];
		}
		
		for (int i = costs.length/2; i < costs.length; i++) {
			total_cost+=costs[i][1];
		}
		
		
		
		return total_cost;
		
		
	}

	public static void main(String[] args) {
		 
		int cost[][] = {{10,20},{30,200},{400,50},{30,20}};

		System.out.println(twoCitySchedCost(cost));
		

	}

}
