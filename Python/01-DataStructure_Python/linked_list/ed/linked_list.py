class Celula:

    def __init__(self, conteudo):
        self.conteudo = conteudo
        self.proximo = None


class ListaLigada:

    def __init__(self) -> None:
        self._inicio = None
        self._quantidade = 0

    @property
    def inicio(self) -> Celula:
        return self._inicio

    @property
    def quantidade(self) -> int:
        return self._quantidade

    def imprimir(self):
        atual = self.inicio
        for i in range(0, self.quantidade):
            print(atual.conteudo)
            atual = atual.proximo

    def inserir_no_inicio(self, conteudo: Celula) -> None:
        celula = Celula(conteudo)
        celula.proximo = self.inicio
        self._inicio = celula
        self._quantidade += 1

    def inserir(self, posicao, conteudo: Celula) -> None:
        if posicao == 0:
            self.inserir_no_inicio(conteudo)
            return

        celula_nova = Celula(conteudo)
        celula_anterior = self._celula(posicao - 1)
        celula_nova.proximo = celula_anterior.proximo
        celula_anterior.proximo = celula_nova
        self._quantidade += 1

    def _celula(self, posicao: int) -> Celula:
        self._validar_posicao(posicao)
        atual = self.inicio
        for i in range(0, posicao):
            atual = atual.proximo

        return atual

    def _validar_posicao(self, posicao: int) -> bool:
        if 0 <= posicao <= self.quantidade:
            return True

        raise IndexError(f"Posição {posicao} inválida")

    def remove_do_inicio(self) -> Celula:
        removido = self.inicio
        self._inicio = removido.proximo
        removido.proximo = None
        self._quantidade -= 1

        return removido.conteudo

    def remove(self, posicao: int) -> Celula:
        self._validar_posicao(posicao)
        if posicao == 0:
            return self.remove_do_inicio()

        anterior = self._celula(posicao - 1)
        removido = anterior.proximo
        anterior.proximo = removido.proximo
        removido.proximo = None
        self._quantidade -= 1

        return removido.conteudo

    def item(self, posicao: int) -> Celula:
        return self._celula(posicao).conteudo
