
public class NodeLinkedList<T> {

	private T data;
	private NodeLinkedList next;
	private NodeLinkedList previous;
	
	public NodeLinkedList(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public NodeLinkedList<T> getNext() {
		return next;
	}

	public void setNext(NodeLinkedList<T> next) {
		this.next = next;
	}

	public NodeLinkedList<T> getPrevious() {
		return previous;
	}

	public void setPrevious(NodeLinkedList<T> previous) {
		this.previous = previous;
	}
	
}