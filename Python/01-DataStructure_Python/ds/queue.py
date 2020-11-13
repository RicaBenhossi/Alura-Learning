from ds.doubly_linked_list import DoublyLinkedList


class Queue:

    def __init__(self):
        self.queue = DoublyLinkedList()

    def add_queue(self, content):
        self.queue.insert_at_end(content)

    def pop_queue(self):
        return self.queue.remove_from_start()

    @property
    def is_empty(self) -> bool:
        return self.queue.quantity == 0

    @property
    def peek(self):
        return self.queue.item(0)
