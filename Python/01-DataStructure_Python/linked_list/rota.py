from ed.linked_list import ListaLigada


class Loja:
    def __init__(self, nome, endereco) -> None:
        self.nome = nome
        self.endereco = endereco

    def __repr__(self) -> str:
        return "{}\n {}".format(self.nome, self.endereco)


def show_result(lista: ListaLigada) -> None:
    print()
    print("Whole list")
    lista.imprimir()
    print(f"Amount of store listed: {lista.quantidade}")
    print()
    print("-" * 80)
    print()


def main():
    loja1 = Loja("Mercadinho", "Rua das Laranjeiras, 12")
    loja2 = Loja("Horti Fruti", "Rua do Pomar, 300")
    loja3 = Loja("Padaria", "Rua das Flores, 600")
    loja4 = Loja("Supermercado", "Alameda Santos, 400")
    loja5 = Loja("Mini Mercado", "Rua da Fazenda, 900")
    loja6 = Loja("Quitanda", "Avenida Rio Branco, 34")

    lista = ListaLigada()

    print("Inserting on begining")
    lista.inserir_no_inicio(loja1)
    lista.inserir_no_inicio(loja2)
    lista.inserir_no_inicio(loja3)

    show_result(lista)

    print("Insert in a position")
    lista.inserir(1, loja4)
    lista.inserir(0, loja5)
    lista.inserir(lista.quantidade, loja6)
    print("Inserted on position 1, 0 and 6")
    # Should be:
    # loja5
    # loja4
    # loja1
    # loja2
    # loja3
    # loja6

    show_result(lista)

    print("Remove from begining")
    removed_item = lista.remove_do_inicio()
    print(f"Removed item {removed_item}")
    print()
    removed_item = lista.remove_do_inicio()
    print(f"Removed item {removed_item}")

    show_result(lista)

    print("Remove from any position")
    loja_removed_position = lista.remove(2)
    print(f"Store of position 2 (removed) is\n{loja_removed_position}")

    show_result(lista)

    print("Remove from position 0")
    removed_item = lista.remove(0)
    print(f"Removed store on position 0: {removed_item}")

    show_result(lista)

    print("Getting the store located by index 1")
    store_index = lista.item(1)
    print(store_index)

    # the class tha implements linked lists in python is LIST


main()
