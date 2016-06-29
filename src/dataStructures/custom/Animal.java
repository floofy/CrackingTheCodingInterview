package dataStructures.custom;

public abstract class Animal {
    public String name;
    protected Integer order;

    public Animal(String n) {
        name = n;
        order = null;
    }
    
    public void setOrder(int order) {
        this.order = order;
    }

}