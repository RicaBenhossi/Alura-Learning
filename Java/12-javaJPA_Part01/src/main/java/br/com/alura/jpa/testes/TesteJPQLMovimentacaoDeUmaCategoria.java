package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJPQLMovimentacaoDeUmaCategoria {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        // Similar to a SQL query, but using CLASSES
        // Here it select all from class Movimentacao, passing the object conta as
        // parameter.
        // Always use the forma pName. Convention.
        String jpql = "select m from Movimentacao m join m.categorias c where c = :pCategoria";

        Categoria categoria = new Categoria();
        categoria.setId(2L);

        // After create the select string, we need to encapsulate it on a query object
        // region The type Query is too generic. So, change to a TypedQuery with the
            // type of the result you will receive
        // query.setParameter("pConta", conta);
        // endregion
        // This TypedQuery solves the Class Cast Exception
        TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
        query.setParameter("pCategoria", categoria);

        // The result will be stored inside a list.
        List<Movimentacao> resultList = query.getResultList();

        for (Movimentacao movimentacao : resultList) {
            System.out.println("Categorias: " + movimentacao.getCategorias());
            System.out.println("Descrição: " + movimentacao.getDescricao());
            System.out.println("Valor: " + movimentacao.getValor());
            System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
        }
    }
}