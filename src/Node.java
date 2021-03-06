public class Node {
    private Object data;
    private Node nextNode;
    private Node prevNode;

    Node() {
        this.data = null;
        this.nextNode = null;
        this.prevNode = null;
    }

    Node(Object inData, Node inNextNode, Node inPrevNode) {
        this();
        this.data = inData;
        this.nextNode = inNextNode;
        this.prevNode = inPrevNode;
    }

    Node(Object inData) {
        this();
        this.data = inData;
        this.setNextNode(this); // set next pointer to itself
        this.setPrevNode(this); // set prev pointer too itself
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Node getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(Node prevNode) {
        this.prevNode = prevNode;
    }
}
