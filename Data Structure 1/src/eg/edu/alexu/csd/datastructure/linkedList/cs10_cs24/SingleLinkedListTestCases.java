package eg.edu.alexu.csd.datastructure.linkedList.cs10_cs24;

import static org.junit.Assert.*;
//import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class SingleLinkedListTestCases {

	@Test
	public void test() {
		sLinkedList sL = new sLinkedList();
		sL.add((int)3);
		sL.add((int)7);
		sL.add((int)1);
		sL.add((int)6);
		// get() test
		int o1 = (int)sL.get(0);
		assertEquals(3,o1);
		o1 = (int)sL.get(1);
		assertEquals(7,o1);
		o1 = (int)sL.get(2);
		assertEquals(1,o1);
		o1 = (int)sL.get(3);
		assertEquals(6,o1);
		// add(index) test
		sL.add(2, (int)13);
		o1 = (int)sL.get(2);
		assertEquals(13,o1);
		sL.add(0, (int)-5);
		o1 = (int)sL.get(0);
		assertEquals(-5,o1);
		// set(index, object) test
		sL.set(2, (int)14);
		o1 = (int)sL.get(2);
		assertEquals(14,o1);
		// sublist(fromIndex, toIndex) test
		sLinkedList l= sL.sublist(0, 2);
		assertEquals(-5,(int)l.get(0));
		assertEquals(3,(int)l.get(1));
		assertEquals(14,(int)l.get(2));
		// size() test
		o1 = l.size();
		assertEquals(3,o1);
		o1 = sL.size();
		assertEquals(6,o1);
		// remove(index) test
		sL.remove(3);
		o1 = sL.size();
		assertEquals(5,o1);
		// contains (object) test
		assertEquals(true,sL.contains((int)-5));
		assertEquals(false,sL.contains((int)56));
		//clear() and isEmpty() test
		sL.clear();
		assertEquals(true,sL.isEmpty());
	}

}
