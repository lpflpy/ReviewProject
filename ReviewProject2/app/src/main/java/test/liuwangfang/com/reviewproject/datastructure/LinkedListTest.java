package test.liuwangfang.com.reviewproject.datastructure;

import java.util.Stack;

/**
 * 输入个链表的头结点，从尾到头反过来打印出每个结点的值。
 */
class LinkedListTest {
    public static void main(String[] args) {
        Node node = new Node(0, null);


    }

    public void printLinkedList(Node head) {
        Stack<Node> stack = new Stack();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop().value);
        }
    }

    static class Node {
        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}