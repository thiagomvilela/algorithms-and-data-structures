
public class NodeDoublyLinkedList<T> {

	private T data;
	private NodeDoublyLinkedList<T> next;
	private NodeDoublyLinkedList<T> previous;
	
	public NodeDoublyLinkedList(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public NodeDoublyLinkedList<T> getNext() {
		return next;
	}

	public void setNext(NodeDoublyLinkedList<T> next) {
		this.next = next;
	}

	public NodeDoublyLinkedList<T> getPrevious() {
		return previous;
	}

	public void setPrevious(NodeDoublyLinkedList<T> previous) {
		this.previous = previous;
	}
	
}