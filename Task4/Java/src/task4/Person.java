package task4;

import java.util.ArrayList;
import java.util.List;

public class Person implements Comparable<Person> {

	private String name;
	private List<Person> friends;

	public Person(String name) {
		super();
		this.name = name;
		this.friends = new ArrayList<Person>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Person> getFriends() {
		return friends;
	}

	public void setFriends(List<Person> friends) {
		this.friends = friends;
	}

	public void addFriend(Person newFriend) {
		this.friends.add(newFriend);
	}

	@Override
	public int compareTo(Person arg0) {
		int c = this.name.compareTo(arg0.getName());
		if (c != 0) {
			return c;
		}
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (!(obj instanceof Person)) {
			return false;
		}

		Person other = (Person) obj;
		boolean sameName = (this.name.equals(other.getName()));
		return sameName;
	}

	@Override
	public String toString() {
		return this.getName();
	}

}
