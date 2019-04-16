package eg.edu.alexu.csd.datastructure.linkedList.cs10_cs24;

public interface ILinkedList {
	public void add(int index, Object element);
	public void add (Object element);
	public Object get(int index);
	public void set(int index, Object element);
	public void clear();
	public boolean isEmpty();
	public void remove(int index);
	public int size();
	public sLinkedList sublist(int fromIndex, int toIndex);
	public boolean contains(Object o);
}
