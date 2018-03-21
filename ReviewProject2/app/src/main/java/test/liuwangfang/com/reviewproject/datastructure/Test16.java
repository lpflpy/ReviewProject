package test.liuwangfang.com.reviewproject.datastructure;
// 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
class Test16{
	public static void main(String[] args) {
		TreeNode node6 = new TreeNode(6,null,null);
		TreeNode node7 = new TreeNode(7,null,null);
		TreeNode node5 = new TreeNode(5,node6,node7);
		TreeNode node4 = new TreeNode(4,null,null);
		TreeNode node2 = new TreeNode(2,node4,node5);

		TreeNode node8 = new TreeNode(8,null,null);
		TreeNode node9 = new TreeNode(9,null,null);
		TreeNode node3 = new TreeNode(3,node8,node9);
		TreeNode node1 = new TreeNode(1,node2,node3);

		TreeNode node62 = new TreeNode(6,null,null);
		TreeNode node72 = new TreeNode(7,null,null);
		TreeNode node52 = new TreeNode(5,node62,node72);

		printMirrorTree(node1);
		// printMirrorTree(node52);

	}

	public static void printMirrorTree(TreeNode root){
		if(root==null){
			return;
		}
		TreeNode left = root.left;
		TreeNode right = root.right;
	 
		TreeNode temp = left;
		left = right;
		right = temp;

		int leftValue = left!=null ? left.value:-1;
		int rightValue = right!=null ?right.value:-1;
		System.out.println("root:"+root.value+"  left:"+leftValue+" right:"+rightValue);
		 
	

		//????总是在循环里面写递归 
		// TreeNode node1 = root;		

		// while(root.right!=null){
			// System.out.println("1111111:");
			printMirrorTree(root.right);
		// 	root = root.right;
		// }

		// while(node1.left!=null){
			// System.out.println("222222:");
			printMirrorTree(root.left);
		// 	node1 = node1.left;		
		// }

	}


	static class TreeNode{
		int value;
		TreeNode left;
		TreeNode right;

		TreeNode(int value,TreeNode left,TreeNode right){
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
}