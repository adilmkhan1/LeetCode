package May2020_Challenge;

import java.util.Stack;

public class RemoveKDigits {

	public static String removeKdigits(String num, int k) {
		if (k == 0)
			return num;

		int n = num.length();

		if (k == n)
			return "0";

		Stack<Character> st = new Stack<>();

		for (char c : num.toCharArray()) {
			while (!st.isEmpty() && k > 0 && st.peek() > c) {
				st.pop();
				k--;
			}

			st.push(c);
		}

		// handling increasing order of elements and k is still left

		while (k > 0) {
			st.pop();
			k--;
		}

		StringBuilder sb = new StringBuilder();

		// take out from stack and reverse numbers

		while (!st.isEmpty()) {
			sb.append(st.pop());
		}

		sb.reverse();

		// handle leading zeroes case

		while (sb.length() > 1 && sb.charAt(0) == '0') {
			sb.deleteCharAt(0);
		}

		return sb.toString();
	}

	public static void main(String[] args) {

		String num = "1432219"; // 1219

		int k = 3;

		String num1 = "10200";

		int k1 = 1;

		String num2 = "10";

		int k2 = 2;

		System.out.println(removeKdigits(num1, k1));

	}

}
