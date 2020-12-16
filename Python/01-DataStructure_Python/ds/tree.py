from ds.doubly_linked_list import DoublyLinkedList

# NOTE: Tree is a non-linear data structure that store the objects hierarclly.
'''
                  A
                / | \
               B  C  D
             / |  |
            E  F  G
               |
               H
             / | \
            I  J  K
'''
# Every Tree starts with a root ('A') thao is a node without a father. Then from the root, we have children.
# Every element of the tree is called NODE. A node without a child is a LEAF ('D', 'E', 'G', 'I', 'J', 'K').
# If you have more than onetree, you have a forest. By definition a node is a tree it self if you take it separtely
# There is more types of tree like Binary search tree where the nodes has, at most, 2 child (left and right).
# there is no Tree on python default library


# NOTE: this is how to use heritage. ListOfNodes inherit of doublyLikedList
class ListOfNodes(DoublyLinkedList):

    # This is how to instance a inherited class.
    def __init__(self) -> None:
        super().__init__()

    def print_out(self, level):
        current = self.start
        for i in range(0, self.quantity):
            current.content.print_out(level)
            current = current.next

    def locate_node(self, content):
        current = self.start
        for i in range(0, self.quantity):
            found = current.content.locate_node(content)
            if found:
                return found
            current = current.next

    def position(self, content) -> int:
        current = self.start
        for i in range(0, self.quantity):
            if current.content.content == content:
                return i
            current = current.next


class Node:

    def __init__(self, content) -> None:
        self.content = content
        self.father = None
        self.children = None

    def __repr__(self) -> str:
        return self.content

    def print_out(self, level=0):
        print(f'{" "*level} - {self.content}')
        if self.children:
            self.children.print_out(level + 1)

    def insert_child(self, child):
        if self.children is None:
            self.children = ListOfNodes()
        node = Node(child)
        node.father = self
        self.children.insert_at_end(node)

    def locate_node(self, content):
        if content == self.content:
            return self

        if self.children:
            return self.children.locate_node(content)

    def remove(self):
        if self.father:
            position = self.father.children.position(self.content)
            return self.father.children.remove(position)
        return self


class Tree:

    def __init__(self, content) -> None:
        self.root = Node(content)

    def print_out(self):
        self.root.print_out()

    def locate_node(self, content):
        return self.root.locate_node(content)

    def insert_node(self, father, child):
        father_node = self.locate_node(father)
        if father_node:
            father_node.insert_child(child)

    def remove_node(self, content):
        found = self.root.locate_node(content)
        if found:
            if found is self.root:
                self.root = None
            else:
                found.remove()

        return found
