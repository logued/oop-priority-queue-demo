package dkit.oop;

// Priority Queue Demo			Feb 2022

// Demonstrates
// - PriorityQueue for queue of Strings ( uses compareTo() as defined in String class)
// - PriorityQueue for queue of User objects (employing the compareTo() method defined in User)
// - PriorityQueue for queue of User Objects using various Comparators that are passed into
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
        //queueOfStringsPriorityDemo();
        //demoUserQueue();
         demoUserFirstNameComparator();
        //demoUserAgeComparator();
        //demoGenderComparator();
    }

    private void queueOfStringsPriorityDemo() {
        PriorityQueue<String> queue = new PriorityQueue<>();

        queue.add("Edward");
        queue.add("Alan");
        queue.add("Vera");
        queue.add("Ben");
        queue.add("Alan");

        // values in a priority queue structure are organized in a manner such that
        // they can be retrieved - using remove() - based on a specified ordering.
        //
        // For Strings, the natural ordering is alphabetical, and is determined
        // by the compareTo() method defined in the String class.

        System.out.println("Using queue.remove() will retrieve the values in Priority Order");
        while (!queue.isEmpty())
            System.out.println(queue.remove());

        if (queue.isEmpty())
            System.out.println("The queue is now empty.");

        // queue has been emptied - so refill it

        queue.add("Edward");
        queue.add("Alan");
        queue.add("Vera");
        queue.add("Ben");
        queue.add("Alan");

        System.out.println("Note that Iterating over a Priority Queue may NOT give the values in priority order!");
        System.out.println("Therefore, you must always use the queue.remove() method for correct results.");
        System.out.println("Dump of the queue values - note NOT in order!");
        System.out.println(queue);    // print the whole queue

        // for-each iteration over the queue
        System.out.println("for-each iteration of the queue values - NOT guaranteed to be in order! Be CAREFUL!");
        for (String name : queue) {
            System.out.print(name + ", ");
        }
        System.out.println();
    }

    private void demoUserQueue() {

        // For your own classes, you need to write a compareTo() method or
        // write a Comparator and pass it into the PriorityQueue constructor.

        PriorityQueue<User> queue = new PriorityQueue<>();

        queue.add(new User("john", "brown", (short) 23, 'M'));
        queue.add(new User("maeve", "green", (short) 19, 'F'));
        queue.add(new User("bea", "scarlet", (short) 28, 'F'));

        queue.add(new User("maeve", "green", (short) 36, 'F'));
        queue.add(new User("alan", "brown", (short) 50, 'M'));

        System.out.println("Users in priority order dictated by compareTo() method in User class");

        while ( !queue.isEmpty() ) {
            System.out.println(queue.remove());
        }
    }

    public void demoUserFirstNameComparator() {
        // For your own classes, you need to write a compareTo() method or
        // write a Comparator and pass it into the PriorityQueue constructor.
        // Here we write a FirstName comparator

        PriorityQueue<User> queue = new PriorityQueue<>(new UserFirstNameComparator());

        queue.add(new User("john", "brown", (short) 23, 'M'));
        queue.add(new User("maeve", "green", (short) 19, 'F'));
        queue.add(new User("bea", "scarlet", (short) 28, 'F'));

        queue.add(new User("maeve", "green", (short) 36, 'F'));
        queue.add(new User("alan", "brown", (short) 50, 'M'));

        while ( !queue.isEmpty() ) {
            System.out.println(queue.remove());
        }
    }


    private void demoGenderComparator() {
        PriorityQueue<User> queue = new PriorityQueue<User>(
                new UserGenderComparator(SortType.Ascending));

        queue.add(new User("john", "brown", (short) 23, 'M'));
        queue.add(new User("maeve", "green", (short) 19, 'F'));
        queue.add(new User("bea", "scarlet", (short) 28, 'F'));

        System.out.println("Values in order of Gender Priority:");
        //iterator & remove
        Iterator<User> iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println(queue.remove());
        }
    }

    private void demoUserAgeComparator() {
        PriorityQueue<User> queue
				= new PriorityQueue<User>(new UserAgeComparator(SortType.Ascending));

        queue.add(new User("john", "brown", (short) 23, 'M'));
        queue.add(new User("maeve", "green", (short) 19, 'F'));
        queue.add(new User("bea", "scarlet", (short) 28, 'F'));

        System.out.println("Values in order of Age Priority:");
        //iterator & remove
        Iterator<User> iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println(queue.remove());
        }
    }


//    public void addToQueue(PriorityQueue<User> queue, User u) {
//        if (!queue.contains(u)) // prevent duplicates (which would otherwise be permitted)
//            queue.add(u);
//    }

}












