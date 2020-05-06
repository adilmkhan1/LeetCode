package May2020_Challenge;

import java.util.HashMap;

public class MajorityElement {
	
	//O(n) time but 2 passes and O(n) space

	public static int majorityElement(int[] nums) {

		if (nums.length == 1)
			return nums[0];

		// number,occurences

		HashMap<Integer, Integer> map = new HashMap();

		for (int i : nums) {
			if (map.containsKey(i) && map.get(i) + 1 > nums.length / 2) {
				return i;
			} else {
				map.put(i, map.getOrDefault(i, 0) + 1);
			}
		}

		return -1; // for java sake

	}
	
	//O(n) time single pass and O(1) space
	
	//Boyer - Moore Majority Voting Algorithm
	
	public static int majorityElement_Best_Approach(int arr[])
	{
		
		int majority = arr[0];
		
		int count = 1;
		
		for (int i = 1; i < arr.length; i++)
		{
		   if (arr[i] == majority)
		   {
			   count+=1;
		   }else
		   {
			   count-=1;
			   if(count == 0)
			   {
				   majority=arr[i];
				   count = 1;
			   }
		   }
			
		}
		
		
		return majority;
	}

	public static void main(String[] args) {

		int arr[] = { 3, 2, 3 }; // 3

		int arr1[] = { 2, 2, 1, 1, 1, 2, 2 }; // 2

		//System.out.println(majorityElement(arr1));
		
		System.out.println(majorityElement_Best_Approach(arr1));

	}

}
