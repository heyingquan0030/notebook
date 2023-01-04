
import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private class Node {
        private int k;
        private int v;
        private Node prev;
        private Node next;

        public Node() {
        }

        public Node(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }

    private int cap;
    private int size;
    private Map<Integer, Node> cache;
    private Node head;
    private Node tail;

    public LRUCache(int cap) {
        this.cap = cap;
        this.size = 0;
        this.cache = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int k) {
        Node node = cache.get(k);
        if (node == null) {
            return -1;
        }

        moveToHead(node);
        return node.v;
    }

    public void put(int k, int v) {
        Node node = cache.get(k);
        if (node != null) {
            node.v = v;
            moveToHead(node);
            return;
        }

        node = new Node(k, v);
        addToHead(node);
        cache.put(k, node);
        size++;

        if (size < cap) {
            return;
        }

        Node tail = removeTail();
        cache.remove(tail.k);
        size--;
    }

    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }

    private Node removeTail() {
        Node node = tail.prev;
        removeNode(node);
        return node;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }
}