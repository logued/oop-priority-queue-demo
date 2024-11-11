package dkit.oop;

// Priority Queue 			Nov 2024
// A Priority Ques is a structure that organises elements in a collection so that
// when we remove() an element from the queue, the element removed will be
// the element with the highest priority.  The highest priority element will always
// 'come to the top' and will be the one available next when a remove() is attempted.
// (The elements in the queue are NOT necessarily sorted, but is organised internally
// so that the highest priority element is always the next one for removal.
// We can set the Priority of elements, by providing appropriate
// compare functions.
// 1. By implementing the Comparable interface (and writing compareTo() method) in the
//    class defining the objects used in the queue
// 2. By coding a Comparator (and writing its compare(obj1, obj2) method).
// A Comparator will take precedence over Comparable if both are provided.


// Demonstrates
// - PriorityQueue of Strings ( uses compareTo() as defined in String class)
// - PriorityQueue of User objects (User class implements Comparable and provides compareTo() method)
// - PriorityQueue of User Objects using various Comparators that are passed into
//   the PriorityQueue's constructor.

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MainApp {
    public static void main(String[] args) {
        MainApp theApp = new MainApp();
        theApp.start();
    }

    private void start() {
        queueOfStringsPriorityDemo();
        demoUserQueue();
        demoUserFirstNameComparator();
        demoUserAgeComparator();
    }

    private void queueOfStringsPriorityDemo() {

        PriorityQueue<String> priorityQueue= new PriorityQueue<>();

        priorityQueue.add("Edward");
        priorityQueue.add("Alan");
        priorityQueue.add("Vera");
        priorityQueue.add("Ben");
        priorityQueue.add("Alan");

        // values in a priority priorityQueue structure are organized in a manner such that
        // they can be retrieved - using remove() - based on priority.
        // For Strings, the natural ordering is 'alphabetical', and is determined
        // by the compareTo() method defined in the String class.

        System.out.println("Remove elements from priorityQueue to get them in priority order");
        while (!priorityQueue.isEmpty())
            System.out.println(priorityQueue.remove());

        if (priorityQueue.isEmpty())
            System.out.println("The priorityQueue is now empty.\n");

        // the priorityQueue has been emptied - so refill it

        priorityQueue.add("Edward");
        priorityQueue.add("Alan");
        priorityQueue.add("Vera");
        priorityQueue.add("Ben");
        priorityQueue.add("Alan");

        System.out.println("Note that Iterating over a Priority priorityQueue may NOT give the values in priority order!");
        System.out.println("Therefore, you must always use the remove() method for correct results.");
        System.out.println("Simple print of the priorityQueue object - note elements are NOT in priority order!");
        System.out.println(priorityQueue);

        // for-each iteration over the queue elements
        System.out.println("\nUsing for-each loop to iterate of the priorityQueue values - NOT guaranteed to be in order! Be CAREFUL!");
        for (String name : priorityQueue) {
            System.out.print(name + ", ");
        }
        System.out.println();
        System.out.println("So, ALWAYS use remove() to retrieve elements in priority order from a Priority Queue.");
    }

    private void demoUserQueue() {

        // For your own classes, you need to write a compareTo() method or
        // write a Comparator and pass it into the PriorityQueue constructor.

        // In this sample a compareTo() method has been implemented in the
        // User class, and it is used to determine the priority ordering.
        // Here, comparison is based on the following priority: Last Name, First Name then on Age .

        PriorityQueue<User> priorityQueue= new PriorityQueue<>();

        priorityQueue.add(new User("John", "Brown",  (short) 23 )); // cast to short integer
        priorityQueue.add(new User("Maeve", "Green", (short) 19 ));
        priorityQueue.add(new User("Bea", "Scarlet", (short) 28 ));
        priorityQueue.add(new User("Maeve", "Green", (short) 36) );
        priorityQueue.add(new User("Alan", "Brown",  (short) 50 ));

        System.out.println("\nUsers in priority order dictated by compareTo() method in User class");

        while ( !priorityQueue.isEmpty() ) {
            System.out.println(priorityQueue.remove());
        }
    }

    public void demoUserFirstNameComparator() {
        // For your own classes, you need to write a compareTo() method or
        // write a Comparator and pass it into the PriorityQueue constructor.
        // Here we write a FirstName comparator. All other fields are ignored.

        PriorityQueue<User> priorityQueue= new PriorityQueue<>(new UserFirstNameComparator());
        // or
        // PriorityQueue<User> priorityQueue= new PriorityQueue<>(Comparator.comparing(User::getFirstName));

        priorityQueue.add(new User("John", "Brown",  (short) 23 )); // cast to short integer
        priorityQueue.add(new User("Maeve", "Green", (short) 19 ));
        priorityQueue.add(new User("Bea", "Scarlet", (short) 28 ));
        priorityQueue.add(new User("Maeve", "Green", (short) 36) );
        priorityQueue.add(new User("Alan", "Brown",  (short) 50 ));

        System.out.println("\nPriorityQueue using First Name Comparator to set ordering");
        displayAllInPriorityOrder(priorityQueue);
    }

    private void demoUserAgeComparator() {

        System.out.println("\nPriority Queue using Age Comparator (with sort order enum).");
        // Construct a PriorityQueue that will return elements in priority of Age, Ascending.
        // In this case, the Comparator accepts a SortType enum that determines the ordering
        // of priority (Ascending or Descending on Age)
        // Ascending will give  users in order of age Ascending (The Youngest First)
        // Descending will give  users in order of age Descending (The Oldest First)
        PriorityQueue<User> priorityQueue
                = new PriorityQueue<>(new UserAgeComparator(SortType.Descending));

        priorityQueue.add(new User("John", "Brown", (short) 23));
        priorityQueue.add(new User("Maeve", "Green", (short) 19));
        priorityQueue.add(new User("Bea", "Scarlet", (short) 28));

        System.out.println("Values in order of Age Priority (Descending) :");
        displayAllInPriorityOrder(priorityQueue);

    }

    // Instead of writing loop each time to output the elements from the queue,
    // here we write a method that will remove All queue elements and print
    // them as it removes them.
    // Note that we can use a parameter that is of Interface Type Queue here.
    // The underlying concrete queue type (PriorityQueue) will ensure that elements
    // are returned in priority order.
    //
    void displayAllInPriorityOrder ( Queue<User> queue) {
        while ( !queue.isEmpty() ) {
            System.out.println(queue.remove());
        }
    }
}












