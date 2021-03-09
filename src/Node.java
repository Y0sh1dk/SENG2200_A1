public class Node {
    private Polygon data;
    private Node nextNode;
    private Node prevNode;

    Node() {
        this.data = null;
        this.nextNode = null;
        this.prevNode = null;
    }

    Node(Polygon inData, Node inNextNode, Node inPrevNode) {
        this();
        this.data = inData;
        this.nextNode = inNextNode;
        this.prevNode = inPrevNode;
    }

    Node(Polygon inData) {
        this();
        this.data = inData;
        this.setNextNode(this); // set next pointer to itself
        this.setPrevNode(this); // set prev pointer too itself
    }

    public Polygon getData() {
        return data;
    }

    public void setData(Polygon inData) {
        if (inData != null) { // or else it will become a Sentinal, BAD!
            this.data = inData;
        }
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
