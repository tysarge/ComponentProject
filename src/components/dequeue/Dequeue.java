package components;

import components.dequeue.DequeueKernel;

/**
 * Secondary Methods for Dequeue.
 *
 * @param <T>
 *            type of elements in the dequeue.
 * @author Ethan Sargeant
 *
 */
public interface Dequeue<T> extends DequeueKernel<T> {
    /**
     * Returns whether {@code x} is in this dequeue.
     *
     * @param x
     *            the element to search for
     *
     * @return true if x is in this dequeue, false otherwise
     * @ensures contains = (x is in this)
     */
    boolean contains(T x);

    /**
     * Replaces the front element of the dequeue with {@code x} and returns the
     * old front element.
     *
     * @param x
     *            the element to place at the front
     * @return the previous front element
     * @requires length() > 0
     * @ensures replaceFront = #front and front = x
     */
    T replaceFront(T x);

    /**
     * Replaces the back element of this dequeue with {@code x} and returns the
     * old back element.
     *
     * @param x
     *            the element to place at the back
     * @return the previous back element
     * @requires length() > 0
     * @ensures replaceBack = #back and back = x
     */
    T replaceBack(T x);
}
