package dkit.oop;

import java.util.Comparator;

public class UserAgeComparator 
				implements Comparator<User> 
{
	private SortType sortType;

	public UserAgeComparator(SortType sortType)
	{
		this.sortType = sortType;
	}

	@Override
	public int compare(User u1, User u2) 
	{
		int direction = sortType.getValue();
		return direction * (u1.getAge() - u2.getAge());
	}
}
