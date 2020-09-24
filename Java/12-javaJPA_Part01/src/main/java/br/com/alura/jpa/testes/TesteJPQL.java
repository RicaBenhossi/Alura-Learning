package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJPQL {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        Conta conta = new Conta();
        conta.setId(2L);

        // Similar to a SQL query, but using CLASSES
        // Here it select all from class Movimentacao, passing the object conta as
        // parameter.
        // Always use the forma pName. Convention.
        String jpql = "select m from Movimentacao m where m.conta = :pConta order by m.valor desc";

        // After create the select string, we need to encapsulate it on a query object
        // region The type Query is too generic. So, change to a TypedQuery with the
            // type of the result you will receive
        // query.setParameter("pConta", conta);
        // endregion
        // This TypedQuery solves the Class Cast Exception
        TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);

        // The result will be stored inside a list.
        List<Movimentacao> resultList = query.getResultList();
        query.setParameter("pConta", conta);

        for (Movimentacao movimentacao : resultList) {

            System.out.println("Descrição: " + movimentacao.getDescricao());
            System.out.println("Valor: " + movimentacao.getValor());
            System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
        }
    }
}