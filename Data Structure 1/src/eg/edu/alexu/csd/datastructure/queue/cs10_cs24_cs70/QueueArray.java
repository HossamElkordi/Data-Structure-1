package eg.edu.alexu.csd.datastructure.queue.cs10_cs24_cs70;

public class QueueArray implements IQueue , IArrayBased {
	
	public int size = 0;
	public int start;
	public int end;
    public Object [] queue;
    
    QueueArray(int n)
    {
        queue = new Object[n];
        start = 0;
        end = n-1;
    }
    
    public void enqueue(Object item) {
        if(size == queue.length)
            throw new IllegalArgumentException("The queue is full");
        end = (end+1) % queue.length;
        queue[end] = item;
        size++;
    }
 
    public Object dequeue() {
        if(size == 0)
            throw new IllegalArgumentException("The queue is already empty");
        Object ans = queue[start];
        start = (start+1) % queue.length;
        size--;
        return ans;
    }
 
    public boolean isEmpty() {
        return (size == 0);
    }
 
    public int size() {
        return size;
    }
}
