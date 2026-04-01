/**
 * Secondary method implementations for Dequeue.
 *
 * @param <T>
 *            type of elements in dequeue
 * @author Ethan Sargeant
 */
public abstract class DequeueSecondary<T> implements Dequeue<T> {


    @Override
    public boolean contains(T x) {

        boolean found = false;
        int length = this.length();
        for (int i = 0; i < length; i++) {
            T front = this.removeFront();
            if (front.equals(x)) {
                found = true;
            }
            this.addBack(front);
        }
        return found;
    }

    @Override
    public T replaceFront(T x) {
        T old = this.removeFront();
        this.addFront(x);
        return old;
    }

    @Override
    public T replaceBack(T x) {
        T old = this.removeBack();
        this.addBack(x);
        return old;
    }
}