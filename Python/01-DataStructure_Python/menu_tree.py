from ds.tree import Tree


def main():

    book_store = Tree('Books')
    book_store.root.insert_child('Gastronomy')
    book_store.root.insert_child('IT')
    book_store.print_out()

    found = book_store.locate_node('Books')
    print(f'Serch result -> {found}')
    found = book_store.locate_node('Gastronomy')
    print(f'Serch result -> {found}')
    found = book_store.locate_node('IT')
    print(f'Serch result -> {found}')
    found = book_store.locate_node('Tourism')
    print(f'Serch result -> {found}')

    book_store.insert_node('IT', 'Languages')
    book_store.insert_node('Languages', 'Python')
    book_store.insert_node('Gastronomy', 'Brasilian food')
    book_store.insert_node('Gastronomy', 'Drinks')

    book_store.print_out()

    removed = book_store.remove_node('Drinks')
    print(f'Removed -> {removed}')
    book_store.print_out()
    removed = book_store.remove_node('IT')
    print(f'Removed -> {removed}')
    book_store.print_out()


main()
