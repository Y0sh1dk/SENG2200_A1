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

    public void prepend(Object inData) {
        if (this.size == 0) { // if CLL is empty
            Node temp = new Node(inData,this.sentinal, this.sentinal);
            this.sentinal.setPrevNode(temp);
            this.sentinal.setNextNode(temp);
        } else { // if not empty
            Node temp = new Node(inData);
            this.sentinal.getNextNode().setPrevNode(temp);
            temp.setPrevNode(this.sentinal);
            temp.setNextNode(this.sentinal.getNextNode());
            this.sentinal.setNextNode(temp);
        }
        this.size++;
    }

    public void append(Object inData) {
        if (this.size == 0) { // if CLL is empty
            Node temp = new Node(inData,this.sentinal, this.sentinal);
            this.sentinal.setPrevNode(temp);
            this.sentinal.setNextNode(temp);
        } else { // if not empty
            Node temp = new Node(inData);
            this.sentinal.getPrevNode().setNextNode(temp);
            temp.setPrevNode(this.sentinal.getPrevNode());
            temp.setNextNode(this.sentinal);
            this.sentinal.setPrevNode(temp);
        }
        this.size++;
    }

    public void insert(Object inData) { // insert AT current index
        Node temp = new Node(inData);
        temp.setNextNode(current.getNextNode());
        temp.setPrevNode(current.getPrevNode());
        current.getPrevNode().setNextNode(temp);
        current.setPrevNode(temp);
        current = temp;
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
