package LRUCache;

import java.util.HashMap;

/**
 * Created by wangning on 2017/8/2.
 */
public class LRUCache {
    class Node{
        int key;
        int value;
        Node next;
        Node pre;
        public Node(int k, int v) {
            this.key = k;
            this.value = v;
        }
    }
    private HashMap<Integer, Node> map;
    private int capacity;
    private Node head, tail;
    private int count;
    private void deleteNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;

    }
    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>(capacity);
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        head.pre = null;
        tail.next = null;
        count=0;
    }

    public int get(int key) {
        Node node = map.get(key);
        if(node==null){
            return -1;
        }else{
            deleteNode(node);
            addToHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if(node==null){
            node = new Node(key, value);
            map.put(key, node);
            if (count < capacity) {
                count++;
                addToHead(node);
            } else {
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
                addToHead(node);
            }
        }else{
            node.value = value;
            deleteNode(node);
            addToHead(node);
        }
    }
}
