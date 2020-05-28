package May2020_Challenge;

import java.util.Arrays;

//https://www.youtube.com/watch?v=GeipEH-g0e8&list=PLxoOrmZMsAWwuMMvyY-dLychxIKjVB4mq&index=2

public class CountingBits {

	public static int[] countBits(int num) {
		int result[] = new int[num + 1];

		Arrays.fill(result, 0);

		int countSetBits = 0;

		for (int i = 1; i <= num; i++) {
			countSetBits = countSetBitsHelper(i);

			if (countSetBits > 0) {
				result[i] = countSetBits;
			} else {
				result[i] = 0;
			}

		}

		return result;
	}

	//Using Bit Masking AND operator and Right Shift
	
	public static int countSetBitsHelper(int n) {
		int result = 0;

		while (n > 0) {
			int val = n & 1;

			if (val == 1) {
				result++;

			}
			n = n >> 1;
		}

		return result;
	}

	public static void main(String[] args) {

		int num = 5; //[0,1,1,2,1,2]

		int num1 = 2; //[0,1,1]

		System.out.println(Arrays.toString(countBits(num1)));

		System.out.println(Arrays.toString(countBits(num)));

	}

}
