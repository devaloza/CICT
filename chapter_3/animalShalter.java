package chapter_3;

import java.util.LinkedList;

abstract class Animal {
    private int order;
    private String name;
    public Animal(String animalName) { name = animalName;}
    public void setOrder(int ord) { order = ord; }
    public int getOrder() { return order;}
    public boolean isOlderThan(Animal a) {
        return order < a.getOrder();
    }
}

public class animalShalter {
    LinkedList<Dog> dogs = new LinkedList<Dog>();
    LinkedList<Cat> cats = new LinkedList<Cat>();
    private int order = 0;
    public void enqueue(Animal a) {
        a.setOrder(order);
        order++;
        if (a instanceof Dog) dogs.addLast((Dog) a);
        else if (a instanceof Cat) cats.addLast((Cat) a);
    }
    public Animal dequeueAny() {
        if (dogs.size() ==0) {
            return dequeueCat();
        } else if (cats.size() == 0) {
            return dequeueDog();
        }
        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if (dog.isOlderThan(cat)) {
            return dequeueDog();
        } else {
            return dequeueCat();
        }
    }
    public Animal dequeueCat() {
        return cats.poll();
    }
    public Animal dequeueDog() {
        return dogs.poll();
    }
}

