package June2020_Challenge;

import java.util.Arrays;

public class PerfectSquares {

	public static int numSquares(int n) {

		int max = (int) Math.sqrt(n);

		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= max; j++) {
				if (i == j * j) { //if number is already a perfect square then 1 sol exists
					dp[i] = 1;
				} else if (i > j * j) { //e.g i = 3 and j = 2 so 3 - 4 ...don't go inside elseif block
					dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
				}
			}
		}

		return dp[n];

	}

	public static void main(String[] args) {

		int n = 13; // 4 + 9 

		int n1 = 12; // 4 + 4 + 4 

		System.out.println(numSquares(n));

	}

}
