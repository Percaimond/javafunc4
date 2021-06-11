package task4;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class SocialGraphTest {

	private final int MAX_EXECUTION_TIME = 1 * 1000; // in milliseconds

	@Test(timeout = MAX_EXECUTION_TIME)
	public void testSmallGraph() {
		SocialGraph graph = new SocialGraph();
		Person you = graph.getCentralPerson();

		// creating other people in the world
		Person[] allPeople = new Person[11];
		for (int i = 0; i < 10; i++) {
			allPeople[i] = new Person("Friend " + String.valueOf(i));
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

		Collections.sort(studentComputedPeopleList);
		System.out.println(studentComputedPeopleList);
		assertEquals(allPeople.length, studentComputedPeopleList.size());
		assertArrayEquals(allPeople, studentComputedPeopleList.toArray());

	}

}
