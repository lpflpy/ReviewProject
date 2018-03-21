package test.liuwangfang.com.reviewproject.datastructure;
// 输入两棵二叉树A 和B，判断B 是不是A 的子结构。

class Test15{
	public static void main(String[] args) {
		//前序遍历
		int[] tree1= {1,2,4,5,6,7,3,8,9};

		int[] tree2= {5,6,7};

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
		TreeNode node42 = new TreeNode(4,null,null);
		TreeNode node22 = new TreeNode(2,node42,node52);

		System.out.println("isContain===="+isTree1ContainTree2(node1,node22));
		System.out.println("isContain===="+isTree1ContainTree22(node1,node22));

	}
	// 自己写的 有明显bug  只比较了根节点的左节点 和右节点 没有比较更深层次的

	public static boolean isTree1ContainTree2(TreeNode node1,TreeNode node2){

		 if(node1 ==node2){
		 	return true;
		 }

		 if(node2==null){
		 	return true;
		 }

		 if(node1 ==null){
		 	return false;
		 }
		System.out.println("node1===="+node1.value);
		if(node1.value == node2.value){
			boolean leftEqual = (node1.left!=null && node2.left!=null && node1.left.value == node2.left.value)|| (node1.left ==null && node2.left ==null);
			boolean rightEqual = (node1.right!=null && node2.right!=null && node1.right.value == node2.right.value)|| (node1.right ==null && node2.right ==null);
			return leftEqual && rightEqual;
		
		}
		TreeNode root = node1;
		while(node1.left!=null){
			if(isTree1ContainTree2(node1.left,node2)){
				return true;
			}else{
				node1 = node1.left;
			}
		}

		while(root.right!=null){
			if(isTree1ContainTree2(root.right,node2)){
				return true;
			}else{
				root = root.right;
			}
		}

		return false;

	}


	public static boolean isTree1ContainTree22(TreeNode node1,TreeNode node2){
		 if(node1 ==node2){
		 	return true;
		 }

		 if(node2==null){
		 	return true;
		 }

		 if(node1 ==null){
		 	return false;
		 }
		 
		 if(match(node1,node2)){
		 	return true;
		 }

		return isTree1ContainTree22(node1.left,node2) || isTree1ContainTree22(node1.right,node2);

	}

	public static boolean match(TreeNode node1,TreeNode node2){
		if(node1==node2){
			return true;
		}

		if(node2==null){
			return true;
		}

		if(node1==null){
			return false;
		}

		if(node1.value ==node2.value){
			return match(node1.left,node2.left) && match(node1.right,node2.right);
		}

		return false;
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