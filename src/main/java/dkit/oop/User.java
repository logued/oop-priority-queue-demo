package dkit.oop;

public class User implements Comparable<User>
{

	private String firstName, lastName;
	private short age;
	private boolean gender; //XXXX XXX1

	public User(String firstName, String lastName, short age, boolean gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
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

	public short getAge() {
		return age;
	}

	public void setAge(short age) {
		this.age = age;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", gender=" + gender + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + (gender ? 1231 : 1237);
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (age != other.age)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender != other.gender)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}



	
	
	
	

}
