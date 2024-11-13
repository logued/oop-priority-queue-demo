package dkit.oop;

import java.util.Objects;

public class User implements Comparable<User>
{

	private String firstName;
	private String lastName;
	private int age;
	public User(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	// Compare based on age within name
	// (Name has priority, and if names are the same then age is used
	@Override
	public int compareTo(User o) 
	{
		boolean bSameFirst = 
			this.getFirstName().equalsIgnoreCase(o.getFirstName());
		
		boolean bSameLast = 
				this.getLastName().equalsIgnoreCase(o.getLastName());
		
		if(bSameFirst && bSameLast) // Both first and last names are the same
		{
			//so, compare based on age
			return this.getAge() - o.getAge();
		}
		else if(!bSameFirst && bSameLast) //Different first, same last
		{
			return this.getFirstName().compareToIgnoreCase(  // so compare on first
					o.getFirstName());
		}
		else //All other cases
		{
			return this.getLastName().compareToIgnoreCase(
					o.getLastName());
		}
	}
	
	/*
	@Override
	public int compareTo(User o) 
	{
		return this.getAge() - o.getAge();
	}
	*/
	
	/*
	@Override
	public int compareTo(Object arg0) 
	{
		User other = (User)arg0;
		
		return 0;
	}
	*/

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(short age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return age == user.age &&
				Objects.equals(firstName, user.firstName) &&
				Objects.equals(lastName, user.lastName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, age);
	}
}
