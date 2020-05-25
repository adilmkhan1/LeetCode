package May2020_Challenge;

import java.util.Arrays;

//https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/discuss/589801/JAVA-3-WAYS-TO-DO-THE-PROBLEM!-O(N)-APPROACH

class TN
{
	int data;
	
	TN left;
	TN right;
	
	
	public TN(int data) {
		
		this.data = data;
		
	}
	
	
}


public class bstFromPreorderConstruct {
	
	TN root;
	
	int globalIndex = 0;
	
	//O(n^2)
	
	public TN bstFromPreorder(int[] preorder)
	{
	    int n = preorder.length;
	    
	    if(n==0)return null;
	    if(n==1) return new TN(preorder[0]);
	    
	    //TN root = new TN(preorder[0])
	    
	    /*for(int i=1;i<n;i++)
	    {
	    	root = insert(root,preorder[i]);
	    }*/
		
		return helper(preorder,0,preorder.length-1);
	}
	
	/*private TN insert(TN root,int val)
	{
		if(root == null) return TN(val);
		
		if (val > root.data)
		   root.left = insert(root.left,val);
		else
		   root.right = insert(root.right,val);   
		
	 return root;	
		
	}*/
	
	
	public TN helper(int []preorder,int start,int end)
	{
		if(start > end)
			return null;
		
		TN node = new TN(preorder[start]);
		
		int i;
		
		for (i = start; i <= end; i++) 
		{
			if(preorder[i] > node.data)
				break;
			
		}
		
		node.left = helper(preorder,start+1,i-1);
		node.right = helper(preorder,i,end);
		
		return node;
		
	}
	
	//O(n) ..upper and lower bound approach
	
	public TN bstFromPreorder_bestapproach(int[] preorder)
	{
		if(preorder.length == 0)
			return null;
		
		return constructBSTHelper(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	private TN constructBSTHelper(int[] preorder,int min,int max)
	{
		if(globalIndex == preorder.length || preorder[globalIndex] < min || preorder[globalIndex] > max)
			return null;
		
		
		int val = preorder[globalIndex++];
		
		TN node = new TN(val);
		
		node.left = constructBSTHelper(preorder, min, val);
		node.right = constructBSTHelper(preorder, val, max);
		
		return node;
	}
	
	
	
	

	public static void main(String[] args) {
		
		bstFromPreorderConstruct tree = new bstFromPreorderConstruct();
		
		tree.root = new TN(8);
		tree.root.left = new TN(5);
		tree.root.right = new TN(10);
		tree.root.right.right = new TN(12);
		tree.root.left.left = new TN(1);
		tree.root.left.right = new TN(7);
		
		int preorder[] = {8,5,1,7,10,12};
		
		
		//tree.bstFromPreorder(preorder);
		
		tree.bstFromPreorder_bestapproach(preorder);
		
		

	}

}
