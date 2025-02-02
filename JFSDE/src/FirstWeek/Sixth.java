package FirstWeek;


class Node{
	int value;
	Node next;
	public Node(int value) {
		this.value = value;
		this.next=null;
	}
	
}
class NodeManager{
	public boolean hasCycle(Node head) {
		Node fast=head;
		Node slow=head;
		while(fast!=null && fast.next!=null) {
			fast=fast.next.next;
			slow=slow.next;
			if(fast==slow) return true;
		}
		return false;
	}
}
public class Sixth {
	public static void main(String[] args) {
    Node head = new Node(1);
    head.next = new Node(3);
    head.next.next = new Node(4);
    head.next.next.next = head.next;
    NodeManager n=new NodeManager();
    System.out.println(n.hasCycle(head));
}}
