/**
 *  FileName: MyPolygons.java
 *  Assessment: SENG2200 - A1
 *  Author: Yosiah de Koeyer
 *  Student No: c3329520
 *
 *  Description:
 *  MyPolygons class that implements a Circular Linked List (CLL) as its underlying data structure. Stores and sorts
 *  instances of the Polygon class
 */

public class MyPolygons {
    private final Node sentinel;
    private Node current;
    private int size;

    MyPolygons() {
        this.sentinel = new Node(null);
        this.current = this.sentinel;
        this.size = 0;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        this.reset();
        for (int i = 0; i < this.size; i++) {
            str.append(current.getData());
            str.append("\n");
            next();
        }
        return str.toString();
    }


    public void insertInOrder(Polygon inData) {
        this.reset();
        if (this.size == 0) {
            prepend(inData);
            return;
        }
        for (int i = 0; i < this.size; i++) {
            if (!inData.ComesBefore(this.current.getData())) {
                this.next();
            } else {
                this.insert(inData);
                return;
            }
        }
        this.insert(inData);
    }

    public void append(Polygon inData) { // too the end
        this.add(inData, this.sentinel);
    }

    public void prepend(Polygon inData) { // too the start
        this.add(inData, this.sentinel.getNextNode());
    }

    public void insert(Polygon inData) { // insert AT current index
        this.add(inData, this.current);
    }

    private void add(Polygon inData, Node n) { // adds at the index of node n
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

    public void resetEnd() {
        this.current = this.sentinel.getPrevNode();
    }

    public Object take() { // TODO: ???
        return new Object();
    }
}
