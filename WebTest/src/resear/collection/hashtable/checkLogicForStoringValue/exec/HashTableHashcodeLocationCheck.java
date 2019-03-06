package resear.collection.hashtable.checkLogicForStoringValue.exec;

import java.util.HashMap;
import java.util.Hashtable;

import resear.collection.hashtable.checkLogicForStoringValue.dto.CheckStateBasedHashcode;
import resear.collection.hashtable.checkLogicForStoringValue.dto.SingleState;
import resear.collection.hashtable.checkLogicForStoringValue.dto.StateIntoOne;
import resear.collection.hashtable.checkLogicForStoringValue.dto.StateIntoTwo;


/**
 * 
 * Logic behind this:
 * 
 * Key will be initialized on basis of <hashcode>%<hashtable_size>
 * default initial capacity is 11
 * 
 * Now the object of the respective HashTable will be created in following sequence:
 * 
 * 	1. 1st priority - Top to bottom
 * 	2. 2nd priority - Right to left
 * 
 * 
 */

public class HashTableHashcodeLocationCheck {

	public static void main(String[] args) {
		
		HashTableHashcodeLocationCheck executorObj = new HashTableHashcodeLocationCheck();
		
		Hashtable<CheckStateBasedHashcode, String> hashtable = new Hashtable<CheckStateBasedHashcode, String>();
		
		executorObj.clearHashTable(hashtable);
		
		hashtable = executorObj.checkLogicForStateIntoOne(hashtable);
		System.out.println("HashTable object for type CheckStateBasedHashcode(SingleIntoOne): "+hashtable);	
		
		executorObj.clearHashTable(hashtable);
		
		hashtable = executorObj.checkLogicForStateIntoTwo(hashtable);
		System.out.println("HashTable object for type CheckStateBasedHashcode(SingleIntoTwo): "+hashtable);	
		
		executorObj.clearHashTable(hashtable);
		
		hashtable = executorObj.checkLogicForSingleState(hashtable);
		System.out.println("HashTable object for type CheckStateBasedHashcode(SingleState): "+hashtable);	
	}

	/**
	 * @param hashtable
	 */
	private void clearHashTable(Hashtable<CheckStateBasedHashcode, String> hashtable) {
		System.out.println("\nClearing initiated of HashTable object before filling another type of objects into it");
		hashtable.clear();
		System.out.println("\nClearing completed of HashTable object before filling another type of objects into it");
	}

	/**
	 * 
	 * 	10th	|			|
	 * 	9th		|			|
	 * 	8th		|			|
	 * 	7th		|			|
	 * 	6th		|6=C		|		(6%11=6) made C in 6th position
	 * 	5th		|5=A, 16=F	|		(5%11=5) made A in 5th position, (16%11=5) made F in 5th position
	 * 	4th		|15=D		|		(15%11=4) made D in 4th position
	 * 	3th		|			|
	 * 	2nd		|2=B		|		(2%11=2) made B in 2nd position
	 * 	1st		|23=E		|		(23%11=1) made E in 1st position
	 * 	0th		|			|
	 * 
	 * 
	 * So the HashTable object would be {6=C, 16=F, 5=A, 15=D, 2=B, 23=E}
	 * 
	 * Since HashMap is implemented on HashTable, so it will also be having same process to allocate location to it's objects. But HashMap takes null keys and values.
	 * 
	 */
	private Hashtable<CheckStateBasedHashcode, String> checkLogicForStateIntoOne(Hashtable<CheckStateBasedHashcode, String> hashtable) {
		
		hashtable.put(new StateIntoOne(5), "A");
		hashtable.put(new StateIntoOne(2), "B");
		hashtable.put(new StateIntoOne(6), "C");
		hashtable.put(new StateIntoOne(15), "D");
		hashtable.put(new StateIntoOne(23), "E");
		hashtable.put(new StateIntoOne(16), "F");
		/*Below lines will give error, since null key or null values not allowed in HashTable*/
		/*hashtable.put(null, "Z");*/
		/*hashtable.put(new StateIntoOne(13), null);*/
		
		HashMap<CheckStateBasedHashcode, String> hashMap = new HashMap<CheckStateBasedHashcode, String>();
		hashMap.put(new StateIntoOne(5), "A");
		hashMap.put(new StateIntoOne(2), "B");
		hashMap.put(new StateIntoOne(6), "C");
		hashMap.put(new StateIntoOne(15), "D");
		hashMap.put(new StateIntoOne(23), "E");
		hashMap.put(new StateIntoOne(16), "F");
		hashMap.put(null, null);
		hashMap.put(null, "X");
		hashMap.put(null, "Z");
		
		System.out.println("HashMap: "+hashMap);
		
		return hashtable;
	}
	
