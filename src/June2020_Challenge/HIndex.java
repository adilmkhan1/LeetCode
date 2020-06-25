package June2020_Challenge;

public class HIndex {
	
	//https://www.youtube.com/watch?v=CjKJDloMnwE
	
	//BS O(logn)
	
	public static int hIndex(int[] citations) {

		int n = citations.length;
		int low = 0;
		int high = n - 1;
		int mid;

		while (low <= high) {
			mid = low + (high - low) / 2;

			if (citations[mid] == n - mid)
				return citations[mid];
			else if (citations[mid] > n - mid)
				high = mid - 1;
			else
				low = mid + 1;

		}

		return n - low;

	}

	public static void main(String[] args) {
		
		int citations[] = {0,1,3,5,6}; //3
		
		int citations_1[] = {1,2,6,7,8,9}; //4
		
		System.out.println(hIndex(citations_1)); 

	}

}
