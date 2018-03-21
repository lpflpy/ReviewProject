package test.liuwangfang.com.reviewproject.datastructure;

// 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。

//不是很明白

public class Test13{
	public static void main(String[] args) {
		
	}

// 	①遍历。将指向下一个节点的指针指向上一个节点。

// ②递归。先让指向下一个节点的指针为空，然后递归调用，最后再将指向下一个节点的指针指向上一个节点。

	public Node reverseLinkList(Node head){
		if(head ==null){
			return null;
		}
		
		Node pre = head;
		Node current = head.next;
		Node next = null;
		while(current!=null){
			next = current.next;
			
			current.next = pre;
			pre = current;
			current = next;
		}
		head.next = null;
		head = pre;
		return head;

	}
	static class Node{
		int value;
		Node next;
	}
}