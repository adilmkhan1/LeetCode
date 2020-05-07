package May2020_Challenge;

class TreeNode {
	int val;

	TreeNode left;

	TreeNode right;

	TreeNode(int val) {
		this.val = val;
	}

}

public class Cousins_BinaryTree {

	TreeNode root;
	
	TreeNode xParent = null;
	
	TreeNode yParent  = null;
	
	int xDepth = -1, yDepth = -1;

//	public static int level(TreeNode node, int a, int lev) {
//		if (node == null)
//			return 0;
//
//		if (node.val == a)
//			return lev;
//
//		int l = level(node.left, a, lev + 1);
//
//		if (l != 0)
//
//			return l;
//
//		return level(node.right, a, lev + 1);
//
//	}

//	public static boolean isSibling(TreeNode root, int a, int b) {
//		
//		if (root == null)
//			return false;
//		
//		
//		return (
//				(root.left.val == a && root.right.val == b) ||
//				(root.left.val == b && root.right.val == a)|| 
//				isSibling(root.left, a, b) ||
//				isSibling(root.right, a, b)
//				);
//
//	}
	
	public void getDepthAndParent(TreeNode root, int x, int y, int depth, TreeNode parent)
	{
        if(root == null){
            return;
        }
        
        if(root.val == x)
        {
            xParent = parent;
            
            xDepth = depth;
        }
        else if(root.val == y)
        {
            yParent = parent;
            
            yDepth = depth;
        } 
        else 
        {       
        getDepthAndParent(root.left, x, y, depth + 1, root);
        
        getDepthAndParent(root.right, x, y, depth + 1, root); 
        }
    }

	public boolean isCousins(TreeNode root, int x, int y) {

		//return (level(root, x, 1) == level(root, y, 1) && !isSibling(root, x, y));
		
		getDepthAndParent(root,x,y,0,null);
		
		return xDepth == yDepth && xParent != yParent? true: false;

	}

	public static void main(String[] args) {

		Cousins_BinaryTree tree = new Cousins_BinaryTree();

		tree.root = new TreeNode(1);
		
		tree.root.left = new TreeNode(2);

		tree.root.right = new TreeNode(3);
		
		tree.root.right.right = new TreeNode(6);
		
		tree.root.left.left = new TreeNode(4);
		
		tree.root.left.right = new TreeNode(5);
		
		System.out.println(tree.isCousins(tree.root,4,5));
		
	}

}
