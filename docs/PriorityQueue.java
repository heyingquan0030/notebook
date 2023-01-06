
import java.util.LinkedList;
import java.util.Queue;

public class PriorityQueue {
    private int[] pq;
    private int cap;
    private int size = 0;

    public MyPriorityQueue(int cap) {
        this.cap = cap;
        this.pq = new int[cap + 1];
    }

    public void push(int v) {
        size++;
        pq[size] = v;
        swim(size);
    }

    public int pop() {
        int max = max();
        exch(1, size);
        pq[size] = -1;
        size--;
        sink(1);
        return max;
    }

    private int parent(int i) {
        return i / 2;
    }

    private int left(int i) {
        return 2 * i;
    }

    private int right(int i) {
        return 2 * i + 1;
    }

    private void exch(int i, int j) {
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private boolean less(int i, int j) {
        return pq[i] < pq[j];
    }

    private int max() {
        return pq[1];
    }

    private void swim(int i) {
        while (i > 1 && less(parent(i), i)) {
            exch(parent(i), i);
            i = parent(i);
        }
    }

    private void sink(int i) {
        while (left(i) <= size) {
            int max = right(i) <= size && less(left(i), right(i)) ? right(i) : left(i);
            if (less(max, i)) break;
            exch(max, i);
            i = max;
        }
    }
}
