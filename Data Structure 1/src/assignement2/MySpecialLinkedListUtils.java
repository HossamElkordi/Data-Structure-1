package assignement2;

public class MySpecialLinkedListUtils {
		
	public static double[] summary(LinkedListNode head) {
		
		double[] a = new double[4];
		int size = getSize(head);
		
		a[0] = (1/(double)size)*head.getValue();
		a[2] = head.getValue();
		a[3] = head.getValue();
		
		int median;
		if (size % 2 == 0) {
			median = size/2 - 1;
		}else {
			median = size/2;
		}
		
		int i = 0;
		LinkedListNode n = head;
		
		while (n.getNext() != null) {
			n = n.getNext();
			i++;
			a[0] += (1/(double)size)*n.getValue();
			if (i == median) {
				a[1] = n.getValue();
			}
			if (n.getValue() > a[2]) {
				a[2] = n.getValue();
			}
			if (n.getValue() < a[3]) {
				a[3] = n.getValue();
			}
		}
		return a;
	}
	
	public static LinkedListNode reverse (LinkedListNode head) {
		
		LinkedListNode newHead = null;
		LinkedListNode n = head;
		// set the head node of the reversed list 
		n = head;
		while (n.getNext().getNext() != null) {
			n = n.getNext();
		}
		newHead = n.getNext();
		n.next = null;
		// add elements to the new list
		while (head.getNext() != null) {
			n = head;
			while (n.getNext().getNext() != null) {
				n = n.getNext();
			}
			LinkedListNode n1 = newHead;
			while (n1.getNext() != null) {
				n1 = n1.getNext();
			}
			n1.next = n.next;
			n.next = null;
		}
		// set the original head as the last element in the new list
		n = newHead;
		while (n.getNext() != null) {
			n = n.getNext();
		}
		n.next = head;
		return newHead;
	}
	
	public static LinkedListNode evenIndexedElements (LinkedListNode head) {
		
		int index = 0;
		LinkedListNode newHead = new LinkedListNode();
		newHead.value = head.getValue();
		LinkedListNode n1 = newHead;
		LinkedListNode n = head;
		while (n.next != null) {
			n = n.getNext();
			index++;
			if (index % 2 == 0) {
				LinkedListNode n2 = new LinkedListNode();
				n2.value = n.getValue();
				while (n1.next != null) {
					n1 = n1.getNext();
				}
				n1.next = n2;
			}
		}
		if (index % 2 == 0) {
			n1.next.next = n.next;
		}
		return newHead;
		
	}
	
	public static LinkedListNode insertionSort(LinkedListNode head) {
		
		LinkedListNode sortedList = null;
	    while(head != null){
		    LinkedListNode current = head;
		    head = head.getNext();
		    LinkedListNode x;
		    LinkedListNode previous = null;
		    for(x = sortedList; x != null; x = x.getNext()){
		        if(current.value < x.value){
		                break;
		         }
		         previous = x;
		    }
		    if(previous == null){               
		          current.next = sortedList;
		          sortedList = current;
		    }
		    else{               
		       current.next = previous.next;
		       previous.next = current;
		    }
	  }
	  return sortedList;
		  
	}
	
	public static LinkedListNode mergeSort(LinkedListNode head) {
		
		if (head == null || head.next == null) {
			return head;
		}
		
		LinkedListNode middle = getmedian(head);
		LinkedListNode newHead = middle.getNext();
		middle.next = null;
		
		LinkedListNode leftList = mergeSort(head);
		LinkedListNode rightList = mergeSort(newHead);
		
		LinkedListNode finalList = merge(leftList,rightList);
		return finalList;
		
	}
	
	public static LinkedListNode removeCentralNode(LinkedListNode head) {
		
		int size = getSize(head);
		int i = 0;
		int median;
		if (size % 2 == 0) {
			median = size/2 - 1;
		}else {
			median = size/2;
		}
		LinkedListNode n = head;
		while (n.next != null) {
			n = n.getNext();
			i++;
			if (i == median-1) {
				n.next = n.getNext().getNext();
			}
		}
		return head;
		
	}
	
	private static LinkedListNode getmedian (LinkedListNode a) {

		int size = getSize(a);
		LinkedListNode middle = a;
		if (size % 2 == 0) {
			for (int i = 0; i<size/2-1; i++) {
				middle = middle.getNext();
			}
		}else {
			for (int i = 0; i<size/2; i++) {
				middle = middle.getNext();
			}
		}
		return middle;
		
	}
	
	public static boolean palindrome(LinkedListNode head) {
		
		boolean palindrome = true;
		LinkedListNode n1 = head;
		LinkedListNode n2 = head;
		int size = getSize(head);
		for (int i = 0; i<size/2; i++) {
			for (int j = 0; j<size-i-1; j++) {
				n2 = n2.getNext();
			}
			if (n1.getValue() != n2.getValue()) {
				palindrome = false;
				break;
			}
			n2 = head;
			n1 = n1.getNext();
		}
		return palindrome;
		
	}
	
	private static LinkedListNode merge(LinkedListNode head, LinkedListNode newHead) {
		
		LinkedListNode sortedList = null;
		
		if (head == null) {
			return newHead;
		}else if (newHead == null) {
			return head;
		}
		
		if (head.getValue() <= newHead.getValue()) {
			sortedList = head;
			sortedList.next = merge(head.getNext(),newHead);
		}else {
			sortedList = newHead;
			sortedList.next = merge(head,newHead.getNext());
		}
		
		return sortedList;
		
	}
	
	private static int getSize (LinkedListNode head) {
		int size = 1;
		LinkedListNode n = head;
		while (n.next != null) {
			n = n.next;
			size++;
		}
		return size;
	}
}
