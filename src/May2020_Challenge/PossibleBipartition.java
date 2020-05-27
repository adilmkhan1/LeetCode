package May2020_Challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PossibleBipartition {

	// solved using adjacency list and graph coloring using bipartite property

	public static boolean possibleBipartition(int N, int[][] dislikes) {
		
		int groups[] = new int[N+1]; //or colors using values 0 or 1

		Arrays.fill(groups, -1);

		List<Integer>[] adj = new ArrayList[N+1]; //array of list type or adjacency list
		
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList();
		}
	
		// adjacency list populate

		for (int[] pairs : dislikes) {
			adj[pairs[0]].add(pairs[1]);
			adj[pairs[1]].add(pairs[0]);
		}

		// dfs

		for (int i = 1; i <=N; i++) {
			if (groups[i] == -1 && !dfs(adj, groups, i, 0)) {
				return false;
			}

		}
		
		System.out.println("Groups defined are (ignore zero index) : "+ Arrays.toString(groups));

		return true;
	}

	private static boolean dfs(List<Integer>[] adj, int groups[], int v, int grp) {
		if (groups[v] == -1)
			groups[v] = grp;
		else
			return groups[v] == grp; //check the color as it is visited already

		// check neighbours

		for (int n : adj[v]) {
			if (!dfs(adj, groups, n, 1 - grp))
				return false;
		}

		return true;
	}

	public static void main(String[] args) {

		int dislikes[][] = { { 1, 2 }, { 1, 3 }, { 2, 4 } }; // true

		int N = 4;

		int dislikes1[][] = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 1, 5 } }; //false

		int N1 = 5;

		System.out.println(possibleBipartition(N, dislikes));

	}

}
