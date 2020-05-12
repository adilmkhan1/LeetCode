package May2020_Challenge;

//Your solution should run in O(log n) time and O(1) space.

public class SingleElementSortedArray {

	// Using XOR ..time complexity O(n) and space O(1)

	public static int singleNonDuplicate(int[] nums) {
		int res = nums[0];

		for (int i = 1; i < nums.length; i++) {
			res = res ^ nums[i];
		}

		return res;

	}

	// time complexity O(log(n)) and space O(1)

	public static int singleNonDuplicate_Efficient(int[] nums) {

		int n = nums.length;

		int low = 0;

		int high = n - 1;

		// Boundary check
		
		if(high == 0)
			return nums[0];

		if (nums[0] != nums[1])
			return nums[0];

		if (nums[n - 2] != nums[n - 1])
			return nums[n - 1];

		// Pair Indices Check (even /odd indices)

		while (low <= high) {
			int mid = low + (high - low) / 2;

			// unique element check

			if ((nums[mid] != nums[mid - 1]) && (nums[mid] != nums[mid + 1])) {
				return nums[mid];
			}

			// Partition Check

			if ((nums[mid] == nums[mid - 1]) && (mid % 2 != 0) || (nums[mid] == nums[mid + 1]) && (mid % 2 == 0)) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}

		}

		return -1;

	}

	public static void main(String[] args) {

		int arr[] = { 1, 1, 2, 3, 3, 4, 4, 8, 8 }; // 2

		int arr1[] = { 3, 3, 7, 7, 10, 11, 11 }; // 10

		// System.out.println(singleNonDuplicate(arr));

		System.out.println(singleNonDuplicate_Efficient(arr1));

	}

}
