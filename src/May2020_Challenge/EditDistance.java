package May2020_Challenge;

public class EditDistance {

	
	//Time Complexity - O(3^n)
	
	public static int editDistCost(String X, int m, String Y, int n)
	{
		// base case: empty strings (case 1)
		if (m == 0) {
			return n;
		}

		if (n == 0) {
			return m;
		}

		// if last characters of the strings match (case 2)
		int cost = (X.charAt(m - 1) == Y.charAt(n - 1)) ? 0: 1;

		return minimum(editDistCost(X, m - 1, Y, n) + 1,  // deletion (case 3a))
				editDistCost(X, m, Y, n - 1) + 1,		 // insertion (case 3b))
				editDistCost(X, m - 1, Y, n - 1) + cost); // substitution (case 2 & 3c)
	}
	
	
	//DP approach
	
	//Time Complexity - O(mn)
	public static int minDistance(String word1, String word2) {
		if (word1 == null || word1.length() == 0)
			return word2.length();
		if (word2 == null || word2.length() == 0)
			return word1.length();

		int m = word1.length();

		int n = word2.length();

		return editDistDP(word1, word2, m, n);
	}

	private static int editDistDP(String word1, String word2, int m, int n) {
		int T[][] = new int[m + 1][n + 1];

		int cost = 0;

		for (int i = 0; i <= m; i++) {
			T[i][0] = i;
		}

		for (int i = 0; i <= n; i++) {
			T[0][i] = i;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1))
					cost = 0;
				else
					cost = 1;

				T[i][j] = minimum(T[i - 1][j] + 1, T[i][j - 1] + 1, T[i - 1][j - 1] + cost);

			}
		}

		return T[m][n];

	}

	private static int minimum(int a, int b, int c) {
		return Integer.min(a, Integer.min(b, c));
	}

	public static void main(String[] args) {

		String word1 = "horse";

		String word2 = "ros"; // 3

		String word1_1 = "intention";

		String word2_1 = "execution"; // 5

		System.out.println(minDistance(word1, word2));
		
		//System.out.println(minDistance(word1_1, word2_1));

	}

}
