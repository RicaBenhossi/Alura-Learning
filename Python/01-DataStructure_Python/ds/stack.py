from ds.linked_list import LinkedList


class Stack:

    def __init__(self):
        self.stack = LinkedList()

    @property
    def peek(self):
        return self.stack.item(0)

    @property
    def is_empty(self):
        return self.stack.quantity == 0

    def stack_up(self, content):
        self.stack.insert_at_beginning(content)

    def unstack(self):
        return self.stack.remove_from_beginning()
