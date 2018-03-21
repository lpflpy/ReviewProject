package test.liuwangfang.com.reviewproject.datastructure; /**用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail 和deleteHead，分别完成在队列尾部插入结点和在队列头部删除结点的功能。
栈1用于存储元素，栈2用于弹出元素，负负得正。

说的通俗一点，现在把数据1、2、3分别入栈一，然后从栈一中出来（3、2、1），放到栈二中，那么，从栈二中出来的数据（1、2、3）就符合队列的规律了，即负负得正。

*/
import java.util.Stack;
class QueueTest{

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);

		System.out.println("queue=="+queue.getFiStack());
		queue.appendTail(6);
		System.out.println("queue=="+queue.getReStack());
		queue.deleteHead();
		System.out.println("queue=="+queue.getReStack());
	}
	

	static class MyQueue{

		private Stack fiStack;
		private Stack reStack;
		public MyQueue(){
			  fiStack = new Stack();
			  reStack = new Stack();
		}

		public void add(int value){
			fiStack.push(value);
			// while(!fiStack.empty()){
			// 	reStack.push(fiStack.peek());
			// }
		}

		public void appendTail(int value){
			fiStack.push(value);
			while(!fiStack.empty()){
				reStack.push(fiStack.pop());
			}
		}

		public void deleteHead(){
			reStack.pop();
		}	

		public Stack getReStack(){
			return reStack;
		}

		public Stack getFiStack(){
			return fiStack;
		}

	}
	/**
	标准答案
	*/

	public static class MList<T> {  
        // 插入栈，只用于插入的数据  
        private Stack<T> stack1 = new Stack<>();  
        // 弹出栈，只用于弹出数据  
        private Stack<T> stack2 = new Stack<>();  
  
        public MList() {  
        }  
          
        // 添加操作，成在队列尾部插入结点  
        public void appendTail(T t) {  
            stack1.add(t);  
        }  
  
        // 删除操作，在队列头部删除结点  
        public T deleteHead() {  
  
            // 先判断弹出栈是否为空，如果为空就将插入栈的所有数据弹出栈，  
            // 并且将弹出的数据压入弹出栈中  
            if (stack2.isEmpty()) {  
                while (!stack1.isEmpty()) {  
                    stack2.add(stack1.pop());  
                }  
            }  
  
            // 如果弹出栈中还没有数据就抛出异常  
            if (stack2.isEmpty()) {  
                throw new RuntimeException("No more element.");  
            }  
  
            // 返回弹出栈的栈顶元素，对应的就是队首元素。  
            return stack2.pop();  
        }  
    }  
}