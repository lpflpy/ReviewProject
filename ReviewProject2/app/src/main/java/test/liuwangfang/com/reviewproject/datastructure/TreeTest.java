package test.liuwangfang.com.reviewproject.datastructure;
/**
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如：前序遍历序列｛ 1, 2, 4, 7, 3, 5, 6, 8｝和中序遍历序列｛4, 7, 2, 1, 5, 3, 8，6}，重建二叉树并输出它的头结点。
*/

import java.util.Arrays;
class TreeTest{
	public static void main(String[] args) {
		int[] preTree={1, 2, 4, 7, 3, 5, 6, 8};
		int[] middleTree = {4, 7, 2, 1, 5, 3, 8,6};
		getTreeRoot(preTree,middleTree);
	}

	public static TreeNode getTreeRoot(int[] preTree,int[] middleTree){
		if(preTree.length==0){
			return null;
		}
		TreeNode root = new TreeNode(preTree[0]);
		System.out.print("root="+root.value+"  ");
		if(preTree.length==1){
			root.leftNode = null;
			root.rightNode = null;	
			return root;
		}
		//找到根节点在中序遍历中的位置
		int rootIndex = 0;
		// for(int i = 0;i<middleTree.length;i++){
		// 	if(middleTree[i] ==root.value){
		// 		rootIndex =  i;
		// 		break;
		// 	}
		// }

		while(middleTree[rootIndex]!=root.value && rootIndex!= middleTree.length-1){
				rootIndex++;
		}


		int[] leftPreTree =  Arrays.copyOfRange(preTree,1,rootIndex+1);
		int[] leftMiddleTree =  Arrays.copyOfRange(middleTree,0,rootIndex);
	

		int[] rightPreTree = Arrays.copyOfRange(preTree,rootIndex+1,preTree.length);
		int[] rightMiddleTree = Arrays.copyOfRange(middleTree,rootIndex+1,middleTree.length);

		root.leftNode =getTreeRoot(leftPreTree,leftMiddleTree);
		root.rightNode =getTreeRoot(rightPreTree,rightMiddleTree);

		System.out.print("left="+(root!=null && root.leftNode!=null ? root.leftNode.value+"  ":"  " ));
		System.out.print("right="+(root!=null && root.rightNode!=null ?root.rightNode.value+"  ":"  "));
	

		return root;
	}

/**
二叉树节点 BinaryTreeNode
*/
	static class TreeNode{
		int value;
		TreeNode leftNode;
		TreeNode rightNode;

		TreeNode(int value){
			this.value = value;
		}
	}



}