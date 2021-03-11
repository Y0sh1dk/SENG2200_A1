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

    /**
     * MyPolygons class constructor when no arguments are given
     */
    MyPolygons() {
        this.sentinel = new Node(null);
        this.current = this.sentinel;
        this.size = 0;
    }

    /**
     * Overridden toString() method
     * @return a String representation of the MyPolygons instance
     */
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


    /**
     * insertInOrder() method
     * @param inData data to be inserted (in order) into the CLL
     */
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

    /**
     * append() method
     * @param inData data to add too the end of the CLL
     */
    public void append(Polygon inData) {
        this.add(inData, this.sentinel);
    }

    /**
     * prepend() method
     * @param inData data to add to the start of the CLL
     */
    public void prepend(Polygon inData) {
        this.add(inData, this.sentinel.getNextNode());
    }

    /**
     * insert() method
     * @param inData data to be inserted at the current index of the CLL
     */
    public void insert(Polygon inData) {
        this.add(inData, this.current);
    }

    /**
     * add() method
     * @param inData data to be inserted at the index of the given node
     * @param n the node to determine where to insert the data (at this nodes index)
     */
    private void add(Polygon inData, Node n) {
        Node temp = new Node(inData);
        temp.setNextNode(n);
        temp.setPrevNode(n.getPrevNode());
        n.getPrevNode().setNextNode(temp);
        n.setPrevNode(temp);
        this.size++;
    }

    /**
     * next() method
     * Moves the current pointer forward one
     */
    public void next() {
        this.current = this.current.getNextNode();
    }

    /**
     * previous() method
     * Moves the current pointer backwards one
     */
    public void previous() {
        this.current = this.current.getPrevNode();
    }

    /**
     * getCurrent() method
     * @return the Polygon object stored in the current node
     */
    public Polygon getCurrent() {
        return this.current.getData();
    }

    /**
     * reset() method
     * Resets the current pointer to the start of the CLL
     */
    public void reset() {
        this.current = this.sentinel.getNextNode();
    }

    /**
     * resetEnd() method
     * Resets the current pointer to the end of the CLL
     */
    public void resetEnd() {
        this.current = this.sentinel.getPrevNode();
    }

    /**
     * take() method
     * @return the data stored in the node at the start of the CLL
     */
    public Polygon take() { // TODO: ???
        return new Polygon();
    }
}
