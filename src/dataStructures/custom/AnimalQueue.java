package dataStructures.custom;

import java.util.LinkedList;

/*
 * Two Queues where user has two choices, dequeue a dog or cat or get
 * the oldest of the two first in the queue.
 * 
 */
public class AnimalQueue {
   
	protected LinkedList<Dog> dogList;
    protected LinkedList<Cat> catList;
    protected int order;
    
    public AnimalQueue() {
        this.dogList = new LinkedList<Dog>();
        this.catList = new LinkedList<Cat>();
        this.order = 0;
    }
    
    public void enqueue(Animal animal) {
        animal.setOrder(this.order);
        if (animal instanceof Dog) {
            this.dogList.add((Dog) animal);
        } else if (animal instanceof Cat) {
            this.catList.add((Cat) animal);
        } else {
            System.out.println("Unknown animal");
        }
        ++this.order;
    }
    
    public Animal dequeueAny() {
        if (this.dogList.size() > 0 && this.catList.size() > 0) {
            if (this.dogList.peek().order < this.catList.peek().order) {
                return this.dogList.removeFirst();
            } else {
                return this.catList.removeFirst();
            }
        } else if (this.dogList.size() > 0) {
            return this.dogList.removeFirst();
        } else if (this.catList.size() > 0) {
            return this.catList.removeFirst();
        }
        System.out.println("Both lists empty!");
        return null;
    }

    public Animal DequeueDog() {
        return dogList.size() > 0 ? dogList.removeFirst() : null;
    }
 
    public Animal DequeueCat() {
        return catList.size() > 0 ? catList.removeFirst() : null;
    }
    
    public void printQueues() {
    	System.out.println("Dog/Cat Queues:");
    	System.out.println(this.dogList);
    	System.out.println(this.catList);
    }
    
    public void test() {
    	System.out.println("AnimalQueue Test:");
    	AnimalQueue a = new AnimalQueue();
    	Animal b = new Dog();
    	a.enqueue(b);
    	b = new Cat();
    	a.enqueue(b);
    	b = new Dog();
    	a.enqueue(b);
    	System.out.println("returned: " + a.dequeueAny().name);
    	System.out.println("returned: " + a.dequeueAny().name);
    	System.out.println("returned: " + a.dequeueAny().name);
    }

}
