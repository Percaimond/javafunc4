package task4;

import java.util.Iterator;

public class SocialGraph implements Iterable<Person> {

	private Person centralPerson;

	public SocialGraph() {
		super();
		this.centralPerson = new Person("YOU");
	}

	public Person getCentralPerson() {
		return centralPerson;
	}

	public void setCentralPerson(Person centralPerson) {
		this.centralPerson = centralPerson;
	}

	@Override
	public Iterator<Person> iterator() {
		// TODO IMPLEMENT YOUR CODE HERE
		// Return iterator over Person objects
		return null;
	}

}
