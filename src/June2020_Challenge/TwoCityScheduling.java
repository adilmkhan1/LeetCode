package June2020_Challenge;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://www.youtube.com/watch?v=cevaICIEyjs

//Time Complexity - O(nlogn)

//logic

//Greedy Approach

//A = cost of flying a candidate to city A,
//B = cost of flying a candidate to city B

//A - B = Difference in cost of flying  to B compared to A 
//= Cost saved on flying a particular candidate to city B instead of flying her/him to city A
//= Money saved by sending a candidate to B instead of A

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
	
	
	//Profit  by flying candidate1 to city A  rather than city B = B-A
	
	public static int twoCitySchedCost_usingMaxHeap(int costs[][])
	{
		int total_cost = 0;
		
		PriorityQueue<Integer[]> maxHeap = new PriorityQueue<>((a,b) -> (a[0] - a[1]) - (b[0] - b[1]));
		
		for (int i = 0; i < costs.length; i++) {
			
			total_cost += i>=costs.length/2?costs[i][1]:costs[i][0];
			
		}
		
		
		return total_cost;
	}

	public static void main(String[] args) {
		 
		int cost[][] = {{10,20},{30,200},{400,50},{30,20}};

		//System.out.println(twoCitySchedCost(cost));
		
		System.out.println(twoCitySchedCost_usingMaxHeap(cost));
		

	}

}
