public class Node {
    private Object data;
    private Node nextNode;
    private Node prevNode;

    Node(Object inData, Node inNextNode, Node inPrevNode) {
        this.data = inData;
        this.nextNode = inNextNode;
        this.prevNode = inPrevNode;
    }

    Node(Object inData) {
        this(inData, null, null);
    }

    Node(Object inData, Node inNextNode) {
        this(inData, inNextNode, null);
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
