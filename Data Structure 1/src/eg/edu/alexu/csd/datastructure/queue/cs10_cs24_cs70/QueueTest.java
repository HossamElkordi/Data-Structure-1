package eg.edu.alexu.csd.datastructure.queue.cs10_cs24_cs70;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;

import org.junit.Test;

public class QueueTest {

	@Test
	public void test() throws IOException {
		QueueLinked q1 = new QueueLinked();
		if (q1 instanceof ILinkedBased) {
			LQueue(q1);
		}else {
			throw new IOException("ILinkedBased interface not implemented");
		}
		
		QueueArray q2 = new QueueArray(7);
		if (q2 instanceof IArrayBased) {
			AQueue(q2);
		}else {
			throw new IOException("IArrayBased interface not implemented");
		}
	}
	
	public void LQueue (Object q) {
		// empty queue test
		assertEquals(true , ((QueueLinked) q).isEmpty());
		assertEquals(0 , ((QueueLinked) q).size());
		// empty queue exception
		assertThrows(IllegalArgumentException.class, () -> ((QueueLinked) q).dequeue());
		
		// enqueue test
		((QueueLinked) q).enqueue(5);
		((QueueLinked) q).enqueue("gdf$");
		((QueueLinked) q).enqueue('w');
		assertEquals(false , ((QueueLinked) q).isEmpty());
		assertEquals(3 , ((QueueLinked) q).size());
		
		// dequeue test
		assertEquals(5 , ((QueueLinked) q).dequeue());
		assertEquals(2 , ((QueueLinked) q).size());
		assertEquals(false , ((QueueLinked) q).isEmpty());
		
		assertEquals("gdf$" , ((QueueLinked) q).dequeue());
		assertEquals(1 , ((QueueLinked) q).size());
		assertEquals(false , ((QueueLinked) q).isEmpty());
		
		assertEquals('w' , ((QueueLinked) q).dequeue());
		assertEquals(0 , ((QueueLinked) q).size());
		assertEquals(true , ((QueueLinked) q).isEmpty());
		// empty queue exception
		assertThrows(IllegalArgumentException.class, () -> ((QueueLinked) q).dequeue());
	}
	
	public void AQueue (Object q) {
		// empty queue test
		assertEquals(true , ((QueueArray) q).isEmpty());
		assertEquals(0 , ((QueueArray) q).size());
		assertEquals(0 , ((QueueArray) q).start);
		assertEquals(6 , ((QueueArray) q).end);
		// empty queue exception
		assertThrows(IllegalArgumentException.class, () -> ((QueueArray) q).dequeue());
		
		// enqueue test
		((QueueArray) q).enqueue(5);
		((QueueArray) q).enqueue("gdf$");
		((QueueArray) q).enqueue('w');
		assertEquals(0 , ((QueueArray) q).start);
		assertEquals(2 , ((QueueArray) q).end);
		assertEquals(false , ((QueueArray) q).isEmpty());
		assertEquals(3 , ((QueueArray) q).size());
		
		((QueueArray) q).enqueue(48);
		((QueueArray) q).enqueue("AHM");
		((QueueArray) q).enqueue('&');
		((QueueArray) q).enqueue("full");
		assertEquals(7 , ((QueueArray) q).size());
		// full queue exception
		assertThrows(IllegalArgumentException.class, () -> ((QueueArray) q).enqueue(7));
		
		// dequeue test
		assertEquals(5 , ((QueueArray) q).dequeue());
		assertEquals("gdf$" , ((QueueArray) q).dequeue());
		assertEquals(5 , ((QueueArray) q).size());
		assertEquals(2 , ((QueueArray) q).start);
		assertEquals(6 , ((QueueArray) q).end);
		
		// circular array cases
		((QueueArray) q).enqueue('=');
		((QueueArray) q).enqueue("circular");
		assertEquals(7 , ((QueueArray) q).size());
		assertEquals(2 , ((QueueArray) q).start);
		assertEquals(1 , ((QueueArray) q).end);
		// full queue exception
		assertThrows(IllegalArgumentException.class, () -> ((QueueArray) q).enqueue(7));
		
		// some other dequeue cases
		assertEquals('w' , ((QueueArray) q).dequeue());
		assertEquals(48 , ((QueueArray) q).dequeue());
		assertEquals("AHM" , ((QueueArray) q).dequeue());
		assertEquals('&' , ((QueueArray) q).dequeue());
		assertEquals(false , ((QueueArray) q).isEmpty());
		assertEquals("full" , ((QueueArray)q).dequeue());
		assertEquals('=' , ((QueueArray) q).dequeue());
		assertEquals("circular" , ((QueueArray) q).dequeue());
		
		assertEquals(0 , ((QueueArray) q).size());
		assertEquals(2 , ((QueueArray) q).start);
		assertEquals(1 , ((QueueArray) q).end);
		assertEquals(true , ((QueueArray) q).isEmpty());
		// empty queue exception
		assertThrows(IllegalArgumentException.class, () -> ((QueueArray) q).dequeue());
	}

}
