package dkit.oop;

import java.util.Comparator;

public class UserGenderComparator implements Comparator<User>
{
	private SortType sortType;

	public UserGenderComparator(SortType sortType)
	{
		this.sortType = sortType;
	}
	
	
	@Override
	public int compare(User u1, User u2)
	{
		if(u1.isGender() && !u2.isGender()) //F, M
		{
			return -1 * this.sortType.getValue();
		}
		else if(!u1.isGender() && u2.isGender()) //M, F
		{
			return 1 * this.sortType.getValue();
		}
		else //M, M or F, F
		{
			return 0;
		}
	}

}
