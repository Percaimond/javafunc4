class Person(object):

    def __init__(self, name):
        self.name = name
        self.friends = []

    def add_friend(self, friend):
        self.friends.append(friend)

    def __eq__(self, other):
        if (isinstance(other, Person)):
            return self.name == other.name

    def __str__(self):
        return self.name

    def __repr__(self):
        return self.name
