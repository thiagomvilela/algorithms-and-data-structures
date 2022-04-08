import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Stack<T> {

	private NodeStack<T> top;
	
	public void push(T data) {
		if (this.top == null) {
			this.top = new NodeStack<T>(data);
		} else {
			NodeStack<T> nextNode = this.top;
			this.top = new NodeStack<T>(data, nextNode);
		}
	}
	
	public T pop() {
		if (this.top == null) {
			throw new RuntimeException("The stack is empty");
		} else {
			NodeStack<T> top = this.top;
			this.top = this.top.getNext();
			return top.getData();
		}
	}
	
	public T peek() {
		if (this.top == null) {
			throw new RuntimeException("The stack is empty");
		} else {
			return this.top.getData();
		}
	}
	
	public boolean isEmpty(){
		return this.top == null;
	}
	
	public static void main(String[] args) {		
		Stack<Integer> stack = new Stack<Integer>(); 
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(8);
		stack.push(9);
		stack.push(10);
		
		System.out.println(stack.peek());
		
		System.out.println(stack.pop());
		
		System.out.println(stack.peek());
		
		
		
//		while(!stack.isEmpty()) {
//			System.out.println(stack.pop());
//		}
	}
	
}
