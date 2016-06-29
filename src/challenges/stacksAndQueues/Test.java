package challenges.stacksAndQueues;

import dataStructures.custom.AnimalQueue;
import dataStructures.linkedList.MyQueue;
import dataStructures.linkedList.SetOfStacks;

public class Test {

	public static void test() {
	
	//		Queue.test();
	//		Stack.test();

		/* 1 
		 * The way I would implement an array to be used as three stacks is to
		 * have to dynamically sized, s.t if one stack was filled an x
		 * percentage, a bigger array would be allocated and the contents of the
		 * current array will be copied. Only the stack of that caused the
		 * resize would be resized to that proportion so the array size would
		 * increase wrt to that. 3 indexes will indicated where 3 of the stacks
		 * start with 3 respective size variables. 
		 */
		
		/* 2 
		 * To implement a constant access to the minimum in a stack, I would
		 * use stack to store all the minimums to every push s.t for ever push
		 * I would peek then push if it was smaller and pop the min stack for
		 * every pop that equals the peek of the min stack. 
		 */

		System.out.println("---[Stacks and Queues test]---");
		System.out.println("3. SetOfStacks: ");
		SetOfStacks.test();
	
		System.out.println("\n5. MyQueue: ");
		MyQueue.test();

		System.out.println("");
		SortStack.test();
        
        AnimalQueue a = new AnimalQueue();
        System.out.println("\n6. AnimalQueue: ");
        a.test();
	}
	





}
