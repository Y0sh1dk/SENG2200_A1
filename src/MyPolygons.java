import java.util.ArrayList;

//TODO: test this class
public class MyPolygons {
    private Node current;
    private Node sentinal;
    private int size;

    MyPolygons() {
        this.sentinal = new Node(null);
        this.current = this.sentinal;
        this.size = 0;
    }

    MyPolygons(Object inData) {
        this();
        this.append(inData);
    }

    MyPolygons(ArrayList<Object> inData) {
        this();
        if (inData != null) { // check yo
            for (Object o : inData) {
                this.append(o);
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

    public void insert(Object inData) { // insert at current

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
        if (this.size == 0) {
            this.current = this.sentinal;
        } else {
            this.current = this.sentinal.getNextNode();
        }
    }

    public Object take() { // TODO: ???
        return new Object();
    }
}
