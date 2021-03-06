package May2020_Challenge;

public class ValidPerfectSquare {

	public static boolean isPerfectSquare(int num) {

		if (num < 2)
			return true;

		for (int i = 2; i <= num / 2; i++) {
			int curr = i * i;

			if (curr == num) {
				return true;
			}
		}

		return false;
	}

	// time complexity - O(log(sqrt(n))

	public static boolean isPerfectSquare_Efficient(int num) {

		if (num < 2)
			return true;

		int low = 2;

		int high = num / 2;

		int mid;

		int sq;

		while (low <= high) {
			mid = low + (high - low) / 2;

			sq = mid * mid;

			if (sq == num)
				return true;

			else if (sq > num)
				high = mid - 1;
			else
				low = mid + 1;

		}

		return false;

	}

	public static void main(String[] args) {

		int num = 16; // true

		int num1 = 14; // false

		// System.out.println(isPerfectSquare(4));

		System.out.println(isPerfectSquare_Efficient(25));

	}

}
