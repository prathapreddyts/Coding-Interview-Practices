package linkedlists.revisitMedium.hardFAQ;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private final int capacity;
    private final Map<Integer, DoubleLinkedNode> cache;
    private final DoubleLinkedNode head;
    private final DoubleLinkedNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        // Dummy DoubleLinkedNodes
        head = new DoubleLinkedNode(-1, -1);
        tail = new DoubleLinkedNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        DoubleLinkedNode DoubleLinkedNode = cache.get(key);
        // Move DoubleLinkedNode to front
        deleteDoubleLinkedNode(DoubleLinkedNode);
        insertAfterHead(DoubleLinkedNode);
        return DoubleLinkedNode.value;
    }

    public void put(int key, int value) {
        // Key already exists
        if (cache.containsKey(key)) {
            DoubleLinkedNode existingDoubleLinkedNode = cache.get(key);
            existingDoubleLinkedNode.value = value;
            deleteDoubleLinkedNode(existingDoubleLinkedNode);
            insertAfterHead(existingDoubleLinkedNode);
            return;
        }
        // Create new DoubleLinkedNode
        DoubleLinkedNode newDoubleLinkedNode = new DoubleLinkedNode(key, value);
        // Capacity exceeded
        if (cache.size() == capacity) {
            DoubleLinkedNode leastRecentlyUsed = tail.prev;
            deleteDoubleLinkedNode(leastRecentlyUsed);
            cache.remove(leastRecentlyUsed.key);
        }
        insertAfterHead(newDoubleLinkedNode);
        cache.put(key, newDoubleLinkedNode);
    }

    private void insertAfterHead(DoubleLinkedNode currentNode) {
        DoubleLinkedNode nextNode = head.next;
        head.next = currentNode;
        currentNode.prev = head;
        currentNode.next = nextNode;
        nextNode.prev = currentNode;
    }

    private void deleteDoubleLinkedNode(DoubleLinkedNode currentNode) {
        DoubleLinkedNode nextNode = currentNode.next;
        DoubleLinkedNode previousNode = currentNode.prev;
        previousNode.next = nextNode;
        nextNode.prev = previousNode;
    }
}



