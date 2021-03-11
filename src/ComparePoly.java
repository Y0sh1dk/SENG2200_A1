/**
 * FileName: ComparePoly.java
 * Assessment: SENG2200 - A1
 * Author: Yosiah de Koeyer
 * Student No: c3329520
 * <p>
 * Description:
 * ComparePoly interface
 */

public interface ComparePoly {
    /**
     * ComesBefore() method
     *
     * @param o Object to compare to the current object
     * @return a boolean that determines if the current object comes before the parsed object or not
     */
    boolean ComesBefore(Object o);  // true if this < param
}
