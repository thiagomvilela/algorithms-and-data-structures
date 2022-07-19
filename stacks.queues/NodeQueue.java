public class NodeQueue {

  private String data;

  private NodeQueue next;

  public NodeQueue(String data) {
    this.data = data;
  }

  public NodeQueue(String data, NodeQueue next) {
    this.data = data;
    this.next = next;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public NodeQueue getNext() {
    return next;
  }

  public void setNext(NodeQueue next) {
    this.next = next;
  }
}
