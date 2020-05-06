package May2020_Challenge;

import java.util.HashMap;

public class MajorityElement {

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

	public static void main(String[] args) {

		int arr[] = { 3, 2, 3 }; // 3

		int arr1[] = { 2, 2, 1, 1, 1, 2, 2 }; // 2

		System.out.println(majorityElement(arr1));

	}

}
