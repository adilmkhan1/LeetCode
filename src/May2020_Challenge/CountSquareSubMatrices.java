package May2020_Challenge;

import java.util.Arrays;

public class CountSquareSubMatrices {

	// Time - O(n*m) , Space - O(n*m)

	public static int countSquares(int matrix[][]) {

		if (matrix == null || matrix.length == 0)
			return 0;

		int row = matrix.length;
		int column = matrix[0].length;

		int count = 0;

		int dp[][] = new int[row][column];

		// top row
		for (int i = 0; i < column; i++) {

			dp[0][i] = matrix[0][i];
			count += dp[0][i];
		}
		// first column
		for (int i = 0; i < row; i++) {
			dp[i][0] = matrix[i][0];
			count += dp[i][0];
		}

		for (int i = 1; i < row; i++) {

			for (int j = 1; j < column; j++) {
				if (matrix[i][j] == 1) {
					dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j - 1]), dp[i - 1][j]);
					count += dp[i][j];
				}
			}
		}

		// System.out.println(Arrays.deepToString(dp));

		return count;
	}

	// shortened code

	public static int countSquares_shortPrecise(int matrix[][]) {

		int[][] dp = matrix.clone();

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 1) {
					dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
				}
			}
		}
		return Arrays.stream(dp).flatMapToInt(Arrays::stream).sum();
	}

	public static void main(String[] args) {

		int matrix[][] = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 } }; // 15

		int matrix1[][] = { { 1, 0, 1 }, { 1, 1, 0 }, { 1, 1, 0 } }; // 7

		System.out.println(countSquares(matrix));

		System.out.println(countSquares_shortPrecise(matrix));

	}

}
