package test.liuwangfang.com.reviewproject.datastructure;

/**
给定单向链表的一个头指针和节点指针，定义一个函数在O(1)时间删除该节点。
*/
public class Test10{
	public static void main(String[] args) {
		
	}

	public static Node deleteNode(Node node,Node head){
		if(node ==null || head ==null){
			return head;
		}
		//要删除的节点有3种情况：头节点，尾节点，中间节点
		if(node ==head){
			return head.next;
		}
		if(node.next ==null){
			//尾节点
			Node temp = head;
			while(temp.next!=node){
				temp = temp.next;
			}

			temp.next =null;
		
		}else{
			Node nextNode = node.next;
			node.value = nextNode.value;
			node.next = nextNode.next;
		}
		return head;

	}

	static class Node{
		Node next;
		int value;
	}
}