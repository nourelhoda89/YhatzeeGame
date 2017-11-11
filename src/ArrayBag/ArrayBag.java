package ArrayBag;

/**
A class of bags whose entries are stored in a fixed-size array. 
@author Frank M. Carrano
*/ 
public class ArrayBag<T> implements BagInterface<T> 
{
	private final T[] bag;
	private static final int DEFAULT_CAPACITY = 25;
	private int numberOfEntries;

   /** Creates an empty bag whose initial capacity is 25. */
   public ArrayBag() 
   { 
   this(DEFAULT_CAPACITY); 
   } // end default constructor
   
  /** Creates an empty bag having a given initial capacity. 
   * @param capacity the integer capacity desired */
   public ArrayBag(int capacity)
   {
   	numberOfEntries = 0; 
   	// the cast is safe because the new array contains null entries 
   	@SuppressWarnings("unchecked")
   	T[] tempBag = (T[])new Object[capacity];// unchecked cast 
   	bag = tempBag;
   } // end constructor
   
   /** Gets the current number of entries in this bag. 
    *  @return the integer number of entries currently in the bag */
   public int getCurrentSize() {
      return this.numberOfEntries;
   }//end getCurrentSize

   /** Sees whether this bag is full.
    *  @return true if the bag is full, or false if not */
   public boolean isFull() 
   {
   	return numberOfEntries == bag.length;
   } // end isFull 

   /** Sees whether this bag is empty. 
    *@return true if the bag is empty, or false if not */
   public boolean isEmpty() {
       return this.numberOfEntries == 0;
   }//end isEmpty

   /** Adds a new entry to this bag. 
    * @param newEntry the object to be added as a new entry 
    * @return true if the addition is successful, or false if not */ 
   public boolean add(T newEntry) 
   {
   	boolean result = true;
   	if (isFull()) { result = false; 
   	} 
   	else 
   	{ // assertion: result is true here 
   		bag[numberOfEntries] = newEntry;
   		numberOfEntries++; 
   	} // end if
   	return result;
   } // end add


   /** Removes one occurrence of a given entry from this bag. 
    *  @param anEntry the entry to be removed
    *  @return true if the removal was successful,
    *  or false if not */ 
   public boolean remove(T anEntry){
       if(!(contains(anEntry))){
           return false;
       }
       else{
           numberOfEntries--;
           bag[getIndexOf(anEntry)] = null;
       }
       return true;
   }


   /** Locates a given entry within the array bag. 
    *  Returns the index of the entry, if located, or -1 otherwise
    * @param anEntry
    * @return
    */
   private int getIndexOf(T anEntry){
       int where = -1;
       boolean stillLooking = true;
       for(int i = 0; stillLooking && i < this.numberOfEntries; i++){
           if(anEntry.equals(this.bag[i])){
               stillLooking = false; 
           }
       }
       return where;
   }

   /** Removes one unspecified entry from this bag, if possible.
    *  @return either the removed entry, if the removal was successful,
    *  or null otherwise */
   public T remove()
   {
   	T result = null;
   	if (numberOfEntries > 0){ 
   		numberOfEntries--; 
   		result = bag[numberOfEntries];
   		bag[numberOfEntries] = null; 
   		} // end if

       return result;
   }

   /** Removes all entries from this bag. */
   public void clear() {
	   while(!isEmpty())remove();
   }

   /** Counts the number of times a given entry appears in this bag.
    *  @param anEntry the entry to be counted
    *  @return the number of times anEntry appears in the bag */ 
   public int getFrequencyOf(T anEntry) {
       int counter = 0;
       for(int i=0; i < numberOfEntries; i++){
           if(anEntry.equals(bag[i])) {
               counter++;
           }//end if
       }//end for
       return counter;
   }//end getFrequencyOf

  /** Tests whether this bag contains a given entry. 
   * @param anEntry the entry to locate 
   * @return true if the bag contains anEntry, or false otherwise */ 
   public boolean contains(T anEntry) {
       boolean found = false;
       for(int i = 0; !found && i <numberOfEntries; i++){
           if(anEntry.equals(bag[i])) {
               found = true;
           }//end if 
       }//end for
       return found;
   }//end contains

   /** Retrieves all entries that are in this bag. 
    *  @return a newly allocated array of all the entries in the bag */ 
   public T[] toArray() {
       @SuppressWarnings("unchecked")
       T [] returnArray = (T []) new Object[this.numberOfEntries];
       //System.arraycopy(this.bag, 0, returnArray, 0, this.numberOfEntries);
       for(int index = 0; index < returnArray.length; index++){
           returnArray[index] = this.bag[index];
       }
       return ( T[] )returnArray;
   }//end toArray
   
/** remove every entry that is similar to the entry passed
 * @param anEntry is the entry to be removed
 * */
   public void removeEvery(T anEntry) {
   	for(int index = 0; index < numberOfEntries; index++){
   		if(anEntry.equals(bag[index])) {
   			removeEntry(index);
   			index--;
   		}//end if		
   	}//end for
   }//end removeEvery
   
   public T removeEntry(int index) {
   	T result=null;
   	
   if(!isEmpty()&& (index>=0))
   {
   	result=bag[index];
   	numberOfEntries--;
   	bag[index]=bag[numberOfEntries];
   	bag[numberOfEntries]=null;
   }
   return result;
   }
   public void displayAll() {
	   System.out.print("[");
	   	for(int index = 0; index < numberOfEntries; index++){
	   		System.out.print(bag[index]+" ");	
	   }
	   	System.out.print("]");
   }
   
}


