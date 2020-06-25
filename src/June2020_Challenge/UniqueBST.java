package June2020_Challenge;

public class UniqueBST {

//catalan number	

	public static int numTrees(int n) {

		if (n < 2)
			return 1;

		int dp[] = new int[n + 1];

		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				dp[i] += dp[j] * dp[i - j - 1];
			}
		}

		return dp[n];

	}

	public static void main(String[] args) {

		int n = 3;

		System.out.println(numTrees(n));

	}

}
