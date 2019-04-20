package eg.edu.alexu.csd.datastructure.linkedList.cs10_cs24;

import static org.junit.Assert.*;
//import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class DoubleLinkedListTestCases {

	@Test
	public void test() {
		dLinkedList dL = new dLinkedList();
		dL.add((int)3);
		dL.add((int)7);
		dL.add((int)1);
		dL.add((int)6);
		// get() test
		int o1 = (int)dL.get(0);
		assertEquals(3,o1);
		o1 = (int)dL.get(1);
		assertEquals(7,o1);
		o1 = (int)dL.get(2);
		assertEquals(1,o1);
		o1 = (int)dL.get(3);
		assertEquals(6,o1);
		// add(index) test
		dL.add(2, (int)13);
		o1 = (int)dL.get(2);
		assertEquals(13,o1);
		dL.add(0, (int)-5);
		o1 = (int)dL.get(0);
		assertEquals(-5,o1);
		// set(index, object) test
		dL.set(2, (int)14);
		o1 = (int)dL.get(2);
		assertEquals(14,o1);
		// sublist(fromIndex, toIndex) test
		dLinkedList l= dL.sublist(0, 2);
		assertEquals(-5,(int)l.get(0));
		assertEquals(3,(int)l.get(1));
		assertEquals(14,(int)l.get(2));
		// size() test
		o1 = l.size();
		assertEquals(3,o1);
		o1 = dL.size();
		assertEquals(6,o1);
		// remove(index) test
		dL.remove(3);
		o1 = dL.size();
		assertEquals(5,o1);
		// contains (object) test
		assertEquals(true,dL.contains((int)-5));
		assertEquals(false,dL.contains((int)56));
		//clear() and isEmpty() test
		dL.clear();
		assertEquals(true,dL.isEmpty());
	}

}
