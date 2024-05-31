package after;
//3 3. Deleting a Node After a Given Node in a Singly Linked List:
public class Node {
	
	
	    int data;
	    Node next;
	    public static void main(String[] args) {
	        LinkedList list = new LinkedList();

	        list.insert(8);
	        list.insert(2);
	        list.insert(9);
	        list.insert(4);
	        list.insert(5);

	        System.out.println("Original->");
	        list.display();

	        Node node = list.head.next; // Node with data 2
	        list.deleteAfterNode(node);

	        System.out.println("List after deleting node after node with data 2:");
	        list.display();
	    }

	    public Node(int data) {
	        this.data = data;
	        this.next = null;
	    }
	}

	class LinkedList {
	    Node head;

	    public LinkedList() {
	        this.head = null;
	    }

	    public void insert(int data) {
	        Node newNode = new Node(data);
	        if (head == null) {
	            head = newNode;
	        } else {
	            Node temp = head;
	            while (temp.next != null) {
	                temp = temp.next;
	            }
	            temp.next = newNode;
	        }
	    }

	    public void deleteAfterNode(Node node) {
	        if (node != null && node.next != null) {
	            Node nodeToDelete = node.next;
	            node.next = nodeToDelete.next;
	            nodeToDelete.next = null;
	        }
	    }

	    public void display() {
	        Node temp = head;
	        while (temp != null) {
	            System.out.print(temp.data + " ");
	            temp = temp.next;
	        }
	        System.out.println();
	    }

	
	}
	 /*The linked list's nodes are represented by the node class.
    The display, insert, and deleteAfterNode methods are available in the LinkedList class.
    The method deleteAfterNode removes the node that comes after the specified node.
    In order to test the functionality, the main method adds items to the list and removes nodes one after the other.
    The output of this code can be seen by running it in a Java environment.*/


