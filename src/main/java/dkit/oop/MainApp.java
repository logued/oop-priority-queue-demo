package dkit.oop;

// Priority Queue 			Feb 2023
// A Priority Ques is a structure that organises elements in the collection so that
// when we request to remove() an element from the queue, then that element will be
// the element with the TOP priority.  The highest priority element will always 'come to the top' and
// will be the one available next when a remove() is attempted.
//
// We can determine what "TOP Priority" means, by providing appropriate
// compare functions (e.e. Comparator)


// Demonstrates
// - PriorityQueue of Strings ( uses compareTo() as defined in String class)
// - PriorityQueue of User objects (employing the compareTo() method defined in User)
// - PriorityQueue of User Objects using various Comparators that are passed into
//   the PriorityQueue's constructor.

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

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
        demoGenderComparator();
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
        //
        // For Strings, the natural ordering is alphabetical, and is determined
        // by the compareTo() method defined in the String class.

        System.out.println("Using priorityQueue.remove() will retrieve the values in Priority Order");
        while (!priorityQueue.isEmpty())
            System.out.println(priorityQueue.remove());

        if (priorityQueue.isEmpty())
            System.out.println("The priorityQueue is now empty.");

        // priorityQueuehas been emptied - so refill it

        priorityQueue.add("Edward");
        priorityQueue.add("Alan");
        priorityQueue.add("Vera");
        priorityQueue.add("Ben");
        priorityQueue.add("Alan");

        System.out.println("Note that Iterating over a Priority priorityQueue may NOT give the values in priority order!");
        System.out.println("Therefore, you must always use the priorityQueue.remove() method for correct results.");
        System.out.println("Dump of the priorityQueue values - note NOT in priority order!");
        System.out.println(priorityQueue);    // print the whole queue

        // for-each iteration over the queue
        System.out.println("for-each iteration of the priorityQueue values - NOT guaranteed to be in order! Be CAREFUL!");
        for (String name : priorityQueue) {
            System.out.print(name + ", ");
        }
        System.out.println();
    }

    private void demoUserQueue() {

        // For your own classes, you need to write a compareTo() method or
        // write a Comparator and pass it into the PriorityQueue constructor.

        // In this sample a compareTo() method has been implemented
        // User class, and this will be used to determine the priority ordering.
        // Here, comparison is based on the following priority: Last Name, First Name then on Age .

        PriorityQueue<User> priorityQueue= new PriorityQueue<>();

        priorityQueue.add(new User("John", "Brown", (short) 23, 'M'));
        priorityQueue.add(new User("Maeve", "Green", (short) 19, 'F'));
        priorityQueue.add(new User("Bea", "Scarlet", (short) 28, 'F'));

        priorityQueue.add(new User("Maeve", "Green", (short) 36, 'F'));
        priorityQueue.add(new User("Alan", "Brown", (short) 50, 'M'));

        System.out.println("Users in priority order dictated by compareTo() method in User class");

        while ( !priorityQueue.isEmpty() ) {
            System.out.println(priorityQueue.remove());
        }
    }

    public void demoUserFirstNameComparator() {
        // For your own classes, you need to write a compareTo() method or
        // write a Comparator and pass it into the PriorityQueue constructor.
        // Here we write a FirstName comparator. All other fields are ignored.

        PriorityQueue<User> priorityQueue= new PriorityQueue<>(new UserFirstNameComparator());

        priorityQueue.add(new User("John", "Brown", (short) 23, 'M'));
        priorityQueue.add(new User("Maeve", "Green", (short) 19, 'F'));
        priorityQueue.add(new User("Bea", "Scarlet", (short) 28, 'F'));

        priorityQueue.add(new User("Maeve", "Green", (short) 36, 'F'));
        priorityQueue.add(new User("Alan", "Brown", (short) 50, 'M'));

        while ( !priorityQueue.isEmpty() ) {
            System.out.println(priorityQueue.remove());
        }
    }

    private void demoGenderComparator() {
        PriorityQueue<User> priorityQueue= new PriorityQueue<>(
                new UserGenderComparator(SortType.Ascending));

        priorityQueue.add(new User("john", "brown", (short) 23, 'M'));
        priorityQueue.add(new User("maeve", "green", (short) 19, 'F'));
        priorityQueue.add(new User("bea", "scarlet", (short) 28, 'F'));

        System.out.println("Values in order of Gender Priority:");
        while ( !priorityQueue.isEmpty() ) {
            System.out.println(priorityQueue.remove());
        }
    }

    private void demoUserAgeComparator() {
        PriorityQueue<User> priorityQueue
                = new PriorityQueue<>(new UserAgeComparator(SortType.Ascending));

        priorityQueue.add(new User("John", "Brown", (short) 23, 'M'));
        priorityQueue.add(new User("Maeve", "Green", (short) 19, 'F'));
        priorityQueue.add(new User("Bea", "Scarlet", (short) 28, 'F'));

        System.out.println("Values in order of Age Priority:");
        while ( !priorityQueue.isEmpty() ) {
            System.out.println(priorityQueue.remove());
        }
    }
}












