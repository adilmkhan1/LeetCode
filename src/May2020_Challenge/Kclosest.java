package May2020_Challenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;




public class Kclosest {
	
	
	static class Point implements Comparable<Point>
	{
		int x;
		int y;
		
		public Point(int pt[])
		{
			x = pt[0];
			y = pt[1];
		}

		@Override
		public int compareTo(Point p) {
			 
			return (p.x*p.x + p.y*p.y) - (x*x +y*y);

			
		}
		
		
		
	}
	
	

	
	//Time Complexity O(n*logn)
	
	public static int[][] kClosest(int points[][], int K) {
		
		int N = points.length;
		
        int[] dists = new int[N];
        
        for (int i = 0; i < N; ++i)
            dists[i] = dist(points[i]);

        Arrays.sort(dists);
        int distK = dists[K-1];

        int[][] ans = new int[K][2];
        int t = 0;
        for (int i = 0; i < N; ++i)
            if (dist(points[i]) <= distK)
                ans[t++] = points[i];
        return ans;

		

	}

	public static int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
	
	
	//Using min heap
	
	//Time Complexity - 0(n) build Heap + O(n*logk) extract
	
	public static int[][] kClosest_usingPQ(int points[][], int K) {
		
		int result[][] = new int[K][2];
		
		PriorityQueue<Point> pq = new PriorityQueue(); //max heap
		
		//PriorityQueue<int[]> maxHeap = new PriorityQueue((a,b) -> (b[0]*b[0]+b[1]*b[1]) - (a[0]*a[0]+a[1]*a[1]));
		
//		for(int[] point : points)
//		{
//			maxHeap.add(point);
//			if(maxHeap.size() > K)
//			{
//				maxHeap.remove();
//			}
//		}
//		
//		while(K-- > 0)
//		{
//			result[K] = maxHeap.remove();
//		}
		
		
		
		for(int i=0;i<points.length;i++)
		{
			if(pq.size() < K)
			{
				pq.offer(new Point(points[i]));
			}else
			{
				Point p = pq.peek();
				
				if ((p.x*p.x + p.y*p.y) > (points[i][0]*points[i][0] + points[i][1]*points[i][1]))
				{
					pq.poll();
					pq.offer(new Point(points[i]));
				}
			}
		}
		
		for (int i = 0; i < K; i++) {
			Point p = pq.poll();
			result[i][0] = p.x;
			result[i][1] = p.y;
		}
		
		return result;
		
	}
	

	public static void main(String[] args) {

		int points[][] = { { 1, 3 }, { -2, 2 } }; // [[-2,2]]

		int K = 1;

		int points1[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } }; // [[3,3],[-2,4]]

		int K1 = 2;

		//int result [][]  = kClosest(points1, K1);
		
		int result [][] = kClosest_usingPQ(points1, K1);
		
		for (int x[] : result) {
			
			System.out.println(Arrays.toString(x));
			
		}

	}

}
