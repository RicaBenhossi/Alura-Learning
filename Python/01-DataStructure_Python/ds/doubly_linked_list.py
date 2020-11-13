class Cell:

    # NOTE: The data structure DEQUE is part of the default Python library and correspond to a Doubly Linked List.
    # https://docs.python.org/3/library/collections.html#collections.deque
    # To use, just import it: from collections import deque
    def __init__(self, content) -> None:
        self.content = content
        self.next = None
        self.prior = None


class DoublyLinkedList:

    def __init__(self) -> None:
        self._start = None
        self._end = None
        self._quantity = 0

    @property
    def start(self) -> Cell:
        return self._start

    @property
    def end(self) -> Cell:
        return self._end

    @property
    def quantity(self) -> int:
        return self._quantity

    def _position_is_valid(self, position):
        if 0 <= position < self.quantity:
            return True

        raise IndexError(f'Position informed is not valid: {position}')

    def _cell(self, position):
        self._position_is_valid(position)

        middle_position = self.quantity // 2
        if position < middle_position:
            current_cell = self.start
            for i in range(0, position):
                current_cell = current_cell.next
            return current_cell

        current_cell = self.end
        for i in range(position + 1, self.quantity)[::-1]:
            current_cell = current_cell.prior
        return current_cell

    def _insert_in_empty_list(self, content):
        new_cell = Cell(content)
        self._start = new_cell
        self._end = self.start

        self._quantity += 1

    def _remove_last(self):
        if self.quantity == 1:
            removed_cell = self.start
            self._start = None
            self._end = None
            self._quantity -= 1
            return removed_cell.content

    def print_list(self) -> str:
        current = self.start
        for i in range(0, self.quantity):
            print(current.content)
            current = current.next

    def item(self, position: int):
        cell = self._cell(position)
        return cell.content

    def insert_at_beginning(self, store: Cell) -> None:
        if self.quantity == 0:
            return self._insert_in_empty_list(store)

        new_cell = Cell(store)
        new_cell.next = self.start
        self._start.prior = new_cell
        self._start = new_cell

        self._quantity += 1

    def insert_at_end(self, store) -> None:
        if self.quantity == 0:
            return self._insert_in_empty_list(store)

        new_cell = Cell(store)
        new_cell.prior = self.end
        self._end.next = new_cell
        self._end = new_cell

        self._quantity += 1

    def insert(self, position, store):
        if position == 0:
            return self.insert_at_beginning(store)

        if position == self.quantity:
            return self.insert_at_end(store)

        left = self._cell(position-1)
        right = left.next
        new_cell = Cell(store)

        new_cell.prior = left
        new_cell.next = right

        right.prior = new_cell
        left.next = new_cell

        self._quantity += 1

    def remove_from_start(self):
        if self.quantity == 1:
            self._remove_last()

        removed_cell = self.start
        self._start = removed_cell.next
        self._start.prior = None
        removed_cell.next = None

        self._quantity -= 1

        return removed_cell.content

    def remove_from_end(self):
        if self.quantity == 1:
            self._remove_last()

        removed_cell = self.end
        self._end = removed_cell.prior
        self._end.next = None
        removed_cell.prior = None

        self._quantity -= 1

        return removed_cell.content

    def remove(self, position):
        if position == 0:
            return self.remove_from_start()

        if position == self.quantity - 1:
            return self.remove_from_end()

        removed_cell = self._cell(position)
        right_cell = removed_cell.next
        left_cell = removed_cell.prior

        right_cell.prior = left_cell
        left_cell.next = right_cell
        removed_cell.prior = None
        removed_cell.next = None

        self._quantity -= 1

        return removed_cell.content
