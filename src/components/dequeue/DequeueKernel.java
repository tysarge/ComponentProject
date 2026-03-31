package components.dequeue;

import components.standard.Standard;

/**
 * Dequeue Kernel Interface.
 *
 * @param <T>
 *            type of elements in dequeue
 * @author Ethan Sargeant
 */
public interface DequeueKernel<T> extends Standard<Dequeue<T>> {

    /**
     * Adds {@code x} to the front of the dequeue.
     *
     * @param x
     *            the element to add
     * @requires x is not null
     * @ensures this = <x> * #this
     */
    void addFront(T x);

    /**
     * Removes and returns the first element in the dequeue.
     *
     * @return the element removed from the front
     * @requires length() > 0
     * @ensures #this = <removeFront> * this
     */
    T removeFront();

    /**
     * Adds {@code x} to the back of the dequeue.
     *
     * @param x
     *            the element to add
     * @requires x is not null
     * @ensures this = #this * <x>
     */
    void addBack(T x);

    /**
     * Removes and returns the element at the end of the dequeue.
     *
     * @return the element removed from the back
     * @requires length() > 0
     * @ensures #this = this * <removeBack>
     */
    T removeBack();

    /**
     * Returns the length of the dequeue.
     *
     * @return the length of this dequeue
     * @ensures length = |this|
     */
    int length();
}
