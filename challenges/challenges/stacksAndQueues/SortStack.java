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
	 * Sorts stacks s.t that biggest element is at the top. This is done by
	 * grabbing the top of the original stack and putting it in the correct
	 * place in s2. All elements > the top will be pushed back onto s1 but
	 * will not go through inner while loop again because those are ordered.
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
