
public class MyPolygons {
    private final Node sentinel;
    private Node current;
    private int size;

    MyPolygons() {
        this.sentinel = new Node(null);
        this.current = this.sentinel;
        this.size = 0;
    }


    public String toString() {
        StringBuilder str = new StringBuilder();
        next();
        for (int i = 0; i < this.size; i++) {
            str.append((Polygon) current.getData());
            str.append("\n");
            next();
        }
        return str.toString();
    }

    public void insertInOrder(Object inData) {

    }

    public void append(Object inData) { // too the end
        this.add(inData, this.sentinel);
    }

    public void prepend(Object inData) { // too the start
        this.add(inData, this.sentinel.getNextNode());
    }

    public void insert(Object inData) { // insert AT current index
        this.add(inData, this.current);
    }

    private void add(Object inData, Node n) { // adds at the index of node n
        Node temp = new Node(inData);
        temp.setNextNode(n);
        temp.setPrevNode(n.getPrevNode());
        n.getPrevNode().setNextNode(temp);
        n.setPrevNode(temp);
        this.size++;
    }

    public void next() {
        this.current = this.current.getNextNode();
    }

    public void previous() {
        this.current = this.current.getPrevNode();
    }

    public Object getCurrent() {
        return this.current.getData();
    }

    public void reset() { // resets current to the start of the list
        this.current = this.sentinel.getNextNode();
    }

    public Object take() { // TODO: ???
        return new Object();
    }
}
