package dkit.oop;

import java.util.Comparator;

public class UserGenderComparator implements Comparator<User>
{
	private SortType sortType;	// Ascending or Descending enum type

	public UserGenderComparator(SortType sortType)
	{
		this.sortType = sortType;
	}
	
	
	@Override
	public int compare(User user1, User user2)
	{
		if( user1.getGender() < user2.getGender() ) //F, M
		{
			return -1 * this.sortType.getValue();  // sorType may negate sort order
		}
		else if(user1.getGender() > user2.getGender()) //M, F
		{
			return 1 * this.sortType.getValue();
		}
		else // same gender
		{
			return 0;
		}
	}

}
