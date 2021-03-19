/**
 * FileName: MyPolygons.java
 * Assessment: SENG2200 - A1
 * Author: Yosiah de Koeyer
 * Student No: c3329520
 * <p>
 * Description:
 * MyPolygons class that implements a Circular Linked List (CLL) as its underlying data structure. Stores and sorts
 * instances of the Polygon class
 */

public class MyPolygons {
    private final Node sentinel;                                // Sentinel node for start/end of CLL (cannot be changed)
    private Node current;                                       // Current node pointer
    private int size;                                           // size of CLL (Excluding sentinel)

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
     *
     * @return a String representation of the MyPolygons instance
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        this.reset();                                           // Reset current back to start
        for (int i = 0; i < this.size; i++) {                   // Loop through whole CLL
            str.append(current.getData());                      // Append str rep of data
            str.append("\n");
            next();
        }
        return str.toString();
    }


    /**
     * insertInOrder() method
     *
     * @param inData data to be inserted (in order) into the CLL
     */
    public void insertInOrder(Polygon inData) {
        this.reset();                                           // Reset current back to start
        if (this.size == 0) {                                   // Special case if CLL empty
            prepend(inData);
            return;
        }
        for (int i = 0; i < this.size; i++) {                   // Loop through whole CLL
            if (!inData.ComesBefore(this.current.getData())) {  // If it doesnt come before
                this.next();                                    // Go to next node
            } else {
                this.insert(inData);                            // Insert at current
                return;
            }
        }
        this.insert(inData);                                    // At end
    }

    /**
     * append() method
     *
     * @param inData data to add too the end of the CLL
     */
    public void append(Polygon inData) {
        this.add(inData, this.sentinel);
    }

    /**
     * prepend() method
     *
     * @param inData data to add to the start of the CLL
     */
    public void prepend(Polygon inData) {
        this.add(inData, this.sentinel.getNextNode());
    }

    /**
     * insert() method
     *
     * @param inData data to be inserted at the current index of the CLL
     */
    public void insert(Polygon inData) {
        this.add(inData, this.current);
    }

    /**
     * add() method
     *
     * @param inData data to be inserted at the index of the given node
     * @param n      the node to determine where to insert the data (at this nodes index)
     */
    private void add(Polygon inData, Node n) {
        Node temp = new Node(inData);                           // Create new node
        temp.setNextNode(n);                                    // Set new nodes next
        temp.setPrevNode(n.getPrevNode());                      // set new nodes prev
        n.getPrevNode().setNextNode(temp);                      // set left nodes next to new node
        n.setPrevNode(temp);                                    // set right nodes prev to new node
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
     *
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
     *
     * @return the data stored in the node at the start of the CLL
     */
    public Polygon take() { // TODO: ???
        reset();
        Polygon p = this.current.getData();
        remove();
        return p;
    }

    /**
     * remove() method
     * removes the data at the current
     */
    public void remove() {
        this.current.getNextNode().setPrevNode(this.current.getPrevNode());
        this.current.getPrevNode().setNextNode(this.current.getNextNode());
        this.current.setNextNode(null);
        this.current.setPrevNode(null);
        reset();
    }

    /**
     * getSize() method
     * @return the size of the CLL
     */
    public int getSize() {
        return size;
    }
}
