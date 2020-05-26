package May2020_Challenge;

import java.util.HashMap;

public class ContiguousArray {

	// O(n) - time and space

	public static int findMaxLength(int arr[]) {
		int longest_subarray = 0;

		int sum = 0;

		HashMap<Integer, Integer> map = new HashMap(); // key - sum , value - index

		for (int i = 0; i < arr.length; i++) {

			sum += arr[i] == 0 ? -1 : 1;

			if (sum == 0) {
				if (longest_subarray < i + 1)
					longest_subarray = i + 1;
			} else if (map.containsKey(sum)) {
				if (longest_subarray < i - map.get(sum))
					longest_subarray = i - map.get(sum);
			} else
				map.put(sum, i);

		}

		return longest_subarray;
	}

	public static int findMaxLength_SimpleApproach(int nums[]) {
		if (nums.length <= 1)
			return 0;

		HashMap<Integer, Integer> map = new HashMap(); // sum ,index

		map.put(0, -1); // initial value in map;

		int sum = 0;

		int maxLength = 0;

		for (int i = 0; i < nums.length; i++) {

			sum += nums[i] == 1 ? 1 : -1;

			if (map.containsKey(sum)) {
				maxLength = Math.max(maxLength, i - map.get(sum));
			} else {
				map.put(sum, i);
			}

		}

		return maxLength;
	}

	public static void main(String[] args) {

		int arr[] = { 0, 1, 0 };// 2

		int arr1[] = { 0, 1 };// 2

		int arr2[] = { 1, 1, 0, 0, 1, 1, 0, 1, 1 };

		// System.out.println(findMaxLength(arr1));

		System.out.println(findMaxLength_SimpleApproach(arr2));

	}

}
