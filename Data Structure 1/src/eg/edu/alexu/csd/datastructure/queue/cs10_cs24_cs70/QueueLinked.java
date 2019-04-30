package eg.edu.alexu.csd.datastructure.queue.cs10_cs24_cs70;

public class QueueLinked implements IQueue , ILinkedBased {
	
	private sLinkedList storage=new sLinkedList();
    
    public void enqueue(Object item){
        storage.add(item);
    }
    
    public Object dequeue(){
        if(storage.isEmpty()){
        	throw new IllegalArgumentException("QUEUE IS EMPTY");
    	}else {
            sNode n=storage.head;
            storage.head=storage.head.next;
            return n.data;
        }
    }
    
    public boolean isEmpty(){
        return storage.isEmpty();
    }
    
    public int size(){
        return storage.size();
    }
	
}