	/**
	 * 
	 * 	10th	|5=A,16=F	|		((5*2)%11=10) made A in 10th position, ((16*2)%11=10) made F in 10th position
	 * 	9th		|			|		
	 * 	8th		|15=D		|		((15*2)%11=8) made D in 8th position
	 * 	7th		|			|
	 * 	6th		|			|
	 * 	5th		|			|		
	 * 	4th		|2=B		|		(2*2)%11=4) made B in 4th position
	 * 	3th		|			|
	 * 	2nd		|23=E		|		((23*2)%11=2) made E in 2nd position
	 * 	1st		|6=C		|		((6*2)%11=1) made C in 1st position
	 * 	0th		|			|
	 * 
	 * 
	 * So the HashTable object would be {16=F, 5=A, 15=D, 2=B, 23=E, 6=C}
	 * 
	 * Since HashMap is implemented on HashTable, so it will also be having same process to allocate location to it's objects. But HashMap takes null keys and values.
	 * 
	 * 
	 * 
	 */
	private Hashtable<CheckStateBasedHashcode, String> checkLogicForStateIntoTwo(Hashtable<CheckStateBasedHashcode, String> hashtable) {
		
		hashtable.put(new StateIntoTwo(5), "A");
		hashtable.put(new StateIntoTwo(2), "B");
		hashtable.put(new StateIntoTwo(6), "C");
		hashtable.put(new StateIntoTwo(15), "D");
		hashtable.put(new StateIntoTwo(23), "E");
		hashtable.put(new StateIntoTwo(16), "F");
		/*Below lines will give error, since null key or null values not allowed in HashTable*/
		/*hashtable.put(null, "Z");*/
		/*hashtable.put(new StateIntoTwo(13), null);*/
		
		HashMap<CheckStateBasedHashcode, String> hashMap = new HashMap<CheckStateBasedHashcode, String>();
		hashMap.put(new StateIntoTwo(5), "A");
		hashMap.put(new StateIntoTwo(2), "B");
		hashMap.put(new StateIntoTwo(6), "C");
		hashMap.put(new StateIntoTwo(15), "D");
		hashMap.put(new StateIntoTwo(23), "E");
		hashMap.put(new StateIntoTwo(16), "F");
//		hashMap.put(null, null);
//		hashMap.put(null, "X");
//		hashMap.put(null, "Z");
		
		
		System.out.println("HashMap: "+hashMap);
		
		return hashtable;
	}
	
	/**
	 * 
	 * 	10th	|							|
	 * 	9th		|							|
	 * 	8th		|							|
	 * 	7th		|							|
	 * 	6th		|							|
	 * 	5th		|							|
	 * 	4th		|							|
	 * 	3th		|							|
	 * 	2nd		|5=A,2=B,6=C,15=D,23=E,16=F	|	(2%11=2) made A in 10th position,(2%11=2) made B in 10th position,(2%11=2) made C in 10th position,(2%11=2) made D in 10th position,(2%11=2) made E in 10th position,(2%11=2) made F in 10th position
	 * 	1st		|							|
	 * 	0th		|							|
	 * 
	 * 
	 * So the HashTable object would be {16=F, 23=E, 15=D, 6=C, 2=B, 5=A}
	 * 
	 * 
	 * 
	 * Since HashMap is implemented on HashTable, so it will also be having same process to allocate location to it's objects. But HashMap takes null keys and values.
	 * 
	 * 
	 * 	10th	|											|
	 * 	9th		|											|
	 * 	8th		|											|
	 * 	7th		|											|
	 * 	6th		|											|
	 * 	5th		|											|
	 * 	4th		|											|
	 * 	3th		|											|
	 * 	2nd		|5=A,2=B,6=C,15=D,23=E,16=F,null=Z(null/X/Z)|	(2%11=2) made A in 10th position,(2%11=2) made B in 10th position,(2%11=2) made C in 10th position,(2%11=2) made D in 10th position,(2%11=2) made E in 10th position,(2%11=2) made F in 10th position,(null%11=null) made null then X then Z in 10th position
	 * 	1st		|											|
	 * 	0th		|											|
	 * 
	 * So the hashMap would be {null=Z, 16=F, 23=E, 15=D, 6=C, 2=B, 5=A}
	 * 
	 */
	private Hashtable<CheckStateBasedHashcode, String> checkLogicForSingleState(Hashtable<CheckStateBasedHashcode, String> hashtable) {
		
		hashtable.put(new SingleState(5), "A");
		hashtable.put(new SingleState(2), "B");
		hashtable.put(new SingleState(6), "C");
		hashtable.put(new SingleState(15), "D");
		hashtable.put(new SingleState(23), "E");
		hashtable.put(new SingleState(16), "F");
		/*Below lines will give error, since null key or null values not allowed in HashTable*/ 
		/*hashtable.put(null, "Z");*/
		/*hashtable.put(new SingleState(13), null);*/
		
		
		HashMap<CheckStateBasedHashcode, String> hashMap = new HashMap<CheckStateBasedHashcode, String>();
		hashMap.put(new SingleState(5), "A");
		hashMap.put(new SingleState(2), "B");
		hashMap.put(new SingleState(6), "C");
		hashMap.put(new SingleState(15), "D");
		hashMap.put(new SingleState(23), "E");
		hashMap.put(new SingleState(16), "F");
		hashMap.put(null, null);
		hashMap.put(null, "X");
		hashMap.put(null, "Z");
		
		
		System.out.println("HashMap: "+hashMap);
		
		return hashtable;
	}

}