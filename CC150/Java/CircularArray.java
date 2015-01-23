/** 14.6 Implement a CiucularArray class that supports an array-like data structure which can be 
 *  efficiently rotated. The class should use a generic type, and should support iteration via
 *  the standard for (Obj o: circularArray) notation.
 */

// 4:11pm

/** here rotate means to change the start of the array and make it circular
 *  
 */
public class CircularArray<T>{
	private T[] items;
	private int head = 0;
	//use a linked list and a hashmap
	public CircularArray(int size){
		items = (T[]) new Object[size]; 
	}
	
	public void set(int i, T item){
		items[convert(i)] = item;
	}
	
	public Object get(int index){
		//is valid?
		if( index < 0 || index >= items.length)
			throw new java.lang.IndexOutOfBoundsException("Index out of bound");
		return items[convert(index)];
	}

	
	private int convert(int offset){
		head += offset;
		if(head < 0)
			head += items.length;
		head %= item.length;
	}
	
	public void rotate(int offset){
		head = convert(offset);
	}
	
	public Object findHead(){
		return head;
	}
	

	//iterator interface
	public Iterator<T> iterator(){
		return new CircularArrayIterator<T>(this);
	}
	
	private CircularArrayIterator<TI> implements Iterable<T>{
		public CircularArrayIterator(CircularArray<TI> array){
			_items = array.items;
		}
		
		public TI next(){
			_current++;
			TI item = (TI) _items[convert(_current)];
			return item;
		}
		
		public boolean hasNext(){
			return _current < items.length -1;
		}
		
			
		public void remove(int index){
			throw new UnsupportedOperationException("Unsupported operation");
		}
	}
}