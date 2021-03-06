import java.util.ArrayList;

//TODO: test this class
public class MyPolygons {
    private final Node sentinal;
    private Node current;
    private int size;

    MyPolygons() {
        this.sentinal = new Node(null);
        this.current = this.sentinal;
        this.size = 0;
    }

    MyPolygons(ArrayList<Polygon> inData) {
        this();
        if (inData != null) { // check yo
            for (Polygon p : inData) {
                this.append(p);
            }
        }
    }

    public void append(Object inData) { // too the end
        this.add(inData, this.sentinal);
    }

    public void prepend(Object inData) { // too the start
        this.add(inData, this.sentinal.getNextNode());
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
        this.current = this.sentinal.getNextNode();
    }

    public Object take() { // TODO: ???
        return new Object();
    }
}
