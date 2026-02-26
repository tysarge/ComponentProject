package components.dequeue;

import components.sequence.Sequence;
import components.sequence.Sequence1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * @author Ethan Sargeant
 */
public class DequeueOnSequenceMVP<T> {

    /**
     * Rep of this
     */
    private Sequence<T> rep;

    private void createNewRep() {
        this.rep = new Sequence1L<>();
    }

    public DequeueOnSequenceMVP() {
        this.createNewRep();

    }

    public void addFront(T x) {
        assert x != null : "Violation of x is not null";
        this.rep.add(0, x);
    }

    public T removeFront() {
        assert this.length() > 0 : "Violation of length > 0";
        return this.rep.remove(0);
    }

    public int length() {
        return this.rep.length();
    }

    public void addBack(T x) {
        assert x != null : "Violation of x is not null";
        this.rep.add(this.rep.length(), x);

    }

    public T removeBack() {
        assert this.length() > 0 : "Violation of length > 0";
        return this.rep.remove(this.rep.length() - 1);
    }

    public void clear() {
        this.createNewRep();
    }

    public boolean contains(T x) {
        int size = this.length();
        boolean result = false;

        for (int i = 0; i < size; i++) {
            T temp = this.removeFront();
            result = result || temp.equals(x);
            this.addBack(temp);
        }
        return result;
    }

    public T replaceFront(T x) {
        T result = this.removeFront();
        this.addFront(x);
        return result;
    }

    public T replaceBack(T x) {
        T result = this.removeBack();
        this.addBack(x);
        return result;
    }

    /*
     * splits from start to index exclusive. first part in this second part
     * returned
     */
    public DequeueOnSequenceMVP<T> split(int index) {
        int size = this.length();

        DequeueOnSequenceMVP<T> temp = new DequeueOnSequenceMVP<>();

        for (int i = 0; i < size - index; i++) {
            temp.addFront(this.removeBack());
        }

        return temp;
    }

    public void combine(DequeueOnSequenceMVP<T> temp) {
        int size = temp.length();

        for (int i = 0; i < size; i++) {
            this.addBack(temp.removeFront());
        }
    }

    @Override
    public String toString() {
        return this.rep.toString();
    }

    public static void main(String[] args) {

        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        /*
         * Scenario: The dequeue train represents a train with traincars
         * attached each traincar is an element in the dequeue and an empty
         * dequeue represents no train. You can't remove a traincar from the
         * middle without removing it and adding back the ones after it.
         *
         * Lets say element 0 represents the head of the train and
         * element(|train| - 1) is the back.
         */
        DequeueOnSequenceMVP<Integer> train = new DequeueOnSequenceMVP<>();

        /*
         * Train with 9 cars
         */
        for (int i = 0; i < 10; i++) {
            train.addBack(i);
        }
        /*
         * Print initial tarin
         */
        out.println(train);

        out.println();
        out.println();
        /**
         * Check if the train has a certain car an ensures it was restored
         */
        out.println(train.contains(9));
        out.println(train);

        out.println();
        out.println();

        /*
         * To remove the train car at index 4
         */
        DequeueOnSequenceMVP<Integer> splitTest = train.split(4);

        out.println(train);
        out.println(splitTest);

        int removed = splitTest.removeFront();

        train.combine(splitTest);

        out.println(train);
        out.println(splitTest);
        out.println(removed);

        out.println();
        out.println();

    }

}
