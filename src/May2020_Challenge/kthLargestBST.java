package May2020_Challenge;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

class TreeKaNode {
	int data;

	TreeKaNode left;

	TreeKaNode right;

	public TreeKaNode(int data) {

		this.data = data;
		left = null;
		right = null;
	}

}

public class kthLargestBST {

	TreeKaNode root;
	

	//O(n) space
	
	public int kthSmallest(TreeKaNode root, int k) {
		int result = 0;

		if (root == null)
			return result;

		ArrayList<Integer> nodeList = new ArrayList<>();

		inOrderList(root, nodeList);

		for (int i = 0; i < k; i++) {
			result = nodeList.get(i);
		}

		return result;
	}

	public void inOrderList(TreeKaNode root, ArrayList<Integer> list) {
		if (root == null)
			return;

		inOrderList(root.left, list);

		list.add(root.data);

		inOrderList(root.right, list);

	}
	
	
	
	
	//O(1) space
	
	public int kthSmallest_withConstSpace(TreeKaNode root,int k)
	{
		if (root == null) return 0;
		
		AtomicInteger count = new AtomicInteger();
		
		AtomicInteger result = new AtomicInteger();
		
		inOrderTraversal(root,count,result,k);
		
		return result.get();
	
	}
	
	public void inOrderTraversal(TreeKaNode root,AtomicInteger count,AtomicInteger result,int k)
	{
		if (root.left  != null)
		   inOrderTraversal(root.left, count,result, k);
		
		count.getAndIncrement();
		
		if (count.get() == k)
		{
			
			result.set(root.data);
			return;
		}
		
		if(root.right != null)
		inOrderTraversal(root.right, count,result, k);
		
	
	}
	

	public static void main(String[] args) {

		TreeKaNode root = new TreeKaNode(3);
		root.left = new TreeKaNode(1);
		root.right = new TreeKaNode(4);
		root.left.right = new TreeKaNode(2);

		kthLargestBST kbst = new kthLargestBST();

		int k = 4;

		//System.out.println(kbst.kthSmallest(root, k));
		
		System.out.println(kbst.kthSmallest_withConstSpace(root, k));

	}

}
