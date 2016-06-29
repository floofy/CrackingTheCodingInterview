package dataStructures.linkedList;

import java.util.Stack;

/*
 * A queue implemented by using two stacks. For every enqueue, the all elements
 * from stack are popped onto buffer, then the enqueued element. All elements
 * in buffer are then popped into the stack to simulate a FIFO queue.
 */

public class MyQueue<E> {
    private Stack<E> stack, buffer;
    
    public MyQueue() {
        stack = new Stack<E>();
        buffer = new Stack<E>();
    }
    
    public void enqueue(E data) {
        while (!this.stack.empty()) {
            buffer.push(this.stack.pop());
        }
        
        this.stack.push(data);
        
        while (!buffer.isEmpty()) {
            this.stack.push(buffer.pop());
        }
        return;
    }
    
    public E dequeue() {
        if (this.empty())
            return null;
        return this.stack.pop();
    }
    
    public E front() {
        if (this.empty()){
            return null;
        }
        return stack.peek();
    }
    
    public boolean empty() {
        return stack.empty();
    }
    
    public static void test() {
        MyQueue<Integer> a = new MyQueue<Integer>();
        a.enqueue(1);
        a.enqueue(2);
        a.enqueue(3);
        a.enqueue(4);
        a.enqueue(5);
        
       while (!a.empty()) {
            System.out.print(a.dequeue() + " ");
       }
       System.out.println("");

    }
    
}