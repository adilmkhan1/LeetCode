package June2020_Challenge;

import java.util.Arrays;

public class SortColors {

	public static void sortColors(int[] nums) {
		if (nums == null || nums.length == 0)
			return;

		int low = 0, high = nums.length - 1;
		int mid = 0;

		while (mid <= high) {
			switch (nums[mid]) {
			case 0:
			{
				swap(nums, low, mid);
				low++;
				mid++;
				break;
			}

			case 1:
				mid++;
				break;

			case 2:
			{
				swap(nums, mid, high);
				high--;
				break;
			}

			}

		}

	}

	private static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {

		//int nums[] = { 2, 0, 2, 1, 1, 0 };
		
		int nums[] = {2,0,1};
		
		sortColors(nums);
		
		System.out.println(Arrays.toString(nums));

	}

}
