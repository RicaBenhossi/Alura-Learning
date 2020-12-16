class Cell:

    def __init__(self, content):
        self.content = content
        self.next = None


class LinkedList:

    def __init__(self) -> None:
        self._start = None
        self._quantity = 0

    @property
    def start(self) -> Cell:
        return self._start

    @property
    def quantity(self) -> int:
        return self._quantity

    def _position_is_valid(self, position: int) -> bool:
        if 0 <= position <= self.quantity:
            return True

        raise IndexError(f'Position informed is not valid: {position}')

    def _cell(self, position: int) -> Cell:
        self._position_is_valid(position)
        current_cell = self.start
        for i in range(0, position):
            current_cell = current_cell.next

        return current_cell

    def print_list(self):
        current_cell = self._start
        for i in range(0, self.quantity):
            print(current_cell.content)
            current_cell = current_cell.next

    def insert_at_beginning(self, content: Cell) -> None:
        new_cell = Cell(content)
        if self.quantity > 0:
            new_cell.next = self.start
        self._start = new_cell
        self._quantity += 1

    def insert(self, position, content: Cell) -> None:
        if position == 0:
            self.insert_at_beginning(content)
            return

        new_cell = Cell(content)
        left_cell = self._cell(position - 1)
        new_cell.next = left_cell.next
        left_cell.next = new_cell
        self._quantity += 1

    def remove_from_beginning(self) -> Cell:
        cell_to_remove = self.start
        self._start = cell_to_remove.next
        cell_to_remove.next = None
        self._quantity -= 1

        return cell_to_remove.content

    def remove(self, position: int) -> Cell:
        self._position_is_valid(position)
        if position == 0:
            return self.remove_from_beginning()

        left_cell = self._cell(position - 1)
        cell_to_remove = left_cell.next
        left_cell.next = cell_to_remove.next
        cell_to_remove.next = None
        self._quantity -= 1

        return cell_to_remove.content

    def item(self, position: int) -> Cell:
        return self._cell(position).content
