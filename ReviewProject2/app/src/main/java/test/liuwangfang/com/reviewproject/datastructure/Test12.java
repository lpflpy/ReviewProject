package test.liuwangfang.com.reviewproject.datastructure;

/**
输入一个链表，输出该链表中倒数第k 个结点。为了符合大多数人的习惯，本题从1 开始计数，即链表的尾结点是倒数第1 个结点．例如一个链表有6 个结点，从头结点开始它们的值依次是1 、2、3、4、5 、6。这个个链表的倒数第3 个结点是值为4 的结点。
*/

class Test12{
	public static void main(String[] args) {
	
	}

	public static int printLastKNode(Node head,int size,int k){
		int count = 0;
		while(head.next!=null){
			head = head.next;
			count++;
			if(count == size-k+1){
				break;
			}
		}
		return head.value;
	}


	//标准答案  不知道size的情况下
	public static int printLastKNode2(Node head,int k){
		//倒数k位到尾节点的距离为k-1;
		//头部先移动看k-1位，该节点和头节点同时移动，当该节点到达尾节点时，头节点刚好到达k-1位；

		// 为了实现只遍历链表一次就能找到倒数第k 个结点，我们可以定义两个指针。第一个指针从链表的头指针开始遍历向前走k-1步，第二个指针保持不动；从第k 步开始，第二个指针也开始从链表的头指针开始遍历。由于两个指针的距离保持在k-1 ， 当第一个（走在前面的）指针到达链表的尾结点时，第二个指针（走在后面的）指针正好是倒数第k 个结点。

		Node pointer = head;
		int i = 0;
		while(i<k && pointer.next!=null){
			if(pointer.next!=null){
				pointer = pointer.next;
			}else{
				return 0;
			}
		}

		while(pointer.next!=null){
			head = head.next;
			pointer = pointer.next;
		}
		return head.value;
	}

	static class Node{
		int value;
		Node next;
	}
}