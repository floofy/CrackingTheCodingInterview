/*
 * Custom data structure consisting of several stacks where the user defines
 * the limit of how much one stack can hold. A new stack will be allocated. 
 */
package dataStructures.linkedList;

import java.util.ArrayList;

public class SetOfStacks <E> {

	protected ArrayList<Stack<E>> setOfStacks = new ArrayList<Stack<E>>();
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
			setOfStacks.add(new Stack<E>());
		}
		setOfStacks.get(setOfStacks.size()-1).push(data);
		elements += 1;
	}

	/*
	 * Opposite of push when elements % limit == 0 remove stack from ArrayList.
	 */
	public E pop() {
		if (setOfStacks.size() == 0)
			return null;

		E data = setOfStacks.get(setOfStacks.size()-1).pop();
		elements -= 1;

		int thisStackSize = elements%limit;
		if (thisStackSize == 0) {
			setOfStacks.remove(setOfStacks.size()-1);
		}

		return data;
	}

	public E peek() {
		if (setOfStacks.size() == 0)
			return null;
		return setOfStacks.get(setOfStacks.size()-1).peek();
	}
	
	/*
	 * Shift all element safter stackIndex-1 left by putting the next element
	 * of the next stack to the bottom of the previous stack. 
	 */
	public E popAt(int stackIndex) {
		if (stackIndex < 1 || stackIndex > this.setOfStacks.size() - 1)
			return null;
		
		E data;
		Stack<E> tmp = new Stack<E>();
		Stack<E> stack = this.setOfStacks.get(stackIndex-1);
		data = stack.pop();

		for (int i=stackIndex-1; i<this.setOfStacks.size()-1; ++i) {
			stack = this.setOfStacks.get(i);
			while (stack.peek() != null) {
				tmp.push(stack.pop());
			}			
			stack.push(this.setOfStacks.get(i+1).pop());
			while (tmp.peek() != null) {
				stack.push(tmp.pop());
			}
		}
		
		if (this.setOfStacks.get(this.setOfStacks.size()-1).peek() == null) {
			this.setOfStacks.remove(this.setOfStacks.size()-1);
		}
		
		this.elements -= 1;

		return data;
	}
	
	public void printAllStack() {
		for (int i=0; i<this.setOfStacks.size(); ++i) {
			System.out.format("Stack %d: ", i);
			Stack<E>stack = setOfStacks.get(i);
			E data = stack.pop();
			while (data != null) {
				System.out.print(data + " ");
				data = stack.pop();
			}
			System.out.print('\t');
		}
		this.setOfStacks.clear();
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
		Integer data = sos.popAt(2);
		System.out.println("Testing popAt(2). Data: " + data);
		sos.printAllStack();
	}
 }
