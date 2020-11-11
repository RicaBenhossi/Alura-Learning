from ds.linked_list import Linked_List


class Store:
    def __init__(self, name, address) -> None:
        self.name = name
        self.address = address

    def __repr__(self) -> str:
        return '{}\n {}'.format(self.name, self.address)


def show_result(lnk_list: Linked_List) -> None:
    print()
    print('Whole list')
    lnk_list.print_list()
    print(f'Amount of store listed: {lnk_list.quantity}')
    print()
    print('-' * 80)
    print()


def main():
    store1 = Store('Mercadinho', 'Rua das Laranjeiras, 12')
    store2 = Store('Horti Fruti', 'Rua do Pomar, 300')
    store3 = Store('Padaria', 'Rua das Flores, 600')
    store4 = Store('Supermercado', 'Alameda Santos, 400')
    store5 = Store('Mini Mercado', 'Rua da Fazenda, 900')
    store6 = Store('Quitanda', 'Avenida Rio Branco, 34')

    lnk_list = Linked_List()

    print('Inserting at begining')
    lnk_list.insert_at_beginning(store1)
    lnk_list.insert_at_beginning(store2)
    lnk_list.insert_at_beginning(store3)

    show_result(lnk_list)

    print('Insert in a position')
    lnk_list.insert(1, store4)
    lnk_list.insert(0, store5)
    lnk_list.insert(lnk_list.quantity, store6)
    print('Inserted on position 1, 0 and 6')
    # Should be:
    # store5
    # store4
    # store1
    # store2
    # store3
    # store6

    show_result(lnk_list)

    print('Remove from begining')
    removed_item = lnk_list.remove_from_beginning()
    print(f'Removed item {removed_item}')
    print()
    removed_item = lnk_list.remove_from_beginning()
    print(f'Removed item {removed_item}')

    show_result(lnk_list)

    print('Remove from any position')
    store_removed_position = lnk_list.remove(2)
    print(f'Store of position 2 (removed) is\n{store_removed_position}')

    show_result(lnk_list)

    print('Remove from position 0')
    removed_item = lnk_list.remove(0)
    print(f'Removed store on position 0: {removed_item}')

    show_result(lnk_list)

    print('Getting the store located by index 1')
    store_index = lnk_list.item(1)
    print(store_index)

    # the class tha implements linked lists in python is LIST


main()
