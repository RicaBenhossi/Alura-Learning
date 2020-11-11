from data_structure.doubly_linked_list import DoublyLinkedList


class Store:

    def __init__(self, name, address) -> None:
        self.store_name = name
        self.address = address

    def __repr__(self) -> str:
        return f"{self.store_name} - {self.address}"


def show_result(dl_list: DoublyLinkedList) -> None:
    print("Whole list")
    dl_list.print_list()
    print()
    print(f"Amount of store listed: {dl_list.quantity}")
    print("-" * 80)
    print()


def main():
    store01 = Store("Minimercado", "Rua das Flores, 11")
    store02 = Store("Hostifruti", "Av. das Borboletas, 12")
    store03 = Store("Padaria Pão Quente", "Praça da Árvore, 13")
    store04 = Store("Hipermercado", "Rua dos Aflitos, 14")
    store05 = Store("Mercado", "Rua das Flores, 15")
    store06 = Store("Quitanda", "Rua da Fazenda, 16")
    store07 = Store("Mercado das Frutas", "Rua do Laranjal, 17")

    dl_list = DoublyLinkedList()
    show_result(dl_list)

    dl_list.insert_at_beginning(store01)
    show_result(dl_list)

    dl_list.insert_at_beginning(store02)
    show_result(dl_list)

    dl_list.insert_at_end(store03)
    show_result(dl_list)

    dl_list.insert_at_end(store04)
    show_result(dl_list)

    dl_list.insert(2, store05)
    show_result(dl_list)

    dl_list.insert(dl_list.quantity, store06)
    show_result(dl_list)

    dl_list.insert(0, store07)
    show_result(dl_list)

    # This return index error
    # dl_list.insert(10, store08)

    store_removed = dl_list.remove_from_start()
    print(f"removed from start: {store_removed}")
    show_result(dl_list)

    store_removed = dl_list.remove_from_end()
    print(f"removed from end: {store_removed}")
    show_result(dl_list)

    store_removed = dl_list.remove(2)
    print(f"removed from position 2: {store_removed}")
    show_result(dl_list)


main()
