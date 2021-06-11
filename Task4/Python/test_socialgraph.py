from person import Person
from socialgraph import SocialGraph
from operator import attrgetter

"""
To run this test go to open the current folder in the terminal and use:
  pytest
If you want to see also the printout of your algorithm use:
  pytest -s
"""


def test_simple_graph():
    """Get all the names of people in your network."""

    graph = SocialGraph()
    you = graph.central_person

    all_people = [
        Person('Friend ' + str(i))
        for i in range(11)
    ]

    all_people[10] = you
    # adding level 1 friends
    you.add_friend(all_people[0])
    you.add_friend(all_people[1])
    # level 2 i.e. friends of my friends at level 1
    all_people[0].add_friend(all_people[2])
    all_people[0].add_friend(all_people[3])
    all_people[1].add_friend(all_people[4])
    # level 2 i.e. friends of my friends at level 2
    all_people[4].add_friend(all_people[5])
    all_people[4].add_friend(all_people[6])
    all_people[4].add_friend(all_people[7])
    # add random friendships
    all_people[7].add_friend(all_people[2])
    all_people[3].add_friend(all_people[4])
    all_people[6].add_friend(all_people[8])
    all_people[8].add_friend(all_people[9])

    iterator = graph.iterate_nodes()
    people_from_student = []
    for person in iterator:
        people_from_student.append(person)
        print(person)

    people_from_student.sort(key=attrgetter('name'))
    all_people.sort(key=attrgetter('name'))

    print('EXPECTED')
    print(people_from_student)
    print('ACTUAL')
    print(all_people)

    assert len(people_from_student) == len(all_people)
    assert all([a == b for a, b in zip(people_from_student, all_people)])
