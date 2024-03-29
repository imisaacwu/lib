package lib;

// Linked List
public class LL<T> {
    public Node head, tail;
    private int size;

    public LL(Node head) {
        this.head = head;
        this.tail = head;
        this.size = 1;
    }
    public LL() {
        this(null);
        this.size = 0;
    }

    public void add(T value) {
        if(head == null) {
            head = new Node(value);
            tail = head;
        } else {
            tail.next = new Node(value);
            tail = tail.next;
        }
        size++;
    }

    public boolean contains(T value) {
        return contains(value, head);
    }
    private boolean contains(T value, Node node) {
        if(node == null) { return false; }
        if(node.value.equals(value)) {
            return true;
        }
        return contains(value, node.next);
    }

    @Override
    public String toString() {
        return head == null ? "" : head.toString();
    }

    @Override
    public int hashCode() {
        return head == null ? 0 : head.hashCode();
    }

    @Override
    public boolean equals(java.lang.Object other) {
        if(this == other) { return true; }
        if(!(other instanceof LL<?>)) { return false; }
        LL<?> o = (LL<?>)other;
        return this.head.equals(o.head);
    }

    public class Node {
        public T value;
        public Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
        public Node(T value) { this(value, null); }
        public Node(Node next) { this(null, next); }
        public Node() { this(null, null); }

        @Override
        public String toString() {
            return value.toString() + (next == null ? "" : ", " + next);
        }

        @Override
        public int hashCode() {
            return value.hashCode()*17 + (next == null ? 0 : next.hashCode()*31);
        }

        @Override
        public boolean equals(java.lang.Object other) {
            if(this == other) { return true; }
            if(!(other instanceof LL<?>.Node)) { return false; }
            LL<?>.Node o = (LL<?>.Node)other;
            return this.value.equals(o.value) && this.next.equals(o.next);
        }
    }
}