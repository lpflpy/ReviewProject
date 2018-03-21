// 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。


// 在二叉树中，每个结点都有两个指向子结点的指针。在双向链表中，每个结点也有两个指针，
// 它们分别指向前一个结点和后一个结点。由于这两种结点的结构相似，同时二叉搜索树也是一种排序的数据结构，
// 因此在理论上有可能实现二叉搜索树和排序的双向链表的转换。

// 在搜索二叉树中，左子结点的值总是小于父结点的值，右子结点的值总是大于父结点的值。
// 因此我们在转换成排序双向链表时，原先指向左子结点的指针调整为链表中指向前一个结点的指针，
// 原先指向右子结点的指针调整为链表中指向后一个结点指针。接下来我们考虑该如何转换。

// 由于要求转换之后的链表是排好序的，我们可以中序遍历树中的每一个结点， 
// 这是因为中序遍历算法的特点是按照从小到大的顺序遍历二叉树的每一个结点。
// 当遍历到根结点的时候，我们把树看成三部分：根结点，左子树，右子树。
// 根据排序链表的定义，根结点将和它的左子树的最大一个结点链接起来，同时它还将和右子树最小的结点链接起来。
class Test24{
	public static void main(String[] args) {
		
		TreeNode node1 = new TreeNode(16,null,null);
		TreeNode node2 = new TreeNode(17,node1,null);
		TreeNode node3 = new TreeNode(15,null,node2);
		TreeNode node4 = new TreeNode(19,null,null);
		TreeNode node5 = new TreeNode(18,node3,node4);

		TreeNode node6 = new TreeNode(2,null,null);
		TreeNode node7 = new TreeNode(9,null,null);
		TreeNode node8 = new TreeNode(5,node6,node7);
		TreeNode node9 = new TreeNode(12,node8,node5);

		// tranferDoubleLinkList(node9);
		middleIterator(node9);
	}

	// public static LinkedNod tranferDoubleLinkList(TreeNode root){
		// LinkedNod preNode  = null;
		// if(root.left!=null){
		// 	preNode = new LinkedNod(root.left.value,tranferDoubleLinkList(root.left),root);
		// }

		// LinkedNod nextNode  = null;
		// if(root.right!=null){
		// 	nextNode = new LinkedNod(root.right.value,root,tranferDoubleLinkList(root.right);
		// }
		// LinkedNod linkroot = new LinkedNod(root.value,preNode,nextNode);

		// return linkroot.preNode;

	// }

	public static void middleIterator(TreeNode root){
		if(root ==null){
			return;
		}
		if(root.left!=null){
			System.out.println(root.left.value);
		}
		System.out.println(root.value);
		if(root.right!=null){
			System.out.println(root.right.value);
		}
		middleIterator(root.left);
		middleIterator(root.right);
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

	static class LinkedNod{
		int value;
		LinkedNod pre;
		LinkedNod next;

		LinkedNod(int value,LinkedNod pre,LinkedNod next){
			this.value = value;
			this.pre = pre;
			this.next = next;
		}
	}


}