package FirstWeek;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Node1 {
    int value;
    Node1 left;
    Node1 right;

    public Node1(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class NodeManager1 {
    public String serialize(Node1 head) {
        if (head == null) return "null,";
        return head.value + "," + serialize(head.left) + serialize(head.right);
    }

    public Node1 deserialize(String s) {
        Queue<String> nodes = new LinkedList<>(Arrays.asList(s.split(",")));
        return buildTree(nodes);
    }

    private Node1 buildTree(Queue<String> nodes) {
        String value = nodes.poll();
        if (value.equals("null")) return null;
        Node1 node = new Node1(Integer.parseInt(value));
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);
        return node;
    }
}

public class Eighth {
    public static void main(String[] args) {
        NodeManager1 nm = new NodeManager1();
        Node1 root = new Node1(1);
        root.left = new Node1(2);
        root.right = new Node1(3);
        root.left.left = new Node1(4);
        root.left.right = new Node1(5);
        root.right.left = new Node1(6);
        root.right.right = new Node1(7);
        String serialized = nm.serialize(root);
        System.out.println("Serialized: " + serialized);
        Node1 deserializedRoot = nm.deserialize(serialized);
        System.out.println("Deserialization successful!");
    }
}
