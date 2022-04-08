public class DoublyLinkedList<T> {

	NodeLinkedList<T> head;
	NodeLinkedList<T> tail;
	int size;
	
	public void add(T data){
		NodeLinkedList<T> newNode = new NodeLinkedList<T>(data);
		
		if(head == null && tail == null) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			this.tail.setNext(newNode);
			newNode.setPrevious(this.tail);
			this.tail = newNode;
		}
		
		this.size++;
	}
	
	public T get(int position) {
		
		if (position > this.size/2) {
			NodeLinkedList<T> foundNode = null;
			int i = this.size - 1;
			
			for (NodeLinkedList<T> currentNode = this.tail; 
					currentNode != null; 
					currentNode = currentNode.getPrevious()) {
				
				if (i == position) {
					foundNode = currentNode;
					break;
				}
				
				i--;
			}
			
			return foundNode == null ? null : foundNode.getData();
		} else {
			NodeLinkedList<T> foundNode = null;
			int i = 0;
			
			for (NodeLinkedList<T> currentNode = this.head; 
					currentNode != null; 
					currentNode = currentNode.getNext()) {
				
				if (i == position) {
					foundNode = currentNode;
					break;
				}
				
				i++;
			}
			
			return foundNode == null ? null : foundNode.getData();
		}
	}
	
//	public void remove(int position) {
//		if (position == 0) {
//			this.head = this.head.next;
//			this.size--;
//		} else {
//			NodeLinkedList previousNode = this.head;
//			
//			for (int i = 1; i < size; i++) {
//				NodeLinkedList currentNode = previousNode.next;
//				if (i == position) {
//					previousNode.next = currentNode.next;
//					this.size--;
//					break;
//				}
//				previousNode = previousNode.next;
//			}
//		}
//	}
	
	public static void main(String[] args) {
		// ======== LISTA DUPLAMENTE LIGADA
		DoublyLinkedList<Integer> doublyList = new DoublyLinkedList<Integer>();
		for (int i = 0; i < 100000000; i++) {
			doublyList.add(i);
		}
		
		long startDoubly = System.currentTimeMillis();
		doublyList.get(99999999);
		long endDoubly = System.currentTimeMillis();
		
		System.out.println(endDoubly - startDoubly);
		
		
		// ======== LISTA SIMPLES
		LinkedList singlyList = new LinkedList();
		for (int i = 0; i < 10000000; i++) {
			singlyList.add(String.valueOf(i));
		}
		
		long startSingly = System.currentTimeMillis();
		singlyList.get(9999999);
		long endSingly = System.currentTimeMillis();
		
		System.out.println(endSingly - startSingly);
		
		
//		for (int i = 0; i < lista.size; i++) {
//			System.out.println(lista.get(i));
//		}
		
//		lista.remove(0);
		
//		for (int i = 0; i < lista.size; i++) {
//			System.out.println(lista.get(i));
//		}
	}
	
}
