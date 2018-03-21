package test.liuwangfang.com.reviewproject.datastructure;
// 从上往下打印出二叉树的每个结点，同一层的结点按照从左向右的顺序打印。

// 这道题实质是考查树的遍历算法。从上到下打印二叉树的规律：每一次打印一个结点的时候，如果该结点有子结点， 
// 则把该结点的子结点放到一个队列的末尾。接下来到队列的头部取出最早进入队列的结点，重复前面的打印操作，
// 直至队列中所有的结点都被打印出来为止。
import java.util.LinkedList;
import java.util.Queue;
class Test20{
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


		Queue<TreeNode> list = new LinkedList<>();
		list.add(node1);
		// printAllNode(list);

		printAllNode2(node1);

	}

	public static void printAllNode(Queue<TreeNode> queue){
		if(queue==null || queue.size()==0){
			return;
		}

		// 递归的方式
		Queue<TreeNode> list = new LinkedList<>();
		for(TreeNode root:queue){			
			if(root.left!=null){
				System.out.print(root.left.value+"  ");
				list.add(root.left);
			}
			if(root.right!=null){
				System.out.print(root.right.value+"  ");
				list.add(root.right);
			}
		}


	}

	//循环的方式 --自己写不出来  不知道怎么循环
	public static void printAllNode2(TreeNode root){
		if(root==null){
			return;
		}

		
		// Queue<TreeNode> queue = new LinkedList<>();
		// queue.add(root);
		// while(queue!=null && queue.size()!=0){	

		// 	for(TreeNode node:queue){			
		// 		if(node.left!=null){
		// 			System.out.print(node.left.value+"  ");
		// 		}
		// 		if(node.right!=null){
		// 			System.out.print(node.right.value+"  ");
		// 		}
				
		// 		if(node.left!=null){
		// 			queue.add(node.left);
		// 		}
		// 		if(node.right!=null){
		// 			queue.add(node.right);
		// 		}
		// 	}
		// }

		 // if (root != null) {
   //          // 用于存放还未遍历的元素
   //          Queue<TreeNode> list = new LinkedList<>();
   //          // 将根结点入队
   //          list.add(root);
   //          // 用于记录当前处理的结点
   //          TreeNode curNode;
   //          int i = 0;
   //          // 队列非空则进行处理
   //          while (!list.isEmpty()) {
   //          	  System.out.println("index=="+i++);
   //              // 删除队首元素
   //              curNode = list.remove();
   //              // 输出队首元素的值
   //              System.out.print(curNode.value + " ");
   //              // 如果左子结点不为空，则左子结点入队
   //              if (curNode.left != null) {
   //                  list.add(curNode.left);
   //              }
   //              // 如果右子结点不为空，则左子结点入队
   //              if (curNode.right != null) {
   //                  list.add(curNode.right);
   //              }
   //          }
   //      }

        Queue<TreeNode> list = new LinkedList();
        list.add(root);

        TreeNode  curNode;
        while(!list.isEmpty()){
        	curNode = list.remove();
        	System.out.print(curNode.value+" ");
        	if(curNode.left!=null){
        		list.add(curNode.left);
        	}

        	if(curNode.right!=null){
        		list.add(curNode.right);
        	}
        }
		
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