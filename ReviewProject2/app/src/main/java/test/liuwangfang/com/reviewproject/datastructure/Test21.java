
package test.liuwangfang.com.reviewproject.datastructure;
// 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true。否则返回false。假设输入的数组的任意两个数字都互不相同。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Test21{
	public static void main(String[] args) {
		//二叉搜索树
		TreeNode node1 = new TreeNode(16,null,null);
		TreeNode node2 = new TreeNode(17,node1,null);
		TreeNode node3 = new TreeNode(15,null,node2);
		TreeNode node4 = new TreeNode(19,null,null);
		TreeNode node5 = new TreeNode(18,node3,node4);

		TreeNode node6 = new TreeNode(2,null,null);
		TreeNode node7 = new TreeNode(9,null,null);
		TreeNode node8 = new TreeNode(5,node6,node7);
		TreeNode node9 = new TreeNode(12,node8,node5);

		int[] array = {2,9,5,16,17,15,19,18,12};

		// isPostTranver(node9,array);
		// postOrderTraverse(node9);
		//   System.out.println();
		// preOrderTraverse(node9);
		//   System.out.println();
		// middleOrderTraverse(node9);

		isPostTranver(node9,array);

	}

	 static  List<Integer> list = new ArrayList<Integer>();

	  //输出后序遍历
	public static void postOrderTraverse(TreeNode node){
        if(node == null) return;
        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        // System.out.print(node.value + " ");
        list.add(node.value);
    }

    //输出前序遍历
    public static void preOrderTraverse(TreeNode node){
        if(node == null) return;
        System.out.print(node.value + " ");
         preOrderTraverse(node.left);
        preOrderTraverse(node.right);
       
    }
   	//输出中序遍历
     public static void middleOrderTraverse(TreeNode node){
        if(node == null) return;
        middleOrderTraverse(node.left);
        System.out.print(node.value + " ");
        middleOrderTraverse(node.right);   
    }

	public static boolean isPostTranver(TreeNode node,int[] array){
		postOrderTraverse(node);

 		Integer[] intArray = new Integer[list.size()];
	
		System.out.println("postArray=="+Arrays.toString( (Integer[])list.toArray(intArray)));
		boolean isequal = isEqual((Integer[])list.toArray(intArray),array);
		System.out.println("isequal=="+isequal);
		return isequal;
	}


	//自己写的非递归的后序遍历－－－未完成 绕进去了
	// public static Integer[]  getPostTranver(TreeNode root){
	// 	// 先访问根节点，如果有左孩子，进入第二步；如果有右孩子，进入第三步
	// 	// 对左孩子继续判断其是否有左孩子，直到某节点的左孩子为空，设为cur节点
	// 	// 对右孩子继续判其是否有左孩子，直到某个节点的左孩子为空，设为curR节点
	// 	// cur节点访问之后，访问其双亲节点的右孩子，如果其双亲节点的右孩子不为空的话。接着访问cur节点的双亲节点，设为curP节点。
	// 	// cur节点的双亲节点访问结束之后，继续访问curP节点的右孩子（如果不为空的话），接着访问curP节点本身
	// 	// 重复以上过程直到根节点
	// 	// 继续访问根节点的右孩子，回到第三步，访问curR节点之后，访问其双亲节点的右孩子（如果有的话）
	// 	// 最后访问curR的双亲节点本身
	// 	// 重复以上过程直到访问根节点，访问结束

	// 	TreeNode left = root.left;
	// 	TreeNode right = root.right;

	// 	TreeNode curL;
	// 	TreeNode curR;

	// 	Stack<TreeNode> stack1 = new Stack<TreeNode> ();
	// 	Stack<TreeNode>  stack2 = new Stack<TreeNode> ();
	// 	List list1 = new ArrayList();


	// 	if(left!=null){
	// 		while(left.left!=null){
	// 			stack1.push(left);
	// 			left = left.left;
	// 		}
	// 		curL = left;

	// 		stack1.push(left);
			
	// 		while(!stack1.isEmpty()){
	// 			TreeNode node = stack1.pop();
	// 			if(node.right!=null){
	// 				list1.add(node.right.value);
	// 			}
	// 			list1.add(node.value);
	// 		}
	// 	}


	// 	if(right!=null){
	// 		while(right.left!=null){
	// 			stack2.push(right);
	// 			right = right.left;
	// 		}
	// 		curR = right;
	// 		stack2.push(right);

	// 		while(!stack2.isEmpty()){
	// 			TreeNode node = stack2.pop();
	// 			if(node.right!=null){
	// 				list1.add(node.right.value);
	// 			}
	// 			list1.add(node.value);
	// 		}
	// 	}
		
	// 	list1.add(root.value);

	// 	 Integer[] intArray = new Integer[list1.size()];
	// 	return (Integer[])list1.toArray(intArray);

	// }
 
	public static boolean isEqual(Integer[] array1,int[] array2){
	
		if(array1 == null && array2 == null){
			return true;
		}else if(array1 == null){
			return false;
		}else if(array2 == null){
			return false;
		}

		if(array1.length != array2.length){
			return false;
		}
		int i = array2.length-1;

		while(i>=0){
			if(array2[i]!=array1[i]){
				return false;
			}
			i--;
		}

		return true;
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