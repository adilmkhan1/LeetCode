package May2020_Challenge;

public class MaxSumCircularArray {
	
//	public static int maxSubarraySumCircular(int arr[])
//	{
//		if (arr == null || arr.length == 0 ) return 0;
//		
//		int maxTillHere = arr[0];
//		int maxInTotal = Integer.MIN_VALUE;
//		int minTillHere = arr[0];
//		int minInTotal = Integer.MAX_VALUE;
//		int sum = arr[0];
//		
//		
//		for (int i = 1; i < arr.length; i++) 
//		{
//			sum+=arr[i];
//			
//			maxTillHere = Math.max(arr[i],maxTillHere+arr[i]);
//			
//			if (maxInTotal < maxTillHere)
//			{
//				maxInTotal = maxTillHere;
//			}
//			
//			minTillHere = Math.min(arr[i],minTillHere+arr[i]);
//			
//			if (minInTotal > minTillHere)
//			{
//				minInTotal = minTillHere;
//			}
//		}
//	
//		
//		//if all elements are -ve
//		if(sum == minInTotal) return maxInTotal;
//		
//		return Math.max(sum - minInTotal, maxInTotal);
//	}
	
	//another approach
	
public static int maxSubarraySumCircular(int[] A) {
        
        if (A == null || A.length == 0 ) return 0;
		
		int maxTillHere = 0;
		int maxInTotal = Integer.MIN_VALUE;
		int minTillHere = 0;
		int minInTotal = Integer.MAX_VALUE;
		int sum = 0;
		
		
		for (int i = 0; i < A.length; i++) 
		{
			sum+=A[i];
			
			maxTillHere = Math.max(A[i],maxTillHere+A[i]);
			
		    maxInTotal = Math.max(maxTillHere,maxInTotal);
		
			minTillHere = Math.min(A[i],minTillHere+A[i]);
            
            minInTotal = Math.min(minTillHere,minInTotal);
            
			
		}
		
        if(maxInTotal > 0)
        
        return Math.max(sum - minInTotal, maxInTotal);
		
		return maxInTotal;
        
    }

	public static void main(String[] args) {
		
		int arr1 [] = {5,-3,5};
		
		int arr2[] = {3,-1,2,-1};
		
		int arr3[] = {9,-4,-7,9};
		
		int arr4[] = {1,2,3};
		
		System.out.println(maxSubarraySumCircular(arr3));

	}

}
