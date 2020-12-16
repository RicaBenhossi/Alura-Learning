from ds.doubly_linked_list import DoublyLinkedList


class Queue:

    # NOTE-> Python doesn't have a data structure correspondig to queue. We can implement it using LISTs but operations
    #       in the beginning of the list is heavy. We should use collections.deque to make it lightier
    # NOTE-> Besides deque python has:
    #           - queue - used to make threads communications safer
    #           - multprocessing - to make communication between process
    #           - asyncio - to manage tasks in asuncronous programming

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
