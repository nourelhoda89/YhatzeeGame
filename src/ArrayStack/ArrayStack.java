package ArrayStack;

/**
A class of ArrayStack whose entries are stored in a fixed-size array. 
@author Nourelhoda
*/ 
import java.util.*;
public class ArrayStack<T> implements StackInterface<T> {
	private T[] stack;
	private int topIndex;
	private static final int DEFAULT_CAPACITY=50;
	/** Creates an empty stack whose initial capacity is 50. */	
	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	}
	/** Creates an empty stack having a given initial capacity. 
	 * @param initialCapacity the integer capacity desired */
	public ArrayStack(int initialCapacity) {
		@SuppressWarnings("unchecked")
		T[] tempStack=(T[])new Object[initialCapacity];
		stack=tempStack;
		topIndex=-1;
	}
	/** Adds a new entry to this stack. 
	 * @param newEntry the object to be added as a new entry 
	 */
	public void push (T newEntry) {
		ensureCapacity();
		topIndex++;
		stack[topIndex]=newEntry;
	}
	/** Ensure that the array is not full, if it is double its size*/	
	private void ensureCapacity() {
		if (topIndex == stack.length - 1)// if array is full,
			// double size of array
			stack = Arrays.copyOf(stack, 2 * stack.length);
	} // end ensureCapacity

	/**retreive the topEntry in the stack
	 * @return topEntry from the stack, or null if stack is empty */
	public T peek() {
		T top = null;
		if (!isEmpty())
			top = stack[topIndex];
		return top;
	} // end peek

	/** Removes top entry from this stack, if possible.
	 *  @return either the removed entry, if the removal was successful,
	 *  or null otherwise */
	public T pop() {
		T top = null;
		if (!isEmpty()) {
			top = stack[topIndex];
			stack[topIndex] = null;			
			topIndex--; 
		} // end if 
		return top; 
	} // end pop 
	/** Sees whether the stack is empty. 
	 *@return true if empty,false if not */
	public boolean isEmpty() {
		return topIndex<0;
	}//end isEmpty

	/** Removes all entries from this bag. */	
	public void clear() {
		while(!isEmpty())
			pop();	
	}// end clear
	/** Tests whether this stack contains a given entry. 
	    * @param anEntry the entry to locate 
	    * @return true if the bag contains anEntry, or false otherwise */ 
	    public boolean contains(T anEntry) {
	        boolean found = false;
	        for(int i = 0; !found && i <stack.length; i++){
	            if(anEntry.equals(stack[i])) {
	                found = true;
	            }//end if 
	        }//end for
	        return found;
	    }//end contains
	    
	    public int getFrequencyOf(T anEntry) {
	        int counter = 0;
	        for(int i=0; i < stack.length; i++){
	            if(anEntry.equals(stack[i])) {
	                counter++;
	            }//end if
	        }//end for
	        return counter;
	    }//end getFrequencyOf

	/** Retrieves all entries that are in this stack. 
	 *  @return a newly allocated array of all the entries in the stack */
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] stackArray= (T[])new Object[stack.length];
		for(int i=0;i<stack.length;i++) {
			stackArray[i]=stack[i];
		}
		return stackArray;
	}

	public void displayAll() {
		for(int i=0;i<stack.length;i++) {
			System.out.print(stack[i]);
		}
	}
	public int size() {
		return stack.length;
	}
}