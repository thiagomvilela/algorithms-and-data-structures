public class LinkedList {

	Node head;
	Node tail;
	int size;
	
	public void add(String data){
		Node newNode = new Node(data);
		
		if(head == null && tail == null) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			this.tail.next = newNode;
			this.tail = newNode;
		}
		
		this.size++;
	}
	
	public String get(int position) {
		Node foundNode = null;
		int i = 0;
		
		for (Node currentNode = this.head; 
				currentNode != null; 
				currentNode = currentNode.next) {
			
			if (i == position) {
				foundNode = currentNode;
				break;
			}
			
			i++;
		}
		
		return foundNode == null ? null : foundNode.data;
	}
	
	public void remove(int position) {
		if (position == 0) {
			this.head = this.head.next;
			this.size--;
		} else {
			Node previousNode = this.head;
			
			for (int i = 1; i < size; i++) {
				Node currentNode = previousNode.next;
				if (i == position) {
					previousNode.next = currentNode.next;
					this.size--;
					break;
				}
				previousNode = previousNode.next;
			}
		}
	}
	
	public static void main(String[] args) {
		LinkedList lista = new LinkedList();
		lista.add("1");
		lista.add("2");
		lista.add("3");
		lista.add("4");
		lista.add("5");
		
//		for (int i = 0; i < lista.size; i++) {
//			System.out.println(lista.get(i));
//		}
		
		lista.remove(0);
		
		for (int i = 0; i < lista.size; i++) {
			System.out.println(lista.get(i));
		}
	}
	
}
