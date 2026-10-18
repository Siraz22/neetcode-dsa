/*
"But how could you live and have no story to tell?"
- White Nights, Fyodor Dostoevsky
*/

class ListNode {
    int key;
    int value;
    ListNode prev;
    ListNode next;

    ListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    private final Map<Integer, ListNode> map;
    private final ListNode dummyHead;
    private final ListNode dummyTail;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        dummyHead = new ListNode(-1, -1);
        dummyTail = new ListNode(-1, -1);

        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    // Remove a node from wherever it currently is.
    private void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Insert a node immediately after dummyHead.
    private void addToFront(ListNode node) {
        node.next = dummyHead.next;
        node.prev = dummyHead;

        dummyHead.next.prev = node;
        dummyHead.next = node;
    }

    // Make an existing node the most recently used.
    private void moveToFront(ListNode node) {
        remove(node);
        addToFront(node);
    }

    public int get(int key) {
        ListNode node = map.get(key);

        if (node == null) {
            return -1;
        }

        moveToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            node.value = value;

            moveToFront(node);
            return;
        }

        ListNode node = new ListNode(key, value);

        map.put(key, node);
        addToFront(node);

        if (map.size() > capacity) {
            ListNode lru = dummyTail.prev;

            remove(lru);
            map.remove(lru.key);
        }
    }
}