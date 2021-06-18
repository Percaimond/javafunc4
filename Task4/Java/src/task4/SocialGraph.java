package task4;



import java.util.*;

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


		Iterator<Person> iterator = new Iterator<Person>() {
			private Set<Person> visitedfriends = new HashSet<>();
			private Queue<Person> allFriends = new LinkedList<>();
			Boolean flag = true;
			@Override
			public boolean hasNext() {

					for (Person neighbor : centralPerson.getFriends()) {
						if(flag){
						allFriends.add(centralPerson);
						}
						setCentralPerson(neighbor);
						if (!visitedfriends.contains(neighbor)) {
							allFriends.add(neighbor);
							visitedfriends.add(neighbor);
							setCentralPerson(allFriends.peek());
							flag = false;
					}
			}
				return !allFriends.isEmpty();
			}

			@Override
			public Person next() {
				if(!hasNext())
					throw new NoSuchElementException();

				return allFriends.remove();
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};

		return iterator;

	}
	public static void main(String[] args){
		SocialGraph graph = new SocialGraph();
		Person you = graph.getCentralPerson();

		// creating other people in the world
		Person[] allPeople = new Person[11];
		for (int i = 0; i < 10; i++) {
			allPeople[i] = new Person("Friend " + String.valueOf(i));
			//System.out.println(allPeople[i]);
		}
		// adding you node
		allPeople[10] = you;

		// adding level 1 friends
		you.addFriend(allPeople[0]);
		you.addFriend(allPeople[1]);
		// level 2 i.e. friends of my friends at level 1
		allPeople[0].addFriend(allPeople[2]);
		allPeople[0].addFriend(allPeople[3]);
		allPeople[1].addFriend(allPeople[4]);
		// level 2 i.e. friends of my friends at level 2
		allPeople[4].addFriend(allPeople[5]);
		allPeople[4].addFriend(allPeople[6]);
		allPeople[4].addFriend(allPeople[7]);
		// add random friendships
		allPeople[7].addFriend(allPeople[2]);
		allPeople[3].addFriend(allPeople[4]);
		allPeople[6].addFriend(allPeople[8]);
		allPeople[8].addFriend(allPeople[9]);

		ArrayList<Person> studentComputedPeopleList = new ArrayList<Person>();
		// to run the test, you are required to implement the iterator for class Tree
		for (Person p : graph) {
			studentComputedPeopleList.add(p);
		}
		System.out.println(studentComputedPeopleList);
	}
}
