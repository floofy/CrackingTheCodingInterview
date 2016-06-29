/*
 * Sort a stack with only one other stack as a data structure. 
 */
package challenges.stacksAndQueues;

import java.util.Stack;

public class SortStack {

	public static void test() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(5);
        stack.push(0);
        stack.push(3);
        stack.push(10);
        stack.push(1);
        stack.push(100);
        System.out.print("5. sortStack(" + stack + ") : ");
        stack = sortStack(stack);
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
	}
	
	/*
	 * Returns a storted stack where it uses 1 other stack s2 as a buffer. All
	 * elements from original stack are popped onto the correct place in s2
	 * where all elements in s2 that are > s1.pop() are moved back into s1. 
	 */
    public static Stack<Integer> sortStack(Stack<Integer> s1) {
    	if (s1 == null) {
    		return null;
    	}
    
        Stack<Integer> s2 = new Stack<Integer>();
        int min;
        s2.push(s1.pop());
        while (!s1.empty()) {
        	if(s1.peek() < s2.peek()) {
        		min = s1.pop();
        		while(true) {
        			if (s2.empty() || min > s2.peek()) {
        				s2.push(min);
        				break;
        			} else {
        				s1.push(s2.pop());
        			}
        		}
        	} else {
        		s2.push(s1.pop());
        	}
        }
        
        return s2;
    }

}
