/*
 * Custom data structure consisting of several stacks where the user defines
 * the limit of how much one stack can hold. A new stack will be allocated. 
 */
package dataStructures.linkedList;

import java.util.ArrayList;

public class SetOfStacks <E> {

	protected ArrayList<Stack<E>> stacks = new ArrayList<Stack<E>>();
	int elements;
	int limit;

	public SetOfStacks(int limit) {
		this.elements = 0; 
		this.limit = limit;
		// if elements%limit > 0: add 1 to size == 0 (add/remove stack)
		// <--- size = elements/limit
	}
	
	public SetOfStacks() {
		this.elements = 0; 
		this.limit = 30;
	}

	/*
	 * Add new stack when the number of elements % limit == 0.
	 */
	public void push(E data) {
		int thisStackSize = elements%limit;
		if (thisStackSize == 0) {
			stacks.add(new Stack<E>());
		}
		stacks.get(stacks.size()-1).push(data);
		elements += 1;
	}

	/*
	 * Opposite of push when elements % limit == 0 remove stack from ArrayList.
	 */
	public E pop() {
		if (stacks.size() == 0)
			return null;

		E data = stacks.get(stacks.size()-1).pop();
		elements -= 1;

		int thisStackSize = elements%limit;
		if (thisStackSize == 0) {
			stacks.remove(stacks.size()-1);
		}

		return data;
	}

	public E peek() {
		if (stacks.size() == 0)
			return null;
		return stacks.get(stacks.size()-1).peek();
	}
	
	/*
	 * Shift all elements after stackIndex-1 left by putting the next element
	 * of the next stack to the bottom of the previous stack. 
	 */
	public E popAt(int stackIndex) {
		if (stackIndex < 0 || stackIndex > this.stacks.size() - 1) // index at 0
			return null;
		
		E data;
		Stack<E> stack = this.stacks.get(stackIndex);
		data = stack.pop();
		
		shiftLeft(stackIndex);
		
		this.elements -= 1;

		return data;
	}
	
	/* 
	 * Shift all elements to the left from user's popAt index to end  by putting
	 * the next stack's top element to the left stack's bottom to maintain
	 * a single-like stack keeping all stacks filled except the last one.  
	 */
	public boolean shiftLeft(int stackIndex) {
		if (stackIndex > stacks.size()-1) {
			return false;
		}

		Stack<E> curStack;
		Stack<E> buffer = new Stack<E>();
		
		for (int i=stackIndex; i<this.stacks.size()-1; ++i) {
			curStack = this.stacks.get(i);

			/* lift all elements off. */
			while (curStack.peek() != null) {
				buffer.push(curStack.pop());
			}
			
			/* put next stack to bottom */
			curStack.push(this.stacks.get(i+1).pop());
			while (buffer.peek() != null) {
				curStack.push(buffer.pop());
			}
		}
		
		/* Remove last stack if leftShift made it empty */
		if (this.stacks.get(this.stacks.size()-1).size() == 0) {
			this.stacks.remove(this.stacks.size()-1);
		}

		return true;
	}
	
	public void printAllStack() {
		for (int i=0; i<this.stacks.size(); ++i) {
			System.out.format("Stack %d: ", i);
			Stack<E>stack = stacks.get(i);
			E data = stack.pop();
			while (data != null) {
				System.out.print(data + " ");
				data = stack.pop();
			}
			System.out.print('\t');
		}
		this.stacks.clear();
		this.elements = 0;
		System.out.println("");
	}
	
	public static void test() {
		System.out.println("All stack elements:");
		SetOfStacks<Integer> sos = new SetOfStacks<Integer>(3);
		sos.push(1);
		sos.push(2);
		sos.push(3);
		sos.push(4);
		sos.push(5);
		sos.push(6);
		sos.push(7);
		Integer a = sos.pop();
		while (a != null) {
			System.out.print(a + " ");
			a = sos.pop();
		}
		
		System.out.println("\n");
		sos.push(3);
		sos.push(2);
		sos.push(1);
		sos.push(6);
		sos.push(5);
		sos.push(4);
		//sos.push(8);
		sos.push(7);
		System.out.println("Printing all stacks:");
		sos.printAllStack();
		System.out.println("");
		
		sos.push(3);
		sos.push(2);
		sos.push(1);
		sos.push(6);
		sos.push(5);
		sos.push(4);
		//sos.push(8);
		sos.push(7);
		Integer data = sos.popAt(1);
		System.out.println("Testing popAt(1). Data: " + data);
		sos.printAllStack();
	}

 }
