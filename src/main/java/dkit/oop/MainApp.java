package dkit.oop;

// Priority Queue 			Nov 2024
// A Priority Ques is a structure that organises elements in a collection so that
// when we remove() an element from the queue, the element removed will be
// the element with the highest priority.  The highest priority element will always
// 'come to the top' and will be the one available next when a remove() is attempted.
// The elements in the queue are NOT necessarily sorted, but are organised internally
// so that the highest priority element is always the next one for removal.
// We can set the Priority of elements, by providing appropriate
// compare functions.
// 1. By implementing the Comparable interface (and writing compareTo() method) in the
//    class defining the objects used in the queue
// 2. By coding a Comparator (and writing its compare(obj1, obj2) method).
// A Comparator will take precedence over Comparable if both are provided.


// Code below Demonstrates:
// - PriorityQueue of Strings ( uses compareTo() as defined in String class)
// - PriorityQueue of User objects (User class implements Comparable and provides compareTo() method)
// - PriorityQueue of User Objects using various Comparators that are passed into
//   the PriorityQueue's constructor.

import java.util.Comparator;
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
        // by the compareTo() method defined in the String class, so priority is Alphabetical.

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
        // for-each iteration over the queue elements
        System.out.println("\nUsing for-each loop to iterate of the priorityQueue values - NOT guaranteed to be in order! Be CAREFUL!");
        for (String name : priorityQueue) {
            System.out.print(name + ", ");
        }
        System.out.println();
        System.out.println("So, ALWAYS use remove() to retrieve elements in priority order from a Priority Queue.");

        //TODO
        // 1. Instantiate (Create) a PriorityQueue "pq" that will store integer values.
        // 2. Add the following numbers to the pq in the following order 2,8,3,7,4,6
        // 3. Write a for loop to repeatedly remove and print the "highest priority" number.
        // 4. Explain how the highest priority is determined!
    }

    private void demoUserQueue() {

        // For your own classes, you need to write a compareTo() method or
        // write a Comparator and pass it into the PriorityQueue constructor.

        // In this sample a compareTo() method has been implemented in the
        // User class, and it is used to determine the priority ordering.
        // Here, comparison is based on the following priority: Last Name, First Name then on Age
        // which is defined in the compareTo() method of the User class

        PriorityQueue<User> priorityQueue= new PriorityQueue<>();

        populateUserPriorityQueue(priorityQueue);

        System.out.println("\nUsers in priority order as dictated by compareTo() method in User class");

        while ( !priorityQueue.isEmpty() ) {
            System.out.println(priorityQueue.remove());
        }
    }

    public void demoUserFirstNameComparator() {
        // For your own classes, you need to write a compareTo() method or
        // write a Comparator and pass it into the PriorityQueue constructor.
        // Here we write a FirstName Comparator and pass it into the
        // PriorityQueue constructor.  All other fields are ignored during comparison.

        PriorityQueue<User> priorityQueue= new PriorityQueue<>(new UserFirstNameComparator());  // separate Comparator
        // or
        // PriorityQueue<User> priorityQueue= new PriorityQueue<>(Comparator.comparing(User::getFirstName));

        populateUserPriorityQueue(priorityQueue);

        System.out.println("\nPriorityQueue using First Name Comparator to set ordering");
        removeAndDisplayAllFromPQueue(priorityQueue);

        //TODO
        // 1. Instantiate a PriorityQueue pq with a Comparator to prioritise Users by
        //    their Last Name. Use the Comparator.comparing() method to set priority.
        // 2. Populate the pq using the populate method supplied.
        // 3. Write code to get the highest priority user from the pq.
        // 4. Print only the first and last names from that user.
        // 5. Use the call and display method to print the remainder of the elements.
    }

    private void demoUserAgeComparator() {

        System.out.println("\nPriority Queue using Age Comparator (with sort order enum).");
        // Construct a PriorityQueue that will return elements in priority of Age.
        // In this case, the Comparator accepts a SortType Enum that determines the ordering
        // of priority (Ascending or Descending on Age)
        // Ascending will give  users in order of age Ascending (The Youngest First)
        // Descending will give  users in order of age Descending (The Oldest First)
        // Required order type is passed in to the comparator constructor.
        PriorityQueue<User> priorityQueue
                = new PriorityQueue<>(new UserAgeComparator(SortType.Descending));

        populateUserPriorityQueue(priorityQueue);

        System.out.println("Values in order of Age Priority (Descending) :");
        removeAndDisplayAllFromPQueue(priorityQueue);

        // Alternatively
        // We can create a Comparator on the fly, and use the.reversed() method to reverse
        // the comparison logic.  (This newer approach is more readable).
        priorityQueue= new PriorityQueue<>( Comparator.comparing(User::getAge).reversed() );
        populateUserPriorityQueue(priorityQueue);
        System.out.println("Values in order of Age Priority (Descending)  using Comparator.comparing(User::getAge).reversed() ");
        removeAndDisplayAllFromPQueue(priorityQueue);
    }

    // Instead of writing a loop each time to output the elements from the queue,
    // here we write a method that will remove All queue elements, one-by-one,
    // in priority order, and print each one.
    //
    void removeAndDisplayAllFromPQueue(PriorityQueue<User> queue) {
        while ( !queue.isEmpty() ) {
            System.out.println(queue.remove());  // remove the highest priority element
        }
    }

    void populateUserPriorityQueue( PriorityQueue<User> queue){
        queue.add(new User("John", "Brown",   23 ));
        queue.add(new User("Maeve", "Green",  19 ));
        queue.add(new User("Bea", "Scarlet",  28 ));
        queue.add(new User("Maeve", "Green",  36) );
        queue.add(new User("Alan", "Brown",   50 ));
    }
}












