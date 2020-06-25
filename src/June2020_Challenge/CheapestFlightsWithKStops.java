package June2020_Challenge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class CheapestFlightsWithKStops {
	
	//https://massivealgorithms.blogspot.com/2018/04/leetcode-787-cheapest-flights-within-k.html
	
	//https://www.youtube.com/watch?v=71xQSBWUupU
	
	public static int findCheapestPrice(int n,int [][]flights,int src,int dst,int k)
	{
		Map<Integer,List<int[]>> map = new HashMap<>();
		
		for(int f[] : flights)
		{
			map.putIfAbsent(f[0],new ArrayList<>());
			map.get(f[0]).add(new int[]{f[1],f[2]});
		}
		
		
		PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				return Integer.compare(o1[1], o2[1]);
			}
			
			
		});
		
		
		minHeap.offer(new int[] {src,0,k});
		
		while(!minHeap.isEmpty())
		{
			int c[] = minHeap.poll();
			int curr = c[0];
			int cost = c[1];
			int stop = c[2];
			
			if(curr==dst) {
				return cost;
			}
			if(stop >= 0)
			{
				if(!map.containsKey(curr))
					continue;
				for (int next[]: map.get(curr)) {
					minHeap.add(new int[]{next[0],cost+next[1],stop-1});
				}
			}
			
			
		}
		
		return -1;
		
	}
	
	
	public static void main(String[] args) {
		
		int n = 3;
		
		int flights[][] = {{0,1,100},{1,2,100},{0,2,500}};
		
		int src = 0;
		
		int dst = 2;
		
		int k = 1;
		
		System.out.println(findCheapestPrice(n,flights,src,dst,k));
		
	}

}
