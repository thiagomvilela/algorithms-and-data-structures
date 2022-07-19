
public class Queue {

  private NodeQueue last;

  private NodeQueue first;

  private int size = 0;

  public void enqueue(String data){
    NodeQueue newNode = new NodeQueue(data);

    if (first == null && last == null){
      this.first = newNode;
    } else {
      this.last.setNext(newNode);
    }

    this.last = newNode;
    this.size++;
  }

  public void dequeue(){
    if (this.first != null || this.last != null){
      if (this.first != null){
        this.first = this.first.getNext();
        this.size--;
      } else {
        throw new RuntimeException("Empty Queue");
      }
    } else {
      throw new RuntimeException("Empty Queue");
    }
  }

  public String peek(){
    if (this.first != null || this.last != null) {
      if (this.first != null) {
        return this.first.getData();
      }
    }
    throw new RuntimeException("Empty Queue");
  }

  public int size(){
    return this.size;
  }

  public boolean isEmpty(){
    return this.first == null;
  }

  public static void main(String[] args) {
    Queue queue = new Queue();

    queue.enqueue("1");
    queue.enqueue("2");
    queue.enqueue("3");
    queue.enqueue("4");
    queue.enqueue("5");
    queue.enqueue("6");
    queue.enqueue("7");
    queue.enqueue("8");
    queue.enqueue("9");
    queue.enqueue("10");

    queue.dequeue();
    queue.dequeue();
    queue.dequeue();

    System.out.println("Size: " + queue.size());
    System.out.println("First: " + queue.peek());
    System.out.println("IsEmpty: " + queue.isEmpty());
  }

}
