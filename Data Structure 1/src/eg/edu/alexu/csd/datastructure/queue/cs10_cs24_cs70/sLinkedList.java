package eg.edu.alexu.csd.datastructure.queue.cs10_cs24_cs70;

public class sLinkedList {

	sNode head = null;
	
	public void add (Object element) {

        sNode node = new sNode();
        node.data = element;
        node.next = null;

        if (head == null) {
            head = node;
        }
        else {
            sNode n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
    }
	
	public boolean isEmpty() {
        return (head == null);
    }
	
	public int size() {
        if(head==null){return 0;}
        int size = 1;
        sNode n = head;
        while (n.next != null) {
            n = n.next;
            size++;
        }
        return size;
    }
	
}
