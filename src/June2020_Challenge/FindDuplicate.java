package June2020_Challenge;

public class FindDuplicate {

	//https://www.youtube.com/watch?v=GOYMcrvg-Ck
	
	public static int findDuplicate(int nums[]) {
		
		int n = nums.length;
		int curr_max = 0;
		int max_idx = 0;
		
		for(int i=0;i<n;i++)
		{
			int idx = nums[i]% n; //takes care of before changed value
			nums[idx] +=n;
			
		}
		
		for(int i=0;i<n;i++)
		{
			if(nums[i] > curr_max)
			{
				curr_max = nums[i];
				max_idx = i;
			}
			
			nums[i] %=  n; //revert back to original array
		}
		
		return max_idx;
		
	}

	public static void main(String[] args) {

		int nums[] = { 1, 3, 4, 2, 2 }; // 2

		int nums1[] = { 3, 1, 3, 4, 2 }; // 3

		System.out.println(findDuplicate(nums1));

	}

}
