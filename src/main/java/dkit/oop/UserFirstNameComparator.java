package dkit.oop;

import java.util.Comparator;

public class UserFirstNameComparator implements Comparator<User>
{

    @Override
    public int compare(User user1, User user2)
    {

        return user1.getFirstName().compareToIgnoreCase(user2.getFirstName());
    }
}
