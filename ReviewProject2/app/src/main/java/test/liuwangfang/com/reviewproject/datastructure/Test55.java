package test.liuwangfang.com.reviewproject.datastructure;
// 在一个排序的链表中，如何删除重复的结点？

// 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5

public class Test55{
	public static void main(String[] args) {
	
		Node node8 = new Node(5,null);
		Node node7 = new Node(4,node8);
		Node node6 = new Node(4,node7);
		Node node5 = new Node(4,node6);
		Node node4 = new Node(3,node5);
		Node node3 = new Node(3,node4);
		Node node2 = new Node(2,node3);
		Node node1 = new Node(1,node2);
		Node head = new Node(-1,node1);

		delDuplicate(head);
		while(head.nextNode!=null){
			System.out.println(head.nextNode.value);
			head = head.nextNode;
		}
	}

	public static void delDuplicate(Node head){
		while(head.nextNode!=null){
			if(head.nextNode.value == head.value){
				head.nextNode = head.nextNode.nextNode;
			}else{
				head = head.nextNode;
			}
			
		}
	}

	static class Node{
		int value;
		Node nextNode;

		public Node(int value,Node next){
			this.value = value;
			nextNode = next;
		}
	}
}