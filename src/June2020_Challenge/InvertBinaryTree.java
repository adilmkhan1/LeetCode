package June2020_Challenge;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode 
{
	      int val;
	      
	      TreeNode left;
	      
	      TreeNode right;
	      
	      TreeNode() {}
	      
	      TreeNode(int val) 
	      { 
	    	  this.val = val;
	      }
	      
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	  }

public class InvertBinaryTree {
	
	public static TreeNode invertTree(TreeNode root)
	{
		if(root == null)
			return null;
		
		Queue<TreeNode> q = new LinkedList();
		
		q.add(root);
		
		while(!q.isEmpty())
		{
			TreeNode curr = q.poll();
			
			// swap left child with right child 	
			TreeNode temp = curr.left;
			curr.left = curr.right;
			curr.right = temp;
			
			 // push left and right children 
			if(curr.left != null) {
				q.add(curr.left);
			}
			
			if(curr.right != null) {
				q.add(curr.right);
			}
		}
		
	
		return root;
	}
	
	public static TreeNode invertTree_usingRecursion(TreeNode root)
	{
		if (root == null)
			return null;
		
		root.left = invertTree_usingRecursion(root.right);
		root.right = invertTree_usingRecursion(root.left);
		
		return root;
	}
	
	

	public static void main(String[] args) {
		
          TreeNode root = new TreeNode(4);
          root.left = new TreeNode(2);
          root.left.left = new TreeNode(1);
          root.left.right = new TreeNode(3);
          root.right = new TreeNode(7);
          root.right.left = new TreeNode(6);
          root.right.right = new TreeNode(9);
          
          invertTree(root);
          
          invertTree_usingRecursion(root);

	}

}
