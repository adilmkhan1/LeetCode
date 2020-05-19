package May2020_Challenge;

import java.util.Stack;

//https://leetcode.com/problems/online-stock-span/discuss/640358/JAVA-Solution-With-visualization-and-easy-explained!

public class StockSpanner {

	Stack<int[]> stack;

	// integer array pair of (current price,max number of consecutive days)

	public StockSpanner() {
		stack = new Stack();
	}

	public int next(int price) {
		int span = 1;

		while (!stack.isEmpty() && stack.peek()[0] <= price) {
			span += stack.pop()[1];
		}

		stack.push(new int[] { price, span });

		return span;
	}

	public static void main(String[] args) {

		StockSpanner obj = new StockSpanner();
		System.out.println(obj.next(100));
		System.out.println(obj.next(80));
		System.out.println(obj.next(60));
		System.out.println(obj.next(70));
		System.out.println(obj.next(60));
		System.out.println(obj.next(75));
		System.out.println(obj.next(85));

	}

}
