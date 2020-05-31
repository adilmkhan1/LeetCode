package May2020_Challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CourseSchedule {
	
	//https://leetcode.com/problems/course-schedule/discuss/58669/Concise-JAVA-solutions-based-on-BFS-and-DFS-with-explanation
	
	//Using topological sorting and DFS
	
	public static boolean canFinish(int numCourses,int [][]prerequisites)
	{
		int inDegree[] = new int[numCourses];
		
		int count = 0;
		
		for (int i = 0; i < prerequisites.length; i++) {
			//for every course which has prerequisite ,add indegree
			
			inDegree[prerequisites[i][0]]++;
			
		}
		
		//DFS
		
		Stack<Integer> stack = new Stack();
		
		//first add vertex that doesn't have prerequisite in Stack
		
		for (int i = 0; i < inDegree.length; i++) {
			
			if(inDegree[i] == 0)
			{
				stack.push(i);
			}
			
		}
		
		while(!stack.isEmpty())
		{
			int curr = stack.pop();
			count++;
			
			for (int i = 0; i < prerequisites.length; i++) {
				
				if(prerequisites[i][1] == curr)
				{
					inDegree[prerequisites[i][0]]--;
					if(inDegree[prerequisites[i][0]] == 0)
					{
						stack.push(prerequisites[i][0]);
					}
				}
			}
		}
		
		return count == numCourses;
	}
	
	//Using Visited and Explored approach
	
	//youtube.com/watch?v=CL4NZAoOdpM
	
	static List<Integer>[] adj;
	
	static boolean visited[];
	static boolean marked[];
	
	public static boolean canFinish_usingCycleDetect(int numCourses,int [][]prerequisites)
	{
	   adj = new ArrayList[numCourses];
	   
	   for (int i = 0; i < numCourses; i++) {
		   
		   adj[i] = new ArrayList<Integer>();
		
	}
	   
	 visited = new boolean[numCourses];
	 marked = new boolean[numCourses];
	   
	   //populate adjacency matrix
	   
	   for (int i = 0; i < prerequisites.length; i++) {
		   adj[prerequisites[i][0]].add(prerequisites[i][1]);
		
	}
	   
	  //dfs traversal
	   
	   for (int i = 0; i < numCourses; i++) {
		   
		   if(!visited[i])
		   {
			   if(isCyclic(i))
			   {
				   return false;
			   }
		   }
		
	}
	   
	   
	 return true;  
	
		
	}
	
	
	private static boolean isCyclic(int i)
	{
		visited[i] = true;
		
		for (Integer j : adj[i]) {
			if(!visited[j])
			{
				if(isCyclic(j))
				{
					return true;
				}
			}else if(!marked[j])
			{
				return true;
			}
			
		}
		

		marked[i] = true;
		
		return false;
	}

	public static void main(String[] args) {
		
         int numCourses = 2;
         
         int prerequisites[][] = {{1,0}}; //true
         
         int prerequisites1[][] = {{1,0},{0,1}}; //false
         
         int numCourses1 = 5;
         
         int prerequisites2[][] = {{1,0},{0,2},{2,1},{4,0},{3,4}};//false
         
         System.out.println(canFinish(numCourses,prerequisites));
         
         System.out.println(canFinish_usingCycleDetect(numCourses1, prerequisites2));
         
         
		

	}

}
